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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aib;
    private boolean apA;
    private boolean apB;
    private boolean apC;
    private boolean apD;
    private boolean apE;
    private boolean apF;
    private boolean apG;
    private boolean apH;
    private boolean apI;
    private boolean apJ;
    private boolean apK;
    private boolean apL;
    private LinearLayout apM;
    private View apN;
    private HeadImageView apO;
    private FrameLayout apP;
    private LinearLayout apQ;
    private TextView apR;
    private TextView apS;
    private TextView apT;
    private TextView apU;
    private TextView apV;
    private TextView apW;
    private LinearLayout apX;
    private TextView apY;
    private TextView apZ;
    private a apy;
    private b apz;
    private int aqA;
    private int aqB;
    private int aqC;
    private int aqD;
    private int aqE;
    private int aqF;
    private int aqG;
    private int aqH;
    private int aqI;
    private int aqJ;
    private String aqK;
    private TextView aqa;
    private LinearLayout aqb;
    private TextView aqc;
    private RelativeLayout aqd;
    private TbImageView aqe;
    private TextView aqf;
    private TextView aqg;
    private TextView aqh;
    private RelativeLayout aqi;
    private TextView aqj;
    private TextView aqk;
    private TextView aql;
    private TextView aqm;
    private int aqn;
    private ArrayList<Integer> aqo;
    private int aqp;
    private int aqq;
    private boolean aqr;
    private boolean aqs;
    private boolean aqt;
    private boolean aqu;
    private int aqv;
    private int aqw;
    private int aqx;
    private int aqy;
    private int aqz;
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
        this.apA = true;
        this.apB = true;
        this.apC = true;
        this.apD = true;
        this.apE = true;
        this.apF = true;
        this.apG = false;
        this.apH = false;
        this.apI = false;
        this.apJ = false;
        this.apK = false;
        this.apL = false;
        this.aqn = 0;
        this.aqo = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.aqp = 0;
        this.aqq = 0;
        this.aqr = false;
        this.aqs = true;
        this.aqt = false;
        this.aqu = false;
        this.isGod = false;
        this.aib = 3;
        this.padding = 0;
        this.aqv = 0;
        this.aqw = 0;
        this.aqx = 0;
        this.aqy = 0;
        this.aqK = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(r.e.ds24);
        this.aqw = (int) context.getResources().getDimension(r.e.ds100);
        this.aqv = (int) context.getResources().getDimension(r.e.ds70);
        this.aqx = (int) context.getResources().getDimension(r.e.ds18);
        this.aqy = (int) context.getResources().getDimension(r.e.ds4);
        this.aqz = (int) context.getResources().getDimension(r.e.ds80);
        this.aqA = (int) context.getResources().getDimension(r.e.ds280);
        this.aqB = (int) context.getResources().getDimension(r.e.ds170);
        this.aqC = (int) context.getResources().getDimension(r.e.ds320);
        this.aqD = (int) context.getResources().getDimension(r.e.ds200);
        this.aqE = (int) context.getResources().getDimension(r.e.ds60);
        this.aqF = (int) context.getResources().getDimension(r.e.ds120);
        this.aqG = (int) context.getResources().getDimension(r.e.ds160);
        this.aqH = (int) context.getResources().getDimension(r.e.ds220);
        this.aqI = (int) context.getResources().getDimension(r.e.ds240);
        this.aqJ = (int) context.getResources().getDimension(r.e.ds180);
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
        this.apM = (LinearLayout) inflate.findViewById(r.g.pl_card_root);
        this.apN = inflate.findViewById(r.g.author_info);
        this.apX = (LinearLayout) inflate.findViewById(r.g.photo_live_card_title);
        this.aqb = (LinearLayout) inflate.findViewById(r.g.photo_live_card_content);
        this.aqd = (RelativeLayout) inflate.findViewById(r.g.photo_live_card_cover_and_expression);
        this.aqi = (RelativeLayout) inflate.findViewById(r.g.photo_live_card_bottom);
        AQ();
        AR();
        AS();
        AU();
        AT();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.apA, photoLiveCardData);
            b(this.apB, this.apG, photoLiveCardData);
            b(this.apC, photoLiveCardData);
            a(this.apD, this.apE, photoLiveCardData);
            a(this.apF, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.isGod = true;
        } else {
            this.isGod = false;
        }
    }

    public void wx() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aib) {
            ar.k(this.apM, r.f.frs_item_control_btn_bg);
            if (this.apA) {
                ar.c(this.apR, r.d.cp_cont_f, 1);
                ar.c(this.apS, r.d.cp_cont_d, 1);
                ar.c(this.apT, r.d.cp_cont_d, 1);
                ar.c(this.apU, r.d.cp_cont_d, 1);
                ar.c(this.apW, r.d.cp_cont_d, 1);
                Drawable drawable = ar.getDrawable(r.f.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.apS.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = ar.getDrawable(r.f.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.apU.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.apB) {
                ar.c(this.apY, r.d.cp_cont_b, 1);
                ar.c(this.apZ, r.d.cp_cont_c, 1);
                ar.c(this.aqa, r.d.cp_cont_i, 1);
                ar.k(this.aqa, r.f.blacklist_remove_button_bg);
                this.apY.setText(e(this.aqK));
            }
            if (this.apF) {
                ar.c(this.aqj, r.d.cp_cont_i, 1);
                ar.k(this.aqj, r.f.label_bg_tie);
                ar.c(this.aqk, r.d.cp_cont_d, 1);
                ar.c(this.aql, r.d.cp_cont_d, 1);
                ar.c(this.aqj, r.d.cp_cont_i, 1);
            }
            ar.c(this.aqc, r.d.cp_cont_b, 1);
            AV();
            this.aib = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.aqs) {
                if (this.paddingBottom != 0) {
                    this.aqd.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.aqd.setPadding(this.padding, 0, this.padding, 0);
                }
                this.aqd.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.aqd != null) {
                this.aqd.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aqi.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                p(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.apH);
                i(photoLiveCardData.getDiscussNum(), this.apK);
                return;
            }
            this.aqi.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apX.setVisibility(0);
                if (this.aqq != 0) {
                    this.apY.setMaxLines(this.aqq);
                } else {
                    this.apY.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                o(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.apY, photoLiveCardData.getThreadId());
                return;
            }
            this.apX.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.apL) {
            this.aqa.setVisibility(0);
            this.aqa.setTag(photoLiveCardData);
            return;
        }
        this.aqa.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aqb.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.aqb.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.aqb.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.aqc, photoLiveCardData.getThreadId());
                return;
            }
            this.aqb.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.aqt) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(String.valueOf(j))) {
                ar.c(textView, r.d.cp_cont_c, 1);
            } else {
                ar.c(textView, r.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apN.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.apN.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.apN.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.apO.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.aqw;
                        layoutParams.width = this.aqw;
                    }
                    if (this.aqm == null) {
                        this.aqm = new TextView(this.context);
                        this.aqm.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.aqm.setEllipsize(TextUtils.TruncateAt.END);
                        this.aqm.setTextSize(0, this.aqx);
                        ar.j((View) this.aqm, r.d.cp_cont_h);
                        ar.k(this.aqm, r.f.icon_shen);
                        this.aqm.setSingleLine(true);
                        this.apQ.addView(this.aqm);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.aqm.setText(r.j.god_intro_default);
                    } else {
                        this.aqm.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.apQ.removeView(this.aqm);
                    this.aqm = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.aqv;
                        layoutParams.width = this.aqv;
                    }
                }
                this.apO.setTag(photoLiveCardData);
                eQ(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.apQ.removeView(this.aqm);
            this.apN.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.apO.setPadding(this.aqy, this.aqy, this.aqy, this.aqy);
            if (this.isGod) {
                this.apP.setBackgroundDrawable(ar.getDrawable(r.f.pic_bg_jinbian));
                return;
            } else {
                this.apP.setBackgroundDrawable(ar.getDrawable(r.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.apP.setBackgroundDrawable(null);
        this.apO.setPadding(0, 0, 0, 0);
    }

    private void AQ() {
        if (this.apN != null) {
            this.apO = (HeadImageView) this.apN.findViewById(r.g.author_portrait);
            this.apP = (FrameLayout) this.apN.findViewById(r.g.author_portrait_info);
            this.apR = (TextView) this.apN.findViewById(r.g.author_name);
            this.apS = (TextView) this.apN.findViewById(r.g.nick_name);
            this.apT = (TextView) this.apN.findViewById(r.g.fans_num);
            this.apU = (TextView) this.apN.findViewById(r.g.reply_num);
            this.apV = (TextView) this.apN.findViewById(r.g.headlive_icon);
            this.apW = (TextView) this.apN.findViewById(r.g.refresh_time_in_head);
            this.apQ = (LinearLayout) this.apN.findViewById(r.g.author_info_and_time);
            this.apO.setOnClickListener(new s(this));
        }
    }

    private void AR() {
        if (this.apX != null) {
            this.apY = (TextView) this.apX.findViewById(r.g.title);
            this.apZ = (TextView) findViewById(r.g.refresh_time_in_title);
            this.aqa = (TextView) this.apX.findViewById(r.g.card_delete_in_title);
            this.aqa.setOnClickListener(new t(this));
        }
    }

    private void AS() {
        if (this.aqb != null) {
            this.aqc = (TextView) this.aqb.findViewById(r.g.content);
        }
    }

    private void AT() {
        if (this.aqi != null) {
            this.aqj = (TextView) this.aqi.findViewById(r.g.ba_name);
            this.aqk = (TextView) this.aqi.findViewById(r.g.bottom_refresh_time);
            this.aql = (TextView) this.aqi.findViewById(r.g.bottom_reply_num);
        }
    }

    private void AU() {
        if (this.aqd != null) {
            this.aqe = (TbImageView) this.aqd.findViewById(r.g.live_cover);
            this.aqe.setGifIconSupport(false);
            AW();
        }
    }

    private void AV() {
        ar.k(this.aqf, r.f.bg_tieziyingxiang);
        ar.k(this.aqg, r.f.bg_tieziyingxiang);
        ar.k(this.aqh, r.f.bg_tieziyingxiang);
    }

    private void AW() {
        if (this.aqd != null) {
            this.aqf = (TextView) this.aqd.findViewById(r.g.first_style_first_expression);
            this.aqg = (TextView) this.aqd.findViewById(r.g.first_style_second_expression);
            this.aqh = (TextView) this.aqd.findViewById(r.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.aqo.clear();
        AY();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AX();
        }
    }

    private void AX() {
        if (this.aqo.size() != 0) {
            int size = this.aqo.size();
            for (int i = 0; i < size; i++) {
                if (this.aqo.get(i).intValue() == this.aqf.getId()) {
                    this.aqf.setVisibility(8);
                } else if (this.aqo.get(i).intValue() == this.aqg.getId()) {
                    this.aqg.setVisibility(8);
                } else if (this.aqo.get(i).intValue() == this.aqh.getId()) {
                    this.aqh.setVisibility(8);
                }
            }
        }
    }

    private void AY() {
        this.aqf.setText("");
        this.aqg.setText("");
        this.aqh.setText("");
        if (this.aqf.getVisibility() == 8) {
            this.aqf.setVisibility(0);
        }
        if (this.aqg.getVisibility() == 8) {
            this.aqg.setVisibility(0);
        }
        if (this.aqh.getVisibility() == 8) {
            this.aqh.setVisibility(0);
        }
        this.aqo.add(Integer.valueOf(this.aqf.getId()));
        this.aqo.add(Integer.valueOf(this.aqg.getId()));
        this.aqo.add(Integer.valueOf(this.aqh.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.AJ())));
            ej(textView.getId());
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
            switch (this.aqn) {
                case 0:
                    a(this.aqz, this.aqA, this.aqf);
                    a(this.aqB, this.aqC, this.aqg);
                    a(this.aqD, this.aqE, this.aqh);
                    break;
                case 1:
                    a(this.aqE, this.aqF, this.aqf);
                    a(this.aqG, this.aqE, this.aqg);
                    a(this.aqH, this.aqC, this.aqh);
                    break;
                case 2:
                    a(this.aqE, this.aqI, this.aqf);
                    a(this.aqJ, this.aqE, this.aqg);
                    a(this.aqH, this.aqC, this.aqh);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.aqf);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aqg);
            } else if (i == 2) {
                a(arrayList.get(i2), this.aqh);
            }
        }
    }

    private void ej(int i) {
        if (this.aqo.size() != 0) {
            int size = this.aqo.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aqo.get(i2).intValue() == i) {
                    this.aqo.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.aqe.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.aqe.c(str, 10, false);
        } else {
            this.aqe.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aqj.setText("");
            return;
        }
        String trim = str.trim();
        this.aqj.setVisibility(0);
        if (com.baidu.tbadk.util.u.gy(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 12)) + "...";
        }
        this.aqj.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(r.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aqc.setText("");
            this.aqc.setVisibility(8);
            return;
        }
        this.aqc.setVisibility(0);
        this.aqc.setText(str);
    }

    private void setTitle(String str) {
        this.aqK = str;
        if (this.aqp != 0) {
            this.apY.setPadding(0, 0, (int) this.context.getResources().getDimension(this.aqp), 0);
            this.aqp = 0;
        } else {
            this.apY.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.apY.setText("");
            return;
        }
        this.apY.setVisibility(0);
        if (this.aqr) {
            if (this.aqu) {
                this.apY.setText(ap.c(this.context, str, r.j.kn_zhibo));
                return;
            } else {
                this.apY.setText(e(str));
                return;
            }
        }
        this.apY.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cQ = ar.cQ(r.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
        int height = cQ.getHeight();
        bitmapDrawable.setBounds(0, 0, cQ.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.apO.c(str, 12, false);
        } else {
            this.apO.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apR.setText("");
            return;
        }
        this.apR.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.u.gy(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 14)) + "...";
        }
        this.apR.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            d(this.apS, this.context.getResources().getString(r.j.fans_default_name));
        } else {
            d(this.apS, str);
        }
    }

    private void d(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = ar.getDrawable(r.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.apT.setText(av.y(i));
    }

    private void setReplyNum(int i) {
        b(this.apU, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(av.y(j));
        Drawable drawable = ar.getDrawable(r.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.aql.setVisibility(0);
            b(this.aql, i);
            return;
        }
        this.aql.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.apJ) {
            this.apV.setVisibility(0);
            ar.k(this.apV, r.f.label_onthelist);
            return;
        }
        this.apV.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.apI) {
            this.apW.setVisibility(0);
            this.apW.setText(str);
            return;
        }
        this.apW.setVisibility(8);
        this.apW.setText("");
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.apZ.setVisibility(8);
            return;
        }
        this.apZ.setVisibility(0);
        this.apZ.setText(str);
    }

    private void p(String str, boolean z) {
        if (!z) {
            this.aqk.setVisibility(8);
            return;
        }
        this.aqk.setVisibility(0);
        this.aqk.setText(str);
    }

    public void setShowHead(boolean z) {
        this.apA = z;
    }

    public void setShowTitle(boolean z) {
        this.apB = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.apG = z;
    }

    public void setShowContent(boolean z) {
        this.apC = z;
    }

    public void setShowCover(boolean z) {
        this.apD = z;
    }

    public void setShowExpression(boolean z) {
        this.apE = z;
    }

    public void setShowBottom(boolean z) {
        this.apF = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.apI = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.apJ = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.apK = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.apL = z;
    }

    public void setChooseStyle(int i) {
        this.aqn = i;
    }

    public int getShowStyle() {
        return this.aqn;
    }

    public void setShowLiveIcon(boolean z) {
        this.aqr = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.apy = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.apz = bVar;
    }

    public void setParentBackground(int i) {
        ar.k(this.apM, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.aqs = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.apH = z;
    }

    public void setTitlePaddingRight(int i) {
        this.aqp = i;
    }

    public void setTitleMaxLines(int i) {
        this.aqq = i;
    }

    public void setAllowGreyState(boolean z) {
        this.aqt = z;
    }

    public void bo(boolean z) {
        this.aqu = z;
    }
}
