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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    private a akV;
    private b akW;
    private boolean akX;
    private boolean akY;
    private boolean akZ;
    private TbImageView alA;
    private TextView alB;
    private TextView alC;
    private TextView alD;
    private RelativeLayout alE;
    private TextView alF;
    private TextView alG;
    private TextView alH;
    private int alI;
    private ArrayList<Integer> alJ;
    private int alK;
    private int alL;
    private boolean alM;
    private boolean alN;
    private boolean alO;
    private boolean ala;
    private boolean alb;
    private boolean alc;
    private boolean ald;
    private boolean ale;
    private boolean alf;
    private boolean alg;
    private boolean alh;
    private boolean ali;
    private LinearLayout alj;
    private LinearLayout alk;
    private HeadImageView all;
    private FrameLayout alm;
    private TextView aln;
    private TextView alo;
    private TextView alp;
    private TextView alq;
    private TextView alr;
    private TextView als;
    private LinearLayout alt;
    private TextView alu;
    private TextView alv;
    private TextView alw;
    private LinearLayout alx;
    private TextView aly;
    private FrameLayout alz;
    private Context context;
    private int paddingBottom;
    private int paddingTop;

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
        this.akX = true;
        this.akY = true;
        this.akZ = true;
        this.ala = true;
        this.alb = true;
        this.alc = true;
        this.ald = false;
        this.ale = false;
        this.alf = false;
        this.alg = false;
        this.alh = false;
        this.ali = false;
        this.alI = 0;
        this.alJ = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alK = 0;
        this.alL = 0;
        this.alM = false;
        this.alN = true;
        this.alO = false;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akX = true;
        this.akY = true;
        this.akZ = true;
        this.ala = true;
        this.alb = true;
        this.alc = true;
        this.ald = false;
        this.ale = false;
        this.alf = false;
        this.alg = false;
        this.alh = false;
        this.ali = false;
        this.alI = 0;
        this.alJ = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alK = 0;
        this.alL = 0;
        this.alM = false;
        this.alN = true;
        this.alO = false;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context) {
        super(context);
        this.akX = true;
        this.akY = true;
        this.akZ = true;
        this.ala = true;
        this.alb = true;
        this.alc = true;
        this.ald = false;
        this.ale = false;
        this.alf = false;
        this.alg = false;
        this.alh = false;
        this.ali = false;
        this.alI = 0;
        this.alJ = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alK = 0;
        this.alL = 0;
        this.alM = false;
        this.alN = true;
        this.alO = false;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i.g.photo_live_card_view, this);
        this.alj = (LinearLayout) inflate.findViewById(i.f.pl_card_root);
        this.alk = (LinearLayout) inflate.findViewById(i.f.photo_live_card_head);
        this.alt = (LinearLayout) inflate.findViewById(i.f.photo_live_card_title);
        this.alx = (LinearLayout) inflate.findViewById(i.f.photo_live_card_content);
        this.alz = (FrameLayout) inflate.findViewById(i.f.photo_live_card_cover_and_expression);
        this.alE = (RelativeLayout) inflate.findViewById(i.f.photo_live_card_bottom);
        yY();
        yZ();
        za();
        zc();
        zb();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            an.i(this.alj, i.e.frs_item_control_btn_bg);
            c(this.akX, photoLiveCardData);
            b(this.akY, this.ald, photoLiveCardData);
            b(this.akZ, photoLiveCardData);
            a(this.ala, this.alb, photoLiveCardData);
            a(this.alc, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.alN) {
                zd();
                if (this.paddingBottom != 0) {
                    this.alz.setPadding((int) this.context.getResources().getDimension(i.d.ds24), 0, (int) this.context.getResources().getDimension(i.d.ds24), (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                }
                this.alz.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.alz != null) {
                this.alz.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                an.b(this.alF, i.c.cp_cont_i, 1);
                an.i((View) this.alF, i.e.label_bg_tie);
                an.b(this.alG, i.c.cp_cont_d, 1);
                an.b(this.alH, i.c.cp_cont_d, 1);
                an.b(this.alF, i.c.cp_cont_i, 1);
                setBaName(photoLiveCardData.getForumName());
                o(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.ale);
                f(photoLiveCardData.getDiscussNum(), this.alh);
                return;
            }
            this.alE.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                if (this.alL != 0) {
                    this.alu.setMaxLines(this.alL);
                } else {
                    this.alu.setMaxLines(2);
                }
                an.b(this.alu, i.c.cp_cont_b, 1);
                an.b(this.alv, i.c.cp_cont_c, 1);
                an.b(this.alw, i.c.cp_cont_i, 1);
                an.i((View) this.alw, i.e.blacklist_remove_button_bg);
                setTitle(photoLiveCardData.getTitle());
                n(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.alu, photoLiveCardData.getThreadId());
                return;
            }
            this.alt.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.ali) {
            this.alw.setVisibility(0);
            this.alw.setTag(photoLiveCardData);
            return;
        }
        this.alw.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alx.setVisibility(0);
                int dimension = (int) this.context.getResources().getDimension(i.d.ds24);
                if (this.paddingBottom != 0) {
                    this.alx.setPadding(dimension, 0, dimension, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.alx.setPadding(dimension, 0, dimension, 0);
                }
                an.b(this.aly, i.c.cp_cont_b, 1);
                setContent(photoLiveCardData.getContent());
                a(this.aly, photoLiveCardData.getThreadId());
                return;
            }
            this.alx.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.alO) {
            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lL(String.valueOf(j))) {
                an.b(this.aly, i.c.cp_cont_c, 1);
            } else {
                an.b(this.aly, i.c.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alk.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.alk.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.alk.setPadding(0, 0, 0, 0);
                }
                an.b(this.aln, i.c.cp_cont_f, 1);
                an.b(this.alo, i.c.cp_cont_d, 1);
                an.b(this.alp, i.c.cp_cont_d, 1);
                an.b(this.alq, i.c.cp_cont_d, 1);
                an.b(this.als, i.c.cp_cont_d, 1);
                this.all.setTag(photoLiveCardData);
                eu(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.alk.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            int dimension = (int) this.context.getResources().getDimension(i.d.ds4);
            this.all.setPadding(dimension, dimension, dimension, dimension);
            this.alm.setBackgroundDrawable(an.getDrawable(i.e.frs_touxiang_jinkuan));
            return;
        }
        this.alm.setBackgroundDrawable(null);
        this.all.setPadding(0, 0, 0, 0);
    }

    private void yY() {
        if (this.alk != null) {
            this.all = (HeadImageView) this.alk.findViewById(i.f.author_portrait);
            this.alm = (FrameLayout) this.alk.findViewById(i.f.author_portrait_info);
            this.aln = (TextView) this.alk.findViewById(i.f.author_name);
            this.alo = (TextView) this.alk.findViewById(i.f.nick_name);
            this.alp = (TextView) this.alk.findViewById(i.f.fans_num);
            this.alq = (TextView) this.alk.findViewById(i.f.reply_num);
            this.alr = (TextView) this.alk.findViewById(i.f.headlive_icon);
            this.als = (TextView) this.alk.findViewById(i.f.refresh_time_in_head);
            this.all.setOnClickListener(new x(this));
        }
    }

    private void yZ() {
        if (this.alt != null) {
            this.alu = (TextView) this.alt.findViewById(i.f.title);
            this.alv = (TextView) findViewById(i.f.refresh_time_in_title);
            this.alw = (TextView) this.alt.findViewById(i.f.card_delete_in_title);
            this.alw.setOnClickListener(new y(this));
        }
    }

    private void za() {
        if (this.alx != null) {
            this.aly = (TextView) this.alx.findViewById(i.f.content);
        }
    }

    private void zb() {
        if (this.alE != null) {
            this.alF = (TextView) this.alE.findViewById(i.f.ba_name);
            this.alG = (TextView) this.alE.findViewById(i.f.bottom_refresh_time);
            this.alH = (TextView) this.alE.findViewById(i.f.bottom_reply_num);
        }
    }

    private void zc() {
        if (this.alz != null) {
            this.alA = (TbImageView) this.alz.findViewById(i.f.live_cover);
            ze();
        }
    }

    private void zd() {
        an.i((View) this.alB, i.e.bg_tieziyingxiang);
        an.i((View) this.alC, i.e.bg_tieziyingxiang);
        an.i((View) this.alD, i.e.bg_tieziyingxiang);
    }

    private void ze() {
        if (this.alz != null) {
            this.alB = (TextView) this.alz.findViewById(i.f.first_style_first_expression);
            this.alC = (TextView) this.alz.findViewById(i.f.first_style_second_expression);
            this.alD = (TextView) this.alz.findViewById(i.f.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.alJ.clear();
        zg();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            zf();
        }
    }

    private void zf() {
        if (this.alJ.size() != 0) {
            int size = this.alJ.size();
            for (int i = 0; i < size; i++) {
                if (this.alJ.get(i).intValue() == this.alB.getId()) {
                    this.alB.setVisibility(8);
                } else if (this.alJ.get(i).intValue() == this.alC.getId()) {
                    this.alC.setVisibility(8);
                } else if (this.alJ.get(i).intValue() == this.alD.getId()) {
                    this.alD.setVisibility(8);
                }
            }
        }
    }

    private void zg() {
        this.alB.setText("");
        this.alC.setText("");
        this.alD.setText("");
        this.alB.setVisibility(0);
        this.alC.setVisibility(0);
        this.alD.setVisibility(0);
        this.alJ.add(Integer.valueOf(this.alB.getId()));
        this.alJ.add(Integer.valueOf(this.alC.getId()));
        this.alJ.add(Integer.valueOf(this.alD.getId()));
    }

    private void a(o oVar, TextView textView) {
        if (oVar != null && textView != null) {
            if (!a(oVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(oVar.ak(oVar.getLabelName(), String.valueOf(oVar.yP())));
            dE(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void a(int i, ArrayList<o> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.alI) {
                case 0:
                    a((int) this.context.getResources().getDimension(i.d.ds80), (int) this.context.getResources().getDimension(i.d.ds280), this.alB);
                    a((int) this.context.getResources().getDimension(i.d.ds170), (int) this.context.getResources().getDimension(i.d.ds320), this.alC);
                    a((int) this.context.getResources().getDimension(i.d.ds200), (int) this.context.getResources().getDimension(i.d.ds60), this.alD);
                    break;
                case 1:
                    a((int) this.context.getResources().getDimension(i.d.ds60), (int) this.context.getResources().getDimension(i.d.ds120), this.alB);
                    a((int) this.context.getResources().getDimension(i.d.ds160), (int) this.context.getResources().getDimension(i.d.ds60), this.alC);
                    a((int) this.context.getResources().getDimension(i.d.ds220), (int) this.context.getResources().getDimension(i.d.ds320), this.alD);
                    break;
                case 2:
                    a((int) this.context.getResources().getDimension(i.d.ds60), (int) this.context.getResources().getDimension(i.d.ds240), this.alB);
                    a((int) this.context.getResources().getDimension(i.d.ds180), (int) this.context.getResources().getDimension(i.d.ds60), this.alC);
                    a((int) this.context.getResources().getDimension(i.d.ds220), (int) this.context.getResources().getDimension(i.d.ds320), this.alD);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.alB);
            } else if (i == 1) {
                a(arrayList.get(i2), this.alC);
            } else if (i == 2) {
                a(arrayList.get(i2), this.alD);
            }
        }
    }

    private void dE(int i) {
        if (this.alJ.size() != 0) {
            int size = this.alJ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.alJ.get(i2).intValue() == i) {
                    this.alJ.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(o oVar) {
        return (oVar == null || StringUtils.isNull(oVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.alA.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.alA.d(str, 10, false);
        } else {
            this.alA.d(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alF.setText("");
            return;
        }
        String trim = str.trim();
        this.alF.setVisibility(0);
        if (com.baidu.tbadk.util.n.fO(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.n.e(trim, 0, 12)) + "...";
        }
        this.alF.setText(as.dm(String.valueOf(trim) + TbadkCoreApplication.m411getInst().getResources().getString(i.h.bar)));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aly.setText("");
            this.aly.setVisibility(8);
            return;
        }
        this.aly.setVisibility(0);
        this.aly.setText(str);
    }

    private void setTitle(String str) {
        if (this.alK != 0) {
            this.alu.setPadding(0, 0, (int) this.context.getResources().getDimension(this.alK), 0);
            this.alK = 0;
        } else {
            this.alu.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.alu.setText("");
            return;
        }
        this.alu.setVisibility(0);
        if (this.alM) {
            this.alu.setText(d(str));
        } else {
            this.alu.setText(str);
        }
    }

    public static SpannableStringBuilder d(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cw = an.cw(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
        int height = cw.getHeight();
        bitmapDrawable.setBounds(0, 0, cw.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return as.a(spannableStringBuilder);
    }

    private void eu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.all.d(str, 12, false);
        } else {
            this.all.d(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aln.setText("");
            return;
        }
        this.aln.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.n.fO(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.n.e(trim, 0, 14)) + "...";
        }
        this.aln.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.alo, this.context.getResources().getString(i.h.fans_default_name));
        } else {
            b(this.alo, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = an.getDrawable(i.e.icon_fengsi_n);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.alp.setText(as.q(i));
    }

    private void setReplyNum(int i) {
        b(this.alq, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(as.q(j));
        Drawable drawable = an.getDrawable(i.e.icon_comment_n);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void f(int i, boolean z) {
        if (z) {
            this.alH.setVisibility(0);
            b(this.alH, i);
            return;
        }
        this.alH.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.alg) {
            this.alr.setVisibility(0);
            an.i((View) this.alr, i.e.label_onthelist);
            return;
        }
        this.alr.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.alf) {
            this.als.setVisibility(0);
            this.als.setText(str);
            return;
        }
        this.als.setVisibility(8);
        this.als.setText("");
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.alv.setVisibility(8);
            return;
        }
        this.alv.setVisibility(0);
        this.alv.setText(str);
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.alG.setVisibility(8);
            return;
        }
        this.alG.setVisibility(0);
        this.alG.setText(str);
    }

    public void setShowHead(boolean z) {
        this.akX = z;
    }

    public void setShowTitle(boolean z) {
        this.akY = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.ald = z;
    }

    public void setShowContent(boolean z) {
        this.akZ = z;
    }

    public void setShowCover(boolean z) {
        this.ala = z;
    }

    public void setShowExpression(boolean z) {
        this.alb = z;
    }

    public void setShowBottom(boolean z) {
        this.alc = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.alf = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.alg = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.alh = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.ali = z;
    }

    public void setChooseStyle(int i) {
        this.alI = i;
    }

    public int getShowStyle() {
        return this.alI;
    }

    public void setShowLiveIcon(boolean z) {
        this.alM = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.akV = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.akW = bVar;
    }

    public void setParentBackground(int i) {
        an.i(this.alj, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.alN = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.ale = z;
    }

    public void setTitlePaddingRight(int i) {
        this.alK = i;
    }

    public void setTitleMaxLines(int i) {
        this.alL = i;
    }

    public void setAllowGreyState(boolean z) {
        this.alO = z;
    }
}
