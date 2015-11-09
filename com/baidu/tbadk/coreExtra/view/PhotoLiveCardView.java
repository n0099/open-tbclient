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
    private TextView alA;
    private TextView alB;
    private LinearLayout alC;
    private TextView alD;
    private FrameLayout alE;
    private TbImageView alF;
    private TextView alG;
    private TextView alH;
    private TextView alI;
    private RelativeLayout alJ;
    private TextView alK;
    private TextView alL;
    private TextView alM;
    private int alN;
    private ArrayList<Integer> alO;
    private int alP;
    private int alQ;
    private boolean alR;
    private boolean alS;
    private boolean alT;
    private a ala;
    private b alb;
    private boolean alc;
    private boolean ald;
    private boolean ale;
    private boolean alf;
    private boolean alg;
    private boolean alh;
    private boolean ali;
    private boolean alj;
    private boolean alk;
    private boolean all;
    private boolean alm;
    private boolean aln;
    private LinearLayout alo;
    private LinearLayout alp;
    private HeadImageView alq;
    private FrameLayout alr;
    private TextView als;
    private TextView alt;
    private TextView alu;
    private TextView alv;
    private TextView alw;
    private TextView alx;
    private LinearLayout aly;
    private TextView alz;
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
        this.alc = true;
        this.ald = true;
        this.ale = true;
        this.alf = true;
        this.alg = true;
        this.alh = true;
        this.ali = false;
        this.alj = false;
        this.alk = false;
        this.all = false;
        this.alm = false;
        this.aln = false;
        this.alN = 0;
        this.alO = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alP = 0;
        this.alQ = 0;
        this.alR = false;
        this.alS = true;
        this.alT = false;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alc = true;
        this.ald = true;
        this.ale = true;
        this.alf = true;
        this.alg = true;
        this.alh = true;
        this.ali = false;
        this.alj = false;
        this.alk = false;
        this.all = false;
        this.alm = false;
        this.aln = false;
        this.alN = 0;
        this.alO = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alP = 0;
        this.alQ = 0;
        this.alR = false;
        this.alS = true;
        this.alT = false;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context) {
        super(context);
        this.alc = true;
        this.ald = true;
        this.ale = true;
        this.alf = true;
        this.alg = true;
        this.alh = true;
        this.ali = false;
        this.alj = false;
        this.alk = false;
        this.all = false;
        this.alm = false;
        this.aln = false;
        this.alN = 0;
        this.alO = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alP = 0;
        this.alQ = 0;
        this.alR = false;
        this.alS = true;
        this.alT = false;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i.g.photo_live_card_view, this);
        this.alo = (LinearLayout) inflate.findViewById(i.f.pl_card_root);
        this.alp = (LinearLayout) inflate.findViewById(i.f.photo_live_card_head);
        this.aly = (LinearLayout) inflate.findViewById(i.f.photo_live_card_title);
        this.alC = (LinearLayout) inflate.findViewById(i.f.photo_live_card_content);
        this.alE = (FrameLayout) inflate.findViewById(i.f.photo_live_card_cover_and_expression);
        this.alJ = (RelativeLayout) inflate.findViewById(i.f.photo_live_card_bottom);
        zd();
        ze();
        zf();
        zh();
        zg();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            an.i(this.alo, i.e.frs_item_control_btn_bg);
            c(this.alc, photoLiveCardData);
            b(this.ald, this.ali, photoLiveCardData);
            b(this.ale, photoLiveCardData);
            a(this.alf, this.alg, photoLiveCardData);
            a(this.alh, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.alS) {
                zi();
                if (this.paddingBottom != 0) {
                    this.alE.setPadding((int) this.context.getResources().getDimension(i.d.ds24), 0, (int) this.context.getResources().getDimension(i.d.ds24), (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                }
                this.alE.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.alE != null) {
                this.alE.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                an.b(this.alK, i.c.cp_cont_i, 1);
                an.i((View) this.alK, i.e.label_bg_tie);
                an.b(this.alL, i.c.cp_cont_d, 1);
                an.b(this.alM, i.c.cp_cont_d, 1);
                an.b(this.alK, i.c.cp_cont_i, 1);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.alj);
                f(photoLiveCardData.getDiscussNum(), this.alm);
                return;
            }
            this.alJ.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                if (this.alQ != 0) {
                    this.alz.setMaxLines(this.alQ);
                } else {
                    this.alz.setMaxLines(2);
                }
                an.b(this.alz, i.c.cp_cont_b, 1);
                an.b(this.alA, i.c.cp_cont_c, 1);
                an.b(this.alB, i.c.cp_cont_i, 1);
                an.i((View) this.alB, i.e.blacklist_remove_button_bg);
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.alz, photoLiveCardData.getThreadId());
                return;
            }
            this.aly.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.aln) {
            this.alB.setVisibility(0);
            this.alB.setTag(photoLiveCardData);
            return;
        }
        this.alB.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alC.setVisibility(0);
                int dimension = (int) this.context.getResources().getDimension(i.d.ds24);
                if (this.paddingBottom != 0) {
                    this.alC.setPadding(dimension, 0, dimension, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.alC.setPadding(dimension, 0, dimension, 0);
                }
                an.b(this.alD, i.c.cp_cont_b, 1);
                setContent(photoLiveCardData.getContent());
                a(this.alD, photoLiveCardData.getThreadId());
                return;
            }
            this.alC.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.alT) {
            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lR(String.valueOf(j))) {
                an.b(this.alD, i.c.cp_cont_c, 1);
            } else {
                an.b(this.alD, i.c.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alp.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.alp.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.alp.setPadding(0, 0, 0, 0);
                }
                an.b(this.als, i.c.cp_cont_f, 1);
                an.b(this.alt, i.c.cp_cont_d, 1);
                an.b(this.alu, i.c.cp_cont_d, 1);
                an.b(this.alv, i.c.cp_cont_d, 1);
                an.b(this.alx, i.c.cp_cont_d, 1);
                this.alq.setTag(photoLiveCardData);
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
            this.alp.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            int dimension = (int) this.context.getResources().getDimension(i.d.ds4);
            this.alq.setPadding(dimension, dimension, dimension, dimension);
            this.alr.setBackgroundDrawable(an.getDrawable(i.e.frs_touxiang_jinkuan));
            return;
        }
        this.alr.setBackgroundDrawable(null);
        this.alq.setPadding(0, 0, 0, 0);
    }

    private void zd() {
        if (this.alp != null) {
            this.alq = (HeadImageView) this.alp.findViewById(i.f.author_portrait);
            this.alr = (FrameLayout) this.alp.findViewById(i.f.author_portrait_info);
            this.als = (TextView) this.alp.findViewById(i.f.author_name);
            this.alt = (TextView) this.alp.findViewById(i.f.nick_name);
            this.alu = (TextView) this.alp.findViewById(i.f.fans_num);
            this.alv = (TextView) this.alp.findViewById(i.f.reply_num);
            this.alw = (TextView) this.alp.findViewById(i.f.headlive_icon);
            this.alx = (TextView) this.alp.findViewById(i.f.refresh_time_in_head);
            this.alq.setOnClickListener(new x(this));
        }
    }

    private void ze() {
        if (this.aly != null) {
            this.alz = (TextView) this.aly.findViewById(i.f.title);
            this.alA = (TextView) findViewById(i.f.refresh_time_in_title);
            this.alB = (TextView) this.aly.findViewById(i.f.card_delete_in_title);
            this.alB.setOnClickListener(new y(this));
        }
    }

    private void zf() {
        if (this.alC != null) {
            this.alD = (TextView) this.alC.findViewById(i.f.content);
        }
    }

    private void zg() {
        if (this.alJ != null) {
            this.alK = (TextView) this.alJ.findViewById(i.f.ba_name);
            this.alL = (TextView) this.alJ.findViewById(i.f.bottom_refresh_time);
            this.alM = (TextView) this.alJ.findViewById(i.f.bottom_reply_num);
        }
    }

    private void zh() {
        if (this.alE != null) {
            this.alF = (TbImageView) this.alE.findViewById(i.f.live_cover);
            zj();
        }
    }

    private void zi() {
        an.i((View) this.alG, i.e.bg_tieziyingxiang);
        an.i((View) this.alH, i.e.bg_tieziyingxiang);
        an.i((View) this.alI, i.e.bg_tieziyingxiang);
    }

    private void zj() {
        if (this.alE != null) {
            this.alG = (TextView) this.alE.findViewById(i.f.first_style_first_expression);
            this.alH = (TextView) this.alE.findViewById(i.f.first_style_second_expression);
            this.alI = (TextView) this.alE.findViewById(i.f.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.alO.clear();
        zl();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            zk();
        }
    }

    private void zk() {
        if (this.alO.size() != 0) {
            int size = this.alO.size();
            for (int i = 0; i < size; i++) {
                if (this.alO.get(i).intValue() == this.alG.getId()) {
                    this.alG.setVisibility(8);
                } else if (this.alO.get(i).intValue() == this.alH.getId()) {
                    this.alH.setVisibility(8);
                } else if (this.alO.get(i).intValue() == this.alI.getId()) {
                    this.alI.setVisibility(8);
                }
            }
        }
    }

    private void zl() {
        this.alG.setText("");
        this.alH.setText("");
        this.alI.setText("");
        this.alG.setVisibility(0);
        this.alH.setVisibility(0);
        this.alI.setVisibility(0);
        this.alO.add(Integer.valueOf(this.alG.getId()));
        this.alO.add(Integer.valueOf(this.alH.getId()));
        this.alO.add(Integer.valueOf(this.alI.getId()));
    }

    private void a(o oVar, TextView textView) {
        if (oVar != null && textView != null) {
            if (!a(oVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(oVar.ak(oVar.getLabelName(), String.valueOf(oVar.yU())));
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
            switch (this.alN) {
                case 0:
                    a((int) this.context.getResources().getDimension(i.d.ds80), (int) this.context.getResources().getDimension(i.d.ds280), this.alG);
                    a((int) this.context.getResources().getDimension(i.d.ds170), (int) this.context.getResources().getDimension(i.d.ds320), this.alH);
                    a((int) this.context.getResources().getDimension(i.d.ds200), (int) this.context.getResources().getDimension(i.d.ds60), this.alI);
                    break;
                case 1:
                    a((int) this.context.getResources().getDimension(i.d.ds60), (int) this.context.getResources().getDimension(i.d.ds120), this.alG);
                    a((int) this.context.getResources().getDimension(i.d.ds160), (int) this.context.getResources().getDimension(i.d.ds60), this.alH);
                    a((int) this.context.getResources().getDimension(i.d.ds220), (int) this.context.getResources().getDimension(i.d.ds320), this.alI);
                    break;
                case 2:
                    a((int) this.context.getResources().getDimension(i.d.ds60), (int) this.context.getResources().getDimension(i.d.ds240), this.alG);
                    a((int) this.context.getResources().getDimension(i.d.ds180), (int) this.context.getResources().getDimension(i.d.ds60), this.alH);
                    a((int) this.context.getResources().getDimension(i.d.ds220), (int) this.context.getResources().getDimension(i.d.ds320), this.alI);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.alG);
            } else if (i == 1) {
                a(arrayList.get(i2), this.alH);
            } else if (i == 2) {
                a(arrayList.get(i2), this.alI);
            }
        }
    }

    private void dE(int i) {
        if (this.alO.size() != 0) {
            int size = this.alO.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.alO.get(i2).intValue() == i) {
                    this.alO.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(o oVar) {
        return (oVar == null || StringUtils.isNull(oVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.alF.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.alF.d(str, 10, false);
        } else {
            this.alF.d(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alK.setText("");
            return;
        }
        String trim = str.trim();
        this.alK.setVisibility(0);
        if (com.baidu.tbadk.util.n.fQ(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.n.e(trim, 0, 12)) + "...";
        }
        this.alK.setText(as.dm(String.valueOf(trim) + TbadkCoreApplication.m411getInst().getResources().getString(i.h.bar)));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alD.setText("");
            this.alD.setVisibility(8);
            return;
        }
        this.alD.setVisibility(0);
        this.alD.setText(str);
    }

    private void setTitle(String str) {
        if (this.alP != 0) {
            this.alz.setPadding(0, 0, (int) this.context.getResources().getDimension(this.alP), 0);
            this.alP = 0;
        } else {
            this.alz.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.alz.setText("");
            return;
        }
        this.alz.setVisibility(0);
        if (this.alR) {
            this.alz.setText(d(str));
        } else {
            this.alz.setText(str);
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
            this.alq.d(str, 12, false);
        } else {
            this.alq.d(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.als.setText("");
            return;
        }
        this.als.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.n.fQ(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.n.e(trim, 0, 14)) + "...";
        }
        this.als.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.alt, this.context.getResources().getString(i.h.fans_default_name));
        } else {
            b(this.alt, str);
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
        this.alu.setText(as.q(i));
    }

    private void setReplyNum(int i) {
        b(this.alv, i);
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
            this.alM.setVisibility(0);
            b(this.alM, i);
            return;
        }
        this.alM.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.all) {
            this.alw.setVisibility(0);
            an.i((View) this.alw, i.e.label_onthelist);
            return;
        }
        this.alw.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.alk) {
            this.alx.setVisibility(0);
            this.alx.setText(str);
            return;
        }
        this.alx.setVisibility(8);
        this.alx.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.alA.setVisibility(8);
            return;
        }
        this.alA.setVisibility(0);
        this.alA.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.alL.setVisibility(8);
            return;
        }
        this.alL.setVisibility(0);
        this.alL.setText(str);
    }

    public void setShowHead(boolean z) {
        this.alc = z;
    }

    public void setShowTitle(boolean z) {
        this.ald = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.ali = z;
    }

    public void setShowContent(boolean z) {
        this.ale = z;
    }

    public void setShowCover(boolean z) {
        this.alf = z;
    }

    public void setShowExpression(boolean z) {
        this.alg = z;
    }

    public void setShowBottom(boolean z) {
        this.alh = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.alk = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.all = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.alm = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.aln = z;
    }

    public void setChooseStyle(int i) {
        this.alN = i;
    }

    public int getShowStyle() {
        return this.alN;
    }

    public void setShowLiveIcon(boolean z) {
        this.alR = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.ala = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.alb = bVar;
    }

    public void setParentBackground(int i) {
        an.i(this.alo, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.alS = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.alj = z;
    }

    public void setTitlePaddingRight(int i) {
        this.alP = i;
    }

    public void setTitleMaxLines(int i) {
        this.alQ = i;
    }

    public void setAllowGreyState(boolean z) {
        this.alT = z;
    }
}
