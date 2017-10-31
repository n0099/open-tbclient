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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int api;
    private a avV;
    private b avW;
    private boolean avX;
    private boolean avY;
    private boolean avZ;
    private RelativeLayout awA;
    private TbImageView awB;
    private TextView awC;
    private TextView awD;
    private TextView awE;
    private RelativeLayout awF;
    private TextView awG;
    private TextView awH;
    private TextView awI;
    private TextView awJ;
    private int awK;
    private ArrayList<Integer> awL;
    private int awM;
    private int awN;
    private boolean awO;
    private boolean awP;
    private boolean awQ;
    private boolean awR;
    private int awS;
    private int awT;
    private int awU;
    private int awV;
    private int awW;
    private int awX;
    private int awY;
    private int awZ;
    private boolean awa;
    private boolean awb;
    private boolean awc;
    private boolean awd;
    private boolean awe;
    private boolean awf;
    private boolean awg;
    private boolean awh;
    private boolean awi;
    private LinearLayout awj;
    private View awk;
    private HeadImageView awl;
    private FrameLayout awm;
    private LinearLayout awn;
    private TextView awo;
    private TextView awp;
    private TextView awq;
    private TextView awr;
    private TextView aws;
    private TextView awt;
    private LinearLayout awu;
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
    private String axh;
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
        this.avX = true;
        this.avY = true;
        this.avZ = true;
        this.awa = true;
        this.awb = true;
        this.awc = true;
        this.awd = false;
        this.awe = false;
        this.awf = false;
        this.awg = false;
        this.awh = false;
        this.awi = false;
        this.awK = 0;
        this.awL = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.awM = 0;
        this.awN = 0;
        this.awO = false;
        this.awP = true;
        this.awQ = false;
        this.awR = false;
        this.isGod = false;
        this.api = 3;
        this.padding = 0;
        this.awS = 0;
        this.awT = 0;
        this.awU = 0;
        this.awV = 0;
        this.axh = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.awT = (int) context.getResources().getDimension(d.e.ds100);
        this.awS = (int) context.getResources().getDimension(d.e.ds70);
        this.awU = (int) context.getResources().getDimension(d.e.ds18);
        this.awV = (int) context.getResources().getDimension(d.e.ds4);
        this.awW = (int) context.getResources().getDimension(d.e.ds80);
        this.awX = (int) context.getResources().getDimension(d.e.ds280);
        this.awY = (int) context.getResources().getDimension(d.e.ds170);
        this.awZ = (int) context.getResources().getDimension(d.e.ds320);
        this.axa = (int) context.getResources().getDimension(d.e.ds200);
        this.axb = (int) context.getResources().getDimension(d.e.ds60);
        this.axc = (int) context.getResources().getDimension(d.e.ds120);
        this.axd = (int) context.getResources().getDimension(d.e.ds160);
        this.axe = (int) context.getResources().getDimension(d.e.ds220);
        this.axf = (int) context.getResources().getDimension(d.e.ds240);
        this.axg = (int) context.getResources().getDimension(d.e.ds180);
        this.size = (int) context.getResources().getDimension(d.e.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_view, this);
        this.awj = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.awk = inflate.findViewById(d.g.author_info);
        this.awu = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.awy = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.awA = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.awF = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        AR();
        AS();
        AT();
        AV();
        AU();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.avX, photoLiveCardData);
            b(this.avY, this.awd, photoLiveCardData);
            b(this.avZ, photoLiveCardData);
            a(this.awa, this.awb, photoLiveCardData);
            a(this.awc, photoLiveCardData);
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
            if (z && this.awP) {
                if (this.paddingBottom != 0) {
                    this.awA.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awA.setPadding(this.padding, 0, this.padding, 0);
                }
                this.awA.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awA != null) {
                this.awA.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awF.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.awe);
                h(photoLiveCardData.getDiscussNum(), this.awh);
                return;
            }
            this.awF.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awu.setVisibility(0);
                if (this.awN != 0) {
                    this.awv.setMaxLines(this.awN);
                } else {
                    this.awv.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.awv, photoLiveCardData.getThreadId());
                return;
            }
            this.awu.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.awi) {
            this.awx.setVisibility(0);
            this.awx.setTag(photoLiveCardData);
            return;
        }
        this.awx.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awy.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.awy.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awy.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.awz, photoLiveCardData.getThreadId());
                return;
            }
            this.awy.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.awQ) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sG(String.valueOf(j))) {
                aj.c(textView, d.C0080d.cp_cont_c, 1);
            } else {
                aj.c(textView, d.C0080d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awk.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.awk.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.awk.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.awl.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.awT;
                        layoutParams.width = this.awT;
                    }
                    if (this.awJ == null) {
                        this.awJ = new TextView(this.context);
                        this.awJ.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.awJ.setEllipsize(TextUtils.TruncateAt.END);
                        this.awJ.setTextSize(0, this.awU);
                        aj.i(this.awJ, d.C0080d.cp_cont_h);
                        aj.j(this.awJ, d.f.icon_shen);
                        this.awJ.setSingleLine(true);
                        this.awn.addView(this.awJ);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.awJ.setText(d.j.god_intro_default);
                    } else {
                        this.awJ.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.awn.removeView(this.awJ);
                    this.awJ = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.awS;
                        layoutParams.width = this.awS;
                    }
                }
                this.awl.setTag(photoLiveCardData);
                fh(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.awn.removeView(this.awJ);
            this.awk.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.awl.setPadding(this.awV, this.awV, this.awV, this.awV);
            if (this.isGod) {
                this.awm.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.awm.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.awm.setBackgroundDrawable(null);
        this.awl.setPadding(0, 0, 0, 0);
    }

    private void AR() {
        if (this.awk != null) {
            this.awl = (HeadImageView) this.awk.findViewById(d.g.author_portrait);
            this.awm = (FrameLayout) this.awk.findViewById(d.g.author_portrait_info);
            this.awo = (TextView) this.awk.findViewById(d.g.author_name);
            this.awp = (TextView) this.awk.findViewById(d.g.nick_name);
            this.awq = (TextView) this.awk.findViewById(d.g.fans_num);
            this.awr = (TextView) this.awk.findViewById(d.g.reply_num);
            this.aws = (TextView) this.awk.findViewById(d.g.headlive_icon);
            this.awt = (TextView) this.awk.findViewById(d.g.refresh_time_in_head);
            this.awn = (LinearLayout) this.awk.findViewById(d.g.author_info_and_time);
            this.awl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.avW != null) {
                        PhotoLiveCardView.this.avW.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void AS() {
        if (this.awu != null) {
            this.awv = (TextView) this.awu.findViewById(d.g.title);
            this.aww = (TextView) findViewById(d.g.refresh_time_in_title);
            this.awx = (TextView) this.awu.findViewById(d.g.card_delete_in_title);
            this.awx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.avV != null) {
                        PhotoLiveCardView.this.avV.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void AT() {
        if (this.awy != null) {
            this.awz = (TextView) this.awy.findViewById(d.g.content);
        }
    }

    private void AU() {
        if (this.awF != null) {
            this.awG = (TextView) this.awF.findViewById(d.g.ba_name);
            this.awH = (TextView) this.awF.findViewById(d.g.bottom_refresh_time);
            this.awI = (TextView) this.awF.findViewById(d.g.bottom_reply_num);
        }
    }

    private void AV() {
        if (this.awA != null) {
            this.awB = (TbImageView) this.awA.findViewById(d.g.live_cover);
            this.awB.setGifIconSupport(false);
            AW();
        }
    }

    private void AW() {
        if (this.awA != null) {
            this.awC = (TextView) this.awA.findViewById(d.g.first_style_first_expression);
            this.awD = (TextView) this.awA.findViewById(d.g.first_style_second_expression);
            this.awE = (TextView) this.awA.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awL.clear();
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
        if (this.awL.size() != 0) {
            int size = this.awL.size();
            for (int i = 0; i < size; i++) {
                if (this.awL.get(i).intValue() == this.awC.getId()) {
                    this.awC.setVisibility(8);
                } else if (this.awL.get(i).intValue() == this.awD.getId()) {
                    this.awD.setVisibility(8);
                } else if (this.awL.get(i).intValue() == this.awE.getId()) {
                    this.awE.setVisibility(8);
                }
            }
        }
    }

    private void AY() {
        this.awC.setText("");
        this.awD.setText("");
        this.awE.setText("");
        if (this.awC.getVisibility() == 8) {
            this.awC.setVisibility(0);
        }
        if (this.awD.getVisibility() == 8) {
            this.awD.setVisibility(0);
        }
        if (this.awE.getVisibility() == 8) {
            this.awE.setVisibility(0);
        }
        this.awL.add(Integer.valueOf(this.awC.getId()));
        this.awL.add(Integer.valueOf(this.awD.getId()));
        this.awL.add(Integer.valueOf(this.awE.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.AK())));
            ex(textView.getId());
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
            switch (this.awK) {
                case 0:
                    a(this.awW, this.awX, this.awC);
                    a(this.awY, this.awZ, this.awD);
                    a(this.axa, this.axb, this.awE);
                    break;
                case 1:
                    a(this.axb, this.axc, this.awC);
                    a(this.axd, this.axb, this.awD);
                    a(this.axe, this.awZ, this.awE);
                    break;
                case 2:
                    a(this.axb, this.axf, this.awC);
                    a(this.axg, this.axb, this.awD);
                    a(this.axe, this.awZ, this.awE);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awC);
            } else if (i == 1) {
                a(arrayList.get(i2), this.awD);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awE);
            }
        }
    }

    private void ex(int i) {
        if (this.awL.size() != 0) {
            int size = this.awL.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awL.get(i2).intValue() == i) {
                    this.awL.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.awB.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awB.startLoad(str, 10, false);
        } else {
            this.awB.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awG.setText("");
            return;
        }
        String trim = str.trim();
        this.awG.setVisibility(0);
        if (w.gV(trim) > 12) {
            trim = w.e(trim, 0, 12) + "...";
        }
        this.awG.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awz.setText("");
            this.awz.setVisibility(8);
            return;
        }
        this.awz.setVisibility(0);
        this.awz.setText(str);
    }

    private void setTitle(String str) {
        this.axh = str;
        if (this.awM != 0) {
            this.awv.setPadding(0, 0, (int) this.context.getResources().getDimension(this.awM), 0);
            this.awM = 0;
        } else {
            this.awv.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.awv.setText("");
            return;
        }
        this.awv.setVisibility(0);
        if (this.awO) {
            if (this.awR) {
                this.awv.setText(m.c(this.context, str, d.j.photo_live_tips));
                return;
            } else {
                this.awv.setText(e(str));
                return;
            }
        }
        this.awv.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap cR = aj.cR(d.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
        int height = cR.getHeight();
        bitmapDrawable.setBounds(0, 0, cR.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fh(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.awl.startLoad(str, 12, false);
        } else {
            this.awl.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awo.setText("");
            return;
        }
        this.awo.setVisibility(0);
        String trim = str.trim();
        if (w.gV(trim) > 14) {
            trim = w.e(trim, 0, 14) + "...";
        }
        this.awo.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.awp, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.awp, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.awq.setText(am.y(i));
    }

    private void setReplyNum(int i) {
        b(this.awr, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(am.y(j));
        Drawable drawable = aj.getDrawable(d.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void h(int i, boolean z) {
        if (z) {
            this.awI.setVisibility(0);
            b(this.awI, i);
            return;
        }
        this.awI.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.awg) {
            this.aws.setVisibility(0);
            aj.j(this.aws, d.f.label_onthelist);
            return;
        }
        this.aws.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.awf) {
            this.awt.setVisibility(0);
            this.awt.setText(str);
            return;
        }
        this.awt.setVisibility(8);
        this.awt.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.aww.setVisibility(8);
            return;
        }
        this.aww.setVisibility(0);
        this.aww.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.awH.setVisibility(8);
            return;
        }
        this.awH.setVisibility(0);
        this.awH.setText(str);
    }

    public void setShowHead(boolean z) {
        this.avX = z;
    }

    public void setShowTitle(boolean z) {
        this.avY = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.awd = z;
    }

    public void setShowContent(boolean z) {
        this.avZ = z;
    }

    public void setShowCover(boolean z) {
        this.awa = z;
    }

    public void setShowExpression(boolean z) {
        this.awb = z;
    }

    public void setShowBottom(boolean z) {
        this.awc = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.awf = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.awg = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.awh = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.awi = z;
    }

    public void setChooseStyle(int i) {
        this.awK = i;
    }

    public int getShowStyle() {
        return this.awK;
    }

    public void setShowLiveIcon(boolean z) {
        this.awO = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.avV = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.avW = bVar;
    }

    public void setParentBackground(int i) {
        aj.j(this.awj, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.awP = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.awe = z;
    }

    public void setTitlePaddingRight(int i) {
        this.awM = i;
    }

    public void setTitleMaxLines(int i) {
        this.awN = i;
    }

    public void setAllowGreyState(boolean z) {
        this.awQ = z;
    }

    public void bk(boolean z) {
        this.awR = z;
    }
}
