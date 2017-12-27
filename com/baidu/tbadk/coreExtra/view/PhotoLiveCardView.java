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
    public int bdE;
    private a bkR;
    private b bkS;
    private boolean bkT;
    private boolean bkU;
    private boolean bkV;
    private boolean bkW;
    private boolean bkX;
    private boolean bkY;
    private boolean bkZ;
    private TextView blA;
    private RelativeLayout blB;
    private TextView blC;
    private TextView blD;
    private TextView blE;
    private TextView blF;
    private int blG;
    private ArrayList<Integer> blH;
    private int blI;
    private int blJ;
    private boolean blK;
    private boolean blL;
    private boolean blM;
    private boolean blN;
    private int blO;
    private int blP;
    private int blQ;
    private int blR;
    private int blS;
    private int blT;
    private int blU;
    private int blV;
    private int blW;
    private int blX;
    private int blY;
    private int blZ;
    private boolean bla;
    private boolean blb;
    private boolean blc;
    private boolean bld;
    private boolean ble;
    private LinearLayout blf;
    private View blg;
    private HeadImageView blh;
    private FrameLayout bli;
    private LinearLayout blj;
    private TextView blk;
    private TextView bll;
    private TextView blm;
    private TextView bln;
    private TextView blo;
    private TextView blp;
    private LinearLayout blq;
    private TextView blr;
    private TextView bls;
    private TextView blt;
    private LinearLayout blu;
    private TextView blv;
    private RelativeLayout blw;
    private TbImageView blx;
    private TextView bly;
    private TextView blz;
    private int bma;
    private int bmb;
    private int bmc;
    private String bmd;
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
        this.bkT = true;
        this.bkU = true;
        this.bkV = true;
        this.bkW = true;
        this.bkX = true;
        this.bkY = true;
        this.bkZ = false;
        this.bla = false;
        this.blb = false;
        this.blc = false;
        this.bld = false;
        this.ble = false;
        this.blG = 0;
        this.blH = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.blI = 0;
        this.blJ = 0;
        this.blK = false;
        this.blL = true;
        this.blM = false;
        this.blN = false;
        this.isGod = false;
        this.bdE = 3;
        this.padding = 0;
        this.blO = 0;
        this.blP = 0;
        this.blQ = 0;
        this.blR = 0;
        this.bmd = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.blP = (int) context.getResources().getDimension(d.e.ds100);
        this.blO = (int) context.getResources().getDimension(d.e.ds70);
        this.blQ = (int) context.getResources().getDimension(d.e.ds18);
        this.blR = (int) context.getResources().getDimension(d.e.ds4);
        this.blS = (int) context.getResources().getDimension(d.e.ds80);
        this.blT = (int) context.getResources().getDimension(d.e.ds280);
        this.blU = (int) context.getResources().getDimension(d.e.ds170);
        this.blV = (int) context.getResources().getDimension(d.e.ds320);
        this.blW = (int) context.getResources().getDimension(d.e.ds200);
        this.blX = (int) context.getResources().getDimension(d.e.ds60);
        this.blY = (int) context.getResources().getDimension(d.e.ds120);
        this.blZ = (int) context.getResources().getDimension(d.e.ds160);
        this.bma = (int) context.getResources().getDimension(d.e.ds220);
        this.bmb = (int) context.getResources().getDimension(d.e.ds240);
        this.bmc = (int) context.getResources().getDimension(d.e.ds180);
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
        this.blf = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.blg = inflate.findViewById(d.g.author_info);
        this.blq = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.blu = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.blw = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.blB = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        IQ();
        IR();
        IS();
        IU();
        IT();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.bkT, photoLiveCardData);
            b(this.bkU, this.bkZ, photoLiveCardData);
            b(this.bkV, photoLiveCardData);
            a(this.bkW, this.bkX, photoLiveCardData);
            a(this.bkY, photoLiveCardData);
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
            if (z && this.blL) {
                if (this.paddingBottom != 0) {
                    this.blw.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.blw.setPadding(this.padding, 0, this.padding, 0);
                }
                this.blw.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.blw != null) {
                this.blw.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blB.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.bla);
                t(photoLiveCardData.getDiscussNum(), this.bld);
                return;
            }
            this.blB.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blq.setVisibility(0);
                if (this.blJ != 0) {
                    this.blr.setMaxLines(this.blJ);
                } else {
                    this.blr.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.blr, photoLiveCardData.getThreadId());
                return;
            }
            this.blq.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.ble) {
            this.blt.setVisibility(0);
            this.blt.setTag(photoLiveCardData);
            return;
        }
        this.blt.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blu.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.blu.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.blu.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.blv, photoLiveCardData.getThreadId());
                return;
            }
            this.blu.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.blM) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tn(String.valueOf(j))) {
                aj.e(textView, d.C0108d.cp_cont_c, 1);
            } else {
                aj.e(textView, d.C0108d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.blg.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.blg.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.blg.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.blh.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.blP;
                        layoutParams.width = this.blP;
                    }
                    if (this.blF == null) {
                        this.blF = new TextView(this.context);
                        this.blF.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.blF.setEllipsize(TextUtils.TruncateAt.END);
                        this.blF.setTextSize(0, this.blQ);
                        aj.r(this.blF, d.C0108d.cp_cont_h);
                        aj.s(this.blF, d.f.icon_shen);
                        this.blF.setSingleLine(true);
                        this.blj.addView(this.blF);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.blF.setText(d.j.god_intro_default);
                    } else {
                        this.blF.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.blj.removeView(this.blF);
                    this.blF = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.blO;
                        layoutParams.width = this.blO;
                    }
                }
                this.blh.setTag(photoLiveCardData);
                fu(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.blj.removeView(this.blF);
            this.blg.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.blh.setPadding(this.blR, this.blR, this.blR, this.blR);
            if (this.isGod) {
                this.bli.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.bli.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.bli.setBackgroundDrawable(null);
        this.blh.setPadding(0, 0, 0, 0);
    }

    private void IQ() {
        if (this.blg != null) {
            this.blh = (HeadImageView) this.blg.findViewById(d.g.author_portrait);
            this.bli = (FrameLayout) this.blg.findViewById(d.g.author_portrait_info);
            this.blk = (TextView) this.blg.findViewById(d.g.author_name);
            this.bll = (TextView) this.blg.findViewById(d.g.nick_name);
            this.blm = (TextView) this.blg.findViewById(d.g.fans_num);
            this.bln = (TextView) this.blg.findViewById(d.g.reply_num);
            this.blo = (TextView) this.blg.findViewById(d.g.headlive_icon);
            this.blp = (TextView) this.blg.findViewById(d.g.refresh_time_in_head);
            this.blj = (LinearLayout) this.blg.findViewById(d.g.author_info_and_time);
            this.blh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bkS != null) {
                        PhotoLiveCardView.this.bkS.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void IR() {
        if (this.blq != null) {
            this.blr = (TextView) this.blq.findViewById(d.g.title);
            this.bls = (TextView) findViewById(d.g.refresh_time_in_title);
            this.blt = (TextView) this.blq.findViewById(d.g.card_delete_in_title);
            this.blt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bkR != null) {
                        PhotoLiveCardView.this.bkR.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void IS() {
        if (this.blu != null) {
            this.blv = (TextView) this.blu.findViewById(d.g.content);
        }
    }

    private void IT() {
        if (this.blB != null) {
            this.blC = (TextView) this.blB.findViewById(d.g.ba_name);
            this.blD = (TextView) this.blB.findViewById(d.g.bottom_refresh_time);
            this.blE = (TextView) this.blB.findViewById(d.g.bottom_reply_num);
        }
    }

    private void IU() {
        if (this.blw != null) {
            this.blx = (TbImageView) this.blw.findViewById(d.g.live_cover);
            this.blx.setGifIconSupport(false);
            IV();
        }
    }

    private void IV() {
        if (this.blw != null) {
            this.bly = (TextView) this.blw.findViewById(d.g.first_style_first_expression);
            this.blz = (TextView) this.blw.findViewById(d.g.first_style_second_expression);
            this.blA = (TextView) this.blw.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.blH.clear();
        IX();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            IW();
        }
    }

    private void IW() {
        if (this.blH.size() != 0) {
            int size = this.blH.size();
            for (int i = 0; i < size; i++) {
                if (this.blH.get(i).intValue() == this.bly.getId()) {
                    this.bly.setVisibility(8);
                } else if (this.blH.get(i).intValue() == this.blz.getId()) {
                    this.blz.setVisibility(8);
                } else if (this.blH.get(i).intValue() == this.blA.getId()) {
                    this.blA.setVisibility(8);
                }
            }
        }
    }

    private void IX() {
        this.bly.setText("");
        this.blz.setText("");
        this.blA.setText("");
        if (this.bly.getVisibility() == 8) {
            this.bly.setVisibility(0);
        }
        if (this.blz.getVisibility() == 8) {
            this.blz.setVisibility(0);
        }
        if (this.blA.getVisibility() == 8) {
            this.blA.setVisibility(0);
        }
        this.blH.add(Integer.valueOf(this.bly.getId()));
        this.blH.add(Integer.valueOf(this.blz.getId()));
        this.blH.add(Integer.valueOf(this.blA.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.IJ())));
            hv(textView.getId());
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
            switch (this.blG) {
                case 0:
                    a(this.blS, this.blT, this.bly);
                    a(this.blU, this.blV, this.blz);
                    a(this.blW, this.blX, this.blA);
                    break;
                case 1:
                    a(this.blX, this.blY, this.bly);
                    a(this.blZ, this.blX, this.blz);
                    a(this.bma, this.blV, this.blA);
                    break;
                case 2:
                    a(this.blX, this.bmb, this.bly);
                    a(this.bmc, this.blX, this.blz);
                    a(this.bma, this.blV, this.blA);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bly);
            } else if (i == 1) {
                a(arrayList.get(i2), this.blz);
            } else if (i == 2) {
                a(arrayList.get(i2), this.blA);
            }
        }
    }

    private void hv(int i) {
        if (this.blH.size() != 0) {
            int size = this.blH.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.blH.get(i2).intValue() == i) {
                    this.blH.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.blx.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.blx.startLoad(str, 10, false);
        } else {
            this.blx.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.blC.setText("");
            return;
        }
        String trim = str.trim();
        this.blC.setVisibility(0);
        if (w.ha(trim) > 12) {
            trim = w.j(trim, 0, 12) + "...";
        }
        this.blC.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.blv.setText("");
            this.blv.setVisibility(8);
            return;
        }
        this.blv.setVisibility(0);
        this.blv.setText(str);
    }

    private void setTitle(String str) {
        this.bmd = str;
        if (this.blI != 0) {
            this.blr.setPadding(0, 0, (int) this.context.getResources().getDimension(this.blI), 0);
            this.blI = 0;
        } else {
            this.blr.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.blr.setText("");
            return;
        }
        this.blr.setVisibility(0);
        if (this.blK) {
            if (this.blN) {
                this.blr.setText(k.c(this.context, str, d.j.photo_live_tips));
                return;
            } else {
                this.blr.setText(s(str));
                return;
            }
        }
        this.blr.setText(str);
    }

    public static SpannableStringBuilder s(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap fQ = aj.fQ(d.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(fQ);
        int height = fQ.getHeight();
        bitmapDrawable.setBounds(0, 0, fQ.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.blh.startLoad(str, 12, false);
        } else {
            this.blh.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.blk.setText("");
            return;
        }
        this.blk.setVisibility(0);
        String trim = str.trim();
        if (w.ha(trim) > 14) {
            trim = w.j(trim, 0, 14) + "...";
        }
        this.blk.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.bll, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.bll, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.blm.setText(am.G(i));
    }

    private void setReplyNum(int i) {
        b(this.bln, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(am.G(j));
        Drawable drawable = aj.getDrawable(d.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void t(int i, boolean z) {
        if (z) {
            this.blE.setVisibility(0);
            b(this.blE, i);
            return;
        }
        this.blE.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.blc) {
            this.blo.setVisibility(0);
            aj.s(this.blo, d.f.label_onthelist);
            return;
        }
        this.blo.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.blb) {
            this.blp.setVisibility(0);
            this.blp.setText(str);
            return;
        }
        this.blp.setVisibility(8);
        this.blp.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.bls.setVisibility(8);
            return;
        }
        this.bls.setVisibility(0);
        this.bls.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.blD.setVisibility(8);
            return;
        }
        this.blD.setVisibility(0);
        this.blD.setText(str);
    }

    public void setShowHead(boolean z) {
        this.bkT = z;
    }

    public void setShowTitle(boolean z) {
        this.bkU = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.bkZ = z;
    }

    public void setShowContent(boolean z) {
        this.bkV = z;
    }

    public void setShowCover(boolean z) {
        this.bkW = z;
    }

    public void setShowExpression(boolean z) {
        this.bkX = z;
    }

    public void setShowBottom(boolean z) {
        this.bkY = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.blb = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.blc = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.bld = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.ble = z;
    }

    public void setChooseStyle(int i) {
        this.blG = i;
    }

    public int getShowStyle() {
        return this.blG;
    }

    public void setShowLiveIcon(boolean z) {
        this.blK = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.bkR = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.bkS = bVar;
    }

    public void setParentBackground(int i) {
        aj.s(this.blf, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.blL = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.bla = z;
    }

    public void setTitlePaddingRight(int i) {
        this.blI = i;
    }

    public void setTitleMaxLines(int i) {
        this.blJ = i;
    }

    public void setAllowGreyState(boolean z) {
        this.blM = z;
    }
}
