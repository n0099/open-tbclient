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
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int apQ;
    private a awA;
    private b awB;
    private boolean awC;
    private boolean awD;
    private boolean awE;
    private boolean awF;
    private boolean awG;
    private boolean awH;
    private boolean awI;
    private boolean awJ;
    private boolean awK;
    private boolean awL;
    private boolean awM;
    private boolean awN;
    private LinearLayout awO;
    private View awP;
    private HeadImageView awQ;
    private FrameLayout awR;
    private LinearLayout awS;
    private TextView awT;
    private TextView awU;
    private TextView awV;
    private TextView awW;
    private TextView awX;
    private TextView awY;
    private LinearLayout awZ;
    private int axA;
    private int axB;
    private int axC;
    private int axD;
    private int axE;
    private int axF;
    private int axG;
    private int axH;
    private int axI;
    private int axJ;
    private int axK;
    private int axL;
    private String axM;
    private TextView axa;
    private TextView axb;
    private TextView axc;
    private LinearLayout axd;
    private TextView axe;
    private RelativeLayout axf;
    private TbImageView axg;
    private TextView axh;
    private TextView axi;
    private TextView axj;
    private RelativeLayout axk;
    private TextView axl;
    private TextView axm;
    private TextView axn;
    private TextView axo;
    private int axp;
    private ArrayList<Integer> axq;
    private int axr;
    private int axs;
    private boolean axt;
    private boolean axu;
    private boolean axv;
    private boolean axw;
    private int axx;
    private int axy;
    private int axz;
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
        this.awC = true;
        this.awD = true;
        this.awE = true;
        this.awF = true;
        this.awG = true;
        this.awH = true;
        this.awI = false;
        this.awJ = false;
        this.awK = false;
        this.awL = false;
        this.awM = false;
        this.awN = false;
        this.axp = 0;
        this.axq = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.axr = 0;
        this.axs = 0;
        this.axt = false;
        this.axu = true;
        this.axv = false;
        this.axw = false;
        this.isGod = false;
        this.apQ = 3;
        this.padding = 0;
        this.axx = 0;
        this.axy = 0;
        this.axz = 0;
        this.axA = 0;
        this.axM = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.f.ds24);
        this.axy = (int) context.getResources().getDimension(d.f.ds100);
        this.axx = (int) context.getResources().getDimension(d.f.ds70);
        this.axz = (int) context.getResources().getDimension(d.f.ds18);
        this.axA = (int) context.getResources().getDimension(d.f.ds4);
        this.axB = (int) context.getResources().getDimension(d.f.ds80);
        this.axC = (int) context.getResources().getDimension(d.f.ds280);
        this.axD = (int) context.getResources().getDimension(d.f.ds170);
        this.axE = (int) context.getResources().getDimension(d.f.ds320);
        this.axF = (int) context.getResources().getDimension(d.f.ds200);
        this.axG = (int) context.getResources().getDimension(d.f.ds60);
        this.axH = (int) context.getResources().getDimension(d.f.ds120);
        this.axI = (int) context.getResources().getDimension(d.f.ds160);
        this.axJ = (int) context.getResources().getDimension(d.f.ds220);
        this.axK = (int) context.getResources().getDimension(d.f.ds240);
        this.axL = (int) context.getResources().getDimension(d.f.ds180);
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
        this.awO = (LinearLayout) inflate.findViewById(d.h.pl_card_root);
        this.awP = inflate.findViewById(d.h.author_info);
        this.awZ = (LinearLayout) inflate.findViewById(d.h.photo_live_card_title);
        this.axd = (LinearLayout) inflate.findViewById(d.h.photo_live_card_content);
        this.axf = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_cover_and_expression);
        this.axk = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_bottom);
        Bq();
        Br();
        Bs();
        Bu();
        Bt();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.awC, photoLiveCardData);
            b(this.awD, this.awI, photoLiveCardData);
            b(this.awE, photoLiveCardData);
            a(this.awF, this.awG, photoLiveCardData);
            a(this.awH, photoLiveCardData);
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
            if (z && this.axu) {
                if (this.paddingBottom != 0) {
                    this.axf.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axf.setPadding(this.padding, 0, this.padding, 0);
                }
                this.axf.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axf != null) {
                this.axf.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axk.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.awJ);
                h(photoLiveCardData.getDiscussNum(), this.awM);
                return;
            }
            this.axk.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awZ.setVisibility(0);
                if (this.axs != 0) {
                    this.axa.setMaxLines(this.axs);
                } else {
                    this.axa.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.axa, photoLiveCardData.getThreadId());
                return;
            }
            this.awZ.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.awN) {
            this.axc.setVisibility(0);
            this.axc.setTag(photoLiveCardData);
            return;
        }
        this.axc.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axd.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.axd.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axd.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.axe, photoLiveCardData.getThreadId());
                return;
            }
            this.axd.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.axv) {
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sp(String.valueOf(j))) {
                aj.c(textView, d.e.cp_cont_c, 1);
            } else {
                aj.c(textView, d.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awP.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.awP.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.awP.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.awQ.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.axy;
                        layoutParams.width = this.axy;
                    }
                    if (this.axo == null) {
                        this.axo = new TextView(this.context);
                        this.axo.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.axo.setEllipsize(TextUtils.TruncateAt.END);
                        this.axo.setTextSize(0, this.axz);
                        aj.i(this.axo, d.e.cp_cont_h);
                        aj.j(this.axo, d.g.icon_shen);
                        this.axo.setSingleLine(true);
                        this.awS.addView(this.axo);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.axo.setText(d.l.god_intro_default);
                    } else {
                        this.axo.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.awS.removeView(this.axo);
                    this.axo = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.axx;
                        layoutParams.width = this.axx;
                    }
                }
                this.awQ.setTag(photoLiveCardData);
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
            this.awS.removeView(this.axo);
            this.awP.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.awQ.setPadding(this.axA, this.axA, this.axA, this.axA);
            if (this.isGod) {
                this.awR.setBackgroundDrawable(aj.getDrawable(d.g.pic_bg_jinbian));
                return;
            } else {
                this.awR.setBackgroundDrawable(aj.getDrawable(d.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.awR.setBackgroundDrawable(null);
        this.awQ.setPadding(0, 0, 0, 0);
    }

    private void Bq() {
        if (this.awP != null) {
            this.awQ = (HeadImageView) this.awP.findViewById(d.h.author_portrait);
            this.awR = (FrameLayout) this.awP.findViewById(d.h.author_portrait_info);
            this.awT = (TextView) this.awP.findViewById(d.h.author_name);
            this.awU = (TextView) this.awP.findViewById(d.h.nick_name);
            this.awV = (TextView) this.awP.findViewById(d.h.fans_num);
            this.awW = (TextView) this.awP.findViewById(d.h.reply_num);
            this.awX = (TextView) this.awP.findViewById(d.h.headlive_icon);
            this.awY = (TextView) this.awP.findViewById(d.h.refresh_time_in_head);
            this.awS = (LinearLayout) this.awP.findViewById(d.h.author_info_and_time);
            this.awQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awB != null) {
                        PhotoLiveCardView.this.awB.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Br() {
        if (this.awZ != null) {
            this.axa = (TextView) this.awZ.findViewById(d.h.title);
            this.axb = (TextView) findViewById(d.h.refresh_time_in_title);
            this.axc = (TextView) this.awZ.findViewById(d.h.card_delete_in_title);
            this.axc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awA != null) {
                        PhotoLiveCardView.this.awA.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bs() {
        if (this.axd != null) {
            this.axe = (TextView) this.axd.findViewById(d.h.content);
        }
    }

    private void Bt() {
        if (this.axk != null) {
            this.axl = (TextView) this.axk.findViewById(d.h.ba_name);
            this.axm = (TextView) this.axk.findViewById(d.h.bottom_refresh_time);
            this.axn = (TextView) this.axk.findViewById(d.h.bottom_reply_num);
        }
    }

    private void Bu() {
        if (this.axf != null) {
            this.axg = (TbImageView) this.axf.findViewById(d.h.live_cover);
            this.axg.setGifIconSupport(false);
            Bv();
        }
    }

    private void Bv() {
        if (this.axf != null) {
            this.axh = (TextView) this.axf.findViewById(d.h.first_style_first_expression);
            this.axi = (TextView) this.axf.findViewById(d.h.first_style_second_expression);
            this.axj = (TextView) this.axf.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axq.clear();
        Bx();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bw();
        }
    }

    private void Bw() {
        if (this.axq.size() != 0) {
            int size = this.axq.size();
            for (int i = 0; i < size; i++) {
                if (this.axq.get(i).intValue() == this.axh.getId()) {
                    this.axh.setVisibility(8);
                } else if (this.axq.get(i).intValue() == this.axi.getId()) {
                    this.axi.setVisibility(8);
                } else if (this.axq.get(i).intValue() == this.axj.getId()) {
                    this.axj.setVisibility(8);
                }
            }
        }
    }

    private void Bx() {
        this.axh.setText("");
        this.axi.setText("");
        this.axj.setText("");
        if (this.axh.getVisibility() == 8) {
            this.axh.setVisibility(0);
        }
        if (this.axi.getVisibility() == 8) {
            this.axi.setVisibility(0);
        }
        if (this.axj.getVisibility() == 8) {
            this.axj.setVisibility(0);
        }
        this.axq.add(Integer.valueOf(this.axh.getId()));
        this.axq.add(Integer.valueOf(this.axi.getId()));
        this.axq.add(Integer.valueOf(this.axj.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bj())));
            em(textView.getId());
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
            switch (this.axp) {
                case 0:
                    a(this.axB, this.axC, this.axh);
                    a(this.axD, this.axE, this.axi);
                    a(this.axF, this.axG, this.axj);
                    break;
                case 1:
                    a(this.axG, this.axH, this.axh);
                    a(this.axI, this.axG, this.axi);
                    a(this.axJ, this.axE, this.axj);
                    break;
                case 2:
                    a(this.axG, this.axK, this.axh);
                    a(this.axL, this.axG, this.axi);
                    a(this.axJ, this.axE, this.axj);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axh);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axi);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axj);
            }
        }
    }

    private void em(int i) {
        if (this.axq.size() != 0) {
            int size = this.axq.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axq.get(i2).intValue() == i) {
                    this.axq.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.axg.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axg.c(str, 10, false);
        } else {
            this.axg.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axl.setText("");
            return;
        }
        String trim = str.trim();
        this.axl.setVisibility(0);
        if (v.gS(trim) > 12) {
            trim = v.e(trim, 0, 12) + "...";
        }
        this.axl.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.l.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axe.setText("");
            this.axe.setVisibility(8);
            return;
        }
        this.axe.setVisibility(0);
        this.axe.setText(str);
    }

    private void setTitle(String str) {
        this.axM = str;
        if (this.axr != 0) {
            this.axa.setPadding(0, 0, (int) this.context.getResources().getDimension(this.axr), 0);
            this.axr = 0;
        } else {
            this.axa.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.axa.setText("");
            return;
        }
        this.axa.setVisibility(0);
        if (this.axt) {
            if (this.axw) {
                this.axa.setText(m.c(this.context, str, d.l.photo_live_tips));
                return;
            } else {
                this.axa.setText(e(str));
                return;
            }
        }
        this.axa.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap cT = aj.cT(d.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
        int height = cT.getHeight();
        bitmapDrawable.setBounds(0, 0, cT.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fi(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.awQ.c(str, 12, false);
        } else {
            this.awQ.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awT.setText("");
            return;
        }
        this.awT.setVisibility(0);
        String trim = str.trim();
        if (v.gS(trim) > 14) {
            trim = v.e(trim, 0, 14) + "...";
        }
        this.awT.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.awU, this.context.getResources().getString(d.l.fans_default_name));
        } else {
            a(this.awU, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.awV.setText(am.y(i));
    }

    private void setReplyNum(int i) {
        b(this.awW, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(am.y(j));
        Drawable drawable = aj.getDrawable(d.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void h(int i, boolean z) {
        if (z) {
            this.axn.setVisibility(0);
            b(this.axn, i);
            return;
        }
        this.axn.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.awL) {
            this.awX.setVisibility(0);
            aj.j(this.awX, d.g.label_onthelist);
            return;
        }
        this.awX.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.awK) {
            this.awY.setVisibility(0);
            this.awY.setText(str);
            return;
        }
        this.awY.setVisibility(8);
        this.awY.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.axb.setVisibility(8);
            return;
        }
        this.axb.setVisibility(0);
        this.axb.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.axm.setVisibility(8);
            return;
        }
        this.axm.setVisibility(0);
        this.axm.setText(str);
    }

    public void setShowHead(boolean z) {
        this.awC = z;
    }

    public void setShowTitle(boolean z) {
        this.awD = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.awI = z;
    }

    public void setShowContent(boolean z) {
        this.awE = z;
    }

    public void setShowCover(boolean z) {
        this.awF = z;
    }

    public void setShowExpression(boolean z) {
        this.awG = z;
    }

    public void setShowBottom(boolean z) {
        this.awH = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.awK = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.awL = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.awM = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.awN = z;
    }

    public void setChooseStyle(int i) {
        this.axp = i;
    }

    public int getShowStyle() {
        return this.axp;
    }

    public void setShowLiveIcon(boolean z) {
        this.axt = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.awA = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.awB = bVar;
    }

    public void setParentBackground(int i) {
        aj.j(this.awO, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.axu = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.awJ = z;
    }

    public void setTitlePaddingRight(int i) {
        this.axr = i;
    }

    public void setTitleMaxLines(int i) {
        this.axs = i;
    }

    public void setAllowGreyState(boolean z) {
        this.axv = z;
    }

    public void bo(boolean z) {
        this.axw = z;
    }
}
