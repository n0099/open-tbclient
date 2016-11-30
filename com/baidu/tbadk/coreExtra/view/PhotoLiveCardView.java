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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.an;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aiA;
    private a apW;
    private b apX;
    private boolean apY;
    private boolean apZ;
    private RelativeLayout aqA;
    private TbImageView aqB;
    private TextView aqC;
    private TextView aqD;
    private TextView aqE;
    private RelativeLayout aqF;
    private TextView aqG;
    private TextView aqH;
    private TextView aqI;
    private TextView aqJ;
    private int aqK;
    private ArrayList<Integer> aqL;
    private int aqM;
    private int aqN;
    private boolean aqO;
    private boolean aqP;
    private boolean aqQ;
    private boolean aqR;
    private int aqS;
    private int aqT;
    private int aqU;
    private int aqV;
    private int aqW;
    private int aqX;
    private int aqY;
    private int aqZ;
    private boolean aqa;
    private boolean aqb;
    private boolean aqc;
    private boolean aqd;
    private boolean aqe;
    private boolean aqf;
    private boolean aqg;
    private boolean aqh;
    private boolean aqi;
    private boolean aqj;
    private LinearLayout aqk;
    private View aql;
    private HeadImageView aqm;
    private FrameLayout aqn;
    private LinearLayout aqo;
    private TextView aqp;
    private TextView aqq;
    private TextView aqr;
    private TextView aqs;
    private TextView aqt;
    private TextView aqu;
    private LinearLayout aqv;
    private TextView aqw;
    private TextView aqx;
    private LinearLayout aqy;
    private TextView aqz;
    private int ara;
    private int arb;
    private int arc;
    private int ard;
    private int are;
    private int arf;
    private int arg;
    private String arh;
    private Context context;
    private boolean isGod;
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
        this.apY = true;
        this.apZ = true;
        this.aqa = true;
        this.aqb = true;
        this.aqc = true;
        this.aqd = true;
        this.aqe = false;
        this.aqf = false;
        this.aqg = false;
        this.aqh = false;
        this.aqi = false;
        this.aqj = false;
        this.aqK = 0;
        this.aqL = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.aqM = 0;
        this.aqN = 0;
        this.aqO = false;
        this.aqP = true;
        this.aqQ = false;
        this.aqR = false;
        this.isGod = false;
        this.aiA = 3;
        this.padding = 0;
        this.aqS = 0;
        this.aqT = 0;
        this.aqU = 0;
        this.aqV = 0;
        this.arh = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(r.e.ds24);
        this.aqT = (int) context.getResources().getDimension(r.e.ds100);
        this.aqS = (int) context.getResources().getDimension(r.e.ds70);
        this.aqU = (int) context.getResources().getDimension(r.e.ds18);
        this.aqV = (int) context.getResources().getDimension(r.e.ds4);
        this.aqW = (int) context.getResources().getDimension(r.e.ds80);
        this.aqX = (int) context.getResources().getDimension(r.e.ds280);
        this.aqY = (int) context.getResources().getDimension(r.e.ds170);
        this.aqZ = (int) context.getResources().getDimension(r.e.ds320);
        this.ara = (int) context.getResources().getDimension(r.e.ds200);
        this.arb = (int) context.getResources().getDimension(r.e.ds60);
        this.arc = (int) context.getResources().getDimension(r.e.ds120);
        this.ard = (int) context.getResources().getDimension(r.e.ds160);
        this.are = (int) context.getResources().getDimension(r.e.ds220);
        this.arf = (int) context.getResources().getDimension(r.e.ds240);
        this.arg = (int) context.getResources().getDimension(r.e.ds180);
        this.size = (int) context.getResources().getDimension(r.e.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(r.h.photo_live_card_view, this);
        this.aqk = (LinearLayout) inflate.findViewById(r.g.pl_card_root);
        this.aql = inflate.findViewById(r.g.author_info);
        this.aqv = (LinearLayout) inflate.findViewById(r.g.photo_live_card_title);
        this.aqy = (LinearLayout) inflate.findViewById(r.g.photo_live_card_content);
        this.aqA = (RelativeLayout) inflate.findViewById(r.g.photo_live_card_cover_and_expression);
        this.aqF = (RelativeLayout) inflate.findViewById(r.g.photo_live_card_bottom);
        Bd();
        Be();
        Bf();
        Bh();
        Bg();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.apY, photoLiveCardData);
            b(this.apZ, this.aqe, photoLiveCardData);
            b(this.aqa, photoLiveCardData);
            a(this.aqb, this.aqc, photoLiveCardData);
            a(this.aqd, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.isGod = true;
        } else {
            this.isGod = false;
        }
    }

    public void wM() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aiA) {
            at.k(this.aqk, r.f.frs_item_control_btn_bg);
            if (this.apY) {
                at.c(this.aqp, r.d.cp_cont_f, 1);
                at.c(this.aqq, r.d.cp_cont_d, 1);
                at.c(this.aqr, r.d.cp_cont_d, 1);
                at.c(this.aqs, r.d.cp_cont_d, 1);
                at.c(this.aqu, r.d.cp_cont_d, 1);
                Drawable drawable = at.getDrawable(r.f.icon_fengsi_n);
                if (drawable != null) {
                    drawable.setBounds(0, 0, this.size, this.size);
                }
                this.aqq.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                Drawable drawable2 = at.getDrawable(r.f.icon_comment_n);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, this.size, this.size);
                }
                this.aqs.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (this.apZ) {
                at.c(this.title, r.d.cp_cont_b, 1);
                at.c(this.aqw, r.d.cp_cont_c, 1);
                at.c(this.aqx, r.d.cp_cont_i, 1);
                at.k(this.aqx, r.f.blacklist_remove_button_bg);
                this.title.setText(e(this.arh));
            }
            if (this.aqd) {
                at.c(this.aqG, r.d.cp_cont_i, 1);
                at.k(this.aqG, r.f.label_bg_tie);
                at.c(this.aqH, r.d.cp_cont_d, 1);
                at.c(this.aqI, r.d.cp_cont_d, 1);
                at.c(this.aqG, r.d.cp_cont_i, 1);
            }
            at.c(this.aqz, r.d.cp_cont_b, 1);
            Bi();
            this.aiA = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.aqP) {
                if (this.paddingBottom != 0) {
                    this.aqA.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.aqA.setPadding(this.padding, 0, this.padding, 0);
                }
                this.aqA.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.aqA != null) {
                this.aqA.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aqF.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                p(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.aqf);
                i(photoLiveCardData.getDiscussNum(), this.aqi);
                return;
            }
            this.aqF.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aqv.setVisibility(0);
                if (this.aqN != 0) {
                    this.title.setMaxLines(this.aqN);
                } else {
                    this.title.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                o(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.title, photoLiveCardData.getThreadId());
                return;
            }
            this.aqv.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.aqj) {
            this.aqx.setVisibility(0);
            this.aqx.setTag(photoLiveCardData);
            return;
        }
        this.aqx.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aqy.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.aqy.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.aqy.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.aqz, photoLiveCardData.getThreadId());
                return;
            }
            this.aqy.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.aqQ) {
            com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rP(String.valueOf(j))) {
                at.c(textView, r.d.cp_cont_c, 1);
            } else {
                at.c(textView, r.d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aql.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.aql.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.aql.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.aqm.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.aqT;
                        layoutParams.width = this.aqT;
                    }
                    if (this.aqJ == null) {
                        this.aqJ = new TextView(this.context);
                        this.aqJ.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.aqJ.setEllipsize(TextUtils.TruncateAt.END);
                        this.aqJ.setTextSize(0, this.aqU);
                        at.j((View) this.aqJ, r.d.cp_cont_h);
                        at.k(this.aqJ, r.f.icon_shen);
                        this.aqJ.setSingleLine(true);
                        this.aqo.addView(this.aqJ);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.aqJ.setText(r.j.god_intro_default);
                    } else {
                        this.aqJ.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.aqo.removeView(this.aqJ);
                    this.aqJ = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.aqS;
                        layoutParams.width = this.aqS;
                    }
                }
                this.aqm.setTag(photoLiveCardData);
                eU(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.aqo.removeView(this.aqJ);
            this.aql.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.aqm.setPadding(this.aqV, this.aqV, this.aqV, this.aqV);
            if (this.isGod) {
                this.aqn.setBackgroundDrawable(at.getDrawable(r.f.pic_bg_jinbian));
                return;
            } else {
                this.aqn.setBackgroundDrawable(at.getDrawable(r.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.aqn.setBackgroundDrawable(null);
        this.aqm.setPadding(0, 0, 0, 0);
    }

    private void Bd() {
        if (this.aql != null) {
            this.aqm = (HeadImageView) this.aql.findViewById(r.g.author_portrait);
            this.aqn = (FrameLayout) this.aql.findViewById(r.g.author_portrait_info);
            this.aqp = (TextView) this.aql.findViewById(r.g.author_name);
            this.aqq = (TextView) this.aql.findViewById(r.g.nick_name);
            this.aqr = (TextView) this.aql.findViewById(r.g.fans_num);
            this.aqs = (TextView) this.aql.findViewById(r.g.reply_num);
            this.aqt = (TextView) this.aql.findViewById(r.g.headlive_icon);
            this.aqu = (TextView) this.aql.findViewById(r.g.refresh_time_in_head);
            this.aqo = (LinearLayout) this.aql.findViewById(r.g.author_info_and_time);
            this.aqm.setOnClickListener(new s(this));
        }
    }

    private void Be() {
        if (this.aqv != null) {
            this.title = (TextView) this.aqv.findViewById(r.g.title);
            this.aqw = (TextView) findViewById(r.g.refresh_time_in_title);
            this.aqx = (TextView) this.aqv.findViewById(r.g.card_delete_in_title);
            this.aqx.setOnClickListener(new t(this));
        }
    }

    private void Bf() {
        if (this.aqy != null) {
            this.aqz = (TextView) this.aqy.findViewById(r.g.content);
        }
    }

    private void Bg() {
        if (this.aqF != null) {
            this.aqG = (TextView) this.aqF.findViewById(r.g.ba_name);
            this.aqH = (TextView) this.aqF.findViewById(r.g.bottom_refresh_time);
            this.aqI = (TextView) this.aqF.findViewById(r.g.bottom_reply_num);
        }
    }

    private void Bh() {
        if (this.aqA != null) {
            this.aqB = (TbImageView) this.aqA.findViewById(r.g.live_cover);
            this.aqB.setGifIconSupport(false);
            Bj();
        }
    }

    private void Bi() {
        at.k(this.aqC, r.f.bg_tieziyingxiang);
        at.k(this.aqD, r.f.bg_tieziyingxiang);
        at.k(this.aqE, r.f.bg_tieziyingxiang);
    }

    private void Bj() {
        if (this.aqA != null) {
            this.aqC = (TextView) this.aqA.findViewById(r.g.first_style_first_expression);
            this.aqD = (TextView) this.aqA.findViewById(r.g.first_style_second_expression);
            this.aqE = (TextView) this.aqA.findViewById(r.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.aqL.clear();
        Bl();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Bk();
        }
    }

    private void Bk() {
        if (this.aqL.size() != 0) {
            int size = this.aqL.size();
            for (int i = 0; i < size; i++) {
                if (this.aqL.get(i).intValue() == this.aqC.getId()) {
                    this.aqC.setVisibility(8);
                } else if (this.aqL.get(i).intValue() == this.aqD.getId()) {
                    this.aqD.setVisibility(8);
                } else if (this.aqL.get(i).intValue() == this.aqE.getId()) {
                    this.aqE.setVisibility(8);
                }
            }
        }
    }

    private void Bl() {
        this.aqC.setText("");
        this.aqD.setText("");
        this.aqE.setText("");
        if (this.aqC.getVisibility() == 8) {
            this.aqC.setVisibility(0);
        }
        if (this.aqD.getVisibility() == 8) {
            this.aqD.setVisibility(0);
        }
        if (this.aqE.getVisibility() == 8) {
            this.aqE.setVisibility(0);
        }
        this.aqL.add(Integer.valueOf(this.aqC.getId()));
        this.aqL.add(Integer.valueOf(this.aqD.getId()));
        this.aqL.add(Integer.valueOf(this.aqE.getId()));
    }

    private void a(n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.AW())));
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
            switch (this.aqK) {
                case 0:
                    a(this.aqW, this.aqX, this.aqC);
                    a(this.aqY, this.aqZ, this.aqD);
                    a(this.ara, this.arb, this.aqE);
                    break;
                case 1:
                    a(this.arb, this.arc, this.aqC);
                    a(this.ard, this.arb, this.aqD);
                    a(this.are, this.aqZ, this.aqE);
                    break;
                case 2:
                    a(this.arb, this.arf, this.aqC);
                    a(this.arg, this.arb, this.aqD);
                    a(this.are, this.aqZ, this.aqE);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.aqC);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aqD);
            } else if (i == 2) {
                a(arrayList.get(i2), this.aqE);
            }
        }
    }

    private void ei(int i) {
        if (this.aqL.size() != 0) {
            int size = this.aqL.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aqL.get(i2).intValue() == i) {
                    this.aqL.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.aqB.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.aqB.c(str, 10, false);
        } else {
            this.aqB.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aqG.setText("");
            return;
        }
        String trim = str.trim();
        this.aqG.setVisibility(0);
        if (com.baidu.tbadk.util.u.gD(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 12)) + "...";
        }
        this.aqG.setText(String.valueOf(trim) + TbadkCoreApplication.m9getInst().getResources().getString(r.j.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aqz.setText("");
            this.aqz.setVisibility(8);
            return;
        }
        this.aqz.setVisibility(0);
        this.aqz.setText(str);
    }

    private void setTitle(String str) {
        this.arh = str;
        if (this.aqM != 0) {
            this.title.setPadding(0, 0, (int) this.context.getResources().getDimension(this.aqM), 0);
            this.aqM = 0;
        } else {
            this.title.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.title.setText("");
            return;
        }
        this.title.setVisibility(0);
        if (this.aqO) {
            if (this.aqR) {
                this.title.setText(an.c(this.context, str, r.j.kn_zhibo));
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
        Bitmap cO = at.cO(r.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        int height = cO.getHeight();
        bitmapDrawable.setBounds(0, 0, cO.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aqm.c(str, 12, false);
        } else {
            this.aqm.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.aqp.setText("");
            return;
        }
        this.aqp.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.u.gD(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.u.d(trim, 0, 14)) + "...";
        }
        this.aqp.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            d(this.aqq, this.context.getResources().getString(r.j.fans_default_name));
        } else {
            d(this.aqq, str);
        }
    }

    private void d(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = at.getDrawable(r.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.aqr.setText(ax.y(i));
    }

    private void setReplyNum(int i) {
        b(this.aqs, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(ax.y(j));
        Drawable drawable = at.getDrawable(r.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void i(int i, boolean z) {
        if (z) {
            this.aqI.setVisibility(0);
            b(this.aqI, i);
            return;
        }
        this.aqI.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.aqh) {
            this.aqt.setVisibility(0);
            at.k(this.aqt, r.f.label_onthelist);
            return;
        }
        this.aqt.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.aqg) {
            this.aqu.setVisibility(0);
            this.aqu.setText(str);
            return;
        }
        this.aqu.setVisibility(8);
        this.aqu.setText("");
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.aqw.setVisibility(8);
            return;
        }
        this.aqw.setVisibility(0);
        this.aqw.setText(str);
    }

    private void p(String str, boolean z) {
        if (!z) {
            this.aqH.setVisibility(8);
            return;
        }
        this.aqH.setVisibility(0);
        this.aqH.setText(str);
    }

    public void setShowHead(boolean z) {
        this.apY = z;
    }

    public void setShowTitle(boolean z) {
        this.apZ = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.aqe = z;
    }

    public void setShowContent(boolean z) {
        this.aqa = z;
    }

    public void setShowCover(boolean z) {
        this.aqb = z;
    }

    public void setShowExpression(boolean z) {
        this.aqc = z;
    }

    public void setShowBottom(boolean z) {
        this.aqd = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.aqg = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.aqh = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.aqi = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.aqj = z;
    }

    public void setChooseStyle(int i) {
        this.aqK = i;
    }

    public int getShowStyle() {
        return this.aqK;
    }

    public void setShowLiveIcon(boolean z) {
        this.aqO = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.apW = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.apX = bVar;
    }

    public void setParentBackground(int i) {
        at.k(this.aqk, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.aqP = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.aqf = z;
    }

    public void setTitlePaddingRight(int i) {
        this.aqM = i;
    }

    public void setTitleMaxLines(int i) {
        this.aqN = i;
    }

    public void setAllowGreyState(boolean z) {
        this.aqQ = z;
    }

    public void bo(boolean z) {
        this.aqR = z;
    }
}
