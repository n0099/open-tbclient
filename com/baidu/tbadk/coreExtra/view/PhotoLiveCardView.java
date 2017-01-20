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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int ahp;
    private a aoD;
    private b aoE;
    private boolean aoF;
    private boolean aoG;
    private boolean aoH;
    private boolean aoI;
    private boolean aoJ;
    private boolean aoK;
    private boolean aoL;
    private boolean aoM;
    private boolean aoN;
    private boolean aoO;
    private boolean aoP;
    private boolean aoQ;
    private LinearLayout aoR;
    private View aoS;
    private HeadImageView aoT;
    private FrameLayout aoU;
    private LinearLayout aoV;
    private TextView aoW;
    private TextView aoX;
    private TextView aoY;
    private TextView aoZ;
    private boolean apA;
    private int apB;
    private int apC;
    private int apD;
    private int apE;
    private int apF;
    private int apG;
    private int apH;
    private int apI;
    private int apJ;
    private int apK;
    private int apL;
    private int apM;
    private int apN;
    private int apO;
    private int apP;
    private String apQ;
    private TextView apa;
    private TextView apb;
    private LinearLayout apc;
    private TextView apd;
    private TextView ape;
    private TextView apf;
    private LinearLayout apg;
    private TextView aph;
    private RelativeLayout api;
    private TbImageView apj;
    private TextView apk;
    private TextView apl;
    private TextView apm;
    private RelativeLayout apn;
    private TextView apo;
    private TextView apq;
    private TextView apr;
    private TextView aps;
    private int apt;
    private ArrayList<Integer> apu;
    private int apv;
    private int apw;
    private boolean apx;
    private boolean apy;
    private boolean apz;
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
        this.aoF = true;
        this.aoG = true;
        this.aoH = true;
        this.aoI = true;
        this.aoJ = true;
        this.aoK = true;
        this.aoL = false;
        this.aoM = false;
        this.aoN = false;
        this.aoO = false;
        this.aoP = false;
        this.aoQ = false;
        this.apt = 0;
        this.apu = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.apv = 0;
        this.apw = 0;
        this.apx = false;
        this.apy = true;
        this.apz = false;
        this.apA = false;
        this.isGod = false;
        this.ahp = 3;
        this.padding = 0;
        this.apB = 0;
        this.apC = 0;
        this.apD = 0;
        this.apE = 0;
        this.apQ = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(r.f.ds24);
        this.apC = (int) context.getResources().getDimension(r.f.ds100);
        this.apB = (int) context.getResources().getDimension(r.f.ds70);
        this.apD = (int) context.getResources().getDimension(r.f.ds18);
        this.apE = (int) context.getResources().getDimension(r.f.ds4);
        this.apF = (int) context.getResources().getDimension(r.f.ds80);
        this.apG = (int) context.getResources().getDimension(r.f.ds280);
        this.apH = (int) context.getResources().getDimension(r.f.ds170);
        this.apI = (int) context.getResources().getDimension(r.f.ds320);
        this.apJ = (int) context.getResources().getDimension(r.f.ds200);
        this.apK = (int) context.getResources().getDimension(r.f.ds60);
        this.apL = (int) context.getResources().getDimension(r.f.ds120);
        this.apM = (int) context.getResources().getDimension(r.f.ds160);
        this.apN = (int) context.getResources().getDimension(r.f.ds220);
        this.apO = (int) context.getResources().getDimension(r.f.ds240);
        this.apP = (int) context.getResources().getDimension(r.f.ds180);
        this.size = (int) context.getResources().getDimension(r.f.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(r.j.photo_live_card_view, this);
        this.aoR = (LinearLayout) inflate.findViewById(r.h.pl_card_root);
        this.aoS = inflate.findViewById(r.h.author_info);
        this.apc = (LinearLayout) inflate.findViewById(r.h.photo_live_card_title);
        this.apg = (LinearLayout) inflate.findViewById(r.h.photo_live_card_content);
        this.api = (RelativeLayout) inflate.findViewById(r.h.photo_live_card_cover_and_expression);
        this.apn = (RelativeLayout) inflate.findViewById(r.h.photo_live_card_bottom);
        AL();
        AM();
        AN();
        AP();
        AO();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.aoF, photoLiveCardData);
            b(this.aoG, this.aoL, photoLiveCardData);
            b(this.aoH, photoLiveCardData);
            a(this.aoI, this.aoJ, photoLiveCardData);
            a(this.aoK, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.isGod = true;
        } else {
            this.isGod = false;
        }
    }

    public void ws() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ahp) {
            ap.j(this.aoR, r.g.frs_item_control_btn_bg);
            if (this.aoF) {
                ap.c(this.aoW, r.e.cp_cont_f, 1);
                ap.c(this.aoX, r.e.cp_cont_d, 1);
                ap.c(this.aoY, r.e.cp_cont_d, 1);
                ap.c(this.aoZ, r.e.cp_cont_d, 1);
                ap.c(this.apb, r.e.cp_cont_d, 1);
                Drawable drawable = ap.getDrawable(r.g.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.aoX.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = ap.getDrawable(r.g.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.aoZ.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.aoG) {
                ap.c(this.apd, r.e.cp_cont_b, 1);
                ap.c(this.ape, r.e.cp_cont_c, 1);
                ap.c(this.apf, r.e.cp_cont_i, 1);
                ap.j((View) this.apf, r.g.blacklist_remove_button_bg);
                this.apd.setText(e(this.apQ));
            }
            if (this.aoK) {
                ap.c(this.apo, r.e.cp_cont_i, 1);
                ap.j((View) this.apo, r.g.label_bg_tie);
                ap.c(this.apq, r.e.cp_cont_d, 1);
                ap.c(this.apr, r.e.cp_cont_d, 1);
                ap.c(this.apo, r.e.cp_cont_i, 1);
            }
            ap.c(this.aph, r.e.cp_cont_b, 1);
            AQ();
            this.ahp = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.apy) {
                if (this.paddingBottom != 0) {
                    this.api.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.api.setPadding(this.padding, 0, this.padding, 0);
                }
                this.api.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.api != null) {
                this.api.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apn.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                p(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.aoM);
                i(photoLiveCardData.getDiscussNum(), this.aoP);
                return;
            }
            this.apn.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apc.setVisibility(0);
                if (this.apw != 0) {
                    this.apd.setMaxLines(this.apw);
                } else {
                    this.apd.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                o(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.apd, photoLiveCardData.getThreadId());
                return;
            }
            this.apc.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.aoQ) {
            this.apf.setVisibility(0);
            this.apf.setTag(photoLiveCardData);
            return;
        }
        this.apf.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apg.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.apg.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.apg.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.aph, photoLiveCardData.getThreadId());
                return;
            }
            this.apg.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.apz) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qP(String.valueOf(j))) {
                ap.c(textView, r.e.cp_cont_c, 1);
            } else {
                ap.c(textView, r.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aoS.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.aoS.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.aoS.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.aoT.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.apC;
                        layoutParams.width = this.apC;
                    }
                    if (this.aps == null) {
                        this.aps = new TextView(this.context);
                        this.aps.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.aps.setEllipsize(TextUtils.TruncateAt.END);
                        this.aps.setTextSize(0, this.apD);
                        ap.i((View) this.aps, r.e.cp_cont_h);
                        ap.j((View) this.aps, r.g.icon_shen);
                        this.aps.setSingleLine(true);
                        this.aoV.addView(this.aps);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.aps.setText(r.l.god_intro_default);
                    } else {
                        this.aps.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.aoV.removeView(this.aps);
                    this.aps = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.apB;
                        layoutParams.width = this.apB;
                    }
                }
                this.aoT.setTag(photoLiveCardData);
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
            this.aoV.removeView(this.aps);
            this.aoS.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.aoT.setPadding(this.apE, this.apE, this.apE, this.apE);
            if (this.isGod) {
                this.aoU.setBackgroundDrawable(ap.getDrawable(r.g.pic_bg_jinbian));
                return;
            } else {
                this.aoU.setBackgroundDrawable(ap.getDrawable(r.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.aoU.setBackgroundDrawable(null);
        this.aoT.setPadding(0, 0, 0, 0);
    }

    private void AL() {
        if (this.aoS != null) {
            this.aoT = (HeadImageView) this.aoS.findViewById(r.h.author_portrait);
            this.aoU = (FrameLayout) this.aoS.findViewById(r.h.author_portrait_info);
            this.aoW = (TextView) this.aoS.findViewById(r.h.author_name);
            this.aoX = (TextView) this.aoS.findViewById(r.h.nick_name);
            this.aoY = (TextView) this.aoS.findViewById(r.h.fans_num);
            this.aoZ = (TextView) this.aoS.findViewById(r.h.reply_num);
            this.apa = (TextView) this.aoS.findViewById(r.h.headlive_icon);
            this.apb = (TextView) this.aoS.findViewById(r.h.refresh_time_in_head);
            this.aoV = (LinearLayout) this.aoS.findViewById(r.h.author_info_and_time);
            this.aoT.setOnClickListener(new s(this));
        }
    }

    private void AM() {
        if (this.apc != null) {
            this.apd = (TextView) this.apc.findViewById(r.h.title);
            this.ape = (TextView) findViewById(r.h.refresh_time_in_title);
            this.apf = (TextView) this.apc.findViewById(r.h.card_delete_in_title);
            this.apf.setOnClickListener(new t(this));
        }
    }

    private void AN() {
        if (this.apg != null) {
            this.aph = (TextView) this.apg.findViewById(r.h.content);
        }
    }

    private void AO() {
        if (this.apn != null) {
            this.apo = (TextView) this.apn.findViewById(r.h.ba_name);
            this.apq = (TextView) this.apn.findViewById(r.h.bottom_refresh_time);
            this.apr = (TextView) this.apn.findViewById(r.h.bottom_reply_num);
        }
    }

    private void AP() {
        if (this.api != null) {
            this.apj = (TbImageView) this.api.findViewById(r.h.live_cover);
            this.apj.setGifIconSupport(false);
            AR();
        }
    }

    private void AQ() {
        ap.j((View) this.apk, r.g.bg_tieziyingxiang);
        ap.j((View) this.apl, r.g.bg_tieziyingxiang);
        ap.j((View) this.apm, r.g.bg_tieziyingxiang);
    }

    private void AR() {
        if (this.api != null) {
            this.apk = (TextView) this.api.findViewById(r.h.first_style_first_expression);
            this.apl = (TextView) this.api.findViewById(r.h.first_style_second_expression);
            this.apm = (TextView) this.api.findViewById(r.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.apu.clear();
        AT();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AS();
        }
    }

    private void AS() {
        if (this.apu.size() != 0) {
            int size = this.apu.size();
            for (int i = 0; i < size; i++) {
                if (this.apu.get(i).intValue() == this.apk.getId()) {
                    this.apk.setVisibility(8);
                } else if (this.apu.get(i).intValue() == this.apl.getId()) {
                    this.apl.setVisibility(8);
                } else if (this.apu.get(i).intValue() == this.apm.getId()) {
                    this.apm.setVisibility(8);
                }
            }
        }
    }

    private void AT() {
        this.apk.setText("");
        this.apl.setText("");
        this.apm.setText("");
        if (this.apk.getVisibility() == 8) {
            this.apk.setVisibility(0);
        }
        if (this.apl.getVisibility() == 8) {
            this.apl.setVisibility(0);
        }
        if (this.apm.getVisibility() == 8) {
            this.apm.setVisibility(0);
        }
        this.apu.add(Integer.valueOf(this.apk.getId()));
        this.apu.add(Integer.valueOf(this.apl.getId()));
        this.apu.add(Integer.valueOf(this.apm.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.AE())));
            ek(textView.getId());
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
            switch (this.apt) {
                case 0:
                    a(this.apF, this.apG, this.apk);
                    a(this.apH, this.apI, this.apl);
                    a(this.apJ, this.apK, this.apm);
                    break;
                case 1:
                    a(this.apK, this.apL, this.apk);
                    a(this.apM, this.apK, this.apl);
                    a(this.apN, this.apI, this.apm);
                    break;
                case 2:
                    a(this.apK, this.apO, this.apk);
                    a(this.apP, this.apK, this.apl);
                    a(this.apN, this.apI, this.apm);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.apk);
            } else if (i == 1) {
                a(arrayList.get(i2), this.apl);
            } else if (i == 2) {
                a(arrayList.get(i2), this.apm);
            }
        }
    }

    private void ek(int i) {
        if (this.apu.size() != 0) {
            int size = this.apu.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.apu.get(i2).intValue() == i) {
                    this.apu.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.apj.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.apj.c(str, 10, false);
        } else {
            this.apj.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apo.setText("");
            return;
        }
        String trim = str.trim();
        this.apo.setVisibility(0);
        if (com.baidu.tbadk.util.u.gv(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 12)) + "...";
        }
        this.apo.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(r.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aph.setText("");
            this.aph.setVisibility(8);
            return;
        }
        this.aph.setVisibility(0);
        this.aph.setText(str);
    }

    private void setTitle(String str) {
        this.apQ = str;
        if (this.apv != 0) {
            this.apd.setPadding(0, 0, (int) this.context.getResources().getDimension(this.apv), 0);
            this.apv = 0;
        } else {
            this.apd.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.apd.setText("");
            return;
        }
        this.apd.setVisibility(0);
        if (this.apx) {
            if (this.apA) {
                this.apd.setText(at.c(this.context, str, r.l.kn_zhibo));
                return;
            } else {
                this.apd.setText(e(str));
                return;
            }
        }
        this.apd.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cP = ap.cP(r.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cP);
        int height = cP.getHeight();
        bitmapDrawable.setBounds(0, 0, cP.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eN(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aoT.c(str, 12, false);
        } else {
            this.aoT.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aoW.setText("");
            return;
        }
        this.aoW.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.u.gv(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 14)) + "...";
        }
        this.aoW.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            d(this.aoX, this.context.getResources().getString(r.l.fans_default_name));
        } else {
            d(this.aoX, str);
        }
    }

    private void d(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = ap.getDrawable(r.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.aoY.setText(com.baidu.tbadk.core.util.at.w(i));
    }

    private void setReplyNum(int i) {
        b(this.aoZ, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(com.baidu.tbadk.core.util.at.w(j));
        Drawable drawable = ap.getDrawable(r.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.apr.setVisibility(0);
            b(this.apr, i);
            return;
        }
        this.apr.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.aoO) {
            this.apa.setVisibility(0);
            ap.j((View) this.apa, r.g.label_onthelist);
            return;
        }
        this.apa.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.aoN) {
            this.apb.setVisibility(0);
            this.apb.setText(str);
            return;
        }
        this.apb.setVisibility(8);
        this.apb.setText("");
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.ape.setVisibility(8);
            return;
        }
        this.ape.setVisibility(0);
        this.ape.setText(str);
    }

    private void p(String str, boolean z) {
        if (!z) {
            this.apq.setVisibility(8);
            return;
        }
        this.apq.setVisibility(0);
        this.apq.setText(str);
    }

    public void setShowHead(boolean z) {
        this.aoF = z;
    }

    public void setShowTitle(boolean z) {
        this.aoG = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.aoL = z;
    }

    public void setShowContent(boolean z) {
        this.aoH = z;
    }

    public void setShowCover(boolean z) {
        this.aoI = z;
    }

    public void setShowExpression(boolean z) {
        this.aoJ = z;
    }

    public void setShowBottom(boolean z) {
        this.aoK = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.aoN = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.aoO = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.aoP = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.aoQ = z;
    }

    public void setChooseStyle(int i) {
        this.apt = i;
    }

    public int getShowStyle() {
        return this.apt;
    }

    public void setShowLiveIcon(boolean z) {
        this.apx = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.aoD = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.aoE = bVar;
    }

    public void setParentBackground(int i) {
        ap.j(this.aoR, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.apy = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.aoM = z;
    }

    public void setTitlePaddingRight(int i) {
        this.apv = i;
    }

    public void setTitleMaxLines(int i) {
        this.apw = i;
    }

    public void setAllowGreyState(boolean z) {
        this.apz = z;
    }

    public void bo(boolean z) {
        this.apA = z;
    }
}
