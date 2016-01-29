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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int ahU;
    private boolean akw;
    private a aoM;
    private b aoN;
    private boolean aoO;
    private boolean aoP;
    private boolean aoQ;
    private boolean aoR;
    private boolean aoS;
    private boolean aoT;
    private boolean aoU;
    private boolean aoV;
    private boolean aoW;
    private boolean aoX;
    private boolean aoY;
    private boolean aoZ;
    private TextView apA;
    private TextView apB;
    private int apC;
    private ArrayList<Integer> apD;
    private int apE;
    private int apF;
    private boolean apG;
    private boolean apH;
    private boolean apI;
    private int apJ;
    private int apK;
    private int apL;
    private int apM;
    private int apN;
    private int apO;
    private int apP;
    private int apQ;
    private int apR;
    private int apS;
    private int apT;
    private int apU;
    private int apV;
    private int apW;
    private int apX;
    private String apY;
    private LinearLayout apa;
    private View apb;
    private HeadImageView apc;
    private FrameLayout apd;
    private LinearLayout ape;
    private TextView apf;
    private TextView apg;
    private TextView aph;
    private TextView api;
    private TextView apj;
    private TextView apk;
    private LinearLayout apl;
    private TextView apm;
    private TextView apn;
    private TextView apo;
    private LinearLayout apq;
    private TextView apr;
    private RelativeLayout aps;
    private TbImageView apt;
    private TextView apu;
    private TextView apv;
    private TextView apw;
    private RelativeLayout apx;
    private TextView apy;
    private TextView apz;
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
        this.aoO = true;
        this.aoP = true;
        this.aoQ = true;
        this.aoR = true;
        this.aoS = true;
        this.aoT = true;
        this.aoU = false;
        this.aoV = false;
        this.aoW = false;
        this.aoX = false;
        this.aoY = false;
        this.aoZ = false;
        this.apC = 0;
        this.apD = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.apE = 0;
        this.apF = 0;
        this.apG = false;
        this.apH = true;
        this.apI = false;
        this.akw = false;
        this.ahU = 3;
        this.padding = 0;
        this.apJ = 0;
        this.apK = 0;
        this.apL = 0;
        this.apM = 0;
        this.apY = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(t.e.ds24);
        this.apK = (int) context.getResources().getDimension(t.e.ds100);
        this.apJ = (int) context.getResources().getDimension(t.e.ds70);
        this.apL = (int) context.getResources().getDimension(t.e.ds18);
        this.apM = (int) context.getResources().getDimension(t.e.ds4);
        this.apN = (int) context.getResources().getDimension(t.e.ds80);
        this.apO = (int) context.getResources().getDimension(t.e.ds280);
        this.apP = (int) context.getResources().getDimension(t.e.ds170);
        this.apQ = (int) context.getResources().getDimension(t.e.ds320);
        this.apR = (int) context.getResources().getDimension(t.e.ds200);
        this.apS = (int) context.getResources().getDimension(t.e.ds60);
        this.apT = (int) context.getResources().getDimension(t.e.ds120);
        this.apU = (int) context.getResources().getDimension(t.e.ds160);
        this.apV = (int) context.getResources().getDimension(t.e.ds220);
        this.apW = (int) context.getResources().getDimension(t.e.ds240);
        this.apX = (int) context.getResources().getDimension(t.e.ds180);
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
        this.apa = (LinearLayout) inflate.findViewById(t.g.pl_card_root);
        this.apb = inflate.findViewById(t.g.author_info);
        this.apl = (LinearLayout) inflate.findViewById(t.g.photo_live_card_title);
        this.apq = (LinearLayout) inflate.findViewById(t.g.photo_live_card_content);
        this.aps = (RelativeLayout) inflate.findViewById(t.g.photo_live_card_cover_and_expression);
        this.apx = (RelativeLayout) inflate.findViewById(t.g.photo_live_card_bottom);
        Bb();
        Bc();
        Bd();
        Bf();
        Be();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.aoO, photoLiveCardData);
            b(this.aoP, this.aoU, photoLiveCardData);
            b(this.aoQ, photoLiveCardData);
            a(this.aoR, this.aoS, photoLiveCardData);
            a(this.aoT, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.akw = true;
        } else {
            this.akw = false;
        }
    }

    public void xf() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahU) {
            ar.k(this.apa, t.f.frs_item_control_btn_bg);
            if (this.aoO) {
                ar.b(this.apf, t.d.cp_cont_f, 1);
                ar.b(this.apg, t.d.cp_cont_d, 1);
                ar.b(this.aph, t.d.cp_cont_d, 1);
                ar.b(this.api, t.d.cp_cont_d, 1);
                ar.b(this.apk, t.d.cp_cont_d, 1);
                Drawable drawable = ar.getDrawable(t.f.icon_fengsi_n);
                drawable.setBounds(0, 0, this.size, this.size);
                this.apg.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = ar.getDrawable(t.f.icon_comment_n);
                drawable2.setBounds(0, 0, this.size, this.size);
                this.api.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.aoP) {
                ar.b(this.apm, t.d.cp_cont_b, 1);
                ar.b(this.apn, t.d.cp_cont_c, 1);
                ar.b(this.apo, t.d.cp_cont_i, 1);
                ar.k(this.apo, t.f.blacklist_remove_button_bg);
                this.apm.setText(e(this.apY));
            }
            if (this.aoT) {
                ar.b(this.apy, t.d.cp_cont_i, 1);
                ar.k(this.apy, t.f.label_bg_tie);
                ar.b(this.apz, t.d.cp_cont_d, 1);
                ar.b(this.apA, t.d.cp_cont_d, 1);
                ar.b(this.apy, t.d.cp_cont_i, 1);
            }
            ar.b(this.apr, t.d.cp_cont_b, 1);
            Bg();
            this.ahU = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.apH) {
                if (this.paddingBottom != 0) {
                    this.aps.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.aps.setPadding(this.padding, 0, this.padding, 0);
                }
                this.aps.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.aps != null) {
                this.aps.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apx.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                o(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.aoV);
                f(photoLiveCardData.getDiscussNum(), this.aoY);
                return;
            }
            this.apx.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apl.setVisibility(0);
                if (this.apF != 0) {
                    this.apm.setMaxLines(this.apF);
                } else {
                    this.apm.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                n(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.apm, photoLiveCardData.getThreadId());
                return;
            }
            this.apl.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.aoZ) {
            this.apo.setVisibility(0);
            this.apo.setTag(photoLiveCardData);
            return;
        }
        this.apo.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apq.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.apq.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.apq.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.apr, photoLiveCardData.getThreadId());
                return;
            }
            this.apq.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.apI) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mU(String.valueOf(j))) {
                ar.b(textView, t.d.cp_cont_c, 1);
            } else {
                ar.b(textView, t.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apb.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.apb.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.apb.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.apc.getLayoutParams();
                if (this.akw) {
                    if (layoutParams != null) {
                        layoutParams.height = this.apK;
                        layoutParams.width = this.apK;
                    }
                    if (this.apB == null) {
                        this.apB = new TextView(this.context);
                        this.apB.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.apB.setEllipsize(TextUtils.TruncateAt.END);
                        this.apB.setTextSize(0, this.apL);
                        ar.j((View) this.apB, t.d.cp_cont_h);
                        ar.k(this.apB, t.f.icon_shen);
                        this.apB.setSingleLine(true);
                        this.ape.addView(this.apB);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.apB.setText(t.j.god_intro_default);
                    } else {
                        this.apB.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.ape.removeView(this.apB);
                    this.apB = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.apJ;
                        layoutParams.width = this.apJ;
                    }
                }
                this.apc.setTag(photoLiveCardData);
                eG(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.ape.removeView(this.apB);
            this.apb.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.apc.setPadding(this.apM, this.apM, this.apM, this.apM);
            if (this.akw) {
                this.apd.setBackgroundDrawable(ar.getDrawable(t.f.pic_bg_jinbian));
                return;
            } else {
                this.apd.setBackgroundDrawable(ar.getDrawable(t.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.apd.setBackgroundDrawable(null);
        this.apc.setPadding(0, 0, 0, 0);
    }

    private void Bb() {
        if (this.apb != null) {
            this.apc = (HeadImageView) this.apb.findViewById(t.g.author_portrait);
            this.apd = (FrameLayout) this.apb.findViewById(t.g.author_portrait_info);
            this.apf = (TextView) this.apb.findViewById(t.g.author_name);
            this.apg = (TextView) this.apb.findViewById(t.g.nick_name);
            this.aph = (TextView) this.apb.findViewById(t.g.fans_num);
            this.api = (TextView) this.apb.findViewById(t.g.reply_num);
            this.apj = (TextView) this.apb.findViewById(t.g.headlive_icon);
            this.apk = (TextView) this.apb.findViewById(t.g.refresh_time_in_head);
            this.ape = (LinearLayout) this.apb.findViewById(t.g.author_info_and_time);
            this.apc.setOnClickListener(new s(this));
        }
    }

    private void Bc() {
        if (this.apl != null) {
            this.apm = (TextView) this.apl.findViewById(t.g.title);
            this.apn = (TextView) findViewById(t.g.refresh_time_in_title);
            this.apo = (TextView) this.apl.findViewById(t.g.card_delete_in_title);
            this.apo.setOnClickListener(new t(this));
        }
    }

    private void Bd() {
        if (this.apq != null) {
            this.apr = (TextView) this.apq.findViewById(t.g.content);
        }
    }

    private void Be() {
        if (this.apx != null) {
            this.apy = (TextView) this.apx.findViewById(t.g.ba_name);
            this.apz = (TextView) this.apx.findViewById(t.g.bottom_refresh_time);
            this.apA = (TextView) this.apx.findViewById(t.g.bottom_reply_num);
        }
    }

    private void Bf() {
        if (this.aps != null) {
            this.apt = (TbImageView) this.aps.findViewById(t.g.live_cover);
            this.apt.setGifIconSupport(false);
            Bh();
        }
    }

    private void Bg() {
        ar.k(this.apu, t.f.bg_tieziyingxiang);
        ar.k(this.apv, t.f.bg_tieziyingxiang);
        ar.k(this.apw, t.f.bg_tieziyingxiang);
    }

    private void Bh() {
        if (this.aps != null) {
            this.apu = (TextView) this.aps.findViewById(t.g.first_style_first_expression);
            this.apv = (TextView) this.aps.findViewById(t.g.first_style_second_expression);
            this.apw = (TextView) this.aps.findViewById(t.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.apD.clear();
        Bj();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bi();
        }
    }

    private void Bi() {
        if (this.apD.size() != 0) {
            int size = this.apD.size();
            for (int i = 0; i < size; i++) {
                if (this.apD.get(i).intValue() == this.apu.getId()) {
                    this.apu.setVisibility(8);
                } else if (this.apD.get(i).intValue() == this.apv.getId()) {
                    this.apv.setVisibility(8);
                } else if (this.apD.get(i).intValue() == this.apw.getId()) {
                    this.apw.setVisibility(8);
                }
            }
        }
    }

    private void Bj() {
        this.apu.setText("");
        this.apv.setText("");
        this.apw.setText("");
        if (this.apu.getVisibility() == 8) {
            this.apu.setVisibility(0);
        }
        if (this.apv.getVisibility() == 8) {
            this.apv.setVisibility(0);
        }
        if (this.apw.getVisibility() == 8) {
            this.apw.setVisibility(0);
        }
        this.apD.add(Integer.valueOf(this.apu.getId()));
        this.apD.add(Integer.valueOf(this.apv.getId()));
        this.apD.add(Integer.valueOf(this.apw.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ag(nVar.getLabelName(), String.valueOf(nVar.AU())));
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
            switch (this.apC) {
                case 0:
                    a(this.apN, this.apO, this.apu);
                    a(this.apP, this.apQ, this.apv);
                    a(this.apR, this.apS, this.apw);
                    break;
                case 1:
                    a(this.apS, this.apT, this.apu);
                    a(this.apU, this.apS, this.apv);
                    a(this.apV, this.apQ, this.apw);
                    break;
                case 2:
                    a(this.apS, this.apW, this.apu);
                    a(this.apX, this.apS, this.apv);
                    a(this.apV, this.apQ, this.apw);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.apu);
            } else if (i == 1) {
                a(arrayList.get(i2), this.apv);
            } else if (i == 2) {
                a(arrayList.get(i2), this.apw);
            }
        }
    }

    private void ei(int i) {
        if (this.apD.size() != 0) {
            int size = this.apD.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.apD.get(i2).intValue() == i) {
                    this.apD.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.apt.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.apt.d(str, 10, false);
        } else {
            this.apt.d(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apy.setText("");
            return;
        }
        String trim = str.trim();
        this.apy.setVisibility(0);
        if (com.baidu.tbadk.util.o.gf(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.o.d(trim, 0, 12)) + "...";
        }
        this.apy.setText(String.valueOf(trim) + TbadkCoreApplication.m411getInst().getResources().getString(t.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apr.setText("");
            this.apr.setVisibility(8);
            return;
        }
        this.apr.setVisibility(0);
        this.apr.setText(str);
    }

    private void setTitle(String str) {
        this.apY = str;
        if (this.apE != 0) {
            this.apm.setPadding(0, 0, (int) this.context.getResources().getDimension(this.apE), 0);
            this.apE = 0;
        } else {
            this.apm.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.apm.setText("");
            return;
        }
        this.apm.setVisibility(0);
        if (this.apG) {
            this.apm.setText(e(str));
        } else {
            this.apm.setText(str);
        }
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cO = ar.cO(t.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        int height = cO.getHeight();
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eG(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.apc.d(str, 12, false);
        } else {
            this.apc.d(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apf.setText("");
            return;
        }
        this.apf.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.o.gf(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.o.d(trim, 0, 14)) + "...";
        }
        this.apf.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            c(this.apg, this.context.getResources().getString(t.j.fans_default_name));
        } else {
            c(this.apg, str);
        }
    }

    private void c(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = ar.getDrawable(t.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.aph.setText(aw.y(i));
    }

    private void setReplyNum(int i) {
        b(this.api, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(aw.y(j));
        Drawable drawable = ar.getDrawable(t.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void f(int i, boolean z) {
        if (z) {
            this.apA.setVisibility(0);
            b(this.apA, i);
            return;
        }
        this.apA.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.aoX) {
            this.apj.setVisibility(0);
            ar.k(this.apj, t.f.label_onthelist);
            return;
        }
        this.apj.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.aoW) {
            this.apk.setVisibility(0);
            this.apk.setText(str);
            return;
        }
        this.apk.setVisibility(8);
        this.apk.setText("");
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.apn.setVisibility(8);
            return;
        }
        this.apn.setVisibility(0);
        this.apn.setText(str);
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.apz.setVisibility(8);
            return;
        }
        this.apz.setVisibility(0);
        this.apz.setText(str);
    }

    public void setShowHead(boolean z) {
        this.aoO = z;
    }

    public void setShowTitle(boolean z) {
        this.aoP = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.aoU = z;
    }

    public void setShowContent(boolean z) {
        this.aoQ = z;
    }

    public void setShowCover(boolean z) {
        this.aoR = z;
    }

    public void setShowExpression(boolean z) {
        this.aoS = z;
    }

    public void setShowBottom(boolean z) {
        this.aoT = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.aoW = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.aoX = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.aoY = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.aoZ = z;
    }

    public void setChooseStyle(int i) {
        this.apC = i;
    }

    public int getShowStyle() {
        return this.apC;
    }

    public void setShowLiveIcon(boolean z) {
        this.apG = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.aoM = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.aoN = bVar;
    }

    public void setParentBackground(int i) {
        ar.k(this.apa, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.apH = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.aoV = z;
    }

    public void setTitlePaddingRight(int i) {
        this.apE = i;
    }

    public void setTitleMaxLines(int i) {
        this.apF = i;
    }

    public void setAllowGreyState(boolean z) {
        this.apI = z;
    }
}
