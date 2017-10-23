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
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aoN;
    private boolean avA;
    private boolean avB;
    private boolean avC;
    private boolean avD;
    private boolean avE;
    private boolean avF;
    private boolean avG;
    private boolean avH;
    private boolean avI;
    private boolean avJ;
    private boolean avK;
    private boolean avL;
    private LinearLayout avM;
    private View avN;
    private HeadImageView avO;
    private FrameLayout avP;
    private LinearLayout avQ;
    private TextView avR;
    private TextView avS;
    private TextView avT;
    private TextView avU;
    private TextView avV;
    private TextView avW;
    private LinearLayout avX;
    private TextView avY;
    private TextView avZ;
    private a avy;
    private b avz;
    private int awA;
    private int awB;
    private int awC;
    private int awD;
    private int awE;
    private int awF;
    private int awG;
    private int awH;
    private int awI;
    private int awJ;
    private String awK;
    private TextView awa;
    private LinearLayout awb;
    private TextView awc;
    private RelativeLayout awd;
    private TbImageView awe;
    private TextView awf;
    private TextView awg;
    private TextView awh;
    private RelativeLayout awi;
    private TextView awj;
    private TextView awk;
    private TextView awl;
    private TextView awm;
    private int awn;
    private ArrayList<Integer> awo;
    private int awp;
    private int awq;
    private boolean awr;
    private boolean aws;
    private boolean awt;
    private boolean awu;
    private int awv;
    private int aww;
    private int awx;
    private int awy;
    private int awz;
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
        this.avA = true;
        this.avB = true;
        this.avC = true;
        this.avD = true;
        this.avE = true;
        this.avF = true;
        this.avG = false;
        this.avH = false;
        this.avI = false;
        this.avJ = false;
        this.avK = false;
        this.avL = false;
        this.awn = 0;
        this.awo = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.awp = 0;
        this.awq = 0;
        this.awr = false;
        this.aws = true;
        this.awt = false;
        this.awu = false;
        this.isGod = false;
        this.aoN = 3;
        this.padding = 0;
        this.awv = 0;
        this.aww = 0;
        this.awx = 0;
        this.awy = 0;
        this.awK = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.f.ds24);
        this.aww = (int) context.getResources().getDimension(d.f.ds100);
        this.awv = (int) context.getResources().getDimension(d.f.ds70);
        this.awx = (int) context.getResources().getDimension(d.f.ds18);
        this.awy = (int) context.getResources().getDimension(d.f.ds4);
        this.awz = (int) context.getResources().getDimension(d.f.ds80);
        this.awA = (int) context.getResources().getDimension(d.f.ds280);
        this.awB = (int) context.getResources().getDimension(d.f.ds170);
        this.awC = (int) context.getResources().getDimension(d.f.ds320);
        this.awD = (int) context.getResources().getDimension(d.f.ds200);
        this.awE = (int) context.getResources().getDimension(d.f.ds60);
        this.awF = (int) context.getResources().getDimension(d.f.ds120);
        this.awG = (int) context.getResources().getDimension(d.f.ds160);
        this.awH = (int) context.getResources().getDimension(d.f.ds220);
        this.awI = (int) context.getResources().getDimension(d.f.ds240);
        this.awJ = (int) context.getResources().getDimension(d.f.ds180);
        this.size = (int) context.getResources().getDimension(d.f.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.j.photo_live_card_view, this);
        this.avM = (LinearLayout) inflate.findViewById(d.h.pl_card_root);
        this.avN = inflate.findViewById(d.h.author_info);
        this.avX = (LinearLayout) inflate.findViewById(d.h.photo_live_card_title);
        this.awb = (LinearLayout) inflate.findViewById(d.h.photo_live_card_content);
        this.awd = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_cover_and_expression);
        this.awi = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_bottom);
        AI();
        AJ();
        AK();
        AM();
        AL();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.avA, photoLiveCardData);
            b(this.avB, this.avG, photoLiveCardData);
            b(this.avC, photoLiveCardData);
            a(this.avD, this.avE, photoLiveCardData);
            a(this.avF, photoLiveCardData);
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
            if (z && this.aws) {
                if (this.paddingBottom != 0) {
                    this.awd.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awd.setPadding(this.padding, 0, this.padding, 0);
                }
                this.awd.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.awd != null) {
                this.awd.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awi.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.avH);
                h(photoLiveCardData.getDiscussNum(), this.avK);
                return;
            }
            this.awi.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.avX.setVisibility(0);
                if (this.awq != 0) {
                    this.avY.setMaxLines(this.awq);
                } else {
                    this.avY.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.avY, photoLiveCardData.getThreadId());
                return;
            }
            this.avX.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.avL) {
            this.awa.setVisibility(0);
            this.awa.setTag(photoLiveCardData);
            return;
        }
        this.awa.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.awb.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.awb.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.awb.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.awc, photoLiveCardData.getThreadId());
                return;
            }
            this.awb.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.awt) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.rY(String.valueOf(j))) {
                aj.c(textView, d.e.cp_cont_c, 1);
            } else {
                aj.c(textView, d.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.avN.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.avN.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.avN.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.avO.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.aww;
                        layoutParams.width = this.aww;
                    }
                    if (this.awm == null) {
                        this.awm = new TextView(this.context);
                        this.awm.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.awm.setEllipsize(TextUtils.TruncateAt.END);
                        this.awm.setTextSize(0, this.awx);
                        aj.i(this.awm, d.e.cp_cont_h);
                        aj.j(this.awm, d.g.icon_shen);
                        this.awm.setSingleLine(true);
                        this.avQ.addView(this.awm);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.awm.setText(d.l.god_intro_default);
                    } else {
                        this.awm.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.avQ.removeView(this.awm);
                    this.awm = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.awv;
                        layoutParams.width = this.awv;
                    }
                }
                this.avO.setTag(photoLiveCardData);
                fa(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.avQ.removeView(this.awm);
            this.avN.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.avO.setPadding(this.awy, this.awy, this.awy, this.awy);
            if (this.isGod) {
                this.avP.setBackgroundDrawable(aj.getDrawable(d.g.pic_bg_jinbian));
                return;
            } else {
                this.avP.setBackgroundDrawable(aj.getDrawable(d.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.avP.setBackgroundDrawable(null);
        this.avO.setPadding(0, 0, 0, 0);
    }

    private void AI() {
        if (this.avN != null) {
            this.avO = (HeadImageView) this.avN.findViewById(d.h.author_portrait);
            this.avP = (FrameLayout) this.avN.findViewById(d.h.author_portrait_info);
            this.avR = (TextView) this.avN.findViewById(d.h.author_name);
            this.avS = (TextView) this.avN.findViewById(d.h.nick_name);
            this.avT = (TextView) this.avN.findViewById(d.h.fans_num);
            this.avU = (TextView) this.avN.findViewById(d.h.reply_num);
            this.avV = (TextView) this.avN.findViewById(d.h.headlive_icon);
            this.avW = (TextView) this.avN.findViewById(d.h.refresh_time_in_head);
            this.avQ = (LinearLayout) this.avN.findViewById(d.h.author_info_and_time);
            this.avO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.avz != null) {
                        PhotoLiveCardView.this.avz.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void AJ() {
        if (this.avX != null) {
            this.avY = (TextView) this.avX.findViewById(d.h.title);
            this.avZ = (TextView) findViewById(d.h.refresh_time_in_title);
            this.awa = (TextView) this.avX.findViewById(d.h.card_delete_in_title);
            this.awa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.avy != null) {
                        PhotoLiveCardView.this.avy.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void AK() {
        if (this.awb != null) {
            this.awc = (TextView) this.awb.findViewById(d.h.content);
        }
    }

    private void AL() {
        if (this.awi != null) {
            this.awj = (TextView) this.awi.findViewById(d.h.ba_name);
            this.awk = (TextView) this.awi.findViewById(d.h.bottom_refresh_time);
            this.awl = (TextView) this.awi.findViewById(d.h.bottom_reply_num);
        }
    }

    private void AM() {
        if (this.awd != null) {
            this.awe = (TbImageView) this.awd.findViewById(d.h.live_cover);
            this.awe.setGifIconSupport(false);
            AN();
        }
    }

    private void AN() {
        if (this.awd != null) {
            this.awf = (TextView) this.awd.findViewById(d.h.first_style_first_expression);
            this.awg = (TextView) this.awd.findViewById(d.h.first_style_second_expression);
            this.awh = (TextView) this.awd.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.awo.clear();
        AP();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            AO();
        }
    }

    private void AO() {
        if (this.awo.size() != 0) {
            int size = this.awo.size();
            for (int i = 0; i < size; i++) {
                if (this.awo.get(i).intValue() == this.awf.getId()) {
                    this.awf.setVisibility(8);
                } else if (this.awo.get(i).intValue() == this.awg.getId()) {
                    this.awg.setVisibility(8);
                } else if (this.awo.get(i).intValue() == this.awh.getId()) {
                    this.awh.setVisibility(8);
                }
            }
        }
    }

    private void AP() {
        this.awf.setText("");
        this.awg.setText("");
        this.awh.setText("");
        if (this.awf.getVisibility() == 8) {
            this.awf.setVisibility(0);
        }
        if (this.awg.getVisibility() == 8) {
            this.awg.setVisibility(0);
        }
        if (this.awh.getVisibility() == 8) {
            this.awh.setVisibility(0);
        }
        this.awo.add(Integer.valueOf(this.awf.getId()));
        this.awo.add(Integer.valueOf(this.awg.getId()));
        this.awo.add(Integer.valueOf(this.awh.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.al(eVar.getLabelName(), String.valueOf(eVar.AB())));
            ew(textView.getId());
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
            switch (this.awn) {
                case 0:
                    a(this.awz, this.awA, this.awf);
                    a(this.awB, this.awC, this.awg);
                    a(this.awD, this.awE, this.awh);
                    break;
                case 1:
                    a(this.awE, this.awF, this.awf);
                    a(this.awG, this.awE, this.awg);
                    a(this.awH, this.awC, this.awh);
                    break;
                case 2:
                    a(this.awE, this.awI, this.awf);
                    a(this.awJ, this.awE, this.awg);
                    a(this.awH, this.awC, this.awh);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.awf);
            } else if (i == 1) {
                a(arrayList.get(i2), this.awg);
            } else if (i == 2) {
                a(arrayList.get(i2), this.awh);
            }
        }
    }

    private void ew(int i) {
        if (this.awo.size() != 0) {
            int size = this.awo.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.awo.get(i2).intValue() == i) {
                    this.awo.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.awe.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.awe.c(str, 10, false);
        } else {
            this.awe.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awj.setText("");
            return;
        }
        String trim = str.trim();
        this.awj.setVisibility(0);
        if (u.gO(trim) > 12) {
            trim = u.e(trim, 0, 12) + "...";
        }
        this.awj.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.l.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.awc.setText("");
            this.awc.setVisibility(8);
            return;
        }
        this.awc.setVisibility(0);
        this.awc.setText(str);
    }

    private void setTitle(String str) {
        this.awK = str;
        if (this.awp != 0) {
            this.avY.setPadding(0, 0, (int) this.context.getResources().getDimension(this.awp), 0);
            this.awp = 0;
        } else {
            this.avY.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.avY.setText("");
            return;
        }
        this.avY.setVisibility(0);
        if (this.awr) {
            if (this.awu) {
                this.avY.setText(m.c(this.context, str, d.l.photo_live_tips));
                return;
            } else {
                this.avY.setText(e(str));
                return;
            }
        }
        this.avY.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap cQ = aj.cQ(d.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
        int height = cQ.getHeight();
        bitmapDrawable.setBounds(0, 0, cQ.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fa(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.avO.c(str, 12, false);
        } else {
            this.avO.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.avR.setText("");
            return;
        }
        this.avR.setVisibility(0);
        String trim = str.trim();
        if (u.gO(trim) > 14) {
            trim = u.e(trim, 0, 14) + "...";
        }
        this.avR.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.avS, this.context.getResources().getString(d.l.fans_default_name));
        } else {
            a(this.avS, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.avT.setText(am.y(i));
    }

    private void setReplyNum(int i) {
        b(this.avU, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(am.y(j));
        Drawable drawable = aj.getDrawable(d.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void h(int i, boolean z) {
        if (z) {
            this.awl.setVisibility(0);
            b(this.awl, i);
            return;
        }
        this.awl.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.avJ) {
            this.avV.setVisibility(0);
            aj.j(this.avV, d.g.label_onthelist);
            return;
        }
        this.avV.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.avI) {
            this.avW.setVisibility(0);
            this.avW.setText(str);
            return;
        }
        this.avW.setVisibility(8);
        this.avW.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.avZ.setVisibility(8);
            return;
        }
        this.avZ.setVisibility(0);
        this.avZ.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.awk.setVisibility(8);
            return;
        }
        this.awk.setVisibility(0);
        this.awk.setText(str);
    }

    public void setShowHead(boolean z) {
        this.avA = z;
    }

    public void setShowTitle(boolean z) {
        this.avB = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.avG = z;
    }

    public void setShowContent(boolean z) {
        this.avC = z;
    }

    public void setShowCover(boolean z) {
        this.avD = z;
    }

    public void setShowExpression(boolean z) {
        this.avE = z;
    }

    public void setShowBottom(boolean z) {
        this.avF = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.avI = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.avJ = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.avK = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.avL = z;
    }

    public void setChooseStyle(int i) {
        this.awn = i;
    }

    public int getShowStyle() {
        return this.awn;
    }

    public void setShowLiveIcon(boolean z) {
        this.awr = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.avy = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.avz = bVar;
    }

    public void setParentBackground(int i) {
        aj.j(this.avM, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.aws = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.avH = z;
    }

    public void setTitlePaddingRight(int i) {
        this.awp = i;
    }

    public void setTitleMaxLines(int i) {
        this.awq = i;
    }

    public void setAllowGreyState(boolean z) {
        this.awt = z;
    }

    public void bm(boolean z) {
        this.awu = z;
    }
}
