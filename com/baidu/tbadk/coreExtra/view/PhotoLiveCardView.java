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
    public int apG;
    private a awM;
    private b awN;
    private boolean awO;
    private boolean awP;
    private boolean awQ;
    private boolean awR;
    private boolean awS;
    private boolean awT;
    private boolean awU;
    private boolean awV;
    private boolean awW;
    private boolean awX;
    private boolean awY;
    private boolean awZ;
    private TextView axA;
    private int axB;
    private ArrayList<Integer> axC;
    private int axD;
    private int axE;
    private boolean axF;
    private boolean axG;
    private boolean axH;
    private boolean axI;
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
    private int axV;
    private int axW;
    private int axX;
    private String axY;
    private LinearLayout axa;
    private View axb;
    private HeadImageView axc;
    private FrameLayout axd;
    private LinearLayout axe;
    private TextView axf;
    private TextView axg;
    private TextView axh;
    private TextView axi;
    private TextView axj;
    private TextView axk;
    private LinearLayout axl;
    private TextView axm;
    private TextView axn;
    private TextView axo;
    private LinearLayout axp;
    private TextView axq;
    private RelativeLayout axr;
    private TbImageView axs;
    private TextView axt;
    private TextView axu;
    private TextView axv;
    private RelativeLayout axw;
    private TextView axx;
    private TextView axy;
    private TextView axz;
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
        this.awO = true;
        this.awP = true;
        this.awQ = true;
        this.awR = true;
        this.awS = true;
        this.awT = true;
        this.awU = false;
        this.awV = false;
        this.awW = false;
        this.awX = false;
        this.awY = false;
        this.awZ = false;
        this.axB = 0;
        this.axC = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.axD = 0;
        this.axE = 0;
        this.axF = false;
        this.axG = true;
        this.axH = false;
        this.axI = false;
        this.isGod = false;
        this.apG = 3;
        this.padding = 0;
        this.axJ = 0;
        this.axK = 0;
        this.axL = 0;
        this.axM = 0;
        this.axY = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.axK = (int) context.getResources().getDimension(d.e.ds100);
        this.axJ = (int) context.getResources().getDimension(d.e.ds70);
        this.axL = (int) context.getResources().getDimension(d.e.ds18);
        this.axM = (int) context.getResources().getDimension(d.e.ds4);
        this.axN = (int) context.getResources().getDimension(d.e.ds80);
        this.axO = (int) context.getResources().getDimension(d.e.ds280);
        this.axP = (int) context.getResources().getDimension(d.e.ds170);
        this.axQ = (int) context.getResources().getDimension(d.e.ds320);
        this.axR = (int) context.getResources().getDimension(d.e.ds200);
        this.axS = (int) context.getResources().getDimension(d.e.ds60);
        this.axT = (int) context.getResources().getDimension(d.e.ds120);
        this.axU = (int) context.getResources().getDimension(d.e.ds160);
        this.axV = (int) context.getResources().getDimension(d.e.ds220);
        this.axW = (int) context.getResources().getDimension(d.e.ds240);
        this.axX = (int) context.getResources().getDimension(d.e.ds180);
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
        this.axa = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.axb = inflate.findViewById(d.g.author_info);
        this.axl = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.axp = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.axr = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.axw = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        Bo();
        Bp();
        Bq();
        Bs();
        Br();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.awO, photoLiveCardData);
            b(this.awP, this.awU, photoLiveCardData);
            b(this.awQ, photoLiveCardData);
            a(this.awR, this.awS, photoLiveCardData);
            a(this.awT, photoLiveCardData);
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
            if (z && this.axG) {
                if (this.paddingBottom != 0) {
                    this.axr.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axr.setPadding(this.padding, 0, this.padding, 0);
                }
                this.axr.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axr != null) {
                this.axr.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axw.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.awV);
                h(photoLiveCardData.getDiscussNum(), this.awY);
                return;
            }
            this.axw.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axl.setVisibility(0);
                if (this.axE != 0) {
                    this.axm.setMaxLines(this.axE);
                } else {
                    this.axm.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.axm, photoLiveCardData.getThreadId());
                return;
            }
            this.axl.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.awZ) {
            this.axo.setVisibility(0);
            this.axo.setTag(photoLiveCardData);
            return;
        }
        this.axo.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axp.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.axp.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axp.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.axq, photoLiveCardData.getThreadId());
                return;
            }
            this.axp.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.axH) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.to(String.valueOf(j))) {
                aj.c(textView, d.C0095d.cp_cont_c, 1);
            } else {
                aj.c(textView, d.C0095d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axb.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.axb.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.axb.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.axc.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.axK;
                        layoutParams.width = this.axK;
                    }
                    if (this.axA == null) {
                        this.axA = new TextView(this.context);
                        this.axA.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.axA.setEllipsize(TextUtils.TruncateAt.END);
                        this.axA.setTextSize(0, this.axL);
                        aj.i(this.axA, d.C0095d.cp_cont_h);
                        aj.j(this.axA, d.f.icon_shen);
                        this.axA.setSingleLine(true);
                        this.axe.addView(this.axA);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.axA.setText(d.j.god_intro_default);
                    } else {
                        this.axA.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.axe.removeView(this.axA);
                    this.axA = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.axJ;
                        layoutParams.width = this.axJ;
                    }
                }
                this.axc.setTag(photoLiveCardData);
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
            this.axe.removeView(this.axA);
            this.axb.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.axc.setPadding(this.axM, this.axM, this.axM, this.axM);
            if (this.isGod) {
                this.axd.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.axd.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.axd.setBackgroundDrawable(null);
        this.axc.setPadding(0, 0, 0, 0);
    }

    private void Bo() {
        if (this.axb != null) {
            this.axc = (HeadImageView) this.axb.findViewById(d.g.author_portrait);
            this.axd = (FrameLayout) this.axb.findViewById(d.g.author_portrait_info);
            this.axf = (TextView) this.axb.findViewById(d.g.author_name);
            this.axg = (TextView) this.axb.findViewById(d.g.nick_name);
            this.axh = (TextView) this.axb.findViewById(d.g.fans_num);
            this.axi = (TextView) this.axb.findViewById(d.g.reply_num);
            this.axj = (TextView) this.axb.findViewById(d.g.headlive_icon);
            this.axk = (TextView) this.axb.findViewById(d.g.refresh_time_in_head);
            this.axe = (LinearLayout) this.axb.findViewById(d.g.author_info_and_time);
            this.axc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awN != null) {
                        PhotoLiveCardView.this.awN.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Bp() {
        if (this.axl != null) {
            this.axm = (TextView) this.axl.findViewById(d.g.title);
            this.axn = (TextView) findViewById(d.g.refresh_time_in_title);
            this.axo = (TextView) this.axl.findViewById(d.g.card_delete_in_title);
            this.axo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.awM != null) {
                        PhotoLiveCardView.this.awM.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bq() {
        if (this.axp != null) {
            this.axq = (TextView) this.axp.findViewById(d.g.content);
        }
    }

    private void Br() {
        if (this.axw != null) {
            this.axx = (TextView) this.axw.findViewById(d.g.ba_name);
            this.axy = (TextView) this.axw.findViewById(d.g.bottom_refresh_time);
            this.axz = (TextView) this.axw.findViewById(d.g.bottom_reply_num);
        }
    }

    private void Bs() {
        if (this.axr != null) {
            this.axs = (TbImageView) this.axr.findViewById(d.g.live_cover);
            this.axs.setGifIconSupport(false);
            Bt();
        }
    }

    private void Bt() {
        if (this.axr != null) {
            this.axt = (TextView) this.axr.findViewById(d.g.first_style_first_expression);
            this.axu = (TextView) this.axr.findViewById(d.g.first_style_second_expression);
            this.axv = (TextView) this.axr.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.axC.clear();
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
        if (this.axC.size() != 0) {
            int size = this.axC.size();
            for (int i = 0; i < size; i++) {
                if (this.axC.get(i).intValue() == this.axt.getId()) {
                    this.axt.setVisibility(8);
                } else if (this.axC.get(i).intValue() == this.axu.getId()) {
                    this.axu.setVisibility(8);
                } else if (this.axC.get(i).intValue() == this.axv.getId()) {
                    this.axv.setVisibility(8);
                }
            }
        }
    }

    private void Bv() {
        this.axt.setText("");
        this.axu.setText("");
        this.axv.setText("");
        if (this.axt.getVisibility() == 8) {
            this.axt.setVisibility(0);
        }
        if (this.axu.getVisibility() == 8) {
            this.axu.setVisibility(0);
        }
        if (this.axv.getVisibility() == 8) {
            this.axv.setVisibility(0);
        }
        this.axC.add(Integer.valueOf(this.axt.getId()));
        this.axC.add(Integer.valueOf(this.axu.getId()));
        this.axC.add(Integer.valueOf(this.axv.getId()));
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
            switch (this.axB) {
                case 0:
                    a(this.axN, this.axO, this.axt);
                    a(this.axP, this.axQ, this.axu);
                    a(this.axR, this.axS, this.axv);
                    break;
                case 1:
                    a(this.axS, this.axT, this.axt);
                    a(this.axU, this.axS, this.axu);
                    a(this.axV, this.axQ, this.axv);
                    break;
                case 2:
                    a(this.axS, this.axW, this.axt);
                    a(this.axX, this.axS, this.axu);
                    a(this.axV, this.axQ, this.axv);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axt);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axu);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axv);
            }
        }
    }

    private void ex(int i) {
        if (this.axC.size() != 0) {
            int size = this.axC.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.axC.get(i2).intValue() == i) {
                    this.axC.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.axs.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axs.startLoad(str, 10, false);
        } else {
            this.axs.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axx.setText("");
            return;
        }
        String trim = str.trim();
        this.axx.setVisibility(0);
        if (w.gX(trim) > 12) {
            trim = w.e(trim, 0, 12) + "...";
        }
        this.axx.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axq.setText("");
            this.axq.setVisibility(8);
            return;
        }
        this.axq.setVisibility(0);
        this.axq.setText(str);
    }

    private void setTitle(String str) {
        this.axY = str;
        if (this.axD != 0) {
            this.axm.setPadding(0, 0, (int) this.context.getResources().getDimension(this.axD), 0);
            this.axD = 0;
        } else {
            this.axm.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.axm.setText("");
            return;
        }
        this.axm.setVisibility(0);
        if (this.axF) {
            if (this.axI) {
                this.axm.setText(k.c(this.context, str, d.j.photo_live_tips));
                return;
            } else {
                this.axm.setText(e(str));
                return;
            }
        }
        this.axm.setText(str);
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
            this.axc.startLoad(str, 12, false);
        } else {
            this.axc.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axf.setText("");
            return;
        }
        this.axf.setVisibility(0);
        String trim = str.trim();
        if (w.gX(trim) > 14) {
            trim = w.e(trim, 0, 14) + "...";
        }
        this.axf.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.axg, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.axg, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.axh.setText(am.y(i));
    }

    private void setReplyNum(int i) {
        b(this.axi, i);
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
            this.axz.setVisibility(0);
            b(this.axz, i);
            return;
        }
        this.axz.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.awX) {
            this.axj.setVisibility(0);
            aj.j(this.axj, d.f.label_onthelist);
            return;
        }
        this.axj.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.awW) {
            this.axk.setVisibility(0);
            this.axk.setText(str);
            return;
        }
        this.axk.setVisibility(8);
        this.axk.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.axn.setVisibility(8);
            return;
        }
        this.axn.setVisibility(0);
        this.axn.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.axy.setVisibility(8);
            return;
        }
        this.axy.setVisibility(0);
        this.axy.setText(str);
    }

    public void setShowHead(boolean z) {
        this.awO = z;
    }

    public void setShowTitle(boolean z) {
        this.awP = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.awU = z;
    }

    public void setShowContent(boolean z) {
        this.awQ = z;
    }

    public void setShowCover(boolean z) {
        this.awR = z;
    }

    public void setShowExpression(boolean z) {
        this.awS = z;
    }

    public void setShowBottom(boolean z) {
        this.awT = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.awW = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.awX = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.awY = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.awZ = z;
    }

    public void setChooseStyle(int i) {
        this.axB = i;
    }

    public int getShowStyle() {
        return this.axB;
    }

    public void setShowLiveIcon(boolean z) {
        this.axF = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.awM = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.awN = bVar;
    }

    public void setParentBackground(int i) {
        aj.j(this.axa, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.axG = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.awV = z;
    }

    public void setTitlePaddingRight(int i) {
        this.axD = i;
    }

    public void setTitleMaxLines(int i) {
        this.axE = i;
    }

    public void setAllowGreyState(boolean z) {
        this.axH = z;
    }

    public void bm(boolean z) {
        this.axI = z;
    }
}
