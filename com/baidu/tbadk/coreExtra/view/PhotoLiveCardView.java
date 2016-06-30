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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aeK;
    private boolean ahe;
    private boolean alA;
    private boolean alB;
    private boolean alC;
    private boolean alD;
    private boolean alE;
    private boolean alF;
    private boolean alG;
    private boolean alH;
    private boolean alI;
    private boolean alJ;
    private boolean alK;
    private boolean alL;
    private LinearLayout alM;
    private View alN;
    private HeadImageView alO;
    private FrameLayout alP;
    private LinearLayout alQ;
    private TextView alR;
    private TextView alS;
    private TextView alT;
    private TextView alU;
    private TextView alV;
    private TextView alW;
    private LinearLayout alX;
    private TextView alY;
    private TextView alZ;
    private a aly;
    private b alz;
    private int amA;
    private int amB;
    private int amC;
    private int amD;
    private int amE;
    private int amF;
    private int amG;
    private int amH;
    private int amI;
    private String amJ;
    private LinearLayout ama;
    private TextView amb;
    private RelativeLayout amc;
    private TbImageView amd;
    private TextView ame;
    private TextView amf;
    private TextView amg;
    private RelativeLayout amh;
    private TextView ami;
    private TextView amj;
    private TextView amk;
    private TextView aml;
    private int amm;
    private ArrayList<Integer> amn;
    private int amo;
    private int amp;
    private boolean amq;
    private boolean amr;
    private boolean ams;
    private boolean amt;
    private int amu;
    private int amv;
    private int amw;
    private int amx;
    private int amy;
    private int amz;
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
        this.alA = true;
        this.alB = true;
        this.alC = true;
        this.alD = true;
        this.alE = true;
        this.alF = true;
        this.alG = false;
        this.alH = false;
        this.alI = false;
        this.alJ = false;
        this.alK = false;
        this.alL = false;
        this.amm = 0;
        this.amn = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.amo = 0;
        this.amp = 0;
        this.amq = false;
        this.amr = true;
        this.ams = false;
        this.amt = false;
        this.ahe = false;
        this.aeK = 3;
        this.padding = 0;
        this.amu = 0;
        this.amv = 0;
        this.amw = 0;
        this.amx = 0;
        this.amJ = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(u.e.ds24);
        this.amv = (int) context.getResources().getDimension(u.e.ds100);
        this.amu = (int) context.getResources().getDimension(u.e.ds70);
        this.amw = (int) context.getResources().getDimension(u.e.ds18);
        this.amx = (int) context.getResources().getDimension(u.e.ds4);
        this.amy = (int) context.getResources().getDimension(u.e.ds80);
        this.amz = (int) context.getResources().getDimension(u.e.ds280);
        this.amA = (int) context.getResources().getDimension(u.e.ds170);
        this.amB = (int) context.getResources().getDimension(u.e.ds320);
        this.amC = (int) context.getResources().getDimension(u.e.ds200);
        this.amD = (int) context.getResources().getDimension(u.e.ds60);
        this.amE = (int) context.getResources().getDimension(u.e.ds120);
        this.amF = (int) context.getResources().getDimension(u.e.ds160);
        this.amG = (int) context.getResources().getDimension(u.e.ds220);
        this.amH = (int) context.getResources().getDimension(u.e.ds240);
        this.amI = (int) context.getResources().getDimension(u.e.ds180);
        this.size = (int) context.getResources().getDimension(u.e.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(u.h.photo_live_card_view, this);
        this.alM = (LinearLayout) inflate.findViewById(u.g.pl_card_root);
        this.alN = inflate.findViewById(u.g.author_info);
        this.alX = (LinearLayout) inflate.findViewById(u.g.photo_live_card_title);
        this.ama = (LinearLayout) inflate.findViewById(u.g.photo_live_card_content);
        this.amc = (RelativeLayout) inflate.findViewById(u.g.photo_live_card_cover_and_expression);
        this.amh = (RelativeLayout) inflate.findViewById(u.g.photo_live_card_bottom);
        zE();
        zF();
        zG();
        zI();
        zH();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.alA, photoLiveCardData);
            b(this.alB, this.alG, photoLiveCardData);
            b(this.alC, photoLiveCardData);
            a(this.alD, this.alE, photoLiveCardData);
            a(this.alF, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.ahe = true;
        } else {
            this.ahe = false;
        }
    }

    public void vm() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aeK) {
            av.k(this.alM, u.f.frs_item_control_btn_bg);
            if (this.alA) {
                av.c(this.alR, u.d.cp_cont_f, 1);
                av.c(this.alS, u.d.cp_cont_d, 1);
                av.c(this.alT, u.d.cp_cont_d, 1);
                av.c(this.alU, u.d.cp_cont_d, 1);
                av.c(this.alW, u.d.cp_cont_d, 1);
                Drawable drawable = av.getDrawable(u.f.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.alS.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = av.getDrawable(u.f.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.alU.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.alB) {
                av.c(this.title, u.d.cp_cont_b, 1);
                av.c(this.alY, u.d.cp_cont_c, 1);
                av.c(this.alZ, u.d.cp_cont_i, 1);
                av.k(this.alZ, u.f.blacklist_remove_button_bg);
                this.title.setText(e(this.amJ));
            }
            if (this.alF) {
                av.c(this.ami, u.d.cp_cont_i, 1);
                av.k(this.ami, u.f.label_bg_tie);
                av.c(this.amj, u.d.cp_cont_d, 1);
                av.c(this.amk, u.d.cp_cont_d, 1);
                av.c(this.ami, u.d.cp_cont_i, 1);
            }
            av.c(this.amb, u.d.cp_cont_b, 1);
            zJ();
            this.aeK = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.amr) {
                if (this.paddingBottom != 0) {
                    this.amc.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.amc.setPadding(this.padding, 0, this.padding, 0);
                }
                this.amc.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.amc != null) {
                this.amc.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.amh.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.alH);
                h(photoLiveCardData.getDiscussNum(), this.alK);
                return;
            }
            this.amh.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alX.setVisibility(0);
                if (this.amp != 0) {
                    this.title.setMaxLines(this.amp);
                } else {
                    this.title.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.title, photoLiveCardData.getThreadId());
                return;
            }
            this.alX.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.alL) {
            this.alZ.setVisibility(0);
            this.alZ.setTag(photoLiveCardData);
            return;
        }
        this.alZ.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.ama.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.ama.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.ama.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.amb, photoLiveCardData.getThreadId());
                return;
            }
            this.ama.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.ams) {
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.pL(String.valueOf(j))) {
                av.c(textView, u.d.cp_cont_c, 1);
            } else {
                av.c(textView, u.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alN.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.alN.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.alN.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.alO.getLayoutParams();
                if (this.ahe) {
                    if (layoutParams != null) {
                        layoutParams.height = this.amv;
                        layoutParams.width = this.amv;
                    }
                    if (this.aml == null) {
                        this.aml = new TextView(this.context);
                        this.aml.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.aml.setEllipsize(TextUtils.TruncateAt.END);
                        this.aml.setTextSize(0, this.amw);
                        av.j((View) this.aml, u.d.cp_cont_h);
                        av.k(this.aml, u.f.icon_shen);
                        this.aml.setSingleLine(true);
                        this.alQ.addView(this.aml);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.aml.setText(u.j.god_intro_default);
                    } else {
                        this.aml.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.alQ.removeView(this.aml);
                    this.aml = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.amu;
                        layoutParams.width = this.amu;
                    }
                }
                this.alO.setTag(photoLiveCardData);
                eO(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.alQ.removeView(this.aml);
            this.alN.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.alO.setPadding(this.amx, this.amx, this.amx, this.amx);
            if (this.ahe) {
                this.alP.setBackgroundDrawable(av.getDrawable(u.f.pic_bg_jinbian));
                return;
            } else {
                this.alP.setBackgroundDrawable(av.getDrawable(u.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.alP.setBackgroundDrawable(null);
        this.alO.setPadding(0, 0, 0, 0);
    }

    private void zE() {
        if (this.alN != null) {
            this.alO = (HeadImageView) this.alN.findViewById(u.g.author_portrait);
            this.alP = (FrameLayout) this.alN.findViewById(u.g.author_portrait_info);
            this.alR = (TextView) this.alN.findViewById(u.g.author_name);
            this.alS = (TextView) this.alN.findViewById(u.g.nick_name);
            this.alT = (TextView) this.alN.findViewById(u.g.fans_num);
            this.alU = (TextView) this.alN.findViewById(u.g.reply_num);
            this.alV = (TextView) this.alN.findViewById(u.g.headlive_icon);
            this.alW = (TextView) this.alN.findViewById(u.g.refresh_time_in_head);
            this.alQ = (LinearLayout) this.alN.findViewById(u.g.author_info_and_time);
            this.alO.setOnClickListener(new s(this));
        }
    }

    private void zF() {
        if (this.alX != null) {
            this.title = (TextView) this.alX.findViewById(u.g.title);
            this.alY = (TextView) findViewById(u.g.refresh_time_in_title);
            this.alZ = (TextView) this.alX.findViewById(u.g.card_delete_in_title);
            this.alZ.setOnClickListener(new t(this));
        }
    }

    private void zG() {
        if (this.ama != null) {
            this.amb = (TextView) this.ama.findViewById(u.g.content);
        }
    }

    private void zH() {
        if (this.amh != null) {
            this.ami = (TextView) this.amh.findViewById(u.g.ba_name);
            this.amj = (TextView) this.amh.findViewById(u.g.bottom_refresh_time);
            this.amk = (TextView) this.amh.findViewById(u.g.bottom_reply_num);
        }
    }

    private void zI() {
        if (this.amc != null) {
            this.amd = (TbImageView) this.amc.findViewById(u.g.live_cover);
            this.amd.setGifIconSupport(false);
            zK();
        }
    }

    private void zJ() {
        av.k(this.ame, u.f.bg_tieziyingxiang);
        av.k(this.amf, u.f.bg_tieziyingxiang);
        av.k(this.amg, u.f.bg_tieziyingxiang);
    }

    private void zK() {
        if (this.amc != null) {
            this.ame = (TextView) this.amc.findViewById(u.g.first_style_first_expression);
            this.amf = (TextView) this.amc.findViewById(u.g.first_style_second_expression);
            this.amg = (TextView) this.amc.findViewById(u.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.amn.clear();
        zM();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            zL();
        }
    }

    private void zL() {
        if (this.amn.size() != 0) {
            int size = this.amn.size();
            for (int i = 0; i < size; i++) {
                if (this.amn.get(i).intValue() == this.ame.getId()) {
                    this.ame.setVisibility(8);
                } else if (this.amn.get(i).intValue() == this.amf.getId()) {
                    this.amf.setVisibility(8);
                } else if (this.amn.get(i).intValue() == this.amg.getId()) {
                    this.amg.setVisibility(8);
                }
            }
        }
    }

    private void zM() {
        this.ame.setText("");
        this.amf.setText("");
        this.amg.setText("");
        if (this.ame.getVisibility() == 8) {
            this.ame.setVisibility(0);
        }
        if (this.amf.getVisibility() == 8) {
            this.amf.setVisibility(0);
        }
        if (this.amg.getVisibility() == 8) {
            this.amg.setVisibility(0);
        }
        this.amn.add(Integer.valueOf(this.ame.getId()));
        this.amn.add(Integer.valueOf(this.amf.getId()));
        this.amn.add(Integer.valueOf(this.amg.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.zx())));
            dS(textView.getId());
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
            switch (this.amm) {
                case 0:
                    a(this.amy, this.amz, this.ame);
                    a(this.amA, this.amB, this.amf);
                    a(this.amC, this.amD, this.amg);
                    break;
                case 1:
                    a(this.amD, this.amE, this.ame);
                    a(this.amF, this.amD, this.amf);
                    a(this.amG, this.amB, this.amg);
                    break;
                case 2:
                    a(this.amD, this.amH, this.ame);
                    a(this.amI, this.amD, this.amf);
                    a(this.amG, this.amB, this.amg);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.ame);
            } else if (i == 1) {
                a(arrayList.get(i2), this.amf);
            } else if (i == 2) {
                a(arrayList.get(i2), this.amg);
            }
        }
    }

    private void dS(int i) {
        if (this.amn.size() != 0) {
            int size = this.amn.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.amn.get(i2).intValue() == i) {
                    this.amn.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.amd.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.amd.c(str, 10, false);
        } else {
            this.amd.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ami.setText("");
            return;
        }
        String trim = str.trim();
        this.ami.setVisibility(0);
        if (com.baidu.tbadk.util.u.gx(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 12)) + "...";
        }
        this.ami.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(u.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.amb.setText("");
            this.amb.setVisibility(8);
            return;
        }
        this.amb.setVisibility(0);
        this.amb.setText(str);
    }

    private void setTitle(String str) {
        this.amJ = str;
        if (this.amo != 0) {
            this.title.setPadding(0, 0, (int) this.context.getResources().getDimension(this.amo), 0);
            this.amo = 0;
        } else {
            this.title.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.title.setText("");
            return;
        }
        this.title.setVisibility(0);
        if (this.amq) {
            if (this.amt) {
                this.title.setText(at.c(this.context, str, u.j.kn_zhibo));
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
        Bitmap cA = av.cA(u.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
        int height = cA.getHeight();
        bitmapDrawable.setBounds(0, 0, cA.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eO(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.alO.c(str, 12, false);
        } else {
            this.alO.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alR.setText("");
            return;
        }
        this.alR.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.u.gx(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 14)) + "...";
        }
        this.alR.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            d(this.alS, this.context.getResources().getString(u.j.fans_default_name));
        } else {
            d(this.alS, str);
        }
    }

    private void d(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = av.getDrawable(u.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.alT.setText(ba.D(i));
    }

    private void setReplyNum(int i) {
        b(this.alU, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(ba.D(j));
        Drawable drawable = av.getDrawable(u.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void h(int i, boolean z) {
        if (z) {
            this.amk.setVisibility(0);
            b(this.amk, i);
            return;
        }
        this.amk.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.alJ) {
            this.alV.setVisibility(0);
            av.k(this.alV, u.f.label_onthelist);
            return;
        }
        this.alV.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.alI) {
            this.alW.setVisibility(0);
            this.alW.setText(str);
            return;
        }
        this.alW.setVisibility(8);
        this.alW.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.alY.setVisibility(8);
            return;
        }
        this.alY.setVisibility(0);
        this.alY.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.amj.setVisibility(8);
            return;
        }
        this.amj.setVisibility(0);
        this.amj.setText(str);
    }

    public void setShowHead(boolean z) {
        this.alA = z;
    }

    public void setShowTitle(boolean z) {
        this.alB = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.alG = z;
    }

    public void setShowContent(boolean z) {
        this.alC = z;
    }

    public void setShowCover(boolean z) {
        this.alD = z;
    }

    public void setShowExpression(boolean z) {
        this.alE = z;
    }

    public void setShowBottom(boolean z) {
        this.alF = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.alI = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.alJ = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.alK = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.alL = z;
    }

    public void setChooseStyle(int i) {
        this.amm = i;
    }

    public int getShowStyle() {
        return this.amm;
    }

    public void setShowLiveIcon(boolean z) {
        this.amq = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.aly = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.alz = bVar;
    }

    public void setParentBackground(int i) {
        av.k(this.alM, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.amr = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.alH = z;
    }

    public void setTitlePaddingRight(int i) {
        this.amo = i;
    }

    public void setTitleMaxLines(int i) {
        this.amp = i;
    }

    public void setAllowGreyState(boolean z) {
        this.ams = z;
    }

    public void bg(boolean z) {
        this.amt = z;
    }
}
