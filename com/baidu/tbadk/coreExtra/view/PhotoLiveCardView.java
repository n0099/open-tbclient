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
    public int bdS;
    private LinearLayout blA;
    private TextView blB;
    private TextView blC;
    private TextView blD;
    private TextView blE;
    private TextView blF;
    private TextView blG;
    private LinearLayout blH;
    private TextView blI;
    private TextView blJ;
    private TextView blK;
    private LinearLayout blL;
    private TextView blM;
    private RelativeLayout blN;
    private TbImageView blO;
    private TextView blP;
    private TextView blQ;
    private TextView blR;
    private RelativeLayout blS;
    private TextView blT;
    private TextView blU;
    private TextView blV;
    private TextView blW;
    private int blX;
    private ArrayList<Integer> blY;
    private int blZ;
    private a bli;
    private b blj;
    private boolean blk;
    private boolean bll;
    private boolean blm;
    private boolean bln;
    private boolean blo;
    private boolean blp;
    private boolean blq;
    private boolean blr;
    private boolean bls;
    private boolean blt;
    private boolean blu;
    private boolean blv;
    private LinearLayout blw;
    private View blx;
    private HeadImageView bly;
    private FrameLayout blz;
    private int bma;
    private boolean bmb;
    private boolean bmc;
    private boolean bmd;
    private boolean bme;
    private int bmf;
    private int bmg;
    private int bmh;
    private int bmi;
    private int bmj;
    private int bmk;
    private int bml;
    private int bmm;
    private int bmn;
    private int bmo;
    private int bmp;
    private int bmq;
    private int bmr;
    private int bms;
    private int bmt;
    private String bmu;
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
        this.blk = true;
        this.bll = true;
        this.blm = true;
        this.bln = true;
        this.blo = true;
        this.blp = true;
        this.blq = false;
        this.blr = false;
        this.bls = false;
        this.blt = false;
        this.blu = false;
        this.blv = false;
        this.blX = 0;
        this.blY = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.blZ = 0;
        this.bma = 0;
        this.bmb = false;
        this.bmc = true;
        this.bmd = false;
        this.bme = false;
        this.isGod = false;
        this.bdS = 3;
        this.padding = 0;
        this.bmf = 0;
        this.bmg = 0;
        this.bmh = 0;
        this.bmi = 0;
        this.bmu = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.bmg = (int) context.getResources().getDimension(d.e.ds100);
        this.bmf = (int) context.getResources().getDimension(d.e.ds70);
        this.bmh = (int) context.getResources().getDimension(d.e.ds18);
        this.bmi = (int) context.getResources().getDimension(d.e.ds4);
        this.bmj = (int) context.getResources().getDimension(d.e.ds80);
        this.bmk = (int) context.getResources().getDimension(d.e.ds280);
        this.bml = (int) context.getResources().getDimension(d.e.ds170);
        this.bmm = (int) context.getResources().getDimension(d.e.ds320);
        this.bmn = (int) context.getResources().getDimension(d.e.ds200);
        this.bmo = (int) context.getResources().getDimension(d.e.ds60);
        this.bmp = (int) context.getResources().getDimension(d.e.ds120);
        this.bmq = (int) context.getResources().getDimension(d.e.ds160);
        this.bmr = (int) context.getResources().getDimension(d.e.ds220);
        this.bms = (int) context.getResources().getDimension(d.e.ds240);
        this.bmt = (int) context.getResources().getDimension(d.e.ds180);
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
        this.blw = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.blx = inflate.findViewById(d.g.author_info);
        this.blH = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.blL = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.blN = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.blS = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        IH();
        II();
        IJ();
        IL();
        IK();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.blk, photoLiveCardData);
            b(this.bll, this.blq, photoLiveCardData);
            b(this.blm, photoLiveCardData);
            a(this.bln, this.blo, photoLiveCardData);
            a(this.blp, photoLiveCardData);
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
            if (z && this.bmc) {
                if (this.paddingBottom != 0) {
                    this.blN.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.blN.setPadding(this.padding, 0, this.padding, 0);
                }
                this.blN.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.blN != null) {
                this.blN.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blS.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.blr);
                t(photoLiveCardData.getDiscussNum(), this.blu);
                return;
            }
            this.blS.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blH.setVisibility(0);
                if (this.bma != 0) {
                    this.blI.setMaxLines(this.bma);
                } else {
                    this.blI.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.blI, photoLiveCardData.getThreadId());
                return;
            }
            this.blH.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.blv) {
            this.blK.setVisibility(0);
            this.blK.setTag(photoLiveCardData);
            return;
        }
        this.blK.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blL.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.blL.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.blL.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.blM, photoLiveCardData.getThreadId());
                return;
            }
            this.blL.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.bmd) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sP(String.valueOf(j))) {
                aj.e(textView, d.C0108d.cp_cont_c, 1);
            } else {
                aj.e(textView, d.C0108d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blx.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.blx.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.blx.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.bly.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.bmg;
                        layoutParams.width = this.bmg;
                    }
                    if (this.blW == null) {
                        this.blW = new TextView(this.context);
                        this.blW.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.blW.setEllipsize(TextUtils.TruncateAt.END);
                        this.blW.setTextSize(0, this.bmh);
                        aj.r(this.blW, d.C0108d.cp_cont_h);
                        aj.s(this.blW, d.f.icon_shen);
                        this.blW.setSingleLine(true);
                        this.blA.addView(this.blW);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.blW.setText(d.j.god_intro_default);
                    } else {
                        this.blW.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.blA.removeView(this.blW);
                    this.blW = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.bmf;
                        layoutParams.width = this.bmf;
                    }
                }
                this.bly.setTag(photoLiveCardData);
                fD(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.blA.removeView(this.blW);
            this.blx.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.bly.setPadding(this.bmi, this.bmi, this.bmi, this.bmi);
            if (this.isGod) {
                this.blz.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.blz.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.blz.setBackgroundDrawable(null);
        this.bly.setPadding(0, 0, 0, 0);
    }

    private void IH() {
        if (this.blx != null) {
            this.bly = (HeadImageView) this.blx.findViewById(d.g.author_portrait);
            this.blz = (FrameLayout) this.blx.findViewById(d.g.author_portrait_info);
            this.blB = (TextView) this.blx.findViewById(d.g.author_name);
            this.blC = (TextView) this.blx.findViewById(d.g.nick_name);
            this.blD = (TextView) this.blx.findViewById(d.g.fans_num);
            this.blE = (TextView) this.blx.findViewById(d.g.reply_num);
            this.blF = (TextView) this.blx.findViewById(d.g.headlive_icon);
            this.blG = (TextView) this.blx.findViewById(d.g.refresh_time_in_head);
            this.blA = (LinearLayout) this.blx.findViewById(d.g.author_info_and_time);
            this.bly.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.blj != null) {
                        PhotoLiveCardView.this.blj.bg(view);
                    }
                }
            });
        }
    }

    private void II() {
        if (this.blH != null) {
            this.blI = (TextView) this.blH.findViewById(d.g.title);
            this.blJ = (TextView) findViewById(d.g.refresh_time_in_title);
            this.blK = (TextView) this.blH.findViewById(d.g.card_delete_in_title);
            this.blK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bli != null) {
                        PhotoLiveCardView.this.bli.bf(view);
                    }
                }
            });
        }
    }

    private void IJ() {
        if (this.blL != null) {
            this.blM = (TextView) this.blL.findViewById(d.g.content);
        }
    }

    private void IK() {
        if (this.blS != null) {
            this.blT = (TextView) this.blS.findViewById(d.g.ba_name);
            this.blU = (TextView) this.blS.findViewById(d.g.bottom_refresh_time);
            this.blV = (TextView) this.blS.findViewById(d.g.bottom_reply_num);
        }
    }

    private void IL() {
        if (this.blN != null) {
            this.blO = (TbImageView) this.blN.findViewById(d.g.live_cover);
            this.blO.setGifIconSupport(false);
            IM();
        }
    }

    private void IM() {
        if (this.blN != null) {
            this.blP = (TextView) this.blN.findViewById(d.g.first_style_first_expression);
            this.blQ = (TextView) this.blN.findViewById(d.g.first_style_second_expression);
            this.blR = (TextView) this.blN.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.blY.clear();
        IO();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            IN();
        }
    }

    private void IN() {
        if (this.blY.size() != 0) {
            int size = this.blY.size();
            for (int i = 0; i < size; i++) {
                if (this.blY.get(i).intValue() == this.blP.getId()) {
                    this.blP.setVisibility(8);
                } else if (this.blY.get(i).intValue() == this.blQ.getId()) {
                    this.blQ.setVisibility(8);
                } else if (this.blY.get(i).intValue() == this.blR.getId()) {
                    this.blR.setVisibility(8);
                }
            }
        }
    }

    private void IO() {
        this.blP.setText("");
        this.blQ.setText("");
        this.blR.setText("");
        if (this.blP.getVisibility() == 8) {
            this.blP.setVisibility(0);
        }
        if (this.blQ.getVisibility() == 8) {
            this.blQ.setVisibility(0);
        }
        if (this.blR.getVisibility() == 8) {
            this.blR.setVisibility(0);
        }
        this.blY.add(Integer.valueOf(this.blP.getId()));
        this.blY.add(Integer.valueOf(this.blQ.getId()));
        this.blY.add(Integer.valueOf(this.blR.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.aj(eVar.getLabelName(), String.valueOf(eVar.IE())));
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
            switch (this.blX) {
                case 0:
                    a(this.bmj, this.bmk, this.blP);
                    a(this.bml, this.bmm, this.blQ);
                    a(this.bmn, this.bmo, this.blR);
                    break;
                case 1:
                    a(this.bmo, this.bmp, this.blP);
                    a(this.bmq, this.bmo, this.blQ);
                    a(this.bmr, this.bmm, this.blR);
                    break;
                case 2:
                    a(this.bmo, this.bms, this.blP);
                    a(this.bmt, this.bmo, this.blQ);
                    a(this.bmr, this.bmm, this.blR);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.blP);
            } else if (i == 1) {
                a(arrayList.get(i2), this.blQ);
            } else if (i == 2) {
                a(arrayList.get(i2), this.blR);
            }
        }
    }

    private void hr(int i) {
        if (this.blY.size() != 0) {
            int size = this.blY.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.blY.get(i2).intValue() == i) {
                    this.blY.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.blO.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.blO.startLoad(str, 10, false);
        } else {
            this.blO.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.blT.setText("");
            return;
        }
        String trim = str.trim();
        this.blT.setVisibility(0);
        if (w.hj(trim) > 12) {
            trim = w.j(trim, 0, 12) + "...";
        }
        this.blT.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.blM.setText("");
            this.blM.setVisibility(8);
            return;
        }
        this.blM.setVisibility(0);
        this.blM.setText(str);
    }

    private void setTitle(String str) {
        this.bmu = str;
        if (this.blZ != 0) {
            this.blI.setPadding(0, 0, (int) this.context.getResources().getDimension(this.blZ), 0);
            this.blZ = 0;
        } else {
            this.blI.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.blI.setText("");
            return;
        }
        this.blI.setVisibility(0);
        if (this.bmb) {
            if (this.bme) {
                this.blI.setText(k.c(this.context, str, d.j.photo_live_tips));
                return;
            } else {
                this.blI.setText(s(str));
                return;
            }
        }
        this.blI.setText(str);
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

    private void fD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bly.startLoad(str, 12, false);
        } else {
            this.bly.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.blB.setText("");
            return;
        }
        this.blB.setVisibility(0);
        String trim = str.trim();
        if (w.hj(trim) > 14) {
            trim = w.j(trim, 0, 14) + "...";
        }
        this.blB.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.blC, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.blC, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.blD.setText(am.H(i));
    }

    private void setReplyNum(int i) {
        b(this.blE, i);
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
            this.blV.setVisibility(0);
            b(this.blV, i);
            return;
        }
        this.blV.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.blt) {
            this.blF.setVisibility(0);
            aj.s(this.blF, d.f.label_onthelist);
            return;
        }
        this.blF.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.bls) {
            this.blG.setVisibility(0);
            this.blG.setText(str);
            return;
        }
        this.blG.setVisibility(8);
        this.blG.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.blJ.setVisibility(8);
            return;
        }
        this.blJ.setVisibility(0);
        this.blJ.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.blU.setVisibility(8);
            return;
        }
        this.blU.setVisibility(0);
        this.blU.setText(str);
    }

    public void setShowHead(boolean z) {
        this.blk = z;
    }

    public void setShowTitle(boolean z) {
        this.bll = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.blq = z;
    }

    public void setShowContent(boolean z) {
        this.blm = z;
    }

    public void setShowCover(boolean z) {
        this.bln = z;
    }

    public void setShowExpression(boolean z) {
        this.blo = z;
    }

    public void setShowBottom(boolean z) {
        this.blp = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.bls = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.blt = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.blu = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.blv = z;
    }

    public void setChooseStyle(int i) {
        this.blX = i;
    }

    public int getShowStyle() {
        return this.blX;
    }

    public void setShowLiveIcon(boolean z) {
        this.bmb = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.bli = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.blj = bVar;
    }

    public void setParentBackground(int i) {
        aj.s(this.blw, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.bmc = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.blr = z;
    }

    public void setTitlePaddingRight(int i) {
        this.blZ = i;
    }

    public void setTitleMaxLines(int i) {
        this.bma = i;
    }

    public void setAllowGreyState(boolean z) {
        this.bmd = z;
    }
}
