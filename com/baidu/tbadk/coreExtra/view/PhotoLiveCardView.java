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
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int apD;
    private a awJ;
    private b awK;
    private boolean awL;
    private boolean awM;
    private boolean awN;
    private boolean awO;
    private boolean awP;
    private boolean awQ;
    private boolean awR;
    private boolean awS;
    private boolean awT;
    private boolean awU;
    private boolean awV;
    private boolean awW;
    private LinearLayout awX;
    private View awY;
    private HeadImageView awZ;
    private int axA;
    private int axB;
    private boolean axC;
    private boolean axD;
    private boolean axE;
    private boolean axF;
    private int axG;
    private int axH;
    private int axI;
    private int axJ;
    private int axK;
    private int axL;
    private int axM;
    private int axN;
    private int axO;
    private int axP;
    private int axQ;
    private int axR;
    private int axS;
    private int axT;
    private int axU;
    private String axV;
    private FrameLayout axa;
    private LinearLayout axb;
    private TextView axc;
    private TextView axd;
    private TextView axe;
    private TextView axf;
    private TextView axg;
    private TextView axh;
    private LinearLayout axi;
    private TextView axj;
    private TextView axk;
    private TextView axl;
    private LinearLayout axm;
    private TextView axn;
    private RelativeLayout axo;
    private TbImageView axp;
    private TextView axq;
    private TextView axr;
    private TextView axs;
    private RelativeLayout axt;
    private TextView axu;
    private TextView axv;
    private TextView axw;
    private TextView axx;
    private int axy;
    private ArrayList<Integer> axz;
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
        this.awL = true;
        this.awM = true;
        this.awN = true;
        this.awO = true;
        this.awP = true;
        this.awQ = true;
        this.awR = false;
        this.awS = false;
        this.awT = false;
        this.awU = false;
        this.awV = false;
        this.awW = false;
        this.axy = 0;
        this.axz = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.axA = 0;
        this.axB = 0;
        this.axC = false;
        this.axD = true;
        this.axE = false;
        this.axF = false;
        this.isGod = false;
        this.apD = 3;
        this.padding = 0;
        this.axG = 0;
        this.axH = 0;
        this.axI = 0;
        this.axJ = 0;
        this.axV = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.axH = (int) context.getResources().getDimension(d.e.ds100);
        this.axG = (int) context.getResources().getDimension(d.e.ds70);
        this.axI = (int) context.getResources().getDimension(d.e.ds18);
        this.axJ = (int) context.getResources().getDimension(d.e.ds4);
        this.axK = (int) context.getResources().getDimension(d.e.ds80);
        this.axL = (int) context.getResources().getDimension(d.e.ds280);
        this.axM = (int) context.getResources().getDimension(d.e.ds170);
        this.axN = (int) context.getResources().getDimension(d.e.ds320);
        this.axO = (int) context.getResources().getDimension(d.e.ds200);
        this.axP = (int) context.getResources().getDimension(d.e.ds60);
        this.axQ = (int) context.getResources().getDimension(d.e.ds120);
        this.axR = (int) context.getResources().getDimension(d.e.ds160);
        this.axS = (int) context.getResources().getDimension(d.e.ds220);
        this.axT = (int) context.getResources().getDimension(d.e.ds240);
        this.axU = (int) context.getResources().getDimension(d.e.ds180);
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
        this.awX = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.awY = inflate.findViewById(d.g.author_info);
        this.axi = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.axm = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.axo = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.axt = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        Bo();
        Bp();
        Bq();
        Bs();
        Br();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.awL, photoLiveCardData);
            b(this.awM, this.awR, photoLiveCardData);
            b(this.awN, photoLiveCardData);
            a(this.awO, this.awP, photoLiveCardData);
            a(this.awQ, photoLiveCardData);
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
            if (z && this.axD) {
                if (this.paddingBottom != 0) {
                    this.axo.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axo.setPadding(this.padding, 0, this.padding, 0);
                }
                this.axo.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axo != null) {
                this.axo.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axt.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.awS);
                h(photoLiveCardData.getDiscussNum(), this.awV);
                return;
            }
            this.axt.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axi.setVisibility(0);
                if (this.axB != 0) {
                    this.axj.setMaxLines(this.axB);
                } else {
                    this.axj.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.axj, photoLiveCardData.getThreadId());
                return;
            }
            this.axi.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.awW) {
            this.axl.setVisibility(0);
            this.axl.setTag(photoLiveCardData);
            return;
        }
        this.axl.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axm.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.axm.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axm.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.axn, photoLiveCardData.getThreadId());
                return;
            }
            this.axm.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.axE) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.to(String.valueOf(j))) {
                aj.c(textView, d.C0096d.cp_cont_c, 1);
            } else {
                aj.c(textView, d.C0096d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awY.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.awY.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.awY.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.awZ.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.axH;
                        layoutParams.width = this.axH;
                    }
                    if (this.axx == null) {
                        this.axx = new TextView(this.context);
                        this.axx.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.axx.setEllipsize(TextUtils.TruncateAt.END);
                        this.axx.setTextSize(0, this.axI);
                        aj.i(this.axx, d.C0096d.cp_cont_h);
                        aj.j(this.axx, d.f.icon_shen);
                        this.axx.setSingleLine(true);
                        this.axb.addView(this.axx);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.axx.setText(d.j.god_intro_default);
                    } else {
                        this.axx.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.axb.removeView(this.axx);
                    this.axx = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.axG;
                        layoutParams.width = this.axG;
                    }
                }
                this.awZ.setTag(photoLiveCardData);
                fn(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.axb.removeView(this.axx);
            this.awY.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.awZ.setPadding(this.axJ, this.axJ, this.axJ, this.axJ);
            if (this.isGod) {
                this.axa.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.axa.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.axa.setBackgroundDrawable(null);
        this.awZ.setPadding(0, 0, 0, 0);
    }

    private void Bo() {
        if (this.awY != null) {
            this.awZ = (HeadImageView) this.awY.findViewById(d.g.author_portrait);
            this.axa = (FrameLayout) this.awY.findViewById(d.g.author_portrait_info);
            this.axc = (TextView) this.awY.findViewById(d.g.author_name);
            this.axd = (TextView) this.awY.findViewById(d.g.nick_name);
            this.axe = (TextView) this.awY.findViewById(d.g.fans_num);
            this.axf = (TextView) this.awY.findViewById(d.g.reply_num);
            this.axg = (TextView) this.awY.findViewById(d.g.headlive_icon);
            this.axh = (TextView) this.awY.findViewById(d.g.refresh_time_in_head);
            this.axb = (LinearLayout) this.awY.findViewById(d.g.author_info_and_time);
            this.awZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awK != null) {
                        PhotoLiveCardView.this.awK.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Bp() {
        if (this.axi != null) {
            this.axj = (TextView) this.axi.findViewById(d.g.title);
            this.axk = (TextView) findViewById(d.g.refresh_time_in_title);
            this.axl = (TextView) this.axi.findViewById(d.g.card_delete_in_title);
            this.axl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awJ != null) {
                        PhotoLiveCardView.this.awJ.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bq() {
        if (this.axm != null) {
            this.axn = (TextView) this.axm.findViewById(d.g.content);
        }
    }

    private void Br() {
        if (this.axt != null) {
            this.axu = (TextView) this.axt.findViewById(d.g.ba_name);
            this.axv = (TextView) this.axt.findViewById(d.g.bottom_refresh_time);
            this.axw = (TextView) this.axt.findViewById(d.g.bottom_reply_num);
        }
    }

    private void Bs() {
        if (this.axo != null) {
            this.axp = (TbImageView) this.axo.findViewById(d.g.live_cover);
            this.axp.setGifIconSupport(false);
            Bt();
        }
    }

    private void Bt() {
        if (this.axo != null) {
            this.axq = (TextView) this.axo.findViewById(d.g.first_style_first_expression);
            this.axr = (TextView) this.axo.findViewById(d.g.first_style_second_expression);
            this.axs = (TextView) this.axo.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axz.clear();
        Bv();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bu();
        }
    }

    private void Bu() {
        if (this.axz.size() != 0) {
            int size = this.axz.size();
            for (int i = 0; i < size; i++) {
                if (this.axz.get(i).intValue() == this.axq.getId()) {
                    this.axq.setVisibility(8);
                } else if (this.axz.get(i).intValue() == this.axr.getId()) {
                    this.axr.setVisibility(8);
                } else if (this.axz.get(i).intValue() == this.axs.getId()) {
                    this.axs.setVisibility(8);
                }
            }
        }
    }

    private void Bv() {
        this.axq.setText("");
        this.axr.setText("");
        this.axs.setText("");
        if (this.axq.getVisibility() == 8) {
            this.axq.setVisibility(0);
        }
        if (this.axr.getVisibility() == 8) {
            this.axr.setVisibility(0);
        }
        if (this.axs.getVisibility() == 8) {
            this.axs.setVisibility(0);
        }
        this.axz.add(Integer.valueOf(this.axq.getId()));
        this.axz.add(Integer.valueOf(this.axr.getId()));
        this.axz.add(Integer.valueOf(this.axs.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bh())));
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
            switch (this.axy) {
                case 0:
                    a(this.axK, this.axL, this.axq);
                    a(this.axM, this.axN, this.axr);
                    a(this.axO, this.axP, this.axs);
                    break;
                case 1:
                    a(this.axP, this.axQ, this.axq);
                    a(this.axR, this.axP, this.axr);
                    a(this.axS, this.axN, this.axs);
                    break;
                case 2:
                    a(this.axP, this.axT, this.axq);
                    a(this.axU, this.axP, this.axr);
                    a(this.axS, this.axN, this.axs);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axq);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axr);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axs);
            }
        }
    }

    private void ex(int i) {
        if (this.axz.size() != 0) {
            int size = this.axz.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axz.get(i2).intValue() == i) {
                    this.axz.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.axp.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axp.startLoad(str, 10, false);
        } else {
            this.axp.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axu.setText("");
            return;
        }
        String trim = str.trim();
        this.axu.setVisibility(0);
        if (w.gX(trim) > 12) {
            trim = w.e(trim, 0, 12) + "...";
        }
        this.axu.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axn.setText("");
            this.axn.setVisibility(8);
            return;
        }
        this.axn.setVisibility(0);
        this.axn.setText(str);
    }

    private void setTitle(String str) {
        this.axV = str;
        if (this.axA != 0) {
            this.axj.setPadding(0, 0, (int) this.context.getResources().getDimension(this.axA), 0);
            this.axA = 0;
        } else {
            this.axj.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.axj.setText("");
            return;
        }
        this.axj.setVisibility(0);
        if (this.axC) {
            if (this.axF) {
                this.axj.setText(k.c(this.context, str, d.j.photo_live_tips));
                return;
            } else {
                this.axj.setText(e(str));
                return;
            }
        }
        this.axj.setText(str);
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

    private void fn(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.awZ.startLoad(str, 12, false);
        } else {
            this.awZ.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axc.setText("");
            return;
        }
        this.axc.setVisibility(0);
        String trim = str.trim();
        if (w.gX(trim) > 14) {
            trim = w.e(trim, 0, 14) + "...";
        }
        this.axc.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.axd, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.axd, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.axe.setText(am.y(i));
    }

    private void setReplyNum(int i) {
        b(this.axf, i);
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
            this.axw.setVisibility(0);
            b(this.axw, i);
            return;
        }
        this.axw.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.awU) {
            this.axg.setVisibility(0);
            aj.j(this.axg, d.f.label_onthelist);
            return;
        }
        this.axg.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.awT) {
            this.axh.setVisibility(0);
            this.axh.setText(str);
            return;
        }
        this.axh.setVisibility(8);
        this.axh.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.axk.setVisibility(8);
            return;
        }
        this.axk.setVisibility(0);
        this.axk.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.axv.setVisibility(8);
            return;
        }
        this.axv.setVisibility(0);
        this.axv.setText(str);
    }

    public void setShowHead(boolean z) {
        this.awL = z;
    }

    public void setShowTitle(boolean z) {
        this.awM = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.awR = z;
    }

    public void setShowContent(boolean z) {
        this.awN = z;
    }

    public void setShowCover(boolean z) {
        this.awO = z;
    }

    public void setShowExpression(boolean z) {
        this.awP = z;
    }

    public void setShowBottom(boolean z) {
        this.awQ = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.awT = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.awU = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.awV = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.awW = z;
    }

    public void setChooseStyle(int i) {
        this.axy = i;
    }

    public int getShowStyle() {
        return this.axy;
    }

    public void setShowLiveIcon(boolean z) {
        this.axC = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.awJ = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.awK = bVar;
    }

    public void setParentBackground(int i) {
        aj.j(this.awX, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.axD = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.awS = z;
    }

    public void setTitlePaddingRight(int i) {
        this.axA = i;
    }

    public void setTitleMaxLines(int i) {
        this.axB = i;
    }

    public void setAllowGreyState(boolean z) {
        this.axE = z;
    }

    public void bm(boolean z) {
        this.axF = z;
    }
}
