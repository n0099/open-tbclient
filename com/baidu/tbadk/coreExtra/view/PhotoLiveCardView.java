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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aoa;
    private TextView avA;
    private TextView avB;
    private TextView avC;
    private TextView avD;
    private TextView avE;
    private TextView avF;
    private LinearLayout avG;
    private TextView avH;
    private TextView avI;
    private TextView avJ;
    private LinearLayout avK;
    private TextView avL;
    private RelativeLayout avM;
    private TbImageView avN;
    private TextView avO;
    private TextView avP;
    private TextView avQ;
    private RelativeLayout avR;
    private TextView avS;
    private TextView avT;
    private TextView avU;
    private TextView avV;
    private int avW;
    private ArrayList<Integer> avX;
    private int avY;
    private int avZ;
    private a avh;
    private b avi;
    private boolean avj;
    private boolean avk;
    private boolean avl;
    private boolean avm;
    private boolean avn;
    private boolean avo;
    private boolean avp;
    private boolean avq;
    private boolean avr;
    private boolean avs;
    private boolean avt;
    private boolean avu;
    private LinearLayout avv;
    private View avw;
    private HeadImageView avx;
    private FrameLayout avy;
    private LinearLayout avz;
    private boolean awa;
    private boolean awb;
    private boolean awc;
    private boolean awd;
    private int awe;
    private int awf;
    private int awg;
    private int awh;
    private int awi;
    private int awj;
    private int awk;
    private int awl;
    private int awm;
    private int awn;
    private int awo;
    private int awp;
    private int awq;
    private int awr;
    private int aws;
    private String awt;
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
        this.avj = true;
        this.avk = true;
        this.avl = true;
        this.avm = true;
        this.avn = true;
        this.avo = true;
        this.avp = false;
        this.avq = false;
        this.avr = false;
        this.avs = false;
        this.avt = false;
        this.avu = false;
        this.avW = 0;
        this.avX = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.avY = 0;
        this.avZ = 0;
        this.awa = false;
        this.awb = true;
        this.awc = false;
        this.awd = false;
        this.isGod = false;
        this.aoa = 3;
        this.padding = 0;
        this.awe = 0;
        this.awf = 0;
        this.awg = 0;
        this.awh = 0;
        this.awt = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(w.f.ds24);
        this.awf = (int) context.getResources().getDimension(w.f.ds100);
        this.awe = (int) context.getResources().getDimension(w.f.ds70);
        this.awg = (int) context.getResources().getDimension(w.f.ds18);
        this.awh = (int) context.getResources().getDimension(w.f.ds4);
        this.awi = (int) context.getResources().getDimension(w.f.ds80);
        this.awj = (int) context.getResources().getDimension(w.f.ds280);
        this.awk = (int) context.getResources().getDimension(w.f.ds170);
        this.awl = (int) context.getResources().getDimension(w.f.ds320);
        this.awm = (int) context.getResources().getDimension(w.f.ds200);
        this.awn = (int) context.getResources().getDimension(w.f.ds60);
        this.awo = (int) context.getResources().getDimension(w.f.ds120);
        this.awp = (int) context.getResources().getDimension(w.f.ds160);
        this.awq = (int) context.getResources().getDimension(w.f.ds220);
        this.awr = (int) context.getResources().getDimension(w.f.ds240);
        this.aws = (int) context.getResources().getDimension(w.f.ds180);
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
        this.avv = (LinearLayout) inflate.findViewById(w.h.pl_card_root);
        this.avw = inflate.findViewById(w.h.author_info);
        this.avG = (LinearLayout) inflate.findViewById(w.h.photo_live_card_title);
        this.avK = (LinearLayout) inflate.findViewById(w.h.photo_live_card_content);
        this.avM = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_cover_and_expression);
        this.avR = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_bottom);
        Bc();
        Bd();
        Be();
        Bg();
        Bf();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.avj, photoLiveCardData);
            b(this.avk, this.avp, photoLiveCardData);
            b(this.avl, photoLiveCardData);
            a(this.avm, this.avn, photoLiveCardData);
            a(this.avo, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.isGod = true;
        } else {
            this.isGod = false;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.awb) {
                if (this.paddingBottom != 0) {
                    this.avM.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.avM.setPadding(this.padding, 0, this.padding, 0);
                }
                this.avM.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.avM != null) {
                this.avM.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.avR.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.avq);
                i(photoLiveCardData.getDiscussNum(), this.avt);
                return;
            }
            this.avR.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.avG.setVisibility(0);
                if (this.avZ != 0) {
                    this.avH.setMaxLines(this.avZ);
                } else {
                    this.avH.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.avH, photoLiveCardData.getThreadId());
                return;
            }
            this.avG.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.avu) {
            this.avJ.setVisibility(0);
            this.avJ.setTag(photoLiveCardData);
            return;
        }
        this.avJ.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.avK.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.avK.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.avK.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.avL, photoLiveCardData.getThreadId());
                return;
            }
            this.avK.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.awc) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ru(String.valueOf(j))) {
                as.c(textView, w.e.cp_cont_c, 1);
            } else {
                as.c(textView, w.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.avw.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.avw.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.avw.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.avx.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.awf;
                        layoutParams.width = this.awf;
                    }
                    if (this.avV == null) {
                        this.avV = new TextView(this.context);
                        this.avV.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.avV.setEllipsize(TextUtils.TruncateAt.END);
                        this.avV.setTextSize(0, this.awg);
                        as.i(this.avV, w.e.cp_cont_h);
                        as.j(this.avV, w.g.icon_shen);
                        this.avV.setSingleLine(true);
                        this.avz.addView(this.avV);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.avV.setText(w.l.god_intro_default);
                    } else {
                        this.avV.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.avz.removeView(this.avV);
                    this.avV = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.awe;
                        layoutParams.width = this.awe;
                    }
                }
                this.avx.setTag(photoLiveCardData);
                eZ(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.avz.removeView(this.avV);
            this.avw.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.avx.setPadding(this.awh, this.awh, this.awh, this.awh);
            if (this.isGod) {
                this.avy.setBackgroundDrawable(as.getDrawable(w.g.pic_bg_jinbian));
                return;
            } else {
                this.avy.setBackgroundDrawable(as.getDrawable(w.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.avy.setBackgroundDrawable(null);
        this.avx.setPadding(0, 0, 0, 0);
    }

    private void Bc() {
        if (this.avw != null) {
            this.avx = (HeadImageView) this.avw.findViewById(w.h.author_portrait);
            this.avy = (FrameLayout) this.avw.findViewById(w.h.author_portrait_info);
            this.avA = (TextView) this.avw.findViewById(w.h.author_name);
            this.avB = (TextView) this.avw.findViewById(w.h.nick_name);
            this.avC = (TextView) this.avw.findViewById(w.h.fans_num);
            this.avD = (TextView) this.avw.findViewById(w.h.reply_num);
            this.avE = (TextView) this.avw.findViewById(w.h.headlive_icon);
            this.avF = (TextView) this.avw.findViewById(w.h.refresh_time_in_head);
            this.avz = (LinearLayout) this.avw.findViewById(w.h.author_info_and_time);
            this.avx.setOnClickListener(new s(this));
        }
    }

    private void Bd() {
        if (this.avG != null) {
            this.avH = (TextView) this.avG.findViewById(w.h.title);
            this.avI = (TextView) findViewById(w.h.refresh_time_in_title);
            this.avJ = (TextView) this.avG.findViewById(w.h.card_delete_in_title);
            this.avJ.setOnClickListener(new t(this));
        }
    }

    private void Be() {
        if (this.avK != null) {
            this.avL = (TextView) this.avK.findViewById(w.h.content);
        }
    }

    private void Bf() {
        if (this.avR != null) {
            this.avS = (TextView) this.avR.findViewById(w.h.ba_name);
            this.avT = (TextView) this.avR.findViewById(w.h.bottom_refresh_time);
            this.avU = (TextView) this.avR.findViewById(w.h.bottom_reply_num);
        }
    }

    private void Bg() {
        if (this.avM != null) {
            this.avN = (TbImageView) this.avM.findViewById(w.h.live_cover);
            this.avN.setGifIconSupport(false);
            Bh();
        }
    }

    private void Bh() {
        if (this.avM != null) {
            this.avO = (TextView) this.avM.findViewById(w.h.first_style_first_expression);
            this.avP = (TextView) this.avM.findViewById(w.h.first_style_second_expression);
            this.avQ = (TextView) this.avM.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.avX.clear();
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
        if (this.avX.size() != 0) {
            int size = this.avX.size();
            for (int i = 0; i < size; i++) {
                if (this.avX.get(i).intValue() == this.avO.getId()) {
                    this.avO.setVisibility(8);
                } else if (this.avX.get(i).intValue() == this.avP.getId()) {
                    this.avP.setVisibility(8);
                } else if (this.avX.get(i).intValue() == this.avQ.getId()) {
                    this.avQ.setVisibility(8);
                }
            }
        }
    }

    private void Bj() {
        this.avO.setText("");
        this.avP.setText("");
        this.avQ.setText("");
        if (this.avO.getVisibility() == 8) {
            this.avO.setVisibility(0);
        }
        if (this.avP.getVisibility() == 8) {
            this.avP.setVisibility(0);
        }
        if (this.avQ.getVisibility() == 8) {
            this.avQ.setVisibility(0);
        }
        this.avX.add(Integer.valueOf(this.avO.getId()));
        this.avX.add(Integer.valueOf(this.avP.getId()));
        this.avX.add(Integer.valueOf(this.avQ.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ai(nVar.getLabelName(), String.valueOf(nVar.AV())));
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
            switch (this.avW) {
                case 0:
                    a(this.awi, this.awj, this.avO);
                    a(this.awk, this.awl, this.avP);
                    a(this.awm, this.awn, this.avQ);
                    break;
                case 1:
                    a(this.awn, this.awo, this.avO);
                    a(this.awp, this.awn, this.avP);
                    a(this.awq, this.awl, this.avQ);
                    break;
                case 2:
                    a(this.awn, this.awr, this.avO);
                    a(this.aws, this.awn, this.avP);
                    a(this.awq, this.awl, this.avQ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.avO);
            } else if (i == 1) {
                a(arrayList.get(i2), this.avP);
            } else if (i == 2) {
                a(arrayList.get(i2), this.avQ);
            }
        }
    }

    private void ej(int i) {
        if (this.avX.size() != 0) {
            int size = this.avX.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.avX.get(i2).intValue() == i) {
                    this.avX.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.avN.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.avN.c(str, 10, false);
        } else {
            this.avN.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.avS.setText("");
            return;
        }
        String trim = str.trim();
        this.avS.setVisibility(0);
        if (com.baidu.tbadk.util.y.gI(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.y.d(trim, 0, 12)) + "...";
        }
        this.avS.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(w.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.avL.setText("");
            this.avL.setVisibility(8);
            return;
        }
        this.avL.setVisibility(0);
        this.avL.setText(str);
    }

    private void setTitle(String str) {
        this.awt = str;
        if (this.avY != 0) {
            this.avH.setPadding(0, 0, (int) this.context.getResources().getDimension(this.avY), 0);
            this.avY = 0;
        } else {
            this.avH.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.avH.setText("");
            return;
        }
        this.avH.setVisibility(0);
        if (this.awa) {
            if (this.awd) {
                this.avH.setText(at.c(this.context, str, w.l.photo_live_tips));
                return;
            } else {
                this.avH.setText(e(str));
                return;
            }
        }
        this.avH.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cO = as.cO(w.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        int height = cO.getHeight();
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.avx.c(str, 12, false);
        } else {
            this.avx.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.avA.setText("");
            return;
        }
        this.avA.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.y.gI(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.y.d(trim, 0, 14)) + "...";
        }
        this.avA.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.avB, this.context.getResources().getString(w.l.fans_default_name));
        } else {
            b(this.avB, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = as.getDrawable(w.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.avC.setText(aw.y(i));
    }

    private void setReplyNum(int i) {
        b(this.avD, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(aw.y(j));
        Drawable drawable = as.getDrawable(w.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.avU.setVisibility(0);
            b(this.avU, i);
            return;
        }
        this.avU.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.avs) {
            this.avE.setVisibility(0);
            as.j(this.avE, w.g.label_onthelist);
            return;
        }
        this.avE.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.avr) {
            this.avF.setVisibility(0);
            this.avF.setText(str);
            return;
        }
        this.avF.setVisibility(8);
        this.avF.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.avI.setVisibility(8);
            return;
        }
        this.avI.setVisibility(0);
        this.avI.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.avT.setVisibility(8);
            return;
        }
        this.avT.setVisibility(0);
        this.avT.setText(str);
    }

    public void setShowHead(boolean z) {
        this.avj = z;
    }

    public void setShowTitle(boolean z) {
        this.avk = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.avp = z;
    }

    public void setShowContent(boolean z) {
        this.avl = z;
    }

    public void setShowCover(boolean z) {
        this.avm = z;
    }

    public void setShowExpression(boolean z) {
        this.avn = z;
    }

    public void setShowBottom(boolean z) {
        this.avo = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.avr = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.avs = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.avt = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.avu = z;
    }

    public void setChooseStyle(int i) {
        this.avW = i;
    }

    public int getShowStyle() {
        return this.avW;
    }

    public void setShowLiveIcon(boolean z) {
        this.awa = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.avh = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.avi = bVar;
    }

    public void setParentBackground(int i) {
        as.j(this.avv, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.awb = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.avq = z;
    }

    public void setTitlePaddingRight(int i) {
        this.avY = i;
    }

    public void setTitleMaxLines(int i) {
        this.avZ = i;
    }

    public void setAllowGreyState(boolean z) {
        this.awc = z;
    }

    public void bn(boolean z) {
        this.awd = z;
    }
}
