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
    public int aph;
    private TextView awA;
    private TextView awB;
    private LinearLayout awC;
    private TextView awD;
    private TextView awE;
    private TextView awF;
    private LinearLayout awG;
    private TextView awH;
    private RelativeLayout awI;
    private TbImageView awJ;
    private TextView awK;
    private TextView awL;
    private TextView awM;
    private RelativeLayout awN;
    private TextView awO;
    private TextView awP;
    private TextView awQ;
    private TextView awR;
    private int awS;
    private ArrayList<Integer> awT;
    private int awU;
    private int awV;
    private boolean awW;
    private boolean awX;
    private boolean awY;
    private boolean awZ;
    private a awd;
    private b awe;
    private boolean awf;
    private boolean awg;
    private boolean awh;
    private boolean awi;
    private boolean awj;
    private boolean awk;
    private boolean awl;
    private boolean awm;
    private boolean awn;
    private boolean awo;
    private boolean awp;
    private boolean awq;
    private LinearLayout awr;
    private View aws;
    private HeadImageView awt;
    private FrameLayout awu;
    private LinearLayout awv;
    private TextView aww;
    private TextView awx;
    private TextView awy;
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
    private int axl;
    private int axm;
    private int axn;
    private int axo;
    private String axp;
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
        this.awf = true;
        this.awg = true;
        this.awh = true;
        this.awi = true;
        this.awj = true;
        this.awk = true;
        this.awl = false;
        this.awm = false;
        this.awn = false;
        this.awo = false;
        this.awp = false;
        this.awq = false;
        this.awS = 0;
        this.awT = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.awU = 0;
        this.awV = 0;
        this.awW = false;
        this.awX = true;
        this.awY = false;
        this.awZ = false;
        this.isGod = false;
        this.aph = 3;
        this.padding = 0;
        this.axa = 0;
        this.axb = 0;
        this.axc = 0;
        this.axd = 0;
        this.axp = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.axb = (int) context.getResources().getDimension(d.e.ds100);
        this.axa = (int) context.getResources().getDimension(d.e.ds70);
        this.axc = (int) context.getResources().getDimension(d.e.ds18);
        this.axd = (int) context.getResources().getDimension(d.e.ds4);
        this.axe = (int) context.getResources().getDimension(d.e.ds80);
        this.axf = (int) context.getResources().getDimension(d.e.ds280);
        this.axg = (int) context.getResources().getDimension(d.e.ds170);
        this.axh = (int) context.getResources().getDimension(d.e.ds320);
        this.axi = (int) context.getResources().getDimension(d.e.ds200);
        this.axj = (int) context.getResources().getDimension(d.e.ds60);
        this.axk = (int) context.getResources().getDimension(d.e.ds120);
        this.axl = (int) context.getResources().getDimension(d.e.ds160);
        this.axm = (int) context.getResources().getDimension(d.e.ds220);
        this.axn = (int) context.getResources().getDimension(d.e.ds240);
        this.axo = (int) context.getResources().getDimension(d.e.ds180);
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
        this.awr = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.aws = inflate.findViewById(d.g.author_info);
        this.awC = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.awG = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.awI = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.awN = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        Bd();
        Be();
        Bf();
        Bh();
        Bg();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.awf, photoLiveCardData);
            b(this.awg, this.awl, photoLiveCardData);
            b(this.awh, photoLiveCardData);
            a(this.awi, this.awj, photoLiveCardData);
            a(this.awk, photoLiveCardData);
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
            if (z && this.awX) {
                if (this.paddingBottom != 0) {
                    this.awI.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awI.setPadding(this.padding, 0, this.padding, 0);
                }
                this.awI.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awI != null) {
                this.awI.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awN.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.awm);
                h(photoLiveCardData.getDiscussNum(), this.awp);
                return;
            }
            this.awN.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awC.setVisibility(0);
                if (this.awV != 0) {
                    this.awD.setMaxLines(this.awV);
                } else {
                    this.awD.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.awD, photoLiveCardData.getThreadId());
                return;
            }
            this.awC.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.awq) {
            this.awF.setVisibility(0);
            this.awF.setTag(photoLiveCardData);
            return;
        }
        this.awF.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awG.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.awG.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awG.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.awH, photoLiveCardData.getThreadId());
                return;
            }
            this.awG.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.awY) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sM(String.valueOf(j))) {
                aj.c(textView, d.C0080d.cp_cont_c, 1);
            } else {
                aj.c(textView, d.C0080d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aws.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.aws.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.aws.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.awt.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.axb;
                        layoutParams.width = this.axb;
                    }
                    if (this.awR == null) {
                        this.awR = new TextView(this.context);
                        this.awR.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.awR.setEllipsize(TextUtils.TruncateAt.END);
                        this.awR.setTextSize(0, this.axc);
                        aj.i(this.awR, d.C0080d.cp_cont_h);
                        aj.j(this.awR, d.f.icon_shen);
                        this.awR.setSingleLine(true);
                        this.awv.addView(this.awR);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.awR.setText(d.j.god_intro_default);
                    } else {
                        this.awR.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.awv.removeView(this.awR);
                    this.awR = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.axa;
                        layoutParams.width = this.axa;
                    }
                }
                this.awt.setTag(photoLiveCardData);
                fi(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.awv.removeView(this.awR);
            this.aws.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.awt.setPadding(this.axd, this.axd, this.axd, this.axd);
            if (this.isGod) {
                this.awu.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.awu.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.awu.setBackgroundDrawable(null);
        this.awt.setPadding(0, 0, 0, 0);
    }

    private void Bd() {
        if (this.aws != null) {
            this.awt = (HeadImageView) this.aws.findViewById(d.g.author_portrait);
            this.awu = (FrameLayout) this.aws.findViewById(d.g.author_portrait_info);
            this.aww = (TextView) this.aws.findViewById(d.g.author_name);
            this.awx = (TextView) this.aws.findViewById(d.g.nick_name);
            this.awy = (TextView) this.aws.findViewById(d.g.fans_num);
            this.awz = (TextView) this.aws.findViewById(d.g.reply_num);
            this.awA = (TextView) this.aws.findViewById(d.g.headlive_icon);
            this.awB = (TextView) this.aws.findViewById(d.g.refresh_time_in_head);
            this.awv = (LinearLayout) this.aws.findViewById(d.g.author_info_and_time);
            this.awt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awe != null) {
                        PhotoLiveCardView.this.awe.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Be() {
        if (this.awC != null) {
            this.awD = (TextView) this.awC.findViewById(d.g.title);
            this.awE = (TextView) findViewById(d.g.refresh_time_in_title);
            this.awF = (TextView) this.awC.findViewById(d.g.card_delete_in_title);
            this.awF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awd != null) {
                        PhotoLiveCardView.this.awd.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bf() {
        if (this.awG != null) {
            this.awH = (TextView) this.awG.findViewById(d.g.content);
        }
    }

    private void Bg() {
        if (this.awN != null) {
            this.awO = (TextView) this.awN.findViewById(d.g.ba_name);
            this.awP = (TextView) this.awN.findViewById(d.g.bottom_refresh_time);
            this.awQ = (TextView) this.awN.findViewById(d.g.bottom_reply_num);
        }
    }

    private void Bh() {
        if (this.awI != null) {
            this.awJ = (TbImageView) this.awI.findViewById(d.g.live_cover);
            this.awJ.setGifIconSupport(false);
            Bi();
        }
    }

    private void Bi() {
        if (this.awI != null) {
            this.awK = (TextView) this.awI.findViewById(d.g.first_style_first_expression);
            this.awL = (TextView) this.awI.findViewById(d.g.first_style_second_expression);
            this.awM = (TextView) this.awI.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awT.clear();
        Bk();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bj();
        }
    }

    private void Bj() {
        if (this.awT.size() != 0) {
            int size = this.awT.size();
            for (int i = 0; i < size; i++) {
                if (this.awT.get(i).intValue() == this.awK.getId()) {
                    this.awK.setVisibility(8);
                } else if (this.awT.get(i).intValue() == this.awL.getId()) {
                    this.awL.setVisibility(8);
                } else if (this.awT.get(i).intValue() == this.awM.getId()) {
                    this.awM.setVisibility(8);
                }
            }
        }
    }

    private void Bk() {
        this.awK.setText("");
        this.awL.setText("");
        this.awM.setText("");
        if (this.awK.getVisibility() == 8) {
            this.awK.setVisibility(0);
        }
        if (this.awL.getVisibility() == 8) {
            this.awL.setVisibility(0);
        }
        if (this.awM.getVisibility() == 8) {
            this.awM.setVisibility(0);
        }
        this.awT.add(Integer.valueOf(this.awK.getId()));
        this.awT.add(Integer.valueOf(this.awL.getId()));
        this.awT.add(Integer.valueOf(this.awM.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.AW())));
            ew(textView.getId());
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
            switch (this.awS) {
                case 0:
                    a(this.axe, this.axf, this.awK);
                    a(this.axg, this.axh, this.awL);
                    a(this.axi, this.axj, this.awM);
                    break;
                case 1:
                    a(this.axj, this.axk, this.awK);
                    a(this.axl, this.axj, this.awL);
                    a(this.axm, this.axh, this.awM);
                    break;
                case 2:
                    a(this.axj, this.axn, this.awK);
                    a(this.axo, this.axj, this.awL);
                    a(this.axm, this.axh, this.awM);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awK);
            } else if (i == 1) {
                a(arrayList.get(i2), this.awL);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awM);
            }
        }
    }

    private void ew(int i) {
        if (this.awT.size() != 0) {
            int size = this.awT.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awT.get(i2).intValue() == i) {
                    this.awT.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.awJ.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awJ.startLoad(str, 10, false);
        } else {
            this.awJ.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awO.setText("");
            return;
        }
        String trim = str.trim();
        this.awO.setVisibility(0);
        if (w.gW(trim) > 12) {
            trim = w.e(trim, 0, 12) + "...";
        }
        this.awO.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awH.setText("");
            this.awH.setVisibility(8);
            return;
        }
        this.awH.setVisibility(0);
        this.awH.setText(str);
    }

    private void setTitle(String str) {
        this.axp = str;
        if (this.awU != 0) {
            this.awD.setPadding(0, 0, (int) this.context.getResources().getDimension(this.awU), 0);
            this.awU = 0;
        } else {
            this.awD.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.awD.setText("");
            return;
        }
        this.awD.setVisibility(0);
        if (this.awW) {
            if (this.awZ) {
                this.awD.setText(m.c(this.context, str, d.j.photo_live_tips));
                return;
            } else {
                this.awD.setText(e(str));
                return;
            }
        }
        this.awD.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap cQ = aj.cQ(d.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
        int height = cQ.getHeight();
        bitmapDrawable.setBounds(0, 0, cQ.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fi(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.awt.startLoad(str, 12, false);
        } else {
            this.awt.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aww.setText("");
            return;
        }
        this.aww.setVisibility(0);
        String trim = str.trim();
        if (w.gW(trim) > 14) {
            trim = w.e(trim, 0, 14) + "...";
        }
        this.aww.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.awx, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.awx, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.awy.setText(am.y(i));
    }

    private void setReplyNum(int i) {
        b(this.awz, i);
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
            this.awQ.setVisibility(0);
            b(this.awQ, i);
            return;
        }
        this.awQ.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.awo) {
            this.awA.setVisibility(0);
            aj.j(this.awA, d.f.label_onthelist);
            return;
        }
        this.awA.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.awn) {
            this.awB.setVisibility(0);
            this.awB.setText(str);
            return;
        }
        this.awB.setVisibility(8);
        this.awB.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.awE.setVisibility(8);
            return;
        }
        this.awE.setVisibility(0);
        this.awE.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.awP.setVisibility(8);
            return;
        }
        this.awP.setVisibility(0);
        this.awP.setText(str);
    }

    public void setShowHead(boolean z) {
        this.awf = z;
    }

    public void setShowTitle(boolean z) {
        this.awg = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.awl = z;
    }

    public void setShowContent(boolean z) {
        this.awh = z;
    }

    public void setShowCover(boolean z) {
        this.awi = z;
    }

    public void setShowExpression(boolean z) {
        this.awj = z;
    }

    public void setShowBottom(boolean z) {
        this.awk = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.awn = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.awo = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.awp = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.awq = z;
    }

    public void setChooseStyle(int i) {
        this.awS = i;
    }

    public int getShowStyle() {
        return this.awS;
    }

    public void setShowLiveIcon(boolean z) {
        this.awW = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.awd = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.awe = bVar;
    }

    public void setParentBackground(int i) {
        aj.j(this.awr, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.awX = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.awm = z;
    }

    public void setTitlePaddingRight(int i) {
        this.awU = i;
    }

    public void setTitleMaxLines(int i) {
        this.awV = i;
    }

    public void setAllowGreyState(boolean z) {
        this.awY = z;
    }

    public void bl(boolean z) {
        this.awZ = z;
    }
}
