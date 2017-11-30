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
    public int apA;
    private a awE;
    private b awF;
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
    private boolean awR;
    private LinearLayout awS;
    private View awT;
    private HeadImageView awU;
    private FrameLayout awV;
    private LinearLayout awW;
    private TextView awX;
    private TextView awY;
    private TextView awZ;
    private boolean axA;
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
    private int axP;
    private String axQ;
    private TextView axa;
    private TextView axb;
    private TextView axc;
    private LinearLayout axd;
    private TextView axe;
    private TextView axf;
    private TextView axg;
    private LinearLayout axh;
    private TextView axi;
    private RelativeLayout axj;
    private TbImageView axk;
    private TextView axl;
    private TextView axm;
    private TextView axn;
    private RelativeLayout axo;
    private TextView axp;
    private TextView axq;
    private TextView axr;
    private TextView axs;
    private int axt;
    private ArrayList<Integer> axu;
    private int axv;
    private int axw;
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
        this.awG = true;
        this.awH = true;
        this.awI = true;
        this.awJ = true;
        this.awK = true;
        this.awL = true;
        this.awM = false;
        this.awN = false;
        this.awO = false;
        this.awP = false;
        this.awQ = false;
        this.awR = false;
        this.axt = 0;
        this.axu = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.axv = 0;
        this.axw = 0;
        this.axx = false;
        this.axy = true;
        this.axz = false;
        this.axA = false;
        this.isGod = false;
        this.apA = 3;
        this.padding = 0;
        this.axB = 0;
        this.axC = 0;
        this.axD = 0;
        this.axE = 0;
        this.axQ = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.axC = (int) context.getResources().getDimension(d.e.ds100);
        this.axB = (int) context.getResources().getDimension(d.e.ds70);
        this.axD = (int) context.getResources().getDimension(d.e.ds18);
        this.axE = (int) context.getResources().getDimension(d.e.ds4);
        this.axF = (int) context.getResources().getDimension(d.e.ds80);
        this.axG = (int) context.getResources().getDimension(d.e.ds280);
        this.axH = (int) context.getResources().getDimension(d.e.ds170);
        this.axI = (int) context.getResources().getDimension(d.e.ds320);
        this.axJ = (int) context.getResources().getDimension(d.e.ds200);
        this.axK = (int) context.getResources().getDimension(d.e.ds60);
        this.axL = (int) context.getResources().getDimension(d.e.ds120);
        this.axM = (int) context.getResources().getDimension(d.e.ds160);
        this.axN = (int) context.getResources().getDimension(d.e.ds220);
        this.axO = (int) context.getResources().getDimension(d.e.ds240);
        this.axP = (int) context.getResources().getDimension(d.e.ds180);
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
        this.awS = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.awT = inflate.findViewById(d.g.author_info);
        this.axd = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.axh = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.axj = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.axo = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        Bn();
        Bo();
        Bp();
        Br();
        Bq();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.awG, photoLiveCardData);
            b(this.awH, this.awM, photoLiveCardData);
            b(this.awI, photoLiveCardData);
            a(this.awJ, this.awK, photoLiveCardData);
            a(this.awL, photoLiveCardData);
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
            if (z && this.axy) {
                if (this.paddingBottom != 0) {
                    this.axj.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axj.setPadding(this.padding, 0, this.padding, 0);
                }
                this.axj.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axj != null) {
                this.axj.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axo.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.awN);
                h(photoLiveCardData.getDiscussNum(), this.awQ);
                return;
            }
            this.axo.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axd.setVisibility(0);
                if (this.axw != 0) {
                    this.axe.setMaxLines(this.axw);
                } else {
                    this.axe.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.axe, photoLiveCardData.getThreadId());
                return;
            }
            this.axd.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.awR) {
            this.axg.setVisibility(0);
            this.axg.setTag(photoLiveCardData);
            return;
        }
        this.axg.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axh.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.axh.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axh.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.axi, photoLiveCardData.getThreadId());
                return;
            }
            this.axh.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.axz) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tj(String.valueOf(j))) {
                aj.c(textView, d.C0082d.cp_cont_c, 1);
            } else {
                aj.c(textView, d.C0082d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awT.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.awT.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.awT.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.awU.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.axC;
                        layoutParams.width = this.axC;
                    }
                    if (this.axs == null) {
                        this.axs = new TextView(this.context);
                        this.axs.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.axs.setEllipsize(TextUtils.TruncateAt.END);
                        this.axs.setTextSize(0, this.axD);
                        aj.i(this.axs, d.C0082d.cp_cont_h);
                        aj.j(this.axs, d.f.icon_shen);
                        this.axs.setSingleLine(true);
                        this.awW.addView(this.axs);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.axs.setText(d.j.god_intro_default);
                    } else {
                        this.axs.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.awW.removeView(this.axs);
                    this.axs = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.axB;
                        layoutParams.width = this.axB;
                    }
                }
                this.awU.setTag(photoLiveCardData);
                fo(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.awW.removeView(this.axs);
            this.awT.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.awU.setPadding(this.axE, this.axE, this.axE, this.axE);
            if (this.isGod) {
                this.awV.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.awV.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.awV.setBackgroundDrawable(null);
        this.awU.setPadding(0, 0, 0, 0);
    }

    private void Bn() {
        if (this.awT != null) {
            this.awU = (HeadImageView) this.awT.findViewById(d.g.author_portrait);
            this.awV = (FrameLayout) this.awT.findViewById(d.g.author_portrait_info);
            this.awX = (TextView) this.awT.findViewById(d.g.author_name);
            this.awY = (TextView) this.awT.findViewById(d.g.nick_name);
            this.awZ = (TextView) this.awT.findViewById(d.g.fans_num);
            this.axa = (TextView) this.awT.findViewById(d.g.reply_num);
            this.axb = (TextView) this.awT.findViewById(d.g.headlive_icon);
            this.axc = (TextView) this.awT.findViewById(d.g.refresh_time_in_head);
            this.awW = (LinearLayout) this.awT.findViewById(d.g.author_info_and_time);
            this.awU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awF != null) {
                        PhotoLiveCardView.this.awF.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Bo() {
        if (this.axd != null) {
            this.axe = (TextView) this.axd.findViewById(d.g.title);
            this.axf = (TextView) findViewById(d.g.refresh_time_in_title);
            this.axg = (TextView) this.axd.findViewById(d.g.card_delete_in_title);
            this.axg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awE != null) {
                        PhotoLiveCardView.this.awE.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bp() {
        if (this.axh != null) {
            this.axi = (TextView) this.axh.findViewById(d.g.content);
        }
    }

    private void Bq() {
        if (this.axo != null) {
            this.axp = (TextView) this.axo.findViewById(d.g.ba_name);
            this.axq = (TextView) this.axo.findViewById(d.g.bottom_refresh_time);
            this.axr = (TextView) this.axo.findViewById(d.g.bottom_reply_num);
        }
    }

    private void Br() {
        if (this.axj != null) {
            this.axk = (TbImageView) this.axj.findViewById(d.g.live_cover);
            this.axk.setGifIconSupport(false);
            Bs();
        }
    }

    private void Bs() {
        if (this.axj != null) {
            this.axl = (TextView) this.axj.findViewById(d.g.first_style_first_expression);
            this.axm = (TextView) this.axj.findViewById(d.g.first_style_second_expression);
            this.axn = (TextView) this.axj.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axu.clear();
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
        if (this.axu.size() != 0) {
            int size = this.axu.size();
            for (int i = 0; i < size; i++) {
                if (this.axu.get(i).intValue() == this.axl.getId()) {
                    this.axl.setVisibility(8);
                } else if (this.axu.get(i).intValue() == this.axm.getId()) {
                    this.axm.setVisibility(8);
                } else if (this.axu.get(i).intValue() == this.axn.getId()) {
                    this.axn.setVisibility(8);
                }
            }
        }
    }

    private void Bu() {
        this.axl.setText("");
        this.axm.setText("");
        this.axn.setText("");
        if (this.axl.getVisibility() == 8) {
            this.axl.setVisibility(0);
        }
        if (this.axm.getVisibility() == 8) {
            this.axm.setVisibility(0);
        }
        if (this.axn.getVisibility() == 8) {
            this.axn.setVisibility(0);
        }
        this.axu.add(Integer.valueOf(this.axl.getId()));
        this.axu.add(Integer.valueOf(this.axm.getId()));
        this.axu.add(Integer.valueOf(this.axn.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.Bg())));
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
            switch (this.axt) {
                case 0:
                    a(this.axF, this.axG, this.axl);
                    a(this.axH, this.axI, this.axm);
                    a(this.axJ, this.axK, this.axn);
                    break;
                case 1:
                    a(this.axK, this.axL, this.axl);
                    a(this.axM, this.axK, this.axm);
                    a(this.axN, this.axI, this.axn);
                    break;
                case 2:
                    a(this.axK, this.axO, this.axl);
                    a(this.axP, this.axK, this.axm);
                    a(this.axN, this.axI, this.axn);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axl);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axm);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axn);
            }
        }
    }

    private void ex(int i) {
        if (this.axu.size() != 0) {
            int size = this.axu.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axu.get(i2).intValue() == i) {
                    this.axu.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.axk.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axk.startLoad(str, 10, false);
        } else {
            this.axk.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axp.setText("");
            return;
        }
        String trim = str.trim();
        this.axp.setVisibility(0);
        if (w.gZ(trim) > 12) {
            trim = w.e(trim, 0, 12) + "...";
        }
        this.axp.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axi.setText("");
            this.axi.setVisibility(8);
            return;
        }
        this.axi.setVisibility(0);
        this.axi.setText(str);
    }

    private void setTitle(String str) {
        this.axQ = str;
        if (this.axv != 0) {
            this.axe.setPadding(0, 0, (int) this.context.getResources().getDimension(this.axv), 0);
            this.axv = 0;
        } else {
            this.axe.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.axe.setText("");
            return;
        }
        this.axe.setVisibility(0);
        if (this.axx) {
            if (this.axA) {
                this.axe.setText(k.c(this.context, str, d.j.photo_live_tips));
                return;
            } else {
                this.axe.setText(e(str));
                return;
            }
        }
        this.axe.setText(str);
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

    private void fo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.awU.startLoad(str, 12, false);
        } else {
            this.awU.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awX.setText("");
            return;
        }
        this.awX.setVisibility(0);
        String trim = str.trim();
        if (w.gZ(trim) > 14) {
            trim = w.e(trim, 0, 14) + "...";
        }
        this.awX.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.awY, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.awY, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.awZ.setText(am.y(i));
    }

    private void setReplyNum(int i) {
        b(this.axa, i);
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
            this.axr.setVisibility(0);
            b(this.axr, i);
            return;
        }
        this.axr.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.awP) {
            this.axb.setVisibility(0);
            aj.j(this.axb, d.f.label_onthelist);
            return;
        }
        this.axb.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.awO) {
            this.axc.setVisibility(0);
            this.axc.setText(str);
            return;
        }
        this.axc.setVisibility(8);
        this.axc.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.axf.setVisibility(8);
            return;
        }
        this.axf.setVisibility(0);
        this.axf.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.axq.setVisibility(8);
            return;
        }
        this.axq.setVisibility(0);
        this.axq.setText(str);
    }

    public void setShowHead(boolean z) {
        this.awG = z;
    }

    public void setShowTitle(boolean z) {
        this.awH = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.awM = z;
    }

    public void setShowContent(boolean z) {
        this.awI = z;
    }

    public void setShowCover(boolean z) {
        this.awJ = z;
    }

    public void setShowExpression(boolean z) {
        this.awK = z;
    }

    public void setShowBottom(boolean z) {
        this.awL = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.awO = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.awP = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.awQ = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.awR = z;
    }

    public void setChooseStyle(int i) {
        this.axt = i;
    }

    public int getShowStyle() {
        return this.axt;
    }

    public void setShowLiveIcon(boolean z) {
        this.axx = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.awE = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.awF = bVar;
    }

    public void setParentBackground(int i) {
        aj.j(this.awS, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.axy = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.awN = z;
    }

    public void setTitlePaddingRight(int i) {
        this.axv = i;
    }

    public void setTitleMaxLines(int i) {
        this.axw = i;
    }

    public void setAllowGreyState(boolean z) {
        this.axz = z;
    }

    public void bl(boolean z) {
        this.axA = z;
    }
}
