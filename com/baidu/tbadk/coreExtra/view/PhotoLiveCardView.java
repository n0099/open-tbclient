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
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aoZ;
    private a avK;
    private b avL;
    private boolean avM;
    private boolean avN;
    private boolean avO;
    private boolean avP;
    private boolean avQ;
    private boolean avR;
    private boolean avS;
    private boolean avT;
    private boolean avU;
    private boolean avV;
    private boolean avW;
    private boolean avX;
    private LinearLayout avY;
    private View avZ;
    private ArrayList<Integer> awA;
    private int awB;
    private int awC;
    private boolean awD;
    private boolean awE;
    private boolean awF;
    private boolean awG;
    private int awH;
    private int awI;
    private int awJ;
    private int awK;
    private int awL;
    private int awM;
    private int awN;
    private int awO;
    private int awP;
    private int awQ;
    private int awR;
    private int awS;
    private int awT;
    private int awU;
    private int awV;
    private String awW;
    private HeadImageView awa;
    private FrameLayout awb;
    private LinearLayout awc;
    private TextView awd;
    private TextView awe;
    private TextView awf;
    private TextView awg;
    private TextView awh;
    private TextView awi;
    private LinearLayout awj;
    private TextView awk;
    private TextView awl;
    private TextView awm;
    private LinearLayout awn;
    private TextView awo;
    private RelativeLayout awp;
    private TbImageView awq;
    private TextView awr;
    private TextView aws;
    private TextView awt;
    private RelativeLayout awu;
    private TextView awv;
    private TextView aww;
    private TextView awx;
    private TextView awy;
    private int awz;
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
        this.avM = true;
        this.avN = true;
        this.avO = true;
        this.avP = true;
        this.avQ = true;
        this.avR = true;
        this.avS = false;
        this.avT = false;
        this.avU = false;
        this.avV = false;
        this.avW = false;
        this.avX = false;
        this.awz = 0;
        this.awA = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.awB = 0;
        this.awC = 0;
        this.awD = false;
        this.awE = true;
        this.awF = false;
        this.awG = false;
        this.isGod = false;
        this.aoZ = 3;
        this.padding = 0;
        this.awH = 0;
        this.awI = 0;
        this.awJ = 0;
        this.awK = 0;
        this.awW = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.f.ds24);
        this.awI = (int) context.getResources().getDimension(d.f.ds100);
        this.awH = (int) context.getResources().getDimension(d.f.ds70);
        this.awJ = (int) context.getResources().getDimension(d.f.ds18);
        this.awK = (int) context.getResources().getDimension(d.f.ds4);
        this.awL = (int) context.getResources().getDimension(d.f.ds80);
        this.awM = (int) context.getResources().getDimension(d.f.ds280);
        this.awN = (int) context.getResources().getDimension(d.f.ds170);
        this.awO = (int) context.getResources().getDimension(d.f.ds320);
        this.awP = (int) context.getResources().getDimension(d.f.ds200);
        this.awQ = (int) context.getResources().getDimension(d.f.ds60);
        this.awR = (int) context.getResources().getDimension(d.f.ds120);
        this.awS = (int) context.getResources().getDimension(d.f.ds160);
        this.awT = (int) context.getResources().getDimension(d.f.ds220);
        this.awU = (int) context.getResources().getDimension(d.f.ds240);
        this.awV = (int) context.getResources().getDimension(d.f.ds180);
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
        this.avY = (LinearLayout) inflate.findViewById(d.h.pl_card_root);
        this.avZ = inflate.findViewById(d.h.author_info);
        this.awj = (LinearLayout) inflate.findViewById(d.h.photo_live_card_title);
        this.awn = (LinearLayout) inflate.findViewById(d.h.photo_live_card_content);
        this.awp = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_cover_and_expression);
        this.awu = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_bottom);
        AO();
        AP();
        AQ();
        AS();
        AR();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.avM, photoLiveCardData);
            b(this.avN, this.avS, photoLiveCardData);
            b(this.avO, photoLiveCardData);
            a(this.avP, this.avQ, photoLiveCardData);
            a(this.avR, photoLiveCardData);
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
            if (z && this.awE) {
                if (this.paddingBottom != 0) {
                    this.awp.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awp.setPadding(this.padding, 0, this.padding, 0);
                }
                this.awp.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awp != null) {
                this.awp.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awu.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.avT);
                h(photoLiveCardData.getDiscussNum(), this.avW);
                return;
            }
            this.awu.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awj.setVisibility(0);
                if (this.awC != 0) {
                    this.awk.setMaxLines(this.awC);
                } else {
                    this.awk.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.awk, photoLiveCardData.getThreadId());
                return;
            }
            this.awj.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.avX) {
            this.awm.setVisibility(0);
            this.awm.setTag(photoLiveCardData);
            return;
        }
        this.awm.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awn.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.awn.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awn.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.awo, photoLiveCardData.getThreadId());
                return;
            }
            this.awn.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.awF) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rZ(String.valueOf(j))) {
                aj.c(textView, d.e.cp_cont_c, 1);
            } else {
                aj.c(textView, d.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.avZ.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.avZ.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.avZ.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.awa.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.awI;
                        layoutParams.width = this.awI;
                    }
                    if (this.awy == null) {
                        this.awy = new TextView(this.context);
                        this.awy.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.awy.setEllipsize(TextUtils.TruncateAt.END);
                        this.awy.setTextSize(0, this.awJ);
                        aj.i(this.awy, d.e.cp_cont_h);
                        aj.j(this.awy, d.g.icon_shen);
                        this.awy.setSingleLine(true);
                        this.awc.addView(this.awy);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.awy.setText(d.l.god_intro_default);
                    } else {
                        this.awy.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.awc.removeView(this.awy);
                    this.awy = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.awH;
                        layoutParams.width = this.awH;
                    }
                }
                this.awa.setTag(photoLiveCardData);
                fb(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.awc.removeView(this.awy);
            this.avZ.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.awa.setPadding(this.awK, this.awK, this.awK, this.awK);
            if (this.isGod) {
                this.awb.setBackgroundDrawable(aj.getDrawable(d.g.pic_bg_jinbian));
                return;
            } else {
                this.awb.setBackgroundDrawable(aj.getDrawable(d.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.awb.setBackgroundDrawable(null);
        this.awa.setPadding(0, 0, 0, 0);
    }

    private void AO() {
        if (this.avZ != null) {
            this.awa = (HeadImageView) this.avZ.findViewById(d.h.author_portrait);
            this.awb = (FrameLayout) this.avZ.findViewById(d.h.author_portrait_info);
            this.awd = (TextView) this.avZ.findViewById(d.h.author_name);
            this.awe = (TextView) this.avZ.findViewById(d.h.nick_name);
            this.awf = (TextView) this.avZ.findViewById(d.h.fans_num);
            this.awg = (TextView) this.avZ.findViewById(d.h.reply_num);
            this.awh = (TextView) this.avZ.findViewById(d.h.headlive_icon);
            this.awi = (TextView) this.avZ.findViewById(d.h.refresh_time_in_head);
            this.awc = (LinearLayout) this.avZ.findViewById(d.h.author_info_and_time);
            this.awa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.avL != null) {
                        PhotoLiveCardView.this.avL.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void AP() {
        if (this.awj != null) {
            this.awk = (TextView) this.awj.findViewById(d.h.title);
            this.awl = (TextView) findViewById(d.h.refresh_time_in_title);
            this.awm = (TextView) this.awj.findViewById(d.h.card_delete_in_title);
            this.awm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.avK != null) {
                        PhotoLiveCardView.this.avK.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void AQ() {
        if (this.awn != null) {
            this.awo = (TextView) this.awn.findViewById(d.h.content);
        }
    }

    private void AR() {
        if (this.awu != null) {
            this.awv = (TextView) this.awu.findViewById(d.h.ba_name);
            this.aww = (TextView) this.awu.findViewById(d.h.bottom_refresh_time);
            this.awx = (TextView) this.awu.findViewById(d.h.bottom_reply_num);
        }
    }

    private void AS() {
        if (this.awp != null) {
            this.awq = (TbImageView) this.awp.findViewById(d.h.live_cover);
            this.awq.setGifIconSupport(false);
            AT();
        }
    }

    private void AT() {
        if (this.awp != null) {
            this.awr = (TextView) this.awp.findViewById(d.h.first_style_first_expression);
            this.aws = (TextView) this.awp.findViewById(d.h.first_style_second_expression);
            this.awt = (TextView) this.awp.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awA.clear();
        AV();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AU();
        }
    }

    private void AU() {
        if (this.awA.size() != 0) {
            int size = this.awA.size();
            for (int i = 0; i < size; i++) {
                if (this.awA.get(i).intValue() == this.awr.getId()) {
                    this.awr.setVisibility(8);
                } else if (this.awA.get(i).intValue() == this.aws.getId()) {
                    this.aws.setVisibility(8);
                } else if (this.awA.get(i).intValue() == this.awt.getId()) {
                    this.awt.setVisibility(8);
                }
            }
        }
    }

    private void AV() {
        this.awr.setText("");
        this.aws.setText("");
        this.awt.setText("");
        if (this.awr.getVisibility() == 8) {
            this.awr.setVisibility(0);
        }
        if (this.aws.getVisibility() == 8) {
            this.aws.setVisibility(0);
        }
        if (this.awt.getVisibility() == 8) {
            this.awt.setVisibility(0);
        }
        this.awA.add(Integer.valueOf(this.awr.getId()));
        this.awA.add(Integer.valueOf(this.aws.getId()));
        this.awA.add(Integer.valueOf(this.awt.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.am(eVar.getLabelName(), String.valueOf(eVar.AH())));
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
            switch (this.awz) {
                case 0:
                    a(this.awL, this.awM, this.awr);
                    a(this.awN, this.awO, this.aws);
                    a(this.awP, this.awQ, this.awt);
                    break;
                case 1:
                    a(this.awQ, this.awR, this.awr);
                    a(this.awS, this.awQ, this.aws);
                    a(this.awT, this.awO, this.awt);
                    break;
                case 2:
                    a(this.awQ, this.awU, this.awr);
                    a(this.awV, this.awQ, this.aws);
                    a(this.awT, this.awO, this.awt);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awr);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aws);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awt);
            }
        }
    }

    private void ex(int i) {
        if (this.awA.size() != 0) {
            int size = this.awA.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awA.get(i2).intValue() == i) {
                    this.awA.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.awq.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awq.c(str, 10, false);
        } else {
            this.awq.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awv.setText("");
            return;
        }
        String trim = str.trim();
        this.awv.setVisibility(0);
        if (u.gP(trim) > 12) {
            trim = u.e(trim, 0, 12) + "...";
        }
        this.awv.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.l.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awo.setText("");
            this.awo.setVisibility(8);
            return;
        }
        this.awo.setVisibility(0);
        this.awo.setText(str);
    }

    private void setTitle(String str) {
        this.awW = str;
        if (this.awB != 0) {
            this.awk.setPadding(0, 0, (int) this.context.getResources().getDimension(this.awB), 0);
            this.awB = 0;
        } else {
            this.awk.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.awk.setText("");
            return;
        }
        this.awk.setVisibility(0);
        if (this.awD) {
            if (this.awG) {
                this.awk.setText(m.c(this.context, str, d.l.photo_live_tips));
                return;
            } else {
                this.awk.setText(e(str));
                return;
            }
        }
        this.awk.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap cR = aj.cR(d.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
        int height = cR.getHeight();
        bitmapDrawable.setBounds(0, 0, cR.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.awa.c(str, 12, false);
        } else {
            this.awa.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awd.setText("");
            return;
        }
        this.awd.setVisibility(0);
        String trim = str.trim();
        if (u.gP(trim) > 14) {
            trim = u.e(trim, 0, 14) + "...";
        }
        this.awd.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.awe, this.context.getResources().getString(d.l.fans_default_name));
        } else {
            a(this.awe, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.awf.setText(am.x(i));
    }

    private void setReplyNum(int i) {
        b(this.awg, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(am.x(j));
        Drawable drawable = aj.getDrawable(d.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void h(int i, boolean z) {
        if (z) {
            this.awx.setVisibility(0);
            b(this.awx, i);
            return;
        }
        this.awx.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.avV) {
            this.awh.setVisibility(0);
            aj.j(this.awh, d.g.label_onthelist);
            return;
        }
        this.awh.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.avU) {
            this.awi.setVisibility(0);
            this.awi.setText(str);
            return;
        }
        this.awi.setVisibility(8);
        this.awi.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.awl.setVisibility(8);
            return;
        }
        this.awl.setVisibility(0);
        this.awl.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.aww.setVisibility(8);
            return;
        }
        this.aww.setVisibility(0);
        this.aww.setText(str);
    }

    public void setShowHead(boolean z) {
        this.avM = z;
    }

    public void setShowTitle(boolean z) {
        this.avN = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.avS = z;
    }

    public void setShowContent(boolean z) {
        this.avO = z;
    }

    public void setShowCover(boolean z) {
        this.avP = z;
    }

    public void setShowExpression(boolean z) {
        this.avQ = z;
    }

    public void setShowBottom(boolean z) {
        this.avR = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.avU = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.avV = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.avW = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.avX = z;
    }

    public void setChooseStyle(int i) {
        this.awz = i;
    }

    public int getShowStyle() {
        return this.awz;
    }

    public void setShowLiveIcon(boolean z) {
        this.awD = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.avK = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.avL = bVar;
    }

    public void setParentBackground(int i) {
        aj.j(this.avY, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.awE = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.avT = z;
    }

    public void setTitlePaddingRight(int i) {
        this.awB = i;
    }

    public void setTitleMaxLines(int i) {
        this.awC = i;
    }

    public void setAllowGreyState(boolean z) {
        this.awF = z;
    }

    public void bn(boolean z) {
        this.awG = z;
    }
}
