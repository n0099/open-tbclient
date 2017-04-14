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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int amZ;
    private boolean auA;
    private boolean auB;
    private LinearLayout auC;
    private View auD;
    private HeadImageView auE;
    private FrameLayout auF;
    private LinearLayout auG;
    private TextView auH;
    private TextView auI;
    private TextView auJ;
    private TextView auK;
    private TextView auL;
    private TextView auM;
    private LinearLayout auN;
    private TextView auO;
    private TextView auP;
    private TextView auQ;
    private LinearLayout auR;
    private TextView auS;
    private RelativeLayout auT;
    private TbImageView auU;
    private TextView auV;
    private TextView auW;
    private TextView auX;
    private RelativeLayout auY;
    private TextView auZ;
    private a auo;
    private b aup;
    private boolean auq;
    private boolean aur;
    private boolean aus;
    private boolean aut;
    private boolean auu;
    private boolean auv;
    private boolean auw;
    private boolean aux;
    private boolean auy;
    private boolean auz;
    private String avA;
    private TextView ava;
    private TextView avb;
    private TextView avc;
    private int avd;
    private ArrayList<Integer> ave;
    private int avf;
    private int avg;
    private boolean avh;
    private boolean avi;
    private boolean avj;
    private boolean avk;
    private int avl;
    private int avm;
    private int avn;
    private int avo;
    private int avp;
    private int avq;
    private int avr;
    private int avs;
    private int avt;
    private int avu;
    private int avv;
    private int avw;
    private int avx;
    private int avy;
    private int avz;
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
        this.auq = true;
        this.aur = true;
        this.aus = true;
        this.aut = true;
        this.auu = true;
        this.auv = true;
        this.auw = false;
        this.aux = false;
        this.auy = false;
        this.auz = false;
        this.auA = false;
        this.auB = false;
        this.avd = 0;
        this.ave = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.avf = 0;
        this.avg = 0;
        this.avh = false;
        this.avi = true;
        this.avj = false;
        this.avk = false;
        this.isGod = false;
        this.amZ = 3;
        this.padding = 0;
        this.avl = 0;
        this.avm = 0;
        this.avn = 0;
        this.avo = 0;
        this.avA = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(w.f.ds24);
        this.avm = (int) context.getResources().getDimension(w.f.ds100);
        this.avl = (int) context.getResources().getDimension(w.f.ds70);
        this.avn = (int) context.getResources().getDimension(w.f.ds18);
        this.avo = (int) context.getResources().getDimension(w.f.ds4);
        this.avp = (int) context.getResources().getDimension(w.f.ds80);
        this.avq = (int) context.getResources().getDimension(w.f.ds280);
        this.avr = (int) context.getResources().getDimension(w.f.ds170);
        this.avs = (int) context.getResources().getDimension(w.f.ds320);
        this.avt = (int) context.getResources().getDimension(w.f.ds200);
        this.avu = (int) context.getResources().getDimension(w.f.ds60);
        this.avv = (int) context.getResources().getDimension(w.f.ds120);
        this.avw = (int) context.getResources().getDimension(w.f.ds160);
        this.avx = (int) context.getResources().getDimension(w.f.ds220);
        this.avy = (int) context.getResources().getDimension(w.f.ds240);
        this.avz = (int) context.getResources().getDimension(w.f.ds180);
        this.size = (int) context.getResources().getDimension(w.f.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.j.photo_live_card_view, this);
        this.auC = (LinearLayout) inflate.findViewById(w.h.pl_card_root);
        this.auD = inflate.findViewById(w.h.author_info);
        this.auN = (LinearLayout) inflate.findViewById(w.h.photo_live_card_title);
        this.auR = (LinearLayout) inflate.findViewById(w.h.photo_live_card_content);
        this.auT = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_cover_and_expression);
        this.auY = (RelativeLayout) inflate.findViewById(w.h.photo_live_card_bottom);
        BD();
        BE();
        BF();
        BH();
        BG();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.auq, photoLiveCardData);
            b(this.aur, this.auw, photoLiveCardData);
            b(this.aus, photoLiveCardData);
            a(this.aut, this.auu, photoLiveCardData);
            a(this.auv, photoLiveCardData);
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
            if (z && this.avi) {
                if (this.paddingBottom != 0) {
                    this.auT.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auT.setPadding(this.padding, 0, this.padding, 0);
                }
                this.auT.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.auT != null) {
                this.auT.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auY.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                p(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.aux);
                i(photoLiveCardData.getDiscussNum(), this.auA);
                return;
            }
            this.auY.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auN.setVisibility(0);
                if (this.avg != 0) {
                    this.auO.setMaxLines(this.avg);
                } else {
                    this.auO.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                o(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.auO, photoLiveCardData.getThreadId());
                return;
            }
            this.auN.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.auB) {
            this.auQ.setVisibility(0);
            this.auQ.setTag(photoLiveCardData);
            return;
        }
        this.auQ.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auR.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.auR.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.auR.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.auS, photoLiveCardData.getThreadId());
                return;
            }
            this.auR.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.avj) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.qo(String.valueOf(j))) {
                aq.c(textView, w.e.cp_cont_c, 1);
            } else {
                aq.c(textView, w.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.auD.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.auD.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.auD.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.auE.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.avm;
                        layoutParams.width = this.avm;
                    }
                    if (this.avc == null) {
                        this.avc = new TextView(this.context);
                        this.avc.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.avc.setEllipsize(TextUtils.TruncateAt.END);
                        this.avc.setTextSize(0, this.avn);
                        aq.i(this.avc, w.e.cp_cont_h);
                        aq.j(this.avc, w.g.icon_shen);
                        this.avc.setSingleLine(true);
                        this.auG.addView(this.avc);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.avc.setText(w.l.god_intro_default);
                    } else {
                        this.avc.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.auG.removeView(this.avc);
                    this.avc = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.avl;
                        layoutParams.width = this.avl;
                    }
                }
                this.auE.setTag(photoLiveCardData);
                eI(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.auG.removeView(this.avc);
            this.auD.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.auE.setPadding(this.avo, this.avo, this.avo, this.avo);
            if (this.isGod) {
                this.auF.setBackgroundDrawable(aq.getDrawable(w.g.pic_bg_jinbian));
                return;
            } else {
                this.auF.setBackgroundDrawable(aq.getDrawable(w.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.auF.setBackgroundDrawable(null);
        this.auE.setPadding(0, 0, 0, 0);
    }

    private void BD() {
        if (this.auD != null) {
            this.auE = (HeadImageView) this.auD.findViewById(w.h.author_portrait);
            this.auF = (FrameLayout) this.auD.findViewById(w.h.author_portrait_info);
            this.auH = (TextView) this.auD.findViewById(w.h.author_name);
            this.auI = (TextView) this.auD.findViewById(w.h.nick_name);
            this.auJ = (TextView) this.auD.findViewById(w.h.fans_num);
            this.auK = (TextView) this.auD.findViewById(w.h.reply_num);
            this.auL = (TextView) this.auD.findViewById(w.h.headlive_icon);
            this.auM = (TextView) this.auD.findViewById(w.h.refresh_time_in_head);
            this.auG = (LinearLayout) this.auD.findViewById(w.h.author_info_and_time);
            this.auE.setOnClickListener(new s(this));
        }
    }

    private void BE() {
        if (this.auN != null) {
            this.auO = (TextView) this.auN.findViewById(w.h.title);
            this.auP = (TextView) findViewById(w.h.refresh_time_in_title);
            this.auQ = (TextView) this.auN.findViewById(w.h.card_delete_in_title);
            this.auQ.setOnClickListener(new t(this));
        }
    }

    private void BF() {
        if (this.auR != null) {
            this.auS = (TextView) this.auR.findViewById(w.h.content);
        }
    }

    private void BG() {
        if (this.auY != null) {
            this.auZ = (TextView) this.auY.findViewById(w.h.ba_name);
            this.ava = (TextView) this.auY.findViewById(w.h.bottom_refresh_time);
            this.avb = (TextView) this.auY.findViewById(w.h.bottom_reply_num);
        }
    }

    private void BH() {
        if (this.auT != null) {
            this.auU = (TbImageView) this.auT.findViewById(w.h.live_cover);
            this.auU.setGifIconSupport(false);
            BI();
        }
    }

    private void BI() {
        if (this.auT != null) {
            this.auV = (TextView) this.auT.findViewById(w.h.first_style_first_expression);
            this.auW = (TextView) this.auT.findViewById(w.h.first_style_second_expression);
            this.auX = (TextView) this.auT.findViewById(w.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.ave.clear();
        BK();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            BJ();
        }
    }

    private void BJ() {
        if (this.ave.size() != 0) {
            int size = this.ave.size();
            for (int i = 0; i < size; i++) {
                if (this.ave.get(i).intValue() == this.auV.getId()) {
                    this.auV.setVisibility(8);
                } else if (this.ave.get(i).intValue() == this.auW.getId()) {
                    this.auW.setVisibility(8);
                } else if (this.ave.get(i).intValue() == this.auX.getId()) {
                    this.auX.setVisibility(8);
                }
            }
        }
    }

    private void BK() {
        this.auV.setText("");
        this.auW.setText("");
        this.auX.setText("");
        if (this.auV.getVisibility() == 8) {
            this.auV.setVisibility(0);
        }
        if (this.auW.getVisibility() == 8) {
            this.auW.setVisibility(0);
        }
        if (this.auX.getVisibility() == 8) {
            this.auX.setVisibility(0);
        }
        this.ave.add(Integer.valueOf(this.auV.getId()));
        this.ave.add(Integer.valueOf(this.auW.getId()));
        this.ave.add(Integer.valueOf(this.auX.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.Bw())));
            ei(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void a(int i, ArrayList<n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.avd) {
                case 0:
                    a(this.avp, this.avq, this.auV);
                    a(this.avr, this.avs, this.auW);
                    a(this.avt, this.avu, this.auX);
                    break;
                case 1:
                    a(this.avu, this.avv, this.auV);
                    a(this.avw, this.avu, this.auW);
                    a(this.avx, this.avs, this.auX);
                    break;
                case 2:
                    a(this.avu, this.avy, this.auV);
                    a(this.avz, this.avu, this.auW);
                    a(this.avx, this.avs, this.auX);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.auV);
            } else if (i == 1) {
                a(arrayList.get(i2), this.auW);
            } else if (i == 2) {
                a(arrayList.get(i2), this.auX);
            }
        }
    }

    private void ei(int i) {
        if (this.ave.size() != 0) {
            int size = this.ave.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ave.get(i2).intValue() == i) {
                    this.ave.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.auU.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.auU.c(str, 10, false);
        } else {
            this.auU.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auZ.setText("");
            return;
        }
        String trim = str.trim();
        this.auZ.setVisibility(0);
        if (com.baidu.tbadk.util.u.gq(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 12)) + "...";
        }
        this.auZ.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(w.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auS.setText("");
            this.auS.setVisibility(8);
            return;
        }
        this.auS.setVisibility(0);
        this.auS.setText(str);
    }

    private void setTitle(String str) {
        this.avA = str;
        if (this.avf != 0) {
            this.auO.setPadding(0, 0, (int) this.context.getResources().getDimension(this.avf), 0);
            this.avf = 0;
        } else {
            this.auO.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.auO.setText("");
            return;
        }
        this.auO.setVisibility(0);
        if (this.avh) {
            if (this.avk) {
                this.auO.setText(at.c(this.context, str, w.l.photo_live_tips));
                return;
            } else {
                this.auO.setText(e(str));
                return;
            }
        }
        this.auO.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cO = aq.cO(w.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        int height = cO.getHeight();
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eI(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.auE.c(str, 12, false);
        } else {
            this.auE.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.auH.setText("");
            return;
        }
        this.auH.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.u.gq(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 14)) + "...";
        }
        this.auH.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.auI, this.context.getResources().getString(w.l.fans_default_name));
        } else {
            b(this.auI, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aq.getDrawable(w.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.auJ.setText(au.w(i));
    }

    private void setReplyNum(int i) {
        b(this.auK, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(au.w(j));
        Drawable drawable = aq.getDrawable(w.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.avb.setVisibility(0);
            b(this.avb, i);
            return;
        }
        this.avb.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.auz) {
            this.auL.setVisibility(0);
            aq.j(this.auL, w.g.label_onthelist);
            return;
        }
        this.auL.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.auy) {
            this.auM.setVisibility(0);
            this.auM.setText(str);
            return;
        }
        this.auM.setVisibility(8);
        this.auM.setText("");
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.auP.setVisibility(8);
            return;
        }
        this.auP.setVisibility(0);
        this.auP.setText(str);
    }

    private void p(String str, boolean z) {
        if (!z) {
            this.ava.setVisibility(8);
            return;
        }
        this.ava.setVisibility(0);
        this.ava.setText(str);
    }

    public void setShowHead(boolean z) {
        this.auq = z;
    }

    public void setShowTitle(boolean z) {
        this.aur = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.auw = z;
    }

    public void setShowContent(boolean z) {
        this.aus = z;
    }

    public void setShowCover(boolean z) {
        this.aut = z;
    }

    public void setShowExpression(boolean z) {
        this.auu = z;
    }

    public void setShowBottom(boolean z) {
        this.auv = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.auy = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.auz = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.auA = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.auB = z;
    }

    public void setChooseStyle(int i) {
        this.avd = i;
    }

    public int getShowStyle() {
        return this.avd;
    }

    public void setShowLiveIcon(boolean z) {
        this.avh = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.auo = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.aup = bVar;
    }

    public void setParentBackground(int i) {
        aq.j(this.auC, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.avi = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.aux = z;
    }

    public void setTitlePaddingRight(int i) {
        this.avf = i;
    }

    public void setTitleMaxLines(int i) {
        this.avg = i;
    }

    public void setAllowGreyState(boolean z) {
        this.avj = z;
    }

    public void bp(boolean z) {
        this.avk = z;
    }
}
