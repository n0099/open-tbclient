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
    public int bdK;
    private TextView blA;
    private TextView blB;
    private TextView blC;
    private LinearLayout blD;
    private TextView blE;
    private RelativeLayout blF;
    private TbImageView blG;
    private TextView blH;
    private TextView blI;
    private TextView blJ;
    private RelativeLayout blK;
    private TextView blL;
    private TextView blM;
    private TextView blN;
    private TextView blO;
    private int blP;
    private ArrayList<Integer> blQ;
    private int blR;
    private int blS;
    private boolean blT;
    private boolean blU;
    private boolean blV;
    private boolean blW;
    private int blX;
    private int blY;
    private int blZ;
    private a bla;
    private b blb;
    private boolean blc;
    private boolean bld;
    private boolean ble;
    private boolean blf;
    private boolean blg;
    private boolean blh;
    private boolean bli;
    private boolean blj;
    private boolean blk;
    private boolean bll;
    private boolean blm;
    private boolean bln;
    private LinearLayout blo;
    private View blp;
    private HeadImageView blq;
    private FrameLayout blr;
    private LinearLayout bls;
    private TextView blt;
    private TextView blu;
    private TextView blv;
    private TextView blw;
    private TextView blx;
    private TextView bly;
    private LinearLayout blz;
    private int bma;
    private int bmb;
    private int bmc;
    private int bmd;
    private int bme;
    private int bmf;
    private int bmg;
    private int bmh;
    private int bmi;
    private int bmj;
    private int bmk;
    private int bml;
    private String bmm;
    private Context context;
    private boolean isGod;
    private int padding;
    private int paddingBottom;
    private int paddingTop;
    private int size;

    /* loaded from: classes.dex */
    public interface a {
        void bf(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bg(View view);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blc = true;
        this.bld = true;
        this.ble = true;
        this.blf = true;
        this.blg = true;
        this.blh = true;
        this.bli = false;
        this.blj = false;
        this.blk = false;
        this.bll = false;
        this.blm = false;
        this.bln = false;
        this.blP = 0;
        this.blQ = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.blR = 0;
        this.blS = 0;
        this.blT = false;
        this.blU = true;
        this.blV = false;
        this.blW = false;
        this.isGod = false;
        this.bdK = 3;
        this.padding = 0;
        this.blX = 0;
        this.blY = 0;
        this.blZ = 0;
        this.bma = 0;
        this.bmm = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.blY = (int) context.getResources().getDimension(d.e.ds100);
        this.blX = (int) context.getResources().getDimension(d.e.ds70);
        this.blZ = (int) context.getResources().getDimension(d.e.ds18);
        this.bma = (int) context.getResources().getDimension(d.e.ds4);
        this.bmb = (int) context.getResources().getDimension(d.e.ds80);
        this.bmc = (int) context.getResources().getDimension(d.e.ds280);
        this.bmd = (int) context.getResources().getDimension(d.e.ds170);
        this.bme = (int) context.getResources().getDimension(d.e.ds320);
        this.bmf = (int) context.getResources().getDimension(d.e.ds200);
        this.bmg = (int) context.getResources().getDimension(d.e.ds60);
        this.bmh = (int) context.getResources().getDimension(d.e.ds120);
        this.bmi = (int) context.getResources().getDimension(d.e.ds160);
        this.bmj = (int) context.getResources().getDimension(d.e.ds220);
        this.bmk = (int) context.getResources().getDimension(d.e.ds240);
        this.bml = (int) context.getResources().getDimension(d.e.ds180);
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
        this.blo = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.blp = inflate.findViewById(d.g.author_info);
        this.blz = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.blD = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.blF = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.blK = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        IF();
        IG();
        IH();
        IJ();
        II();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.blc, photoLiveCardData);
            b(this.bld, this.bli, photoLiveCardData);
            b(this.ble, photoLiveCardData);
            a(this.blf, this.blg, photoLiveCardData);
            a(this.blh, photoLiveCardData);
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
            if (z && this.blU) {
                if (this.paddingBottom != 0) {
                    this.blF.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.blF.setPadding(this.padding, 0, this.padding, 0);
                }
                this.blF.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.blF != null) {
                this.blF.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blK.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.blj);
                t(photoLiveCardData.getDiscussNum(), this.blm);
                return;
            }
            this.blK.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blz.setVisibility(0);
                if (this.blS != 0) {
                    this.blA.setMaxLines(this.blS);
                } else {
                    this.blA.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.blA, photoLiveCardData.getThreadId());
                return;
            }
            this.blz.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.bln) {
            this.blC.setVisibility(0);
            this.blC.setTag(photoLiveCardData);
            return;
        }
        this.blC.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blD.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.blD.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.blD.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.blE, photoLiveCardData.getThreadId());
                return;
            }
            this.blD.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.blV) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sH(String.valueOf(j))) {
                aj.e(textView, d.C0107d.cp_cont_c, 1);
            } else {
                aj.e(textView, d.C0107d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blp.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.blp.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.blp.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.blq.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.blY;
                        layoutParams.width = this.blY;
                    }
                    if (this.blO == null) {
                        this.blO = new TextView(this.context);
                        this.blO.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.blO.setEllipsize(TextUtils.TruncateAt.END);
                        this.blO.setTextSize(0, this.blZ);
                        aj.r(this.blO, d.C0107d.cp_cont_h);
                        aj.s(this.blO, d.f.icon_shen);
                        this.blO.setSingleLine(true);
                        this.bls.addView(this.blO);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.blO.setText(d.j.god_intro_default);
                    } else {
                        this.blO.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.bls.removeView(this.blO);
                    this.blO = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.blX;
                        layoutParams.width = this.blX;
                    }
                }
                this.blq.setTag(photoLiveCardData);
                fv(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.bls.removeView(this.blO);
            this.blp.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.blq.setPadding(this.bma, this.bma, this.bma, this.bma);
            if (this.isGod) {
                this.blr.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.blr.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.blr.setBackgroundDrawable(null);
        this.blq.setPadding(0, 0, 0, 0);
    }

    private void IF() {
        if (this.blp != null) {
            this.blq = (HeadImageView) this.blp.findViewById(d.g.author_portrait);
            this.blr = (FrameLayout) this.blp.findViewById(d.g.author_portrait_info);
            this.blt = (TextView) this.blp.findViewById(d.g.author_name);
            this.blu = (TextView) this.blp.findViewById(d.g.nick_name);
            this.blv = (TextView) this.blp.findViewById(d.g.fans_num);
            this.blw = (TextView) this.blp.findViewById(d.g.reply_num);
            this.blx = (TextView) this.blp.findViewById(d.g.headlive_icon);
            this.bly = (TextView) this.blp.findViewById(d.g.refresh_time_in_head);
            this.bls = (LinearLayout) this.blp.findViewById(d.g.author_info_and_time);
            this.blq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.blb != null) {
                        PhotoLiveCardView.this.blb.bg(view);
                    }
                }
            });
        }
    }

    private void IG() {
        if (this.blz != null) {
            this.blA = (TextView) this.blz.findViewById(d.g.title);
            this.blB = (TextView) findViewById(d.g.refresh_time_in_title);
            this.blC = (TextView) this.blz.findViewById(d.g.card_delete_in_title);
            this.blC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bla != null) {
                        PhotoLiveCardView.this.bla.bf(view);
                    }
                }
            });
        }
    }

    private void IH() {
        if (this.blD != null) {
            this.blE = (TextView) this.blD.findViewById(d.g.content);
        }
    }

    private void II() {
        if (this.blK != null) {
            this.blL = (TextView) this.blK.findViewById(d.g.ba_name);
            this.blM = (TextView) this.blK.findViewById(d.g.bottom_refresh_time);
            this.blN = (TextView) this.blK.findViewById(d.g.bottom_reply_num);
        }
    }

    private void IJ() {
        if (this.blF != null) {
            this.blG = (TbImageView) this.blF.findViewById(d.g.live_cover);
            this.blG.setGifIconSupport(false);
            IK();
        }
    }

    private void IK() {
        if (this.blF != null) {
            this.blH = (TextView) this.blF.findViewById(d.g.first_style_first_expression);
            this.blI = (TextView) this.blF.findViewById(d.g.first_style_second_expression);
            this.blJ = (TextView) this.blF.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.blQ.clear();
        IM();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            IL();
        }
    }

    private void IL() {
        if (this.blQ.size() != 0) {
            int size = this.blQ.size();
            for (int i = 0; i < size; i++) {
                if (this.blQ.get(i).intValue() == this.blH.getId()) {
                    this.blH.setVisibility(8);
                } else if (this.blQ.get(i).intValue() == this.blI.getId()) {
                    this.blI.setVisibility(8);
                } else if (this.blQ.get(i).intValue() == this.blJ.getId()) {
                    this.blJ.setVisibility(8);
                }
            }
        }
    }

    private void IM() {
        this.blH.setText("");
        this.blI.setText("");
        this.blJ.setText("");
        if (this.blH.getVisibility() == 8) {
            this.blH.setVisibility(0);
        }
        if (this.blI.getVisibility() == 8) {
            this.blI.setVisibility(0);
        }
        if (this.blJ.getVisibility() == 8) {
            this.blJ.setVisibility(0);
        }
        this.blQ.add(Integer.valueOf(this.blH.getId()));
        this.blQ.add(Integer.valueOf(this.blI.getId()));
        this.blQ.add(Integer.valueOf(this.blJ.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.IC())));
            hr(textView.getId());
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
            switch (this.blP) {
                case 0:
                    a(this.bmb, this.bmc, this.blH);
                    a(this.bmd, this.bme, this.blI);
                    a(this.bmf, this.bmg, this.blJ);
                    break;
                case 1:
                    a(this.bmg, this.bmh, this.blH);
                    a(this.bmi, this.bmg, this.blI);
                    a(this.bmj, this.bme, this.blJ);
                    break;
                case 2:
                    a(this.bmg, this.bmk, this.blH);
                    a(this.bml, this.bmg, this.blI);
                    a(this.bmj, this.bme, this.blJ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.blH);
            } else if (i == 1) {
                a(arrayList.get(i2), this.blI);
            } else if (i == 2) {
                a(arrayList.get(i2), this.blJ);
            }
        }
    }

    private void hr(int i) {
        if (this.blQ.size() != 0) {
            int size = this.blQ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.blQ.get(i2).intValue() == i) {
                    this.blQ.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.blG.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.blG.startLoad(str, 10, false);
        } else {
            this.blG.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.blL.setText("");
            return;
        }
        String trim = str.trim();
        this.blL.setVisibility(0);
        if (w.hb(trim) > 12) {
            trim = w.j(trim, 0, 12) + "...";
        }
        this.blL.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.blE.setText("");
            this.blE.setVisibility(8);
            return;
        }
        this.blE.setVisibility(0);
        this.blE.setText(str);
    }

    private void setTitle(String str) {
        this.bmm = str;
        if (this.blR != 0) {
            this.blA.setPadding(0, 0, (int) this.context.getResources().getDimension(this.blR), 0);
            this.blR = 0;
        } else {
            this.blA.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.blA.setText("");
            return;
        }
        this.blA.setVisibility(0);
        if (this.blT) {
            if (this.blW) {
                this.blA.setText(k.c(this.context, str, d.j.photo_live_tips));
                return;
            } else {
                this.blA.setText(s(str));
                return;
            }
        }
        this.blA.setText(str);
    }

    public static SpannableStringBuilder s(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap fO = aj.fO(d.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
        int height = fO.getHeight();
        bitmapDrawable.setBounds(0, 0, fO.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fv(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.blq.startLoad(str, 12, false);
        } else {
            this.blq.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.blt.setText("");
            return;
        }
        this.blt.setVisibility(0);
        String trim = str.trim();
        if (w.hb(trim) > 14) {
            trim = w.j(trim, 0, 14) + "...";
        }
        this.blt.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.blu, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.blu, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.blv.setText(am.H(i));
    }

    private void setReplyNum(int i) {
        b(this.blw, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(am.H(j));
        Drawable drawable = aj.getDrawable(d.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void t(int i, boolean z) {
        if (z) {
            this.blN.setVisibility(0);
            b(this.blN, i);
            return;
        }
        this.blN.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.bll) {
            this.blx.setVisibility(0);
            aj.s(this.blx, d.f.label_onthelist);
            return;
        }
        this.blx.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.blk) {
            this.bly.setVisibility(0);
            this.bly.setText(str);
            return;
        }
        this.bly.setVisibility(8);
        this.bly.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.blB.setVisibility(8);
            return;
        }
        this.blB.setVisibility(0);
        this.blB.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.blM.setVisibility(8);
            return;
        }
        this.blM.setVisibility(0);
        this.blM.setText(str);
    }

    public void setShowHead(boolean z) {
        this.blc = z;
    }

    public void setShowTitle(boolean z) {
        this.bld = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.bli = z;
    }

    public void setShowContent(boolean z) {
        this.ble = z;
    }

    public void setShowCover(boolean z) {
        this.blf = z;
    }

    public void setShowExpression(boolean z) {
        this.blg = z;
    }

    public void setShowBottom(boolean z) {
        this.blh = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.blk = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.bll = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.blm = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.bln = z;
    }

    public void setChooseStyle(int i) {
        this.blP = i;
    }

    public int getShowStyle() {
        return this.blP;
    }

    public void setShowLiveIcon(boolean z) {
        this.blT = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.bla = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.blb = bVar;
    }

    public void setParentBackground(int i) {
        aj.s(this.blo, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.blU = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.blj = z;
    }

    public void setTitlePaddingRight(int i) {
        this.blR = i;
    }

    public void setTitleMaxLines(int i) {
        this.blS = i;
    }

    public void setAllowGreyState(boolean z) {
        this.blV = z;
    }
}
