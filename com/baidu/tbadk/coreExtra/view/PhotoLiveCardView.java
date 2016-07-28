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
    public int afy;
    private boolean ahT;
    private boolean amA;
    private LinearLayout amB;
    private View amC;
    private HeadImageView amD;
    private FrameLayout amE;
    private LinearLayout amF;
    private TextView amG;
    private TextView amH;
    private TextView amI;
    private TextView amJ;
    private TextView amK;
    private TextView amL;
    private LinearLayout amM;
    private TextView amN;
    private TextView amO;
    private LinearLayout amP;
    private TextView amQ;
    private RelativeLayout amR;
    private TbImageView amS;
    private TextView amT;
    private TextView amU;
    private TextView amV;
    private RelativeLayout amW;
    private TextView amX;
    private TextView amY;
    private TextView amZ;
    private a amn;
    private b amo;
    private boolean amp;
    private boolean amq;
    private boolean amr;
    private boolean ams;
    private boolean amt;
    private boolean amu;
    private boolean amv;
    private boolean amw;
    private boolean amx;
    private boolean amy;
    private boolean amz;
    private TextView ana;
    private int anb;
    private ArrayList<Integer> anc;
    private int and;
    private int ane;
    private boolean anf;
    private boolean ang;
    private boolean anh;
    private boolean ani;
    private int anj;
    private int ank;
    private int anl;
    private int anm;
    private int ann;
    private int ano;
    private int anp;
    private int anq;
    private int anr;
    private int ans;
    private int ant;
    private int anu;
    private int anv;
    private int anw;
    private int anx;
    private String any;
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
        this.amp = true;
        this.amq = true;
        this.amr = true;
        this.ams = true;
        this.amt = true;
        this.amu = true;
        this.amv = false;
        this.amw = false;
        this.amx = false;
        this.amy = false;
        this.amz = false;
        this.amA = false;
        this.anb = 0;
        this.anc = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.and = 0;
        this.ane = 0;
        this.anf = false;
        this.ang = true;
        this.anh = false;
        this.ani = false;
        this.ahT = false;
        this.afy = 3;
        this.padding = 0;
        this.anj = 0;
        this.ank = 0;
        this.anl = 0;
        this.anm = 0;
        this.any = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(u.e.ds24);
        this.ank = (int) context.getResources().getDimension(u.e.ds100);
        this.anj = (int) context.getResources().getDimension(u.e.ds70);
        this.anl = (int) context.getResources().getDimension(u.e.ds18);
        this.anm = (int) context.getResources().getDimension(u.e.ds4);
        this.ann = (int) context.getResources().getDimension(u.e.ds80);
        this.ano = (int) context.getResources().getDimension(u.e.ds280);
        this.anp = (int) context.getResources().getDimension(u.e.ds170);
        this.anq = (int) context.getResources().getDimension(u.e.ds320);
        this.anr = (int) context.getResources().getDimension(u.e.ds200);
        this.ans = (int) context.getResources().getDimension(u.e.ds60);
        this.ant = (int) context.getResources().getDimension(u.e.ds120);
        this.anu = (int) context.getResources().getDimension(u.e.ds160);
        this.anv = (int) context.getResources().getDimension(u.e.ds220);
        this.anw = (int) context.getResources().getDimension(u.e.ds240);
        this.anx = (int) context.getResources().getDimension(u.e.ds180);
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
        this.amB = (LinearLayout) inflate.findViewById(u.g.pl_card_root);
        this.amC = inflate.findViewById(u.g.author_info);
        this.amM = (LinearLayout) inflate.findViewById(u.g.photo_live_card_title);
        this.amP = (LinearLayout) inflate.findViewById(u.g.photo_live_card_content);
        this.amR = (RelativeLayout) inflate.findViewById(u.g.photo_live_card_cover_and_expression);
        this.amW = (RelativeLayout) inflate.findViewById(u.g.photo_live_card_bottom);
        zE();
        zF();
        zG();
        zI();
        zH();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.amp, photoLiveCardData);
            b(this.amq, this.amv, photoLiveCardData);
            b(this.amr, photoLiveCardData);
            a(this.ams, this.amt, photoLiveCardData);
            a(this.amu, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.ahT = true;
        } else {
            this.ahT = false;
        }
    }

    public void vm() {
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (skinType != this.afy) {
            av.k(this.amB, u.f.frs_item_control_btn_bg);
            if (this.amp) {
                av.c(this.amG, u.d.cp_cont_f, 1);
                av.c(this.amH, u.d.cp_cont_d, 1);
                av.c(this.amI, u.d.cp_cont_d, 1);
                av.c(this.amJ, u.d.cp_cont_d, 1);
                av.c(this.amL, u.d.cp_cont_d, 1);
                Drawable drawable = av.getDrawable(u.f.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.amH.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = av.getDrawable(u.f.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.amJ.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.amq) {
                av.c(this.title, u.d.cp_cont_b, 1);
                av.c(this.amN, u.d.cp_cont_c, 1);
                av.c(this.amO, u.d.cp_cont_i, 1);
                av.k(this.amO, u.f.blacklist_remove_button_bg);
                this.title.setText(e(this.any));
            }
            if (this.amu) {
                av.c(this.amX, u.d.cp_cont_i, 1);
                av.k(this.amX, u.f.label_bg_tie);
                av.c(this.amY, u.d.cp_cont_d, 1);
                av.c(this.amZ, u.d.cp_cont_d, 1);
                av.c(this.amX, u.d.cp_cont_i, 1);
            }
            av.c(this.amQ, u.d.cp_cont_b, 1);
            zJ();
            this.afy = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.ang) {
                if (this.paddingBottom != 0) {
                    this.amR.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.amR.setPadding(this.padding, 0, this.padding, 0);
                }
                this.amR.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.amR != null) {
                this.amR.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.amW.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.amw);
                i(photoLiveCardData.getDiscussNum(), this.amz);
                return;
            }
            this.amW.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.amM.setVisibility(0);
                if (this.ane != 0) {
                    this.title.setMaxLines(this.ane);
                } else {
                    this.title.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.title, photoLiveCardData.getThreadId());
                return;
            }
            this.amM.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.amA) {
            this.amO.setVisibility(0);
            this.amO.setTag(photoLiveCardData);
            return;
        }
        this.amO.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.amP.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.amP.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.amP.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.amQ, photoLiveCardData.getThreadId());
                return;
            }
            this.amP.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.anh) {
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qv(String.valueOf(j))) {
                av.c(textView, u.d.cp_cont_c, 1);
            } else {
                av.c(textView, u.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.amC.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.amC.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.amC.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.amD.getLayoutParams();
                if (this.ahT) {
                    if (layoutParams != null) {
                        layoutParams.height = this.ank;
                        layoutParams.width = this.ank;
                    }
                    if (this.ana == null) {
                        this.ana = new TextView(this.context);
                        this.ana.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.ana.setEllipsize(TextUtils.TruncateAt.END);
                        this.ana.setTextSize(0, this.anl);
                        av.j((View) this.ana, u.d.cp_cont_h);
                        av.k(this.ana, u.f.icon_shen);
                        this.ana.setSingleLine(true);
                        this.amF.addView(this.ana);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.ana.setText(u.j.god_intro_default);
                    } else {
                        this.ana.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.amF.removeView(this.ana);
                    this.ana = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.anj;
                        layoutParams.width = this.anj;
                    }
                }
                this.amD.setTag(photoLiveCardData);
                eM(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.amF.removeView(this.ana);
            this.amC.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.amD.setPadding(this.anm, this.anm, this.anm, this.anm);
            if (this.ahT) {
                this.amE.setBackgroundDrawable(av.getDrawable(u.f.pic_bg_jinbian));
                return;
            } else {
                this.amE.setBackgroundDrawable(av.getDrawable(u.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.amE.setBackgroundDrawable(null);
        this.amD.setPadding(0, 0, 0, 0);
    }

    private void zE() {
        if (this.amC != null) {
            this.amD = (HeadImageView) this.amC.findViewById(u.g.author_portrait);
            this.amE = (FrameLayout) this.amC.findViewById(u.g.author_portrait_info);
            this.amG = (TextView) this.amC.findViewById(u.g.author_name);
            this.amH = (TextView) this.amC.findViewById(u.g.nick_name);
            this.amI = (TextView) this.amC.findViewById(u.g.fans_num);
            this.amJ = (TextView) this.amC.findViewById(u.g.reply_num);
            this.amK = (TextView) this.amC.findViewById(u.g.headlive_icon);
            this.amL = (TextView) this.amC.findViewById(u.g.refresh_time_in_head);
            this.amF = (LinearLayout) this.amC.findViewById(u.g.author_info_and_time);
            this.amD.setOnClickListener(new s(this));
        }
    }

    private void zF() {
        if (this.amM != null) {
            this.title = (TextView) this.amM.findViewById(u.g.title);
            this.amN = (TextView) findViewById(u.g.refresh_time_in_title);
            this.amO = (TextView) this.amM.findViewById(u.g.card_delete_in_title);
            this.amO.setOnClickListener(new t(this));
        }
    }

    private void zG() {
        if (this.amP != null) {
            this.amQ = (TextView) this.amP.findViewById(u.g.content);
        }
    }

    private void zH() {
        if (this.amW != null) {
            this.amX = (TextView) this.amW.findViewById(u.g.ba_name);
            this.amY = (TextView) this.amW.findViewById(u.g.bottom_refresh_time);
            this.amZ = (TextView) this.amW.findViewById(u.g.bottom_reply_num);
        }
    }

    private void zI() {
        if (this.amR != null) {
            this.amS = (TbImageView) this.amR.findViewById(u.g.live_cover);
            this.amS.setGifIconSupport(false);
            zK();
        }
    }

    private void zJ() {
        av.k(this.amT, u.f.bg_tieziyingxiang);
        av.k(this.amU, u.f.bg_tieziyingxiang);
        av.k(this.amV, u.f.bg_tieziyingxiang);
    }

    private void zK() {
        if (this.amR != null) {
            this.amT = (TextView) this.amR.findViewById(u.g.first_style_first_expression);
            this.amU = (TextView) this.amR.findViewById(u.g.first_style_second_expression);
            this.amV = (TextView) this.amR.findViewById(u.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.anc.clear();
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
        if (this.anc.size() != 0) {
            int size = this.anc.size();
            for (int i = 0; i < size; i++) {
                if (this.anc.get(i).intValue() == this.amT.getId()) {
                    this.amT.setVisibility(8);
                } else if (this.anc.get(i).intValue() == this.amU.getId()) {
                    this.amU.setVisibility(8);
                } else if (this.anc.get(i).intValue() == this.amV.getId()) {
                    this.amV.setVisibility(8);
                }
            }
        }
    }

    private void zM() {
        this.amT.setText("");
        this.amU.setText("");
        this.amV.setText("");
        if (this.amT.getVisibility() == 8) {
            this.amT.setVisibility(0);
        }
        if (this.amU.getVisibility() == 8) {
            this.amU.setVisibility(0);
        }
        if (this.amV.getVisibility() == 8) {
            this.amV.setVisibility(0);
        }
        this.anc.add(Integer.valueOf(this.amT.getId()));
        this.anc.add(Integer.valueOf(this.amU.getId()));
        this.anc.add(Integer.valueOf(this.amV.getId()));
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
            switch (this.anb) {
                case 0:
                    a(this.ann, this.ano, this.amT);
                    a(this.anp, this.anq, this.amU);
                    a(this.anr, this.ans, this.amV);
                    break;
                case 1:
                    a(this.ans, this.ant, this.amT);
                    a(this.anu, this.ans, this.amU);
                    a(this.anv, this.anq, this.amV);
                    break;
                case 2:
                    a(this.ans, this.anw, this.amT);
                    a(this.anx, this.ans, this.amU);
                    a(this.anv, this.anq, this.amV);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.amT);
            } else if (i == 1) {
                a(arrayList.get(i2), this.amU);
            } else if (i == 2) {
                a(arrayList.get(i2), this.amV);
            }
        }
    }

    private void dS(int i) {
        if (this.anc.size() != 0) {
            int size = this.anc.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.anc.get(i2).intValue() == i) {
                    this.anc.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.amS.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.amS.c(str, 10, false);
        } else {
            this.amS.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.amX.setText("");
            return;
        }
        String trim = str.trim();
        this.amX.setVisibility(0);
        if (com.baidu.tbadk.util.v.gw(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.v.d(trim, 0, 12)) + "...";
        }
        this.amX.setText(String.valueOf(trim) + TbadkCoreApplication.m10getInst().getResources().getString(u.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.amQ.setText("");
            this.amQ.setVisibility(8);
            return;
        }
        this.amQ.setVisibility(0);
        this.amQ.setText(str);
    }

    private void setTitle(String str) {
        this.any = str;
        if (this.and != 0) {
            this.title.setPadding(0, 0, (int) this.context.getResources().getDimension(this.and), 0);
            this.and = 0;
        } else {
            this.title.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.title.setText("");
            return;
        }
        this.title.setVisibility(0);
        if (this.anf) {
            if (this.ani) {
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

    private void eM(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.amD.c(str, 12, false);
        } else {
            this.amD.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.amG.setText("");
            return;
        }
        this.amG.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.v.gw(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.v.d(trim, 0, 14)) + "...";
        }
        this.amG.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            d(this.amH, this.context.getResources().getString(u.j.fans_default_name));
        } else {
            d(this.amH, str);
        }
    }

    private void d(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = av.getDrawable(u.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.amI.setText(ba.y(i));
    }

    private void setReplyNum(int i) {
        b(this.amJ, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(ba.y(j));
        Drawable drawable = av.getDrawable(u.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.amZ.setVisibility(0);
            b(this.amZ, i);
            return;
        }
        this.amZ.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.amy) {
            this.amK.setVisibility(0);
            av.k(this.amK, u.f.label_onthelist);
            return;
        }
        this.amK.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.amx) {
            this.amL.setVisibility(0);
            this.amL.setText(str);
            return;
        }
        this.amL.setVisibility(8);
        this.amL.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.amN.setVisibility(8);
            return;
        }
        this.amN.setVisibility(0);
        this.amN.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.amY.setVisibility(8);
            return;
        }
        this.amY.setVisibility(0);
        this.amY.setText(str);
    }

    public void setShowHead(boolean z) {
        this.amp = z;
    }

    public void setShowTitle(boolean z) {
        this.amq = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.amv = z;
    }

    public void setShowContent(boolean z) {
        this.amr = z;
    }

    public void setShowCover(boolean z) {
        this.ams = z;
    }

    public void setShowExpression(boolean z) {
        this.amt = z;
    }

    public void setShowBottom(boolean z) {
        this.amu = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.amx = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.amy = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.amz = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.amA = z;
    }

    public void setChooseStyle(int i) {
        this.anb = i;
    }

    public int getShowStyle() {
        return this.anb;
    }

    public void setShowLiveIcon(boolean z) {
        this.anf = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.amn = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.amo = bVar;
    }

    public void setParentBackground(int i) {
        av.k(this.amB, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.ang = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.amw = z;
    }

    public void setTitlePaddingRight(int i) {
        this.and = i;
    }

    public void setTitleMaxLines(int i) {
        this.ane = i;
    }

    public void setAllowGreyState(boolean z) {
        this.anh = z;
    }

    public void bj(boolean z) {
        this.ani = z;
    }
}
