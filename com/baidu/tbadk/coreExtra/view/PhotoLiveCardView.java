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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    private a akU;
    private b akV;
    private boolean akW;
    private boolean akX;
    private boolean akY;
    private boolean akZ;
    private TextView alA;
    private TextView alB;
    private TextView alC;
    private RelativeLayout alD;
    private TextView alE;
    private TextView alF;
    private TextView alG;
    private int alH;
    private ArrayList<Integer> alI;
    private int alJ;
    private int alK;
    private boolean alL;
    private boolean alM;
    private boolean alN;
    private boolean ala;
    private boolean alb;
    private boolean alc;
    private boolean ald;
    private boolean ale;
    private boolean alf;
    private boolean alg;
    private boolean alh;
    private LinearLayout ali;
    private LinearLayout alj;
    private HeadImageView alk;
    private FrameLayout all;
    private TextView alm;
    private TextView aln;
    private TextView alo;
    private TextView alp;
    private TextView alq;
    private TextView alr;
    private LinearLayout als;
    private TextView alt;
    private TextView alu;
    private TextView alv;
    private LinearLayout alw;
    private TextView alx;
    private FrameLayout aly;
    private TbImageView alz;
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
        this.akW = true;
        this.akX = true;
        this.akY = true;
        this.akZ = true;
        this.ala = true;
        this.alb = true;
        this.alc = false;
        this.ald = false;
        this.ale = false;
        this.alf = false;
        this.alg = false;
        this.alh = false;
        this.alH = 0;
        this.alI = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alJ = 0;
        this.alK = 0;
        this.alL = false;
        this.alM = true;
        this.alN = false;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akW = true;
        this.akX = true;
        this.akY = true;
        this.akZ = true;
        this.ala = true;
        this.alb = true;
        this.alc = false;
        this.ald = false;
        this.ale = false;
        this.alf = false;
        this.alg = false;
        this.alh = false;
        this.alH = 0;
        this.alI = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alJ = 0;
        this.alK = 0;
        this.alL = false;
        this.alM = true;
        this.alN = false;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context) {
        super(context);
        this.akW = true;
        this.akX = true;
        this.akY = true;
        this.akZ = true;
        this.ala = true;
        this.alb = true;
        this.alc = false;
        this.ald = false;
        this.ale = false;
        this.alf = false;
        this.alg = false;
        this.alh = false;
        this.alH = 0;
        this.alI = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.alJ = 0;
        this.alK = 0;
        this.alL = false;
        this.alM = true;
        this.alN = false;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i.g.photo_live_card_view, this);
        this.ali = (LinearLayout) inflate.findViewById(i.f.pl_card_root);
        this.alj = (LinearLayout) inflate.findViewById(i.f.photo_live_card_head);
        this.als = (LinearLayout) inflate.findViewById(i.f.photo_live_card_title);
        this.alw = (LinearLayout) inflate.findViewById(i.f.photo_live_card_content);
        this.aly = (FrameLayout) inflate.findViewById(i.f.photo_live_card_cover_and_expression);
        this.alD = (RelativeLayout) inflate.findViewById(i.f.photo_live_card_bottom);
        zb();
        zc();
        zd();
        zf();
        ze();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            am.i(this.ali, i.e.frs_item_control_btn_bg);
            c(this.akW, photoLiveCardData);
            b(this.akX, this.alc, photoLiveCardData);
            b(this.akY, photoLiveCardData);
            a(this.akZ, this.ala, photoLiveCardData);
            a(this.alb, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.alM) {
                zg();
                if (this.paddingBottom != 0) {
                    this.aly.setPadding((int) this.context.getResources().getDimension(i.d.ds24), 0, (int) this.context.getResources().getDimension(i.d.ds24), (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                }
                this.aly.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.aly != null) {
                this.aly.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                am.b(this.alE, i.c.cp_cont_i, 1);
                am.i((View) this.alE, i.e.label_bg_tie);
                am.b(this.alF, i.c.cp_cont_d, 1);
                am.b(this.alG, i.c.cp_cont_d, 1);
                am.b(this.alE, i.c.cp_cont_i, 1);
                setBaName(photoLiveCardData.getForumName());
                o(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.ald);
                f(photoLiveCardData.getDiscussNum(), this.alg);
                return;
            }
            this.alD.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                if (this.alK != 0) {
                    this.alt.setMaxLines(this.alK);
                } else {
                    this.alt.setMaxLines(2);
                }
                am.b(this.alt, i.c.cp_cont_b, 1);
                am.b(this.alu, i.c.cp_cont_c, 1);
                am.b(this.alv, i.c.cp_cont_i, 1);
                am.i((View) this.alv, i.e.blacklist_remove_button_bg);
                setTitle(photoLiveCardData.getTitle());
                n(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.alt, photoLiveCardData.getThreadId());
                return;
            }
            this.als.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.alh) {
            this.alv.setVisibility(0);
            this.alv.setTag(photoLiveCardData);
            return;
        }
        this.alv.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alw.setVisibility(0);
                int dimension = (int) this.context.getResources().getDimension(i.d.ds24);
                if (this.paddingBottom != 0) {
                    this.alw.setPadding(dimension, 0, dimension, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.alw.setPadding(dimension, 0, dimension, 0);
                }
                am.b(this.alx, i.c.cp_cont_b, 1);
                setContent(photoLiveCardData.getContent());
                a(this.alx, photoLiveCardData.getThreadId());
                return;
            }
            this.alw.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.alN) {
            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lI(String.valueOf(j))) {
                am.b(this.alx, i.c.cp_cont_c, 1);
            } else {
                am.b(this.alx, i.c.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.alj.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.alj.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.alj.setPadding(0, 0, 0, 0);
                }
                am.b(this.alm, i.c.cp_cont_f, 1);
                am.b(this.aln, i.c.cp_cont_d, 1);
                am.b(this.alo, i.c.cp_cont_d, 1);
                am.b(this.alp, i.c.cp_cont_d, 1);
                am.b(this.alr, i.c.cp_cont_d, 1);
                this.alk.setTag(photoLiveCardData);
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
            this.alj.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            int dimension = (int) this.context.getResources().getDimension(i.d.ds4);
            this.alk.setPadding(dimension, dimension, dimension, dimension);
            this.all.setBackgroundDrawable(am.getDrawable(i.e.frs_touxiang_jinkuan));
            return;
        }
        this.all.setBackgroundDrawable(null);
        this.alk.setPadding(0, 0, 0, 0);
    }

    private void zb() {
        if (this.alj != null) {
            this.alk = (HeadImageView) this.alj.findViewById(i.f.author_portrait);
            this.all = (FrameLayout) this.alj.findViewById(i.f.author_portrait_info);
            this.alm = (TextView) this.alj.findViewById(i.f.author_name);
            this.aln = (TextView) this.alj.findViewById(i.f.nick_name);
            this.alo = (TextView) this.alj.findViewById(i.f.fans_num);
            this.alp = (TextView) this.alj.findViewById(i.f.reply_num);
            this.alq = (TextView) this.alj.findViewById(i.f.headlive_icon);
            this.alr = (TextView) this.alj.findViewById(i.f.refresh_time_in_head);
            this.alk.setOnClickListener(new x(this));
        }
    }

    private void zc() {
        if (this.als != null) {
            this.alt = (TextView) this.als.findViewById(i.f.title);
            this.alu = (TextView) findViewById(i.f.refresh_time_in_title);
            this.alv = (TextView) this.als.findViewById(i.f.card_delete_in_title);
            this.alv.setOnClickListener(new y(this));
        }
    }

    private void zd() {
        if (this.alw != null) {
            this.alx = (TextView) this.alw.findViewById(i.f.content);
        }
    }

    private void ze() {
        if (this.alD != null) {
            this.alE = (TextView) this.alD.findViewById(i.f.ba_name);
            this.alF = (TextView) this.alD.findViewById(i.f.bottom_refresh_time);
            this.alG = (TextView) this.alD.findViewById(i.f.bottom_reply_num);
        }
    }

    private void zf() {
        if (this.aly != null) {
            this.alz = (TbImageView) this.aly.findViewById(i.f.live_cover);
            zh();
        }
    }

    private void zg() {
        am.i((View) this.alA, i.e.bg_tieziyingxiang);
        am.i((View) this.alB, i.e.bg_tieziyingxiang);
        am.i((View) this.alC, i.e.bg_tieziyingxiang);
    }

    private void zh() {
        if (this.aly != null) {
            this.alA = (TextView) this.aly.findViewById(i.f.first_style_first_expression);
            this.alB = (TextView) this.aly.findViewById(i.f.first_style_second_expression);
            this.alC = (TextView) this.aly.findViewById(i.f.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.alI.clear();
        zj();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            zi();
        }
    }

    private void zi() {
        if (this.alI.size() != 0) {
            int size = this.alI.size();
            for (int i = 0; i < size; i++) {
                if (this.alI.get(i).intValue() == this.alA.getId()) {
                    this.alA.setVisibility(8);
                } else if (this.alI.get(i).intValue() == this.alB.getId()) {
                    this.alB.setVisibility(8);
                } else if (this.alI.get(i).intValue() == this.alC.getId()) {
                    this.alC.setVisibility(8);
                }
            }
        }
    }

    private void zj() {
        this.alA.setText("");
        this.alB.setText("");
        this.alC.setText("");
        this.alA.setVisibility(0);
        this.alB.setVisibility(0);
        this.alC.setVisibility(0);
        this.alI.add(Integer.valueOf(this.alA.getId()));
        this.alI.add(Integer.valueOf(this.alB.getId()));
        this.alI.add(Integer.valueOf(this.alC.getId()));
    }

    private void a(o oVar, TextView textView) {
        if (oVar != null && textView != null) {
            if (!a(oVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(oVar.ak(oVar.getLabelName(), String.valueOf(oVar.yS())));
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
            switch (this.alH) {
                case 0:
                    a((int) this.context.getResources().getDimension(i.d.ds80), (int) this.context.getResources().getDimension(i.d.ds280), this.alA);
                    a((int) this.context.getResources().getDimension(i.d.ds170), (int) this.context.getResources().getDimension(i.d.ds320), this.alB);
                    a((int) this.context.getResources().getDimension(i.d.ds200), (int) this.context.getResources().getDimension(i.d.ds60), this.alC);
                    break;
                case 1:
                    a((int) this.context.getResources().getDimension(i.d.ds60), (int) this.context.getResources().getDimension(i.d.ds120), this.alA);
                    a((int) this.context.getResources().getDimension(i.d.ds160), (int) this.context.getResources().getDimension(i.d.ds60), this.alB);
                    a((int) this.context.getResources().getDimension(i.d.ds220), (int) this.context.getResources().getDimension(i.d.ds320), this.alC);
                    break;
                case 2:
                    a((int) this.context.getResources().getDimension(i.d.ds60), (int) this.context.getResources().getDimension(i.d.ds240), this.alA);
                    a((int) this.context.getResources().getDimension(i.d.ds180), (int) this.context.getResources().getDimension(i.d.ds60), this.alB);
                    a((int) this.context.getResources().getDimension(i.d.ds220), (int) this.context.getResources().getDimension(i.d.ds320), this.alC);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.alA);
            } else if (i == 1) {
                a(arrayList.get(i2), this.alB);
            } else if (i == 2) {
                a(arrayList.get(i2), this.alC);
            }
        }
    }

    private void dE(int i) {
        if (this.alI.size() != 0) {
            int size = this.alI.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.alI.get(i2).intValue() == i) {
                    this.alI.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(o oVar) {
        return (oVar == null || StringUtils.isNull(oVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.alz.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.alz.d(str, 10, false);
        } else {
            this.alz.d(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alE.setText("");
            return;
        }
        String trim = str.trim();
        this.alE.setVisibility(0);
        if (com.baidu.tbadk.util.n.fO(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.n.e(trim, 0, 12)) + "...";
        }
        this.alE.setText(ar.dl(String.valueOf(trim) + TbadkCoreApplication.m411getInst().getResources().getString(i.h.bar)));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alx.setText("");
            this.alx.setVisibility(8);
            return;
        }
        this.alx.setVisibility(0);
        this.alx.setText(str);
    }

    private void setTitle(String str) {
        if (this.alJ != 0) {
            this.alt.setPadding(0, 0, (int) this.context.getResources().getDimension(this.alJ), 0);
            this.alJ = 0;
        } else {
            this.alt.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.alt.setText("");
            return;
        }
        this.alt.setVisibility(0);
        if (this.alL) {
            this.alt.setText(d(str));
        } else {
            this.alt.setText(str);
        }
    }

    public static SpannableStringBuilder d(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cw = am.cw(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cw);
        int height = cw.getHeight();
        bitmapDrawable.setBounds(0, 0, cw.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return ar.a(spannableStringBuilder);
    }

    private void eu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.alk.d(str, 12, false);
        } else {
            this.alk.d(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.alm.setText("");
            return;
        }
        this.alm.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.n.fO(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.n.e(trim, 0, 14)) + "...";
        }
        this.alm.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.aln, this.context.getResources().getString(i.h.fans_default_name));
        } else {
            b(this.aln, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = am.getDrawable(i.e.icon_fengsi_n);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.alo.setText(ar.s(i));
    }

    private void setReplyNum(int i) {
        b(this.alp, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(ar.s(j));
        Drawable drawable = am.getDrawable(i.e.icon_comment_n);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void f(int i, boolean z) {
        if (z) {
            this.alG.setVisibility(0);
            b(this.alG, i);
            return;
        }
        this.alG.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.alf) {
            this.alq.setVisibility(0);
            am.i((View) this.alq, i.e.label_onthelist);
            return;
        }
        this.alq.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.ale) {
            this.alr.setVisibility(0);
            this.alr.setText(str);
            return;
        }
        this.alr.setVisibility(8);
        this.alr.setText("");
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.alu.setVisibility(8);
            return;
        }
        this.alu.setVisibility(0);
        this.alu.setText(str);
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.alF.setVisibility(8);
            return;
        }
        this.alF.setVisibility(0);
        this.alF.setText(str);
    }

    public void setShowHead(boolean z) {
        this.akW = z;
    }

    public void setShowTitle(boolean z) {
        this.akX = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.alc = z;
    }

    public void setShowContent(boolean z) {
        this.akY = z;
    }

    public void setShowCover(boolean z) {
        this.akZ = z;
    }

    public void setShowExpression(boolean z) {
        this.ala = z;
    }

    public void setShowBottom(boolean z) {
        this.alb = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.ale = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.alf = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.alg = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.alh = z;
    }

    public void setChooseStyle(int i) {
        this.alH = i;
    }

    public int getShowStyle() {
        return this.alH;
    }

    public void setShowLiveIcon(boolean z) {
        this.alL = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.akU = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.akV = bVar;
    }

    public void setParentBackground(int i) {
        am.i(this.ali, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.alM = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.ald = z;
    }

    public void setTitlePaddingRight(int i) {
        this.alJ = i;
    }

    public void setTitleMaxLines(int i) {
        this.alK = i;
    }

    public void setAllowGreyState(boolean z) {
        this.alN = z;
    }
}
