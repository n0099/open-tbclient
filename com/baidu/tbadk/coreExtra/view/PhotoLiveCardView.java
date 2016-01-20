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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int ahf;
    private TextView ahk;
    private a anV;
    private b anW;
    private boolean anX;
    private boolean anY;
    private boolean anZ;
    private TbImageView aoA;
    private TextView aoB;
    private TextView aoC;
    private TextView aoD;
    private RelativeLayout aoE;
    private TextView aoF;
    private TextView aoG;
    private TextView aoH;
    private TextView aoI;
    private int aoJ;
    private ArrayList<Integer> aoK;
    private int aoL;
    private int aoM;
    private boolean aoN;
    private boolean aoO;
    private boolean aoP;
    private boolean aoQ;
    private int aoR;
    private int aoS;
    private int aoT;
    private int aoU;
    private int aoV;
    private int aoW;
    private int aoX;
    private int aoY;
    private int aoZ;
    private boolean aoa;
    private boolean aob;
    private boolean aoc;
    private boolean aod;
    private boolean aoe;
    private boolean aof;
    private boolean aog;
    private boolean aoh;
    private boolean aoi;
    private LinearLayout aoj;
    private View aok;
    private HeadImageView aol;
    private FrameLayout aom;
    private LinearLayout aon;
    private TextView aoo;
    private TextView aop;
    private TextView aoq;
    private TextView aor;
    private TextView aos;
    private TextView aot;
    private LinearLayout aou;
    private TextView aov;
    private TextView aow;
    private LinearLayout aox;
    private TextView aoy;
    private RelativeLayout aoz;
    private int apa;
    private int apb;
    private int apc;
    private int apd;
    private int ape;
    private int apf;
    private String apg;
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
        this.anX = true;
        this.anY = true;
        this.anZ = true;
        this.aoa = true;
        this.aob = true;
        this.aoc = true;
        this.aod = false;
        this.aoe = false;
        this.aof = false;
        this.aog = false;
        this.aoh = false;
        this.aoi = false;
        this.aoJ = 0;
        this.aoK = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.aoL = 0;
        this.aoM = 0;
        this.aoN = false;
        this.aoO = true;
        this.aoP = false;
        this.aoQ = false;
        this.ahf = 3;
        this.padding = 0;
        this.aoR = 0;
        this.aoS = 0;
        this.aoT = 0;
        this.aoU = 0;
        this.apg = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(n.e.ds24);
        this.aoS = (int) context.getResources().getDimension(n.e.ds100);
        this.aoR = (int) context.getResources().getDimension(n.e.ds70);
        this.aoT = (int) context.getResources().getDimension(n.e.ds18);
        this.aoU = (int) context.getResources().getDimension(n.e.ds4);
        this.aoV = (int) context.getResources().getDimension(n.e.ds80);
        this.aoW = (int) context.getResources().getDimension(n.e.ds280);
        this.aoX = (int) context.getResources().getDimension(n.e.ds170);
        this.aoY = (int) context.getResources().getDimension(n.e.ds320);
        this.aoZ = (int) context.getResources().getDimension(n.e.ds200);
        this.apa = (int) context.getResources().getDimension(n.e.ds60);
        this.apb = (int) context.getResources().getDimension(n.e.ds120);
        this.apc = (int) context.getResources().getDimension(n.e.ds160);
        this.apd = (int) context.getResources().getDimension(n.e.ds220);
        this.ape = (int) context.getResources().getDimension(n.e.ds240);
        this.apf = (int) context.getResources().getDimension(n.e.ds180);
        this.size = (int) context.getResources().getDimension(n.e.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(n.h.photo_live_card_view, this);
        this.aoj = (LinearLayout) inflate.findViewById(n.g.pl_card_root);
        this.aok = inflate.findViewById(n.g.author_info);
        this.aou = (LinearLayout) inflate.findViewById(n.g.photo_live_card_title);
        this.aox = (LinearLayout) inflate.findViewById(n.g.photo_live_card_content);
        this.aoz = (RelativeLayout) inflate.findViewById(n.g.photo_live_card_cover_and_expression);
        this.aoE = (RelativeLayout) inflate.findViewById(n.g.photo_live_card_bottom);
        zL();
        zM();
        zN();
        zP();
        zO();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.anX, photoLiveCardData);
            b(this.anY, this.aod, photoLiveCardData);
            b(this.anZ, photoLiveCardData);
            a(this.aoa, this.aob, photoLiveCardData);
            a(this.aoc, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.aoQ = true;
        } else {
            this.aoQ = false;
        }
    }

    public void vR() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahf) {
            as.i(this.aoj, n.f.frs_item_control_btn_bg);
            if (this.anX) {
                as.b(this.aoo, n.d.cp_cont_f, 1);
                as.b(this.aop, n.d.cp_cont_d, 1);
                as.b(this.aoq, n.d.cp_cont_d, 1);
                as.b(this.aor, n.d.cp_cont_d, 1);
                as.b(this.aot, n.d.cp_cont_d, 1);
                Drawable drawable = as.getDrawable(n.f.icon_fengsi_n);
                drawable.setBounds(0, 0, this.size, this.size);
                this.aop.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = as.getDrawable(n.f.icon_comment_n);
                drawable2.setBounds(0, 0, this.size, this.size);
                this.aor.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.anY) {
                as.b(this.ahk, n.d.cp_cont_b, 1);
                as.b(this.aov, n.d.cp_cont_c, 1);
                as.b(this.aow, n.d.cp_cont_i, 1);
                as.i((View) this.aow, n.f.blacklist_remove_button_bg);
                this.ahk.setText(e(this.apg));
            }
            if (this.aoc) {
                as.b(this.aoF, n.d.cp_cont_i, 1);
                as.i((View) this.aoF, n.f.label_bg_tie);
                as.b(this.aoG, n.d.cp_cont_d, 1);
                as.b(this.aoH, n.d.cp_cont_d, 1);
                as.b(this.aoF, n.d.cp_cont_i, 1);
            }
            as.b(this.aoy, n.d.cp_cont_b, 1);
            zQ();
            this.ahf = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.aoO) {
                if (this.paddingBottom != 0) {
                    this.aoz.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.aoz.setPadding(this.padding, 0, this.padding, 0);
                }
                this.aoz.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.aoz != null) {
                this.aoz.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aoE.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                o(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.aoe);
                f(photoLiveCardData.getDiscussNum(), this.aoh);
                return;
            }
            this.aoE.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aou.setVisibility(0);
                if (this.aoM != 0) {
                    this.ahk.setMaxLines(this.aoM);
                } else {
                    this.ahk.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                n(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.ahk, photoLiveCardData.getThreadId());
                return;
            }
            this.aou.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.aoi) {
            this.aow.setVisibility(0);
            this.aow.setTag(photoLiveCardData);
            return;
        }
        this.aow.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aox.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.aox.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.aox.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.aoy, photoLiveCardData.getThreadId());
                return;
            }
            this.aox.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.aoP) {
            com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mD(String.valueOf(j))) {
                as.b(textView, n.d.cp_cont_c, 1);
            } else {
                as.b(textView, n.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aok.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.aok.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.aok.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.aol.getLayoutParams();
                if (this.aoQ) {
                    if (layoutParams != null) {
                        layoutParams.height = this.aoS;
                        layoutParams.width = this.aoS;
                    }
                    if (this.aoI == null) {
                        this.aoI = new TextView(this.context);
                        this.aoI.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.aoI.setEllipsize(TextUtils.TruncateAt.END);
                        this.aoI.setTextSize(0, this.aoT);
                        as.h((View) this.aoI, n.d.cp_cont_h);
                        as.i((View) this.aoI, n.f.icon_shen);
                        this.aoI.setSingleLine(true);
                        this.aon.addView(this.aoI);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.aoI.setText(n.j.god_intro_default);
                    } else {
                        this.aoI.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.aon.removeView(this.aoI);
                    this.aoI = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.aoR;
                        layoutParams.width = this.aoR;
                    }
                }
                this.aol.setTag(photoLiveCardData);
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
            this.aon.removeView(this.aoI);
            this.aok.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.aol.setPadding(this.aoU, this.aoU, this.aoU, this.aoU);
            if (this.aoQ) {
                this.aom.setBackgroundDrawable(as.getDrawable(n.f.pic_bg_jinbian));
                return;
            } else {
                this.aom.setBackgroundDrawable(as.getDrawable(n.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.aom.setBackgroundDrawable(null);
        this.aol.setPadding(0, 0, 0, 0);
    }

    private void zL() {
        if (this.aok != null) {
            this.aol = (HeadImageView) this.aok.findViewById(n.g.author_portrait);
            this.aom = (FrameLayout) this.aok.findViewById(n.g.author_portrait_info);
            this.aoo = (TextView) this.aok.findViewById(n.g.author_name);
            this.aop = (TextView) this.aok.findViewById(n.g.nick_name);
            this.aoq = (TextView) this.aok.findViewById(n.g.fans_num);
            this.aor = (TextView) this.aok.findViewById(n.g.reply_num);
            this.aos = (TextView) this.aok.findViewById(n.g.headlive_icon);
            this.aot = (TextView) this.aok.findViewById(n.g.refresh_time_in_head);
            this.aon = (LinearLayout) this.aok.findViewById(n.g.author_info_and_time);
            this.aol.setOnClickListener(new x(this));
        }
    }

    private void zM() {
        if (this.aou != null) {
            this.ahk = (TextView) this.aou.findViewById(n.g.title);
            this.aov = (TextView) findViewById(n.g.refresh_time_in_title);
            this.aow = (TextView) this.aou.findViewById(n.g.card_delete_in_title);
            this.aow.setOnClickListener(new y(this));
        }
    }

    private void zN() {
        if (this.aox != null) {
            this.aoy = (TextView) this.aox.findViewById(n.g.content);
        }
    }

    private void zO() {
        if (this.aoE != null) {
            this.aoF = (TextView) this.aoE.findViewById(n.g.ba_name);
            this.aoG = (TextView) this.aoE.findViewById(n.g.bottom_refresh_time);
            this.aoH = (TextView) this.aoE.findViewById(n.g.bottom_reply_num);
        }
    }

    private void zP() {
        if (this.aoz != null) {
            this.aoA = (TbImageView) this.aoz.findViewById(n.g.live_cover);
            this.aoA.setGifIconSupport(false);
            zR();
        }
    }

    private void zQ() {
        as.i((View) this.aoB, n.f.bg_tieziyingxiang);
        as.i((View) this.aoC, n.f.bg_tieziyingxiang);
        as.i((View) this.aoD, n.f.bg_tieziyingxiang);
    }

    private void zR() {
        if (this.aoz != null) {
            this.aoB = (TextView) this.aoz.findViewById(n.g.first_style_first_expression);
            this.aoC = (TextView) this.aoz.findViewById(n.g.first_style_second_expression);
            this.aoD = (TextView) this.aoz.findViewById(n.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.aoK.clear();
        zT();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            zS();
        }
    }

    private void zS() {
        if (this.aoK.size() != 0) {
            int size = this.aoK.size();
            for (int i = 0; i < size; i++) {
                if (this.aoK.get(i).intValue() == this.aoB.getId()) {
                    this.aoB.setVisibility(8);
                } else if (this.aoK.get(i).intValue() == this.aoC.getId()) {
                    this.aoC.setVisibility(8);
                } else if (this.aoK.get(i).intValue() == this.aoD.getId()) {
                    this.aoD.setVisibility(8);
                }
            }
        }
    }

    private void zT() {
        this.aoB.setText("");
        this.aoC.setText("");
        this.aoD.setText("");
        if (this.aoB.getVisibility() == 8) {
            this.aoB.setVisibility(0);
        }
        if (this.aoC.getVisibility() == 8) {
            this.aoC.setVisibility(0);
        }
        if (this.aoD.getVisibility() == 8) {
            this.aoD.setVisibility(0);
        }
        this.aoK.add(Integer.valueOf(this.aoB.getId()));
        this.aoK.add(Integer.valueOf(this.aoC.getId()));
        this.aoK.add(Integer.valueOf(this.aoD.getId()));
    }

    private void a(o oVar, TextView textView) {
        if (oVar != null && textView != null) {
            if (!a(oVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(oVar.ag(oVar.getLabelName(), String.valueOf(oVar.zC())));
            dN(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void a(int i, ArrayList<o> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.aoJ) {
                case 0:
                    a(this.aoV, this.aoW, this.aoB);
                    a(this.aoX, this.aoY, this.aoC);
                    a(this.aoZ, this.apa, this.aoD);
                    break;
                case 1:
                    a(this.apa, this.apb, this.aoB);
                    a(this.apc, this.apa, this.aoC);
                    a(this.apd, this.aoY, this.aoD);
                    break;
                case 2:
                    a(this.apa, this.ape, this.aoB);
                    a(this.apf, this.apa, this.aoC);
                    a(this.apd, this.aoY, this.aoD);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.aoB);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aoC);
            } else if (i == 2) {
                a(arrayList.get(i2), this.aoD);
            }
        }
    }

    private void dN(int i) {
        if (this.aoK.size() != 0) {
            int size = this.aoK.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aoK.get(i2).intValue() == i) {
                    this.aoK.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(o oVar) {
        return (oVar == null || StringUtils.isNull(oVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.aoA.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.aoA.d(str, 10, false);
        } else {
            this.aoA.d(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aoF.setText("");
            return;
        }
        String trim = str.trim();
        this.aoF.setVisibility(0);
        if (com.baidu.tbadk.util.o.gi(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.o.e(trim, 0, 12)) + "...";
        }
        this.aoF.setText(String.valueOf(trim) + TbadkCoreApplication.m411getInst().getResources().getString(n.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aoy.setText("");
            this.aoy.setVisibility(8);
            return;
        }
        this.aoy.setVisibility(0);
        this.aoy.setText(str);
    }

    private void setTitle(String str) {
        this.apg = str;
        if (this.aoL != 0) {
            this.ahk.setPadding(0, 0, (int) this.context.getResources().getDimension(this.aoL), 0);
            this.aoL = 0;
        } else {
            this.ahk.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.ahk.setText("");
            return;
        }
        this.ahk.setVisibility(0);
        if (this.aoN) {
            this.ahk.setText(e(str));
        } else {
            this.ahk.setText(str);
        }
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cx = as.cx(n.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cx);
        int height = cx.getHeight();
        bitmapDrawable.setBounds(0, 0, cx.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eH(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aol.d(str, 12, false);
        } else {
            this.aol.d(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aoo.setText("");
            return;
        }
        this.aoo.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.o.gi(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.o.e(trim, 0, 14)) + "...";
        }
        this.aoo.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.aop, this.context.getResources().getString(n.j.fans_default_name));
        } else {
            b(this.aop, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = as.getDrawable(n.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.aoq.setText(ax.x(i));
    }

    private void setReplyNum(int i) {
        b(this.aor, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(ax.x(j));
        Drawable drawable = as.getDrawable(n.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void f(int i, boolean z) {
        if (z) {
            this.aoH.setVisibility(0);
            b(this.aoH, i);
            return;
        }
        this.aoH.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.aog) {
            this.aos.setVisibility(0);
            as.i((View) this.aos, n.f.label_onthelist);
            return;
        }
        this.aos.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.aof) {
            this.aot.setVisibility(0);
            this.aot.setText(str);
            return;
        }
        this.aot.setVisibility(8);
        this.aot.setText("");
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.aov.setVisibility(8);
            return;
        }
        this.aov.setVisibility(0);
        this.aov.setText(str);
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.aoG.setVisibility(8);
            return;
        }
        this.aoG.setVisibility(0);
        this.aoG.setText(str);
    }

    public void setShowHead(boolean z) {
        this.anX = z;
    }

    public void setShowTitle(boolean z) {
        this.anY = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.aod = z;
    }

    public void setShowContent(boolean z) {
        this.anZ = z;
    }

    public void setShowCover(boolean z) {
        this.aoa = z;
    }

    public void setShowExpression(boolean z) {
        this.aob = z;
    }

    public void setShowBottom(boolean z) {
        this.aoc = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.aof = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.aog = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.aoh = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.aoi = z;
    }

    public void setChooseStyle(int i) {
        this.aoJ = i;
    }

    public int getShowStyle() {
        return this.aoJ;
    }

    public void setShowLiveIcon(boolean z) {
        this.aoN = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.anV = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.anW = bVar;
    }

    public void setParentBackground(int i) {
        as.i(this.aoj, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.aoO = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.aoe = z;
    }

    public void setTitlePaddingRight(int i) {
        this.aoL = i;
    }

    public void setTitleMaxLines(int i) {
        this.aoM = i;
    }

    public void setAllowGreyState(boolean z) {
        this.aoP = z;
    }
}
