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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int ait;
    private boolean akX;
    private boolean apA;
    private boolean apB;
    private boolean apC;
    private boolean apD;
    private boolean apE;
    private boolean apF;
    private boolean apG;
    private boolean apH;
    private LinearLayout apI;
    private View apJ;
    private HeadImageView apK;
    private FrameLayout apL;
    private LinearLayout apM;
    private TextView apN;
    private TextView apO;
    private TextView apP;
    private TextView apQ;
    private TextView apR;
    private TextView apS;
    private LinearLayout apT;
    private TextView apU;
    private TextView apV;
    private LinearLayout apW;
    private TextView apX;
    private RelativeLayout apY;
    private TbImageView apZ;
    private a apu;
    private b apv;
    private boolean apw;
    private boolean apx;
    private boolean apy;
    private boolean apz;
    private int aqA;
    private int aqB;
    private int aqC;
    private int aqD;
    private int aqE;
    private String aqF;
    private TextView aqa;
    private TextView aqb;
    private TextView aqc;
    private RelativeLayout aqd;
    private TextView aqe;
    private TextView aqf;
    private TextView aqg;
    private TextView aqh;
    private int aqi;
    private ArrayList<Integer> aqj;
    private int aqk;
    private int aql;
    private boolean aqm;
    private boolean aqn;
    private boolean aqo;
    private boolean aqp;
    private int aqq;
    private int aqr;
    private int aqs;
    private int aqt;
    private int aqu;
    private int aqv;
    private int aqw;
    private int aqx;
    private int aqy;
    private int aqz;
    private Context context;
    private int padding;
    private int paddingBottom;
    private int paddingTop;
    private int size;
    private TextView title;

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
        this.apw = true;
        this.apx = true;
        this.apy = true;
        this.apz = true;
        this.apA = true;
        this.apB = true;
        this.apC = false;
        this.apD = false;
        this.apE = false;
        this.apF = false;
        this.apG = false;
        this.apH = false;
        this.aqi = 0;
        this.aqj = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.aqk = 0;
        this.aql = 0;
        this.aqm = false;
        this.aqn = true;
        this.aqo = false;
        this.aqp = false;
        this.akX = false;
        this.ait = 3;
        this.padding = 0;
        this.aqq = 0;
        this.aqr = 0;
        this.aqs = 0;
        this.aqt = 0;
        this.aqF = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(t.e.ds24);
        this.aqr = (int) context.getResources().getDimension(t.e.ds100);
        this.aqq = (int) context.getResources().getDimension(t.e.ds70);
        this.aqs = (int) context.getResources().getDimension(t.e.ds18);
        this.aqt = (int) context.getResources().getDimension(t.e.ds4);
        this.aqu = (int) context.getResources().getDimension(t.e.ds80);
        this.aqv = (int) context.getResources().getDimension(t.e.ds280);
        this.aqw = (int) context.getResources().getDimension(t.e.ds170);
        this.aqx = (int) context.getResources().getDimension(t.e.ds320);
        this.aqy = (int) context.getResources().getDimension(t.e.ds200);
        this.aqz = (int) context.getResources().getDimension(t.e.ds60);
        this.aqA = (int) context.getResources().getDimension(t.e.ds120);
        this.aqB = (int) context.getResources().getDimension(t.e.ds160);
        this.aqC = (int) context.getResources().getDimension(t.e.ds220);
        this.aqD = (int) context.getResources().getDimension(t.e.ds240);
        this.aqE = (int) context.getResources().getDimension(t.e.ds180);
        this.size = (int) context.getResources().getDimension(t.e.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(t.h.photo_live_card_view, this);
        this.apI = (LinearLayout) inflate.findViewById(t.g.pl_card_root);
        this.apJ = inflate.findViewById(t.g.author_info);
        this.apT = (LinearLayout) inflate.findViewById(t.g.photo_live_card_title);
        this.apW = (LinearLayout) inflate.findViewById(t.g.photo_live_card_content);
        this.apY = (RelativeLayout) inflate.findViewById(t.g.photo_live_card_cover_and_expression);
        this.aqd = (RelativeLayout) inflate.findViewById(t.g.photo_live_card_bottom);
        AT();
        AU();
        AV();
        AX();
        AW();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.apw, photoLiveCardData);
            b(this.apx, this.apC, photoLiveCardData);
            b(this.apy, photoLiveCardData);
            a(this.apz, this.apA, photoLiveCardData);
            a(this.apB, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.akX = true;
        } else {
            this.akX = false;
        }
    }

    public void wq() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ait) {
            av.k(this.apI, t.f.frs_item_control_btn_bg);
            if (this.apw) {
                av.c(this.apN, t.d.cp_cont_f, 1);
                av.c(this.apO, t.d.cp_cont_d, 1);
                av.c(this.apP, t.d.cp_cont_d, 1);
                av.c(this.apQ, t.d.cp_cont_d, 1);
                av.c(this.apS, t.d.cp_cont_d, 1);
                Drawable drawable = av.getDrawable(t.f.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.apO.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = av.getDrawable(t.f.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.apQ.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.apx) {
                av.c(this.title, t.d.cp_cont_b, 1);
                av.c(this.apU, t.d.cp_cont_c, 1);
                av.c(this.apV, t.d.cp_cont_i, 1);
                av.k(this.apV, t.f.blacklist_remove_button_bg);
                this.title.setText(e(this.aqF));
            }
            if (this.apB) {
                av.c(this.aqe, t.d.cp_cont_i, 1);
                av.k(this.aqe, t.f.label_bg_tie);
                av.c(this.aqf, t.d.cp_cont_d, 1);
                av.c(this.aqg, t.d.cp_cont_d, 1);
                av.c(this.aqe, t.d.cp_cont_i, 1);
            }
            av.c(this.apX, t.d.cp_cont_b, 1);
            AY();
            this.ait = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.aqn) {
                if (this.paddingBottom != 0) {
                    this.apY.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.apY.setPadding(this.padding, 0, this.padding, 0);
                }
                this.apY.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.apY != null) {
                this.apY.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aqd.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                o(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.apD);
                i(photoLiveCardData.getDiscussNum(), this.apG);
                return;
            }
            this.aqd.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apT.setVisibility(0);
                if (this.aql != 0) {
                    this.title.setMaxLines(this.aql);
                } else {
                    this.title.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                n(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.title, photoLiveCardData.getThreadId());
                return;
            }
            this.apT.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.apH) {
            this.apV.setVisibility(0);
            this.apV.setTag(photoLiveCardData);
            return;
        }
        this.apV.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apW.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.apW.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.apW.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.apX, photoLiveCardData.getThreadId());
                return;
            }
            this.apW.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.aqo) {
            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rf(String.valueOf(j))) {
                av.c(textView, t.d.cp_cont_c, 1);
            } else {
                av.c(textView, t.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.apJ.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.apJ.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.apJ.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.apK.getLayoutParams();
                if (this.akX) {
                    if (layoutParams != null) {
                        layoutParams.height = this.aqr;
                        layoutParams.width = this.aqr;
                    }
                    if (this.aqh == null) {
                        this.aqh = new TextView(this.context);
                        this.aqh.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.aqh.setEllipsize(TextUtils.TruncateAt.END);
                        this.aqh.setTextSize(0, this.aqs);
                        av.j((View) this.aqh, t.d.cp_cont_h);
                        av.k(this.aqh, t.f.icon_shen);
                        this.aqh.setSingleLine(true);
                        this.apM.addView(this.aqh);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.aqh.setText(t.j.god_intro_default);
                    } else {
                        this.aqh.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.apM.removeView(this.aqh);
                    this.aqh = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.aqq;
                        layoutParams.width = this.aqq;
                    }
                }
                this.apK.setTag(photoLiveCardData);
                eP(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.apM.removeView(this.aqh);
            this.apJ.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.apK.setPadding(this.aqt, this.aqt, this.aqt, this.aqt);
            if (this.akX) {
                this.apL.setBackgroundDrawable(av.getDrawable(t.f.pic_bg_jinbian));
                return;
            } else {
                this.apL.setBackgroundDrawable(av.getDrawable(t.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.apL.setBackgroundDrawable(null);
        this.apK.setPadding(0, 0, 0, 0);
    }

    private void AT() {
        if (this.apJ != null) {
            this.apK = (HeadImageView) this.apJ.findViewById(t.g.author_portrait);
            this.apL = (FrameLayout) this.apJ.findViewById(t.g.author_portrait_info);
            this.apN = (TextView) this.apJ.findViewById(t.g.author_name);
            this.apO = (TextView) this.apJ.findViewById(t.g.nick_name);
            this.apP = (TextView) this.apJ.findViewById(t.g.fans_num);
            this.apQ = (TextView) this.apJ.findViewById(t.g.reply_num);
            this.apR = (TextView) this.apJ.findViewById(t.g.headlive_icon);
            this.apS = (TextView) this.apJ.findViewById(t.g.refresh_time_in_head);
            this.apM = (LinearLayout) this.apJ.findViewById(t.g.author_info_and_time);
            this.apK.setOnClickListener(new s(this));
        }
    }

    private void AU() {
        if (this.apT != null) {
            this.title = (TextView) this.apT.findViewById(t.g.title);
            this.apU = (TextView) findViewById(t.g.refresh_time_in_title);
            this.apV = (TextView) this.apT.findViewById(t.g.card_delete_in_title);
            this.apV.setOnClickListener(new t(this));
        }
    }

    private void AV() {
        if (this.apW != null) {
            this.apX = (TextView) this.apW.findViewById(t.g.content);
        }
    }

    private void AW() {
        if (this.aqd != null) {
            this.aqe = (TextView) this.aqd.findViewById(t.g.ba_name);
            this.aqf = (TextView) this.aqd.findViewById(t.g.bottom_refresh_time);
            this.aqg = (TextView) this.aqd.findViewById(t.g.bottom_reply_num);
        }
    }

    private void AX() {
        if (this.apY != null) {
            this.apZ = (TbImageView) this.apY.findViewById(t.g.live_cover);
            this.apZ.setGifIconSupport(false);
            AZ();
        }
    }

    private void AY() {
        av.k(this.aqa, t.f.bg_tieziyingxiang);
        av.k(this.aqb, t.f.bg_tieziyingxiang);
        av.k(this.aqc, t.f.bg_tieziyingxiang);
    }

    private void AZ() {
        if (this.apY != null) {
            this.aqa = (TextView) this.apY.findViewById(t.g.first_style_first_expression);
            this.aqb = (TextView) this.apY.findViewById(t.g.first_style_second_expression);
            this.aqc = (TextView) this.apY.findViewById(t.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.aqj.clear();
        Bb();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Ba();
        }
    }

    private void Ba() {
        if (this.aqj.size() != 0) {
            int size = this.aqj.size();
            for (int i = 0; i < size; i++) {
                if (this.aqj.get(i).intValue() == this.aqa.getId()) {
                    this.aqa.setVisibility(8);
                } else if (this.aqj.get(i).intValue() == this.aqb.getId()) {
                    this.aqb.setVisibility(8);
                } else if (this.aqj.get(i).intValue() == this.aqc.getId()) {
                    this.aqc.setVisibility(8);
                }
            }
        }
    }

    private void Bb() {
        this.aqa.setText("");
        this.aqb.setText("");
        this.aqc.setText("");
        if (this.aqa.getVisibility() == 8) {
            this.aqa.setVisibility(0);
        }
        if (this.aqb.getVisibility() == 8) {
            this.aqb.setVisibility(0);
        }
        if (this.aqc.getVisibility() == 8) {
            this.aqc.setVisibility(0);
        }
        this.aqj.add(Integer.valueOf(this.aqa.getId()));
        this.aqj.add(Integer.valueOf(this.aqb.getId()));
        this.aqj.add(Integer.valueOf(this.aqc.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.AM())));
            eg(textView.getId());
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
            switch (this.aqi) {
                case 0:
                    a(this.aqu, this.aqv, this.aqa);
                    a(this.aqw, this.aqx, this.aqb);
                    a(this.aqy, this.aqz, this.aqc);
                    break;
                case 1:
                    a(this.aqz, this.aqA, this.aqa);
                    a(this.aqB, this.aqz, this.aqb);
                    a(this.aqC, this.aqx, this.aqc);
                    break;
                case 2:
                    a(this.aqz, this.aqD, this.aqa);
                    a(this.aqE, this.aqz, this.aqb);
                    a(this.aqC, this.aqx, this.aqc);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.aqa);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aqb);
            } else if (i == 2) {
                a(arrayList.get(i2), this.aqc);
            }
        }
    }

    private void eg(int i) {
        if (this.aqj.size() != 0) {
            int size = this.aqj.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aqj.get(i2).intValue() == i) {
                    this.aqj.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.apZ.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.apZ.c(str, 10, false);
        } else {
            this.apZ.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aqe.setText("");
            return;
        }
        String trim = str.trim();
        this.aqe.setVisibility(0);
        if (com.baidu.tbadk.util.v.gz(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.v.d(trim, 0, 12)) + "...";
        }
        this.aqe.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(t.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apX.setText("");
            this.apX.setVisibility(8);
            return;
        }
        this.apX.setVisibility(0);
        this.apX.setText(str);
    }

    private void setTitle(String str) {
        this.aqF = str;
        if (this.aqk != 0) {
            this.title.setPadding(0, 0, (int) this.context.getResources().getDimension(this.aqk), 0);
            this.aqk = 0;
        } else {
            this.title.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.title.setText("");
            return;
        }
        this.title.setVisibility(0);
        if (this.aqm) {
            if (this.aqp) {
                this.title.setText(ap.c(this.context, str, t.j.kn_zhibo));
                return;
            } else {
                this.title.setText(e(str));
                return;
            }
        }
        this.title.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cN = av.cN(t.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
        int height = cN.getHeight();
        bitmapDrawable.setBounds(0, 0, cN.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eP(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.apK.c(str, 12, false);
        } else {
            this.apK.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.apN.setText("");
            return;
        }
        this.apN.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.v.gz(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.v.d(trim, 0, 14)) + "...";
        }
        this.apN.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            d(this.apO, this.context.getResources().getString(t.j.fans_default_name));
        } else {
            d(this.apO, str);
        }
    }

    private void d(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = av.getDrawable(t.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.apP.setText(ba.y(i));
    }

    private void setReplyNum(int i) {
        b(this.apQ, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(ba.y(j));
        Drawable drawable = av.getDrawable(t.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.aqg.setVisibility(0);
            b(this.aqg, i);
            return;
        }
        this.aqg.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.apF) {
            this.apR.setVisibility(0);
            av.k(this.apR, t.f.label_onthelist);
            return;
        }
        this.apR.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.apE) {
            this.apS.setVisibility(0);
            this.apS.setText(str);
            return;
        }
        this.apS.setVisibility(8);
        this.apS.setText("");
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.apU.setVisibility(8);
            return;
        }
        this.apU.setVisibility(0);
        this.apU.setText(str);
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.aqf.setVisibility(8);
            return;
        }
        this.aqf.setVisibility(0);
        this.aqf.setText(str);
    }

    public void setShowHead(boolean z) {
        this.apw = z;
    }

    public void setShowTitle(boolean z) {
        this.apx = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.apC = z;
    }

    public void setShowContent(boolean z) {
        this.apy = z;
    }

    public void setShowCover(boolean z) {
        this.apz = z;
    }

    public void setShowExpression(boolean z) {
        this.apA = z;
    }

    public void setShowBottom(boolean z) {
        this.apB = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.apE = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.apF = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.apG = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.apH = z;
    }

    public void setChooseStyle(int i) {
        this.aqi = i;
    }

    public int getShowStyle() {
        return this.aqi;
    }

    public void setShowLiveIcon(boolean z) {
        this.aqm = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.apu = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.apv = bVar;
    }

    public void setParentBackground(int i) {
        av.k(this.apI, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.aqn = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.apD = z;
    }

    public void setTitlePaddingRight(int i) {
        this.aqk = i;
    }

    public void setTitleMaxLines(int i) {
        this.aql = i;
    }

    public void setAllowGreyState(boolean z) {
        this.aqo = z;
    }

    public void bl(boolean z) {
        this.aqp = z;
    }
}
