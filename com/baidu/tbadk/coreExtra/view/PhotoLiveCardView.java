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
    public int apS;
    private a awD;
    private b awE;
    private boolean awF;
    private boolean awG;
    private boolean awH;
    private boolean awI;
    private boolean awJ;
    private boolean awK;
    private boolean awL;
    private boolean awM;
    private boolean awN;
    private boolean awO;
    private boolean awP;
    private boolean awQ;
    private LinearLayout awR;
    private View awS;
    private HeadImageView awT;
    private FrameLayout awU;
    private LinearLayout awV;
    private TextView awW;
    private TextView awX;
    private TextView awY;
    private TextView awZ;
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
    private int axM;
    private int axN;
    private int axO;
    private String axP;
    private TextView axa;
    private TextView axb;
    private LinearLayout axc;
    private TextView axd;
    private TextView axe;
    private TextView axf;
    private LinearLayout axg;
    private TextView axh;
    private RelativeLayout axi;
    private TbImageView axj;
    private TextView axk;
    private TextView axl;
    private TextView axm;
    private RelativeLayout axn;
    private TextView axo;
    private TextView axp;
    private TextView axq;
    private TextView axr;
    private int axs;
    private ArrayList<Integer> axt;
    private int axu;
    private int axv;
    private boolean axw;
    private boolean axx;
    private boolean axy;
    private boolean axz;
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
        this.awF = true;
        this.awG = true;
        this.awH = true;
        this.awI = true;
        this.awJ = true;
        this.awK = true;
        this.awL = false;
        this.awM = false;
        this.awN = false;
        this.awO = false;
        this.awP = false;
        this.awQ = false;
        this.axs = 0;
        this.axt = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.axu = 0;
        this.axv = 0;
        this.axw = false;
        this.axx = true;
        this.axy = false;
        this.axz = false;
        this.isGod = false;
        this.apS = 3;
        this.padding = 0;
        this.axA = 0;
        this.axB = 0;
        this.axC = 0;
        this.axD = 0;
        this.axP = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.f.ds24);
        this.axB = (int) context.getResources().getDimension(d.f.ds100);
        this.axA = (int) context.getResources().getDimension(d.f.ds70);
        this.axC = (int) context.getResources().getDimension(d.f.ds18);
        this.axD = (int) context.getResources().getDimension(d.f.ds4);
        this.axE = (int) context.getResources().getDimension(d.f.ds80);
        this.axF = (int) context.getResources().getDimension(d.f.ds280);
        this.axG = (int) context.getResources().getDimension(d.f.ds170);
        this.axH = (int) context.getResources().getDimension(d.f.ds320);
        this.axI = (int) context.getResources().getDimension(d.f.ds200);
        this.axJ = (int) context.getResources().getDimension(d.f.ds60);
        this.axK = (int) context.getResources().getDimension(d.f.ds120);
        this.axL = (int) context.getResources().getDimension(d.f.ds160);
        this.axM = (int) context.getResources().getDimension(d.f.ds220);
        this.axN = (int) context.getResources().getDimension(d.f.ds240);
        this.axO = (int) context.getResources().getDimension(d.f.ds180);
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
        this.awR = (LinearLayout) inflate.findViewById(d.h.pl_card_root);
        this.awS = inflate.findViewById(d.h.author_info);
        this.axc = (LinearLayout) inflate.findViewById(d.h.photo_live_card_title);
        this.axg = (LinearLayout) inflate.findViewById(d.h.photo_live_card_content);
        this.axi = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_cover_and_expression);
        this.axn = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_bottom);
        Bq();
        Br();
        Bs();
        Bu();
        Bt();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.awF, photoLiveCardData);
            b(this.awG, this.awL, photoLiveCardData);
            b(this.awH, photoLiveCardData);
            a(this.awI, this.awJ, photoLiveCardData);
            a(this.awK, photoLiveCardData);
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
            if (z && this.axx) {
                if (this.paddingBottom != 0) {
                    this.axi.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axi.setPadding(this.padding, 0, this.padding, 0);
                }
                this.axi.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axi != null) {
                this.axi.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axn.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.awM);
                h(photoLiveCardData.getDiscussNum(), this.awP);
                return;
            }
            this.axn.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axc.setVisibility(0);
                if (this.axv != 0) {
                    this.axd.setMaxLines(this.axv);
                } else {
                    this.axd.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.axd, photoLiveCardData.getThreadId());
                return;
            }
            this.axc.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.awQ) {
            this.axf.setVisibility(0);
            this.axf.setTag(photoLiveCardData);
            return;
        }
        this.axf.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axg.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.axg.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axg.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.axh, photoLiveCardData.getThreadId());
                return;
            }
            this.axg.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.axy) {
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sn(String.valueOf(j))) {
                aj.c(textView, d.e.cp_cont_c, 1);
            } else {
                aj.c(textView, d.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awS.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.awS.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.awS.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.awT.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.axB;
                        layoutParams.width = this.axB;
                    }
                    if (this.axr == null) {
                        this.axr = new TextView(this.context);
                        this.axr.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.axr.setEllipsize(TextUtils.TruncateAt.END);
                        this.axr.setTextSize(0, this.axC);
                        aj.i(this.axr, d.e.cp_cont_h);
                        aj.j(this.axr, d.g.icon_shen);
                        this.axr.setSingleLine(true);
                        this.awV.addView(this.axr);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.axr.setText(d.l.god_intro_default);
                    } else {
                        this.axr.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.awV.removeView(this.axr);
                    this.axr = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.axA;
                        layoutParams.width = this.axA;
                    }
                }
                this.awT.setTag(photoLiveCardData);
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
            this.awV.removeView(this.axr);
            this.awS.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.awT.setPadding(this.axD, this.axD, this.axD, this.axD);
            if (this.isGod) {
                this.awU.setBackgroundDrawable(aj.getDrawable(d.g.pic_bg_jinbian));
                return;
            } else {
                this.awU.setBackgroundDrawable(aj.getDrawable(d.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.awU.setBackgroundDrawable(null);
        this.awT.setPadding(0, 0, 0, 0);
    }

    private void Bq() {
        if (this.awS != null) {
            this.awT = (HeadImageView) this.awS.findViewById(d.h.author_portrait);
            this.awU = (FrameLayout) this.awS.findViewById(d.h.author_portrait_info);
            this.awW = (TextView) this.awS.findViewById(d.h.author_name);
            this.awX = (TextView) this.awS.findViewById(d.h.nick_name);
            this.awY = (TextView) this.awS.findViewById(d.h.fans_num);
            this.awZ = (TextView) this.awS.findViewById(d.h.reply_num);
            this.axa = (TextView) this.awS.findViewById(d.h.headlive_icon);
            this.axb = (TextView) this.awS.findViewById(d.h.refresh_time_in_head);
            this.awV = (LinearLayout) this.awS.findViewById(d.h.author_info_and_time);
            this.awT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awE != null) {
                        PhotoLiveCardView.this.awE.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Br() {
        if (this.axc != null) {
            this.axd = (TextView) this.axc.findViewById(d.h.title);
            this.axe = (TextView) findViewById(d.h.refresh_time_in_title);
            this.axf = (TextView) this.axc.findViewById(d.h.card_delete_in_title);
            this.axf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awD != null) {
                        PhotoLiveCardView.this.awD.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bs() {
        if (this.axg != null) {
            this.axh = (TextView) this.axg.findViewById(d.h.content);
        }
    }

    private void Bt() {
        if (this.axn != null) {
            this.axo = (TextView) this.axn.findViewById(d.h.ba_name);
            this.axp = (TextView) this.axn.findViewById(d.h.bottom_refresh_time);
            this.axq = (TextView) this.axn.findViewById(d.h.bottom_reply_num);
        }
    }

    private void Bu() {
        if (this.axi != null) {
            this.axj = (TbImageView) this.axi.findViewById(d.h.live_cover);
            this.axj.setGifIconSupport(false);
            Bv();
        }
    }

    private void Bv() {
        if (this.axi != null) {
            this.axk = (TextView) this.axi.findViewById(d.h.first_style_first_expression);
            this.axl = (TextView) this.axi.findViewById(d.h.first_style_second_expression);
            this.axm = (TextView) this.axi.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axt.clear();
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
        if (this.axt.size() != 0) {
            int size = this.axt.size();
            for (int i = 0; i < size; i++) {
                if (this.axt.get(i).intValue() == this.axk.getId()) {
                    this.axk.setVisibility(8);
                } else if (this.axt.get(i).intValue() == this.axl.getId()) {
                    this.axl.setVisibility(8);
                } else if (this.axt.get(i).intValue() == this.axm.getId()) {
                    this.axm.setVisibility(8);
                }
            }
        }
    }

    private void Bx() {
        this.axk.setText("");
        this.axl.setText("");
        this.axm.setText("");
        if (this.axk.getVisibility() == 8) {
            this.axk.setVisibility(0);
        }
        if (this.axl.getVisibility() == 8) {
            this.axl.setVisibility(0);
        }
        if (this.axm.getVisibility() == 8) {
            this.axm.setVisibility(0);
        }
        this.axt.add(Integer.valueOf(this.axk.getId()));
        this.axt.add(Integer.valueOf(this.axl.getId()));
        this.axt.add(Integer.valueOf(this.axm.getId()));
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
            switch (this.axs) {
                case 0:
                    a(this.axE, this.axF, this.axk);
                    a(this.axG, this.axH, this.axl);
                    a(this.axI, this.axJ, this.axm);
                    break;
                case 1:
                    a(this.axJ, this.axK, this.axk);
                    a(this.axL, this.axJ, this.axl);
                    a(this.axM, this.axH, this.axm);
                    break;
                case 2:
                    a(this.axJ, this.axN, this.axk);
                    a(this.axO, this.axJ, this.axl);
                    a(this.axM, this.axH, this.axm);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axk);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axl);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axm);
            }
        }
    }

    private void em(int i) {
        if (this.axt.size() != 0) {
            int size = this.axt.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axt.get(i2).intValue() == i) {
                    this.axt.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.axj.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axj.c(str, 10, false);
        } else {
            this.axj.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axo.setText("");
            return;
        }
        String trim = str.trim();
        this.axo.setVisibility(0);
        if (v.gS(trim) > 12) {
            trim = v.e(trim, 0, 12) + "...";
        }
        this.axo.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.l.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axh.setText("");
            this.axh.setVisibility(8);
            return;
        }
        this.axh.setVisibility(0);
        this.axh.setText(str);
    }

    private void setTitle(String str) {
        this.axP = str;
        if (this.axu != 0) {
            this.axd.setPadding(0, 0, (int) this.context.getResources().getDimension(this.axu), 0);
            this.axu = 0;
        } else {
            this.axd.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.axd.setText("");
            return;
        }
        this.axd.setVisibility(0);
        if (this.axw) {
            if (this.axz) {
                this.axd.setText(m.c(this.context, str, d.l.photo_live_tips));
                return;
            } else {
                this.axd.setText(e(str));
                return;
            }
        }
        this.axd.setText(str);
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
            this.awT.c(str, 12, false);
        } else {
            this.awT.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awW.setText("");
            return;
        }
        this.awW.setVisibility(0);
        String trim = str.trim();
        if (v.gS(trim) > 14) {
            trim = v.e(trim, 0, 14) + "...";
        }
        this.awW.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.awX, this.context.getResources().getString(d.l.fans_default_name));
        } else {
            a(this.awX, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.awY.setText(am.y(i));
    }

    private void setReplyNum(int i) {
        b(this.awZ, i);
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
            this.axq.setVisibility(0);
            b(this.axq, i);
            return;
        }
        this.axq.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.awO) {
            this.axa.setVisibility(0);
            aj.j(this.axa, d.g.label_onthelist);
            return;
        }
        this.axa.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.awN) {
            this.axb.setVisibility(0);
            this.axb.setText(str);
            return;
        }
        this.axb.setVisibility(8);
        this.axb.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.axe.setVisibility(8);
            return;
        }
        this.axe.setVisibility(0);
        this.axe.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.axp.setVisibility(8);
            return;
        }
        this.axp.setVisibility(0);
        this.axp.setText(str);
    }

    public void setShowHead(boolean z) {
        this.awF = z;
    }

    public void setShowTitle(boolean z) {
        this.awG = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.awL = z;
    }

    public void setShowContent(boolean z) {
        this.awH = z;
    }

    public void setShowCover(boolean z) {
        this.awI = z;
    }

    public void setShowExpression(boolean z) {
        this.awJ = z;
    }

    public void setShowBottom(boolean z) {
        this.awK = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.awN = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.awO = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.awP = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.awQ = z;
    }

    public void setChooseStyle(int i) {
        this.axs = i;
    }

    public int getShowStyle() {
        return this.axs;
    }

    public void setShowLiveIcon(boolean z) {
        this.axw = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.awD = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.awE = bVar;
    }

    public void setParentBackground(int i) {
        aj.j(this.awR, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.axx = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.awM = z;
    }

    public void setTitlePaddingRight(int i) {
        this.axu = i;
    }

    public void setTitleMaxLines(int i) {
        this.axv = i;
    }

    public void setAllowGreyState(boolean z) {
        this.axy = z;
    }

    public void bo(boolean z) {
        this.axz = z;
    }
}
