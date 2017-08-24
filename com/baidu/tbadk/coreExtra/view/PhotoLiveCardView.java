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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int aqm;
    private boolean axA;
    private boolean axB;
    private boolean axC;
    private boolean axD;
    private boolean axE;
    private boolean axF;
    private LinearLayout axG;
    private View axH;
    private HeadImageView axI;
    private FrameLayout axJ;
    private LinearLayout axK;
    private TextView axL;
    private TextView axM;
    private TextView axN;
    private TextView axO;
    private TextView axP;
    private TextView axQ;
    private LinearLayout axR;
    private TextView axS;
    private TextView axT;
    private TextView axU;
    private LinearLayout axV;
    private TextView axW;
    private RelativeLayout axX;
    private TbImageView axY;
    private TextView axZ;
    private a axs;
    private b axt;
    private boolean axu;
    private boolean axv;
    private boolean axw;
    private boolean axx;
    private boolean axy;
    private boolean axz;
    private int ayA;
    private int ayB;
    private int ayC;
    private int ayD;
    private String ayE;
    private TextView aya;
    private TextView ayb;
    private RelativeLayout ayc;
    private TextView ayd;
    private TextView aye;
    private TextView ayf;
    private TextView ayg;
    private int ayh;
    private ArrayList<Integer> ayi;
    private int ayj;
    private int ayk;
    private boolean ayl;
    private boolean aym;
    private boolean ayn;
    private boolean ayo;
    private int ayp;
    private int ayq;
    private int ayr;
    private int ays;
    private int ayt;
    private int ayu;
    private int ayv;
    private int ayw;
    private int ayx;
    private int ayy;
    private int ayz;
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
        this.axu = true;
        this.axv = true;
        this.axw = true;
        this.axx = true;
        this.axy = true;
        this.axz = true;
        this.axA = false;
        this.axB = false;
        this.axC = false;
        this.axD = false;
        this.axE = false;
        this.axF = false;
        this.ayh = 0;
        this.ayi = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.ayj = 0;
        this.ayk = 0;
        this.ayl = false;
        this.aym = true;
        this.ayn = false;
        this.ayo = false;
        this.isGod = false;
        this.aqm = 3;
        this.padding = 0;
        this.ayp = 0;
        this.ayq = 0;
        this.ayr = 0;
        this.ays = 0;
        this.ayE = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.f.ds24);
        this.ayq = (int) context.getResources().getDimension(d.f.ds100);
        this.ayp = (int) context.getResources().getDimension(d.f.ds70);
        this.ayr = (int) context.getResources().getDimension(d.f.ds18);
        this.ays = (int) context.getResources().getDimension(d.f.ds4);
        this.ayt = (int) context.getResources().getDimension(d.f.ds80);
        this.ayu = (int) context.getResources().getDimension(d.f.ds280);
        this.ayv = (int) context.getResources().getDimension(d.f.ds170);
        this.ayw = (int) context.getResources().getDimension(d.f.ds320);
        this.ayx = (int) context.getResources().getDimension(d.f.ds200);
        this.ayy = (int) context.getResources().getDimension(d.f.ds60);
        this.ayz = (int) context.getResources().getDimension(d.f.ds120);
        this.ayA = (int) context.getResources().getDimension(d.f.ds160);
        this.ayB = (int) context.getResources().getDimension(d.f.ds220);
        this.ayC = (int) context.getResources().getDimension(d.f.ds240);
        this.ayD = (int) context.getResources().getDimension(d.f.ds180);
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
        this.axG = (LinearLayout) inflate.findViewById(d.h.pl_card_root);
        this.axH = inflate.findViewById(d.h.author_info);
        this.axR = (LinearLayout) inflate.findViewById(d.h.photo_live_card_title);
        this.axV = (LinearLayout) inflate.findViewById(d.h.photo_live_card_content);
        this.axX = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_cover_and_expression);
        this.ayc = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_bottom);
        Bv();
        Bw();
        Bx();
        Bz();
        By();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.axu, photoLiveCardData);
            b(this.axv, this.axA, photoLiveCardData);
            b(this.axw, photoLiveCardData);
            a(this.axx, this.axy, photoLiveCardData);
            a(this.axz, photoLiveCardData);
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
            if (z && this.aym) {
                if (this.paddingBottom != 0) {
                    this.axX.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axX.setPadding(this.padding, 0, this.padding, 0);
                }
                this.axX.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axX != null) {
                this.axX.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.ayc.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.axB);
                j(photoLiveCardData.getDiscussNum(), this.axE);
                return;
            }
            this.ayc.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axR.setVisibility(0);
                if (this.ayk != 0) {
                    this.axS.setMaxLines(this.ayk);
                } else {
                    this.axS.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.axS, photoLiveCardData.getThreadId());
                return;
            }
            this.axR.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.axF) {
            this.axU.setVisibility(0);
            this.axU.setTag(photoLiveCardData);
            return;
        }
        this.axU.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axV.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.axV.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axV.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.axW, photoLiveCardData.getThreadId());
                return;
            }
            this.axV.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.ayn) {
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ss(String.valueOf(j))) {
                ai.c(textView, d.e.cp_cont_c, 1);
            } else {
                ai.c(textView, d.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axH.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.axH.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.axH.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.axI.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.ayq;
                        layoutParams.width = this.ayq;
                    }
                    if (this.ayg == null) {
                        this.ayg = new TextView(this.context);
                        this.ayg.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.ayg.setEllipsize(TextUtils.TruncateAt.END);
                        this.ayg.setTextSize(0, this.ayr);
                        ai.i(this.ayg, d.e.cp_cont_h);
                        ai.j(this.ayg, d.g.icon_shen);
                        this.ayg.setSingleLine(true);
                        this.axK.addView(this.ayg);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.ayg.setText(d.l.god_intro_default);
                    } else {
                        this.ayg.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.axK.removeView(this.ayg);
                    this.ayg = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.ayp;
                        layoutParams.width = this.ayp;
                    }
                }
                this.axI.setTag(photoLiveCardData);
                fn(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.axK.removeView(this.ayg);
            this.axH.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.axI.setPadding(this.ays, this.ays, this.ays, this.ays);
            if (this.isGod) {
                this.axJ.setBackgroundDrawable(ai.getDrawable(d.g.pic_bg_jinbian));
                return;
            } else {
                this.axJ.setBackgroundDrawable(ai.getDrawable(d.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.axJ.setBackgroundDrawable(null);
        this.axI.setPadding(0, 0, 0, 0);
    }

    private void Bv() {
        if (this.axH != null) {
            this.axI = (HeadImageView) this.axH.findViewById(d.h.author_portrait);
            this.axJ = (FrameLayout) this.axH.findViewById(d.h.author_portrait_info);
            this.axL = (TextView) this.axH.findViewById(d.h.author_name);
            this.axM = (TextView) this.axH.findViewById(d.h.nick_name);
            this.axN = (TextView) this.axH.findViewById(d.h.fans_num);
            this.axO = (TextView) this.axH.findViewById(d.h.reply_num);
            this.axP = (TextView) this.axH.findViewById(d.h.headlive_icon);
            this.axQ = (TextView) this.axH.findViewById(d.h.refresh_time_in_head);
            this.axK = (LinearLayout) this.axH.findViewById(d.h.author_info_and_time);
            this.axI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.axt != null) {
                        PhotoLiveCardView.this.axt.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Bw() {
        if (this.axR != null) {
            this.axS = (TextView) this.axR.findViewById(d.h.title);
            this.axT = (TextView) findViewById(d.h.refresh_time_in_title);
            this.axU = (TextView) this.axR.findViewById(d.h.card_delete_in_title);
            this.axU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.axs != null) {
                        PhotoLiveCardView.this.axs.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bx() {
        if (this.axV != null) {
            this.axW = (TextView) this.axV.findViewById(d.h.content);
        }
    }

    private void By() {
        if (this.ayc != null) {
            this.ayd = (TextView) this.ayc.findViewById(d.h.ba_name);
            this.aye = (TextView) this.ayc.findViewById(d.h.bottom_refresh_time);
            this.ayf = (TextView) this.ayc.findViewById(d.h.bottom_reply_num);
        }
    }

    private void Bz() {
        if (this.axX != null) {
            this.axY = (TbImageView) this.axX.findViewById(d.h.live_cover);
            this.axY.setGifIconSupport(false);
            BA();
        }
    }

    private void BA() {
        if (this.axX != null) {
            this.axZ = (TextView) this.axX.findViewById(d.h.first_style_first_expression);
            this.aya = (TextView) this.axX.findViewById(d.h.first_style_second_expression);
            this.ayb = (TextView) this.axX.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.ayi.clear();
        BC();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            BB();
        }
    }

    private void BB() {
        if (this.ayi.size() != 0) {
            int size = this.ayi.size();
            for (int i = 0; i < size; i++) {
                if (this.ayi.get(i).intValue() == this.axZ.getId()) {
                    this.axZ.setVisibility(8);
                } else if (this.ayi.get(i).intValue() == this.aya.getId()) {
                    this.aya.setVisibility(8);
                } else if (this.ayi.get(i).intValue() == this.ayb.getId()) {
                    this.ayb.setVisibility(8);
                }
            }
        }
    }

    private void BC() {
        this.axZ.setText("");
        this.aya.setText("");
        this.ayb.setText("");
        if (this.axZ.getVisibility() == 8) {
            this.axZ.setVisibility(0);
        }
        if (this.aya.getVisibility() == 8) {
            this.aya.setVisibility(0);
        }
        if (this.ayb.getVisibility() == 8) {
            this.ayb.setVisibility(0);
        }
        this.ayi.add(Integer.valueOf(this.axZ.getId()));
        this.ayi.add(Integer.valueOf(this.aya.getId()));
        this.ayi.add(Integer.valueOf(this.ayb.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ai(eVar.getLabelName(), String.valueOf(eVar.Bo())));
            en(textView.getId());
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
            switch (this.ayh) {
                case 0:
                    a(this.ayt, this.ayu, this.axZ);
                    a(this.ayv, this.ayw, this.aya);
                    a(this.ayx, this.ayy, this.ayb);
                    break;
                case 1:
                    a(this.ayy, this.ayz, this.axZ);
                    a(this.ayA, this.ayy, this.aya);
                    a(this.ayB, this.ayw, this.ayb);
                    break;
                case 2:
                    a(this.ayy, this.ayC, this.axZ);
                    a(this.ayD, this.ayy, this.aya);
                    a(this.ayB, this.ayw, this.ayb);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axZ);
            } else if (i == 1) {
                a(arrayList.get(i2), this.aya);
            } else if (i == 2) {
                a(arrayList.get(i2), this.ayb);
            }
        }
    }

    private void en(int i) {
        if (this.ayi.size() != 0) {
            int size = this.ayi.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ayi.get(i2).intValue() == i) {
                    this.ayi.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.axY.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axY.c(str, 10, false);
        } else {
            this.axY.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ayd.setText("");
            return;
        }
        String trim = str.trim();
        this.ayd.setVisibility(0);
        if (v.gW(trim) > 12) {
            trim = v.e(trim, 0, 12) + "...";
        }
        this.ayd.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axW.setText("");
            this.axW.setVisibility(8);
            return;
        }
        this.axW.setVisibility(0);
        this.axW.setText(str);
    }

    private void setTitle(String str) {
        this.ayE = str;
        if (this.ayj != 0) {
            this.axS.setPadding(0, 0, (int) this.context.getResources().getDimension(this.ayj), 0);
            this.ayj = 0;
        } else {
            this.axS.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.axS.setText("");
            return;
        }
        this.axS.setVisibility(0);
        if (this.ayl) {
            if (this.ayo) {
                this.axS.setText(m.c(this.context, str, d.l.photo_live_tips));
                return;
            } else {
                this.axS.setText(e(str));
                return;
            }
        }
        this.axS.setText(str);
    }

    public static SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap cS = ai.cS(d.g.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cS);
        int height = cS.getHeight();
        bitmapDrawable.setBounds(0, 0, cS.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fn(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.axI.c(str, 12, false);
        } else {
            this.axI.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axL.setText("");
            return;
        }
        this.axL.setVisibility(0);
        String trim = str.trim();
        if (v.gW(trim) > 14) {
            trim = v.e(trim, 0, 14) + "...";
        }
        this.axL.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.axM, this.context.getResources().getString(d.l.fans_default_name));
        } else {
            a(this.axM, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = ai.getDrawable(d.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.axN.setText(al.z(i));
    }

    private void setReplyNum(int i) {
        b(this.axO, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(al.z(j));
        Drawable drawable = ai.getDrawable(d.g.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void j(int i, boolean z) {
        if (z) {
            this.ayf.setVisibility(0);
            b(this.ayf, i);
            return;
        }
        this.ayf.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.axD) {
            this.axP.setVisibility(0);
            ai.j(this.axP, d.g.label_onthelist);
            return;
        }
        this.axP.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.axC) {
            this.axQ.setVisibility(0);
            this.axQ.setText(str);
            return;
        }
        this.axQ.setVisibility(8);
        this.axQ.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.axT.setVisibility(8);
            return;
        }
        this.axT.setVisibility(0);
        this.axT.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.aye.setVisibility(8);
            return;
        }
        this.aye.setVisibility(0);
        this.aye.setText(str);
    }

    public void setShowHead(boolean z) {
        this.axu = z;
    }

    public void setShowTitle(boolean z) {
        this.axv = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.axA = z;
    }

    public void setShowContent(boolean z) {
        this.axw = z;
    }

    public void setShowCover(boolean z) {
        this.axx = z;
    }

    public void setShowExpression(boolean z) {
        this.axy = z;
    }

    public void setShowBottom(boolean z) {
        this.axz = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.axC = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.axD = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.axE = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.axF = z;
    }

    public void setChooseStyle(int i) {
        this.ayh = i;
    }

    public int getShowStyle() {
        return this.ayh;
    }

    public void setShowLiveIcon(boolean z) {
        this.ayl = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.axs = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.axt = bVar;
    }

    public void setParentBackground(int i) {
        ai.j(this.axG, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.aym = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.axB = z;
    }

    public void setTitlePaddingRight(int i) {
        this.ayj = i;
    }

    public void setTitleMaxLines(int i) {
        this.ayk = i;
    }

    public void setAllowGreyState(boolean z) {
        this.ayn = z;
    }

    public void bp(boolean z) {
        this.ayo = z;
    }
}
