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
import com.baidu.tieba.card.au;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aej;
    private boolean agA;
    private a akR;
    private b akS;
    private boolean akT;
    private boolean akU;
    private boolean akV;
    private boolean akW;
    private boolean akX;
    private boolean akY;
    private boolean akZ;
    private TextView alA;
    private RelativeLayout alB;
    private TextView alC;
    private TextView alD;
    private TextView alE;
    private TextView alF;
    private int alG;
    private ArrayList<Integer> alH;
    private int alI;
    private int alJ;
    private boolean alK;
    private boolean alL;
    private boolean alM;
    private boolean alN;
    private int alO;
    private int alP;
    private int alQ;
    private int alR;
    private int alS;
    private int alT;
    private int alU;
    private int alV;
    private int alW;
    private int alX;
    private int alY;
    private int alZ;
    private boolean ala;
    private boolean alb;
    private boolean alc;
    private boolean ald;
    private boolean ale;
    private LinearLayout alf;
    private View alg;
    private HeadImageView alh;
    private FrameLayout ali;
    private LinearLayout alj;
    private TextView alk;
    private TextView alm;
    private TextView aln;
    private TextView alo;
    private TextView alp;
    private TextView alq;
    private LinearLayout alr;
    private TextView als;
    private TextView alt;
    private LinearLayout alu;
    private TextView alv;
    private RelativeLayout alw;
    private TbImageView alx;
    private TextView aly;
    private TextView alz;
    private int ama;
    private int amb;
    private int amc;
    private String amd;
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
        this.akT = true;
        this.akU = true;
        this.akV = true;
        this.akW = true;
        this.akX = true;
        this.akY = true;
        this.akZ = false;
        this.ala = false;
        this.alb = false;
        this.alc = false;
        this.ald = false;
        this.ale = false;
        this.alG = 0;
        this.alH = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alI = 0;
        this.alJ = 0;
        this.alK = false;
        this.alL = true;
        this.alM = false;
        this.alN = false;
        this.agA = false;
        this.aej = 3;
        this.padding = 0;
        this.alO = 0;
        this.alP = 0;
        this.alQ = 0;
        this.alR = 0;
        this.amd = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(t.e.ds24);
        this.alP = (int) context.getResources().getDimension(t.e.ds100);
        this.alO = (int) context.getResources().getDimension(t.e.ds70);
        this.alQ = (int) context.getResources().getDimension(t.e.ds18);
        this.alR = (int) context.getResources().getDimension(t.e.ds4);
        this.alS = (int) context.getResources().getDimension(t.e.ds80);
        this.alT = (int) context.getResources().getDimension(t.e.ds280);
        this.alU = (int) context.getResources().getDimension(t.e.ds170);
        this.alV = (int) context.getResources().getDimension(t.e.ds320);
        this.alW = (int) context.getResources().getDimension(t.e.ds200);
        this.alX = (int) context.getResources().getDimension(t.e.ds60);
        this.alY = (int) context.getResources().getDimension(t.e.ds120);
        this.alZ = (int) context.getResources().getDimension(t.e.ds160);
        this.ama = (int) context.getResources().getDimension(t.e.ds220);
        this.amb = (int) context.getResources().getDimension(t.e.ds240);
        this.amc = (int) context.getResources().getDimension(t.e.ds180);
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
        this.alf = (LinearLayout) inflate.findViewById(t.g.pl_card_root);
        this.alg = inflate.findViewById(t.g.author_info);
        this.alr = (LinearLayout) inflate.findViewById(t.g.photo_live_card_title);
        this.alu = (LinearLayout) inflate.findViewById(t.g.photo_live_card_content);
        this.alw = (RelativeLayout) inflate.findViewById(t.g.photo_live_card_cover_and_expression);
        this.alB = (RelativeLayout) inflate.findViewById(t.g.photo_live_card_bottom);
        zy();
        zz();
        zA();
        zC();
        zB();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.akT, photoLiveCardData);
            b(this.akU, this.akZ, photoLiveCardData);
            b(this.akV, photoLiveCardData);
            a(this.akW, this.akX, photoLiveCardData);
            a(this.akY, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.agA = true;
        } else {
            this.agA = false;
        }
    }

    public void vl() {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (skinType != this.aej) {
            at.k(this.alf, t.f.frs_item_control_btn_bg);
            if (this.akT) {
                at.c(this.alk, t.d.cp_cont_f, 1);
                at.c(this.alm, t.d.cp_cont_d, 1);
                at.c(this.aln, t.d.cp_cont_d, 1);
                at.c(this.alo, t.d.cp_cont_d, 1);
                at.c(this.alq, t.d.cp_cont_d, 1);
                Drawable drawable = at.getDrawable(t.f.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.alm.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = at.getDrawable(t.f.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.alo.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.akU) {
                at.c(this.title, t.d.cp_cont_b, 1);
                at.c(this.als, t.d.cp_cont_c, 1);
                at.c(this.alt, t.d.cp_cont_i, 1);
                at.k(this.alt, t.f.blacklist_remove_button_bg);
                this.title.setText(e(this.amd));
            }
            if (this.akY) {
                at.c(this.alC, t.d.cp_cont_i, 1);
                at.k(this.alC, t.f.label_bg_tie);
                at.c(this.alD, t.d.cp_cont_d, 1);
                at.c(this.alE, t.d.cp_cont_d, 1);
                at.c(this.alC, t.d.cp_cont_i, 1);
            }
            at.c(this.alv, t.d.cp_cont_b, 1);
            zD();
            this.aej = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.alL) {
                if (this.paddingBottom != 0) {
                    this.alw.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.alw.setPadding(this.padding, 0, this.padding, 0);
                }
                this.alw.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.alw != null) {
                this.alw.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alB.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.ala);
                h(photoLiveCardData.getDiscussNum(), this.ald);
                return;
            }
            this.alB.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alr.setVisibility(0);
                if (this.alJ != 0) {
                    this.title.setMaxLines(this.alJ);
                } else {
                    this.title.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.title, photoLiveCardData.getThreadId());
                return;
            }
            this.alr.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.ale) {
            this.alt.setVisibility(0);
            this.alt.setTag(photoLiveCardData);
            return;
        }
        this.alt.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alu.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.alu.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.alu.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.alv, photoLiveCardData.getThreadId());
                return;
            }
            this.alu.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.alM) {
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.od(String.valueOf(j))) {
                at.c(textView, t.d.cp_cont_c, 1);
            } else {
                at.c(textView, t.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alg.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.alg.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.alg.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.alh.getLayoutParams();
                if (this.agA) {
                    if (layoutParams != null) {
                        layoutParams.height = this.alP;
                        layoutParams.width = this.alP;
                    }
                    if (this.alF == null) {
                        this.alF = new TextView(this.context);
                        this.alF.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.alF.setEllipsize(TextUtils.TruncateAt.END);
                        this.alF.setTextSize(0, this.alQ);
                        at.j((View) this.alF, t.d.cp_cont_h);
                        at.k(this.alF, t.f.icon_shen);
                        this.alF.setSingleLine(true);
                        this.alj.addView(this.alF);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.alF.setText(t.j.god_intro_default);
                    } else {
                        this.alF.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.alj.removeView(this.alF);
                    this.alF = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.alO;
                        layoutParams.width = this.alO;
                    }
                }
                this.alh.setTag(photoLiveCardData);
                eK(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.alj.removeView(this.alF);
            this.alg.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.alh.setPadding(this.alR, this.alR, this.alR, this.alR);
            if (this.agA) {
                this.ali.setBackgroundDrawable(at.getDrawable(t.f.pic_bg_jinbian));
                return;
            } else {
                this.ali.setBackgroundDrawable(at.getDrawable(t.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.ali.setBackgroundDrawable(null);
        this.alh.setPadding(0, 0, 0, 0);
    }

    private void zy() {
        if (this.alg != null) {
            this.alh = (HeadImageView) this.alg.findViewById(t.g.author_portrait);
            this.ali = (FrameLayout) this.alg.findViewById(t.g.author_portrait_info);
            this.alk = (TextView) this.alg.findViewById(t.g.author_name);
            this.alm = (TextView) this.alg.findViewById(t.g.nick_name);
            this.aln = (TextView) this.alg.findViewById(t.g.fans_num);
            this.alo = (TextView) this.alg.findViewById(t.g.reply_num);
            this.alp = (TextView) this.alg.findViewById(t.g.headlive_icon);
            this.alq = (TextView) this.alg.findViewById(t.g.refresh_time_in_head);
            this.alj = (LinearLayout) this.alg.findViewById(t.g.author_info_and_time);
            this.alh.setOnClickListener(new s(this));
        }
    }

    private void zz() {
        if (this.alr != null) {
            this.title = (TextView) this.alr.findViewById(t.g.title);
            this.als = (TextView) findViewById(t.g.refresh_time_in_title);
            this.alt = (TextView) this.alr.findViewById(t.g.card_delete_in_title);
            this.alt.setOnClickListener(new t(this));
        }
    }

    private void zA() {
        if (this.alu != null) {
            this.alv = (TextView) this.alu.findViewById(t.g.content);
        }
    }

    private void zB() {
        if (this.alB != null) {
            this.alC = (TextView) this.alB.findViewById(t.g.ba_name);
            this.alD = (TextView) this.alB.findViewById(t.g.bottom_refresh_time);
            this.alE = (TextView) this.alB.findViewById(t.g.bottom_reply_num);
        }
    }

    private void zC() {
        if (this.alw != null) {
            this.alx = (TbImageView) this.alw.findViewById(t.g.live_cover);
            this.alx.setGifIconSupport(false);
            zE();
        }
    }

    private void zD() {
        at.k(this.aly, t.f.bg_tieziyingxiang);
        at.k(this.alz, t.f.bg_tieziyingxiang);
        at.k(this.alA, t.f.bg_tieziyingxiang);
    }

    private void zE() {
        if (this.alw != null) {
            this.aly = (TextView) this.alw.findViewById(t.g.first_style_first_expression);
            this.alz = (TextView) this.alw.findViewById(t.g.first_style_second_expression);
            this.alA = (TextView) this.alw.findViewById(t.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.alH.clear();
        zG();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            zF();
        }
    }

    private void zF() {
        if (this.alH.size() != 0) {
            int size = this.alH.size();
            for (int i = 0; i < size; i++) {
                if (this.alH.get(i).intValue() == this.aly.getId()) {
                    this.aly.setVisibility(8);
                } else if (this.alH.get(i).intValue() == this.alz.getId()) {
                    this.alz.setVisibility(8);
                } else if (this.alH.get(i).intValue() == this.alA.getId()) {
                    this.alA.setVisibility(8);
                }
            }
        }
    }

    private void zG() {
        this.aly.setText("");
        this.alz.setText("");
        this.alA.setText("");
        if (this.aly.getVisibility() == 8) {
            this.aly.setVisibility(0);
        }
        if (this.alz.getVisibility() == 8) {
            this.alz.setVisibility(0);
        }
        if (this.alA.getVisibility() == 8) {
            this.alA.setVisibility(0);
        }
        this.alH.add(Integer.valueOf(this.aly.getId()));
        this.alH.add(Integer.valueOf(this.alz.getId()));
        this.alH.add(Integer.valueOf(this.alA.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.zr())));
            dR(textView.getId());
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
            switch (this.alG) {
                case 0:
                    a(this.alS, this.alT, this.aly);
                    a(this.alU, this.alV, this.alz);
                    a(this.alW, this.alX, this.alA);
                    break;
                case 1:
                    a(this.alX, this.alY, this.aly);
                    a(this.alZ, this.alX, this.alz);
                    a(this.ama, this.alV, this.alA);
                    break;
                case 2:
                    a(this.alX, this.amb, this.aly);
                    a(this.amc, this.alX, this.alz);
                    a(this.ama, this.alV, this.alA);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.aly);
            } else if (i == 1) {
                a(arrayList.get(i2), this.alz);
            } else if (i == 2) {
                a(arrayList.get(i2), this.alA);
            }
        }
    }

    private void dR(int i) {
        if (this.alH.size() != 0) {
            int size = this.alH.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.alH.get(i2).intValue() == i) {
                    this.alH.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.alx.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.alx.c(str, 10, false);
        } else {
            this.alx.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alC.setText("");
            return;
        }
        String trim = str.trim();
        this.alC.setVisibility(0);
        if (com.baidu.tbadk.util.u.gp(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 12)) + "...";
        }
        this.alC.setText(String.valueOf(trim) + TbadkCoreApplication.m11getInst().getResources().getString(t.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alv.setText("");
            this.alv.setVisibility(8);
            return;
        }
        this.alv.setVisibility(0);
        this.alv.setText(str);
    }

    private void setTitle(String str) {
        this.amd = str;
        if (this.alI != 0) {
            this.title.setPadding(0, 0, (int) this.context.getResources().getDimension(this.alI), 0);
            this.alI = 0;
        } else {
            this.title.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.title.setText("");
            return;
        }
        this.title.setVisibility(0);
        if (this.alK) {
            if (this.alN) {
                this.title.setText(au.c(this.context, str, t.j.kn_zhibo));
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
        Bitmap cA = at.cA(t.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
        int height = cA.getHeight();
        bitmapDrawable.setBounds(0, 0, cA.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.alh.c(str, 12, false);
        } else {
            this.alh.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alk.setText("");
            return;
        }
        this.alk.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.u.gp(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 14)) + "...";
        }
        this.alk.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            c(this.alm, this.context.getResources().getString(t.j.fans_default_name));
        } else {
            c(this.alm, str);
        }
    }

    private void c(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = at.getDrawable(t.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.aln.setText(ay.B(i));
    }

    private void setReplyNum(int i) {
        b(this.alo, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(ay.B(j));
        Drawable drawable = at.getDrawable(t.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void h(int i, boolean z) {
        if (z) {
            this.alE.setVisibility(0);
            b(this.alE, i);
            return;
        }
        this.alE.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.alc) {
            this.alp.setVisibility(0);
            at.k(this.alp, t.f.label_onthelist);
            return;
        }
        this.alp.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.alb) {
            this.alq.setVisibility(0);
            this.alq.setText(str);
            return;
        }
        this.alq.setVisibility(8);
        this.alq.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.als.setVisibility(8);
            return;
        }
        this.als.setVisibility(0);
        this.als.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.alD.setVisibility(8);
            return;
        }
        this.alD.setVisibility(0);
        this.alD.setText(str);
    }

    public void setShowHead(boolean z) {
        this.akT = z;
    }

    public void setShowTitle(boolean z) {
        this.akU = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.akZ = z;
    }

    public void setShowContent(boolean z) {
        this.akV = z;
    }

    public void setShowCover(boolean z) {
        this.akW = z;
    }

    public void setShowExpression(boolean z) {
        this.akX = z;
    }

    public void setShowBottom(boolean z) {
        this.akY = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.alb = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.alc = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.ald = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.ale = z;
    }

    public void setChooseStyle(int i) {
        this.alG = i;
    }

    public int getShowStyle() {
        return this.alG;
    }

    public void setShowLiveIcon(boolean z) {
        this.alK = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.akR = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.akS = bVar;
    }

    public void setParentBackground(int i) {
        at.k(this.alf, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.alL = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.ala = z;
    }

    public void setTitlePaddingRight(int i) {
        this.alI = i;
    }

    public void setTitleMaxLines(int i) {
        this.alJ = i;
    }

    public void setAllowGreyState(boolean z) {
        this.alM = z;
    }

    public void bj(boolean z) {
        this.alN = z;
    }
}
