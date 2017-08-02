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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aoR;
    private a avZ;
    private TextView awA;
    private TextView awB;
    private LinearLayout awC;
    private TextView awD;
    private RelativeLayout awE;
    private TbImageView awF;
    private TextView awG;
    private TextView awH;
    private TextView awI;
    private RelativeLayout awJ;
    private TextView awK;
    private TextView awL;
    private TextView awM;
    private TextView awN;
    private int awO;
    private ArrayList<Integer> awP;
    private int awQ;
    private int awR;
    private boolean awS;
    private boolean awT;
    private boolean awU;
    private boolean awV;
    private int awW;
    private int awX;
    private int awY;
    private int awZ;
    private b awa;
    private boolean awb;
    private boolean awc;
    private boolean awd;
    private boolean awe;
    private boolean awf;
    private boolean awg;
    private boolean awh;
    private boolean awi;
    private boolean awj;
    private boolean awk;
    private boolean awl;
    private boolean awm;
    private LinearLayout awn;
    private View awo;
    private HeadImageView awp;
    private FrameLayout awq;
    private LinearLayout awr;
    private TextView aws;
    private TextView awt;
    private TextView awu;
    private TextView awv;
    private TextView aww;
    private TextView awx;
    private LinearLayout awy;
    private TextView awz;
    private int axa;
    private int axb;
    private int axc;
    private int axd;
    private int axe;
    private int axf;
    private int axg;
    private int axh;
    private int axi;
    private int axj;
    private int axk;
    private String axl;
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
        this.awb = true;
        this.awc = true;
        this.awd = true;
        this.awe = true;
        this.awf = true;
        this.awg = true;
        this.awh = false;
        this.awi = false;
        this.awj = false;
        this.awk = false;
        this.awl = false;
        this.awm = false;
        this.awO = 0;
        this.awP = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.awQ = 0;
        this.awR = 0;
        this.awS = false;
        this.awT = true;
        this.awU = false;
        this.awV = false;
        this.isGod = false;
        this.aoR = 3;
        this.padding = 0;
        this.awW = 0;
        this.awX = 0;
        this.awY = 0;
        this.awZ = 0;
        this.axl = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.f.ds24);
        this.awX = (int) context.getResources().getDimension(d.f.ds100);
        this.awW = (int) context.getResources().getDimension(d.f.ds70);
        this.awY = (int) context.getResources().getDimension(d.f.ds18);
        this.awZ = (int) context.getResources().getDimension(d.f.ds4);
        this.axa = (int) context.getResources().getDimension(d.f.ds80);
        this.axb = (int) context.getResources().getDimension(d.f.ds280);
        this.axc = (int) context.getResources().getDimension(d.f.ds170);
        this.axd = (int) context.getResources().getDimension(d.f.ds320);
        this.axe = (int) context.getResources().getDimension(d.f.ds200);
        this.axf = (int) context.getResources().getDimension(d.f.ds60);
        this.axg = (int) context.getResources().getDimension(d.f.ds120);
        this.axh = (int) context.getResources().getDimension(d.f.ds160);
        this.axi = (int) context.getResources().getDimension(d.f.ds220);
        this.axj = (int) context.getResources().getDimension(d.f.ds240);
        this.axk = (int) context.getResources().getDimension(d.f.ds180);
        this.size = (int) context.getResources().getDimension(d.f.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_view, this);
        this.awn = (LinearLayout) inflate.findViewById(d.h.pl_card_root);
        this.awo = inflate.findViewById(d.h.author_info);
        this.awy = (LinearLayout) inflate.findViewById(d.h.photo_live_card_title);
        this.awC = (LinearLayout) inflate.findViewById(d.h.photo_live_card_content);
        this.awE = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_cover_and_expression);
        this.awJ = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_bottom);
        Bn();
        Bo();
        Bp();
        Br();
        Bq();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.awb, photoLiveCardData);
            b(this.awc, this.awh, photoLiveCardData);
            b(this.awd, photoLiveCardData);
            a(this.awe, this.awf, photoLiveCardData);
            a(this.awg, photoLiveCardData);
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
            if (z && this.awT) {
                if (this.paddingBottom != 0) {
                    this.awE.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awE.setPadding(this.padding, 0, this.padding, 0);
                }
                this.awE.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awE != null) {
                this.awE.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awJ.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.awi);
                j(photoLiveCardData.getDiscussNum(), this.awl);
                return;
            }
            this.awJ.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awy.setVisibility(0);
                if (this.awR != 0) {
                    this.awz.setMaxLines(this.awR);
                } else {
                    this.awz.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.awz, photoLiveCardData.getThreadId());
                return;
            }
            this.awy.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.awm) {
            this.awB.setVisibility(0);
            this.awB.setTag(photoLiveCardData);
            return;
        }
        this.awB.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awC.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.awC.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awC.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.awD, photoLiveCardData.getThreadId());
                return;
            }
            this.awC.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.awU) {
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sg(String.valueOf(j))) {
                ai.c(textView, d.e.cp_cont_c, 1);
            } else {
                ai.c(textView, d.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awo.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.awo.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.awo.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.awp.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.awX;
                        layoutParams.width = this.awX;
                    }
                    if (this.awN == null) {
                        this.awN = new TextView(this.context);
                        this.awN.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.awN.setEllipsize(TextUtils.TruncateAt.END);
                        this.awN.setTextSize(0, this.awY);
                        ai.i(this.awN, d.e.cp_cont_h);
                        ai.j(this.awN, d.g.icon_shen);
                        this.awN.setSingleLine(true);
                        this.awr.addView(this.awN);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.awN.setText(d.l.god_intro_default);
                    } else {
                        this.awN.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.awr.removeView(this.awN);
                    this.awN = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.awW;
                        layoutParams.width = this.awW;
                    }
                }
                this.awp.setTag(photoLiveCardData);
                fd(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.awr.removeView(this.awN);
            this.awo.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.awp.setPadding(this.awZ, this.awZ, this.awZ, this.awZ);
            if (this.isGod) {
                this.awq.setBackgroundDrawable(ai.getDrawable(d.g.pic_bg_jinbian));
                return;
            } else {
                this.awq.setBackgroundDrawable(ai.getDrawable(d.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.awq.setBackgroundDrawable(null);
        this.awp.setPadding(0, 0, 0, 0);
    }

    private void Bn() {
        if (this.awo != null) {
            this.awp = (HeadImageView) this.awo.findViewById(d.h.author_portrait);
            this.awq = (FrameLayout) this.awo.findViewById(d.h.author_portrait_info);
            this.aws = (TextView) this.awo.findViewById(d.h.author_name);
            this.awt = (TextView) this.awo.findViewById(d.h.nick_name);
            this.awu = (TextView) this.awo.findViewById(d.h.fans_num);
            this.awv = (TextView) this.awo.findViewById(d.h.reply_num);
            this.aww = (TextView) this.awo.findViewById(d.h.headlive_icon);
            this.awx = (TextView) this.awo.findViewById(d.h.refresh_time_in_head);
            this.awr = (LinearLayout) this.awo.findViewById(d.h.author_info_and_time);
            this.awp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awa != null) {
                        PhotoLiveCardView.this.awa.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Bo() {
        if (this.awy != null) {
            this.awz = (TextView) this.awy.findViewById(d.h.title);
            this.awA = (TextView) findViewById(d.h.refresh_time_in_title);
            this.awB = (TextView) this.awy.findViewById(d.h.card_delete_in_title);
            this.awB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.avZ != null) {
                        PhotoLiveCardView.this.avZ.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bp() {
        if (this.awC != null) {
            this.awD = (TextView) this.awC.findViewById(d.h.content);
        }
    }

    private void Bq() {
        if (this.awJ != null) {
            this.awK = (TextView) this.awJ.findViewById(d.h.ba_name);
            this.awL = (TextView) this.awJ.findViewById(d.h.bottom_refresh_time);
            this.awM = (TextView) this.awJ.findViewById(d.h.bottom_reply_num);
        }
    }

    private void Br() {
        if (this.awE != null) {
            this.awF = (TbImageView) this.awE.findViewById(d.h.live_cover);
            this.awF.setGifIconSupport(false);
            Bs();
        }
    }

    private void Bs() {
        if (this.awE != null) {
            this.awG = (TextView) this.awE.findViewById(d.h.first_style_first_expression);
            this.awH = (TextView) this.awE.findViewById(d.h.first_style_second_expression);
            this.awI = (TextView) this.awE.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awP.clear();
        Bu();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bt();
        }
    }

    private void Bt() {
        if (this.awP.size() != 0) {
            int size = this.awP.size();
            for (int i = 0; i < size; i++) {
                if (this.awP.get(i).intValue() == this.awG.getId()) {
                    this.awG.setVisibility(8);
                } else if (this.awP.get(i).intValue() == this.awH.getId()) {
                    this.awH.setVisibility(8);
                } else if (this.awP.get(i).intValue() == this.awI.getId()) {
                    this.awI.setVisibility(8);
                }
            }
        }
    }

    private void Bu() {
        this.awG.setText("");
        this.awH.setText("");
        this.awI.setText("");
        if (this.awG.getVisibility() == 8) {
            this.awG.setVisibility(0);
        }
        if (this.awH.getVisibility() == 8) {
            this.awH.setVisibility(0);
        }
        if (this.awI.getVisibility() == 8) {
            this.awI.setVisibility(0);
        }
        this.awP.add(Integer.valueOf(this.awG.getId()));
        this.awP.add(Integer.valueOf(this.awH.getId()));
        this.awP.add(Integer.valueOf(this.awI.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ai(eVar.getLabelName(), String.valueOf(eVar.Bg())));
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

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.awO) {
                case 0:
                    a(this.axa, this.axb, this.awG);
                    a(this.axc, this.axd, this.awH);
                    a(this.axe, this.axf, this.awI);
                    break;
                case 1:
                    a(this.axf, this.axg, this.awG);
                    a(this.axh, this.axf, this.awH);
                    a(this.axi, this.axd, this.awI);
                    break;
                case 2:
                    a(this.axf, this.axj, this.awG);
                    a(this.axk, this.axf, this.awH);
                    a(this.axi, this.axd, this.awI);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awG);
            } else if (i == 1) {
                a(arrayList.get(i2), this.awH);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awI);
            }
        }
    }

    private void el(int i) {
        if (this.awP.size() != 0) {
            int size = this.awP.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awP.get(i2).intValue() == i) {
                    this.awP.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.awF.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awF.c(str, 10, false);
        } else {
            this.awF.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awK.setText("");
            return;
        }
        String trim = str.trim();
        this.awK.setVisibility(0);
        if (v.gO(trim) > 12) {
            trim = v.d(trim, 0, 12) + "...";
        }
        this.awK.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awD.setText("");
            this.awD.setVisibility(8);
            return;
        }
        this.awD.setVisibility(0);
        this.awD.setText(str);
    }

    private void setTitle(String str) {
        this.axl = str;
        if (this.awQ != 0) {
            this.awz.setPadding(0, 0, (int) this.context.getResources().getDimension(this.awQ), 0);
            this.awQ = 0;
        } else {
            this.awz.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.awz.setText("");
            return;
        }
        this.awz.setVisibility(0);
        if (this.awS) {
            if (this.awV) {
                this.awz.setText(m.c(this.context, str, d.l.photo_live_tips));
                return;
            } else {
                this.awz.setText(e(str));
                return;
            }
        }
        this.awz.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap cQ = ai.cQ(d.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
        int height = cQ.getHeight();
        bitmapDrawable.setBounds(0, 0, cQ.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fd(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.awp.c(str, 12, false);
        } else {
            this.awp.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aws.setText("");
            return;
        }
        this.aws.setVisibility(0);
        String trim = str.trim();
        if (v.gO(trim) > 14) {
            trim = v.d(trim, 0, 14) + "...";
        }
        this.aws.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.awt, this.context.getResources().getString(d.l.fans_default_name));
        } else {
            b(this.awt, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = ai.getDrawable(d.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.awu.setText(al.z(i));
    }

    private void setReplyNum(int i) {
        b(this.awv, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(al.z(j));
        Drawable drawable = ai.getDrawable(d.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void j(int i, boolean z) {
        if (z) {
            this.awM.setVisibility(0);
            b(this.awM, i);
            return;
        }
        this.awM.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.awk) {
            this.aww.setVisibility(0);
            ai.j(this.aww, d.g.label_onthelist);
            return;
        }
        this.aww.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.awj) {
            this.awx.setVisibility(0);
            this.awx.setText(str);
            return;
        }
        this.awx.setVisibility(8);
        this.awx.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.awA.setVisibility(8);
            return;
        }
        this.awA.setVisibility(0);
        this.awA.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.awL.setVisibility(8);
            return;
        }
        this.awL.setVisibility(0);
        this.awL.setText(str);
    }

    public void setShowHead(boolean z) {
        this.awb = z;
    }

    public void setShowTitle(boolean z) {
        this.awc = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.awh = z;
    }

    public void setShowContent(boolean z) {
        this.awd = z;
    }

    public void setShowCover(boolean z) {
        this.awe = z;
    }

    public void setShowExpression(boolean z) {
        this.awf = z;
    }

    public void setShowBottom(boolean z) {
        this.awg = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.awj = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.awk = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.awl = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.awm = z;
    }

    public void setChooseStyle(int i) {
        this.awO = i;
    }

    public int getShowStyle() {
        return this.awO;
    }

    public void setShowLiveIcon(boolean z) {
        this.awS = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.avZ = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.awa = bVar;
    }

    public void setParentBackground(int i) {
        ai.j(this.awn, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.awT = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.awi = z;
    }

    public void setTitlePaddingRight(int i) {
        this.awQ = i;
    }

    public void setTitleMaxLines(int i) {
        this.awR = i;
    }

    public void setAllowGreyState(boolean z) {
        this.awU = z;
    }

    public void bp(boolean z) {
        this.awV = z;
    }
}
