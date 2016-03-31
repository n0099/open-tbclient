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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aik;
    private boolean akN;
    private TextView apA;
    private TextView apB;
    private TextView apC;
    private LinearLayout apD;
    private TextView apE;
    private TextView apF;
    private TextView apG;
    private LinearLayout apH;
    private TextView apI;
    private RelativeLayout apJ;
    private TbImageView apK;
    private TextView apL;
    private TextView apM;
    private TextView apN;
    private RelativeLayout apO;
    private TextView apP;
    private TextView apQ;
    private TextView apR;
    private TextView apS;
    private int apT;
    private ArrayList<Integer> apU;
    private int apV;
    private int apW;
    private boolean apX;
    private boolean apY;
    private boolean apZ;
    private a apd;
    private b ape;
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
    private boolean apq;
    private boolean apr;
    private LinearLayout aps;
    private View apt;
    private HeadImageView apu;
    private FrameLayout apv;
    private LinearLayout apw;
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
    private int aqn;
    private int aqo;
    private String aqp;
    private Context context;
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
        this.apf = true;
        this.apg = true;
        this.aph = true;
        this.api = true;
        this.apj = true;
        this.apk = true;
        this.apl = false;
        this.apm = false;
        this.apn = false;
        this.apo = false;
        this.apq = false;
        this.apr = false;
        this.apT = 0;
        this.apU = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.apV = 0;
        this.apW = 0;
        this.apX = false;
        this.apY = true;
        this.apZ = false;
        this.akN = false;
        this.aik = 3;
        this.padding = 0;
        this.aqa = 0;
        this.aqb = 0;
        this.aqc = 0;
        this.aqd = 0;
        this.aqp = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(t.e.ds24);
        this.aqb = (int) context.getResources().getDimension(t.e.ds100);
        this.aqa = (int) context.getResources().getDimension(t.e.ds70);
        this.aqc = (int) context.getResources().getDimension(t.e.ds18);
        this.aqd = (int) context.getResources().getDimension(t.e.ds4);
        this.aqe = (int) context.getResources().getDimension(t.e.ds80);
        this.aqf = (int) context.getResources().getDimension(t.e.ds280);
        this.aqg = (int) context.getResources().getDimension(t.e.ds170);
        this.aqh = (int) context.getResources().getDimension(t.e.ds320);
        this.aqi = (int) context.getResources().getDimension(t.e.ds200);
        this.aqj = (int) context.getResources().getDimension(t.e.ds60);
        this.aqk = (int) context.getResources().getDimension(t.e.ds120);
        this.aql = (int) context.getResources().getDimension(t.e.ds160);
        this.aqm = (int) context.getResources().getDimension(t.e.ds220);
        this.aqn = (int) context.getResources().getDimension(t.e.ds240);
        this.aqo = (int) context.getResources().getDimension(t.e.ds180);
        this.size = (int) context.getResources().getDimension(t.e.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(t.h.photo_live_card_view, this);
        this.aps = (LinearLayout) inflate.findViewById(t.g.pl_card_root);
        this.apt = inflate.findViewById(t.g.author_info);
        this.apD = (LinearLayout) inflate.findViewById(t.g.photo_live_card_title);
        this.apH = (LinearLayout) inflate.findViewById(t.g.photo_live_card_content);
        this.apJ = (RelativeLayout) inflate.findViewById(t.g.photo_live_card_cover_and_expression);
        this.apO = (RelativeLayout) inflate.findViewById(t.g.photo_live_card_bottom);
        BE();
        BF();
        BG();
        BI();
        BH();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.apf, photoLiveCardData);
            b(this.apg, this.apl, photoLiveCardData);
            b(this.aph, photoLiveCardData);
            a(this.api, this.apj, photoLiveCardData);
            a(this.apk, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.akN = true;
        } else {
            this.akN = false;
        }
    }

    public void xy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.aik) {
            at.k(this.aps, t.f.frs_item_control_btn_bg);
            if (this.apf) {
                at.b(this.apx, t.d.cp_cont_f, 1);
                at.b(this.apy, t.d.cp_cont_d, 1);
                at.b(this.apz, t.d.cp_cont_d, 1);
                at.b(this.apA, t.d.cp_cont_d, 1);
                at.b(this.apC, t.d.cp_cont_d, 1);
                Drawable drawable = at.getDrawable(t.f.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.apy.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = at.getDrawable(t.f.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.apA.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.apg) {
                at.b(this.apE, t.d.cp_cont_b, 1);
                at.b(this.apF, t.d.cp_cont_c, 1);
                at.b(this.apG, t.d.cp_cont_i, 1);
                at.k(this.apG, t.f.blacklist_remove_button_bg);
                this.apE.setText(e(this.aqp));
            }
            if (this.apk) {
                at.b(this.apP, t.d.cp_cont_i, 1);
                at.k(this.apP, t.f.label_bg_tie);
                at.b(this.apQ, t.d.cp_cont_d, 1);
                at.b(this.apR, t.d.cp_cont_d, 1);
                at.b(this.apP, t.d.cp_cont_i, 1);
            }
            at.b(this.apI, t.d.cp_cont_b, 1);
            BJ();
            this.aik = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.apY) {
                if (this.paddingBottom != 0) {
                    this.apJ.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.apJ.setPadding(this.padding, 0, this.padding, 0);
                }
                this.apJ.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.apJ != null) {
                this.apJ.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apO.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.apm);
                f(photoLiveCardData.getDiscussNum(), this.apq);
                return;
            }
            this.apO.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apD.setVisibility(0);
                if (this.apW != 0) {
                    this.apE.setMaxLines(this.apW);
                } else {
                    this.apE.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.apE, photoLiveCardData.getThreadId());
                return;
            }
            this.apD.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.apr) {
            this.apG.setVisibility(0);
            this.apG.setTag(photoLiveCardData);
            return;
        }
        this.apG.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apH.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.apH.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.apH.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.apI, photoLiveCardData.getThreadId());
                return;
            }
            this.apH.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.apZ) {
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.oh(String.valueOf(j))) {
                at.b(textView, t.d.cp_cont_c, 1);
            } else {
                at.b(textView, t.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apt.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.apt.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.apt.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.apu.getLayoutParams();
                if (this.akN) {
                    if (layoutParams != null) {
                        layoutParams.height = this.aqb;
                        layoutParams.width = this.aqb;
                    }
                    if (this.apS == null) {
                        this.apS = new TextView(this.context);
                        this.apS.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.apS.setEllipsize(TextUtils.TruncateAt.END);
                        this.apS.setTextSize(0, this.aqc);
                        at.j((View) this.apS, t.d.cp_cont_h);
                        at.k(this.apS, t.f.icon_shen);
                        this.apS.setSingleLine(true);
                        this.apw.addView(this.apS);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.apS.setText(t.j.god_intro_default);
                    } else {
                        this.apS.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.apw.removeView(this.apS);
                    this.apS = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.aqa;
                        layoutParams.width = this.aqa;
                    }
                }
                this.apu.setTag(photoLiveCardData);
                eN(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.apw.removeView(this.apS);
            this.apt.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.apu.setPadding(this.aqd, this.aqd, this.aqd, this.aqd);
            if (this.akN) {
                this.apv.setBackgroundDrawable(at.getDrawable(t.f.pic_bg_jinbian));
                return;
            } else {
                this.apv.setBackgroundDrawable(at.getDrawable(t.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.apv.setBackgroundDrawable(null);
        this.apu.setPadding(0, 0, 0, 0);
    }

    private void BE() {
        if (this.apt != null) {
            this.apu = (HeadImageView) this.apt.findViewById(t.g.author_portrait);
            this.apv = (FrameLayout) this.apt.findViewById(t.g.author_portrait_info);
            this.apx = (TextView) this.apt.findViewById(t.g.author_name);
            this.apy = (TextView) this.apt.findViewById(t.g.nick_name);
            this.apz = (TextView) this.apt.findViewById(t.g.fans_num);
            this.apA = (TextView) this.apt.findViewById(t.g.reply_num);
            this.apB = (TextView) this.apt.findViewById(t.g.headlive_icon);
            this.apC = (TextView) this.apt.findViewById(t.g.refresh_time_in_head);
            this.apw = (LinearLayout) this.apt.findViewById(t.g.author_info_and_time);
            this.apu.setOnClickListener(new s(this));
        }
    }

    private void BF() {
        if (this.apD != null) {
            this.apE = (TextView) this.apD.findViewById(t.g.title);
            this.apF = (TextView) findViewById(t.g.refresh_time_in_title);
            this.apG = (TextView) this.apD.findViewById(t.g.card_delete_in_title);
            this.apG.setOnClickListener(new t(this));
        }
    }

    private void BG() {
        if (this.apH != null) {
            this.apI = (TextView) this.apH.findViewById(t.g.content);
        }
    }

    private void BH() {
        if (this.apO != null) {
            this.apP = (TextView) this.apO.findViewById(t.g.ba_name);
            this.apQ = (TextView) this.apO.findViewById(t.g.bottom_refresh_time);
            this.apR = (TextView) this.apO.findViewById(t.g.bottom_reply_num);
        }
    }

    private void BI() {
        if (this.apJ != null) {
            this.apK = (TbImageView) this.apJ.findViewById(t.g.live_cover);
            this.apK.setGifIconSupport(false);
            BK();
        }
    }

    private void BJ() {
        at.k(this.apL, t.f.bg_tieziyingxiang);
        at.k(this.apM, t.f.bg_tieziyingxiang);
        at.k(this.apN, t.f.bg_tieziyingxiang);
    }

    private void BK() {
        if (this.apJ != null) {
            this.apL = (TextView) this.apJ.findViewById(t.g.first_style_first_expression);
            this.apM = (TextView) this.apJ.findViewById(t.g.first_style_second_expression);
            this.apN = (TextView) this.apJ.findViewById(t.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.apU.clear();
        BM();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            BL();
        }
    }

    private void BL() {
        if (this.apU.size() != 0) {
            int size = this.apU.size();
            for (int i = 0; i < size; i++) {
                if (this.apU.get(i).intValue() == this.apL.getId()) {
                    this.apL.setVisibility(8);
                } else if (this.apU.get(i).intValue() == this.apM.getId()) {
                    this.apM.setVisibility(8);
                } else if (this.apU.get(i).intValue() == this.apN.getId()) {
                    this.apN.setVisibility(8);
                }
            }
        }
    }

    private void BM() {
        this.apL.setText("");
        this.apM.setText("");
        this.apN.setText("");
        if (this.apL.getVisibility() == 8) {
            this.apL.setVisibility(0);
        }
        if (this.apM.getVisibility() == 8) {
            this.apM.setVisibility(0);
        }
        if (this.apN.getVisibility() == 8) {
            this.apN.setVisibility(0);
        }
        this.apU.add(Integer.valueOf(this.apL.getId()));
        this.apU.add(Integer.valueOf(this.apM.getId()));
        this.apU.add(Integer.valueOf(this.apN.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.Bx())));
            el(textView.getId());
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
            switch (this.apT) {
                case 0:
                    a(this.aqe, this.aqf, this.apL);
                    a(this.aqg, this.aqh, this.apM);
                    a(this.aqi, this.aqj, this.apN);
                    break;
                case 1:
                    a(this.aqj, this.aqk, this.apL);
                    a(this.aql, this.aqj, this.apM);
                    a(this.aqm, this.aqh, this.apN);
                    break;
                case 2:
                    a(this.aqj, this.aqn, this.apL);
                    a(this.aqo, this.aqj, this.apM);
                    a(this.aqm, this.aqh, this.apN);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.apL);
            } else if (i == 1) {
                a(arrayList.get(i2), this.apM);
            } else if (i == 2) {
                a(arrayList.get(i2), this.apN);
            }
        }
    }

    private void el(int i) {
        if (this.apU.size() != 0) {
            int size = this.apU.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.apU.get(i2).intValue() == i) {
                    this.apU.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.apK.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.apK.c(str, 10, false);
        } else {
            this.apK.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apP.setText("");
            return;
        }
        String trim = str.trim();
        this.apP.setVisibility(0);
        if (com.baidu.tbadk.util.r.go(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.r.d(trim, 0, 12)) + "...";
        }
        this.apP.setText(String.valueOf(trim) + TbadkCoreApplication.m411getInst().getResources().getString(t.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apI.setText("");
            this.apI.setVisibility(8);
            return;
        }
        this.apI.setVisibility(0);
        this.apI.setText(str);
    }

    private void setTitle(String str) {
        this.aqp = str;
        if (this.apV != 0) {
            this.apE.setPadding(0, 0, (int) this.context.getResources().getDimension(this.apV), 0);
            this.apV = 0;
        } else {
            this.apE.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.apE.setText("");
            return;
        }
        this.apE.setVisibility(0);
        if (this.apX) {
            this.apE.setText(e(str));
        } else {
            this.apE.setText(str);
        }
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cR = at.cR(t.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
        int height = cR.getHeight();
        bitmapDrawable.setBounds(0, 0, cR.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eN(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.apu.c(str, 12, false);
        } else {
            this.apu.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apx.setText("");
            return;
        }
        this.apx.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.r.go(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.r.d(trim, 0, 14)) + "...";
        }
        this.apx.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            c(this.apy, this.context.getResources().getString(t.j.fans_default_name));
        } else {
            c(this.apy, str);
        }
    }

    private void c(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = at.getDrawable(t.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.apz.setText(ay.A(i));
    }

    private void setReplyNum(int i) {
        b(this.apA, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(ay.A(j));
        Drawable drawable = at.getDrawable(t.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void f(int i, boolean z) {
        if (z) {
            this.apR.setVisibility(0);
            b(this.apR, i);
            return;
        }
        this.apR.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.apo) {
            this.apB.setVisibility(0);
            at.k(this.apB, t.f.label_onthelist);
            return;
        }
        this.apB.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.apn) {
            this.apC.setVisibility(0);
            this.apC.setText(str);
            return;
        }
        this.apC.setVisibility(8);
        this.apC.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.apF.setVisibility(8);
            return;
        }
        this.apF.setVisibility(0);
        this.apF.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.apQ.setVisibility(8);
            return;
        }
        this.apQ.setVisibility(0);
        this.apQ.setText(str);
    }

    public void setShowHead(boolean z) {
        this.apf = z;
    }

    public void setShowTitle(boolean z) {
        this.apg = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.apl = z;
    }

    public void setShowContent(boolean z) {
        this.aph = z;
    }

    public void setShowCover(boolean z) {
        this.api = z;
    }

    public void setShowExpression(boolean z) {
        this.apj = z;
    }

    public void setShowBottom(boolean z) {
        this.apk = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.apn = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.apo = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.apq = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.apr = z;
    }

    public void setChooseStyle(int i) {
        this.apT = i;
    }

    public int getShowStyle() {
        return this.apT;
    }

    public void setShowLiveIcon(boolean z) {
        this.apX = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.apd = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.ape = bVar;
    }

    public void setParentBackground(int i) {
        at.k(this.aps, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.apY = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.apm = z;
    }

    public void setTitlePaddingRight(int i) {
        this.apV = i;
    }

    public void setTitleMaxLines(int i) {
        this.apW = i;
    }

    public void setAllowGreyState(boolean z) {
        this.apZ = z;
    }
}
