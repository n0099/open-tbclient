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
    private LinearLayout axF;
    private View axG;
    private HeadImageView axH;
    private FrameLayout axI;
    private LinearLayout axJ;
    private TextView axK;
    private TextView axL;
    private TextView axM;
    private TextView axN;
    private TextView axO;
    private TextView axP;
    private LinearLayout axQ;
    private TextView axR;
    private TextView axS;
    private TextView axT;
    private LinearLayout axU;
    private TextView axV;
    private RelativeLayout axW;
    private TbImageView axX;
    private TextView axY;
    private TextView axZ;
    private a axr;
    private b axs;
    private boolean axt;
    private boolean axu;
    private boolean axv;
    private boolean axw;
    private boolean axx;
    private boolean axy;
    private boolean axz;
    private int ayA;
    private int ayB;
    private int ayC;
    private String ayD;
    private TextView aya;
    private RelativeLayout ayb;
    private TextView ayc;
    private TextView ayd;
    private TextView aye;
    private TextView ayf;
    private int ayg;
    private ArrayList<Integer> ayh;
    private int ayi;
    private int ayj;
    private boolean ayk;
    private boolean ayl;
    private boolean aym;
    private boolean ayn;
    private int ayo;
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
        this.axt = true;
        this.axu = true;
        this.axv = true;
        this.axw = true;
        this.axx = true;
        this.axy = true;
        this.axz = false;
        this.axA = false;
        this.axB = false;
        this.axC = false;
        this.axD = false;
        this.axE = false;
        this.ayg = 0;
        this.ayh = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.ayi = 0;
        this.ayj = 0;
        this.ayk = false;
        this.ayl = true;
        this.aym = false;
        this.ayn = false;
        this.isGod = false;
        this.aqm = 3;
        this.padding = 0;
        this.ayo = 0;
        this.ayp = 0;
        this.ayq = 0;
        this.ayr = 0;
        this.ayD = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.f.ds24);
        this.ayp = (int) context.getResources().getDimension(d.f.ds100);
        this.ayo = (int) context.getResources().getDimension(d.f.ds70);
        this.ayq = (int) context.getResources().getDimension(d.f.ds18);
        this.ayr = (int) context.getResources().getDimension(d.f.ds4);
        this.ays = (int) context.getResources().getDimension(d.f.ds80);
        this.ayt = (int) context.getResources().getDimension(d.f.ds280);
        this.ayu = (int) context.getResources().getDimension(d.f.ds170);
        this.ayv = (int) context.getResources().getDimension(d.f.ds320);
        this.ayw = (int) context.getResources().getDimension(d.f.ds200);
        this.ayx = (int) context.getResources().getDimension(d.f.ds60);
        this.ayy = (int) context.getResources().getDimension(d.f.ds120);
        this.ayz = (int) context.getResources().getDimension(d.f.ds160);
        this.ayA = (int) context.getResources().getDimension(d.f.ds220);
        this.ayB = (int) context.getResources().getDimension(d.f.ds240);
        this.ayC = (int) context.getResources().getDimension(d.f.ds180);
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
        this.axF = (LinearLayout) inflate.findViewById(d.h.pl_card_root);
        this.axG = inflate.findViewById(d.h.author_info);
        this.axQ = (LinearLayout) inflate.findViewById(d.h.photo_live_card_title);
        this.axU = (LinearLayout) inflate.findViewById(d.h.photo_live_card_content);
        this.axW = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_cover_and_expression);
        this.ayb = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_bottom);
        Bv();
        Bw();
        Bx();
        Bz();
        By();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.axt, photoLiveCardData);
            b(this.axu, this.axz, photoLiveCardData);
            b(this.axv, photoLiveCardData);
            a(this.axw, this.axx, photoLiveCardData);
            a(this.axy, photoLiveCardData);
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
            if (z && this.ayl) {
                if (this.paddingBottom != 0) {
                    this.axW.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axW.setPadding(this.padding, 0, this.padding, 0);
                }
                this.axW.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axW != null) {
                this.axW.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.ayb.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.axA);
                j(photoLiveCardData.getDiscussNum(), this.axD);
                return;
            }
            this.ayb.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axQ.setVisibility(0);
                if (this.ayj != 0) {
                    this.axR.setMaxLines(this.ayj);
                } else {
                    this.axR.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.axR, photoLiveCardData.getThreadId());
                return;
            }
            this.axQ.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.axE) {
            this.axT.setVisibility(0);
            this.axT.setTag(photoLiveCardData);
            return;
        }
        this.axT.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axU.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.axU.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axU.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.axV, photoLiveCardData.getThreadId());
                return;
            }
            this.axU.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.aym) {
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sn(String.valueOf(j))) {
                ai.c(textView, d.e.cp_cont_c, 1);
            } else {
                ai.c(textView, d.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axG.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.axG.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.axG.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.axH.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.ayp;
                        layoutParams.width = this.ayp;
                    }
                    if (this.ayf == null) {
                        this.ayf = new TextView(this.context);
                        this.ayf.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.ayf.setEllipsize(TextUtils.TruncateAt.END);
                        this.ayf.setTextSize(0, this.ayq);
                        ai.i(this.ayf, d.e.cp_cont_h);
                        ai.j(this.ayf, d.g.icon_shen);
                        this.ayf.setSingleLine(true);
                        this.axJ.addView(this.ayf);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.ayf.setText(d.l.god_intro_default);
                    } else {
                        this.ayf.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.axJ.removeView(this.ayf);
                    this.ayf = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.ayo;
                        layoutParams.width = this.ayo;
                    }
                }
                this.axH.setTag(photoLiveCardData);
                fj(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.axJ.removeView(this.ayf);
            this.axG.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.axH.setPadding(this.ayr, this.ayr, this.ayr, this.ayr);
            if (this.isGod) {
                this.axI.setBackgroundDrawable(ai.getDrawable(d.g.pic_bg_jinbian));
                return;
            } else {
                this.axI.setBackgroundDrawable(ai.getDrawable(d.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.axI.setBackgroundDrawable(null);
        this.axH.setPadding(0, 0, 0, 0);
    }

    private void Bv() {
        if (this.axG != null) {
            this.axH = (HeadImageView) this.axG.findViewById(d.h.author_portrait);
            this.axI = (FrameLayout) this.axG.findViewById(d.h.author_portrait_info);
            this.axK = (TextView) this.axG.findViewById(d.h.author_name);
            this.axL = (TextView) this.axG.findViewById(d.h.nick_name);
            this.axM = (TextView) this.axG.findViewById(d.h.fans_num);
            this.axN = (TextView) this.axG.findViewById(d.h.reply_num);
            this.axO = (TextView) this.axG.findViewById(d.h.headlive_icon);
            this.axP = (TextView) this.axG.findViewById(d.h.refresh_time_in_head);
            this.axJ = (LinearLayout) this.axG.findViewById(d.h.author_info_and_time);
            this.axH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.axs != null) {
                        PhotoLiveCardView.this.axs.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Bw() {
        if (this.axQ != null) {
            this.axR = (TextView) this.axQ.findViewById(d.h.title);
            this.axS = (TextView) findViewById(d.h.refresh_time_in_title);
            this.axT = (TextView) this.axQ.findViewById(d.h.card_delete_in_title);
            this.axT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.axr != null) {
                        PhotoLiveCardView.this.axr.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bx() {
        if (this.axU != null) {
            this.axV = (TextView) this.axU.findViewById(d.h.content);
        }
    }

    private void By() {
        if (this.ayb != null) {
            this.ayc = (TextView) this.ayb.findViewById(d.h.ba_name);
            this.ayd = (TextView) this.ayb.findViewById(d.h.bottom_refresh_time);
            this.aye = (TextView) this.ayb.findViewById(d.h.bottom_reply_num);
        }
    }

    private void Bz() {
        if (this.axW != null) {
            this.axX = (TbImageView) this.axW.findViewById(d.h.live_cover);
            this.axX.setGifIconSupport(false);
            BA();
        }
    }

    private void BA() {
        if (this.axW != null) {
            this.axY = (TextView) this.axW.findViewById(d.h.first_style_first_expression);
            this.axZ = (TextView) this.axW.findViewById(d.h.first_style_second_expression);
            this.aya = (TextView) this.axW.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.ayh.clear();
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
        if (this.ayh.size() != 0) {
            int size = this.ayh.size();
            for (int i = 0; i < size; i++) {
                if (this.ayh.get(i).intValue() == this.axY.getId()) {
                    this.axY.setVisibility(8);
                } else if (this.ayh.get(i).intValue() == this.axZ.getId()) {
                    this.axZ.setVisibility(8);
                } else if (this.ayh.get(i).intValue() == this.aya.getId()) {
                    this.aya.setVisibility(8);
                }
            }
        }
    }

    private void BC() {
        this.axY.setText("");
        this.axZ.setText("");
        this.aya.setText("");
        if (this.axY.getVisibility() == 8) {
            this.axY.setVisibility(0);
        }
        if (this.axZ.getVisibility() == 8) {
            this.axZ.setVisibility(0);
        }
        if (this.aya.getVisibility() == 8) {
            this.aya.setVisibility(0);
        }
        this.ayh.add(Integer.valueOf(this.axY.getId()));
        this.ayh.add(Integer.valueOf(this.axZ.getId()));
        this.ayh.add(Integer.valueOf(this.aya.getId()));
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
            switch (this.ayg) {
                case 0:
                    a(this.ays, this.ayt, this.axY);
                    a(this.ayu, this.ayv, this.axZ);
                    a(this.ayw, this.ayx, this.aya);
                    break;
                case 1:
                    a(this.ayx, this.ayy, this.axY);
                    a(this.ayz, this.ayx, this.axZ);
                    a(this.ayA, this.ayv, this.aya);
                    break;
                case 2:
                    a(this.ayx, this.ayB, this.axY);
                    a(this.ayC, this.ayx, this.axZ);
                    a(this.ayA, this.ayv, this.aya);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axY);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axZ);
            } else if (i == 2) {
                a(arrayList.get(i2), this.aya);
            }
        }
    }

    private void en(int i) {
        if (this.ayh.size() != 0) {
            int size = this.ayh.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ayh.get(i2).intValue() == i) {
                    this.ayh.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.axX.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axX.c(str, 10, false);
        } else {
            this.axX.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ayc.setText("");
            return;
        }
        String trim = str.trim();
        this.ayc.setVisibility(0);
        if (v.gT(trim) > 12) {
            trim = v.d(trim, 0, 12) + "...";
        }
        this.ayc.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axV.setText("");
            this.axV.setVisibility(8);
            return;
        }
        this.axV.setVisibility(0);
        this.axV.setText(str);
    }

    private void setTitle(String str) {
        this.ayD = str;
        if (this.ayi != 0) {
            this.axR.setPadding(0, 0, (int) this.context.getResources().getDimension(this.ayi), 0);
            this.ayi = 0;
        } else {
            this.axR.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.axR.setText("");
            return;
        }
        this.axR.setVisibility(0);
        if (this.ayk) {
            if (this.ayn) {
                this.axR.setText(m.c(this.context, str, d.l.photo_live_tips));
                return;
            } else {
                this.axR.setText(e(str));
                return;
            }
        }
        this.axR.setText(str);
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

    private void fj(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.axH.c(str, 12, false);
        } else {
            this.axH.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axK.setText("");
            return;
        }
        this.axK.setVisibility(0);
        String trim = str.trim();
        if (v.gT(trim) > 14) {
            trim = v.d(trim, 0, 14) + "...";
        }
        this.axK.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.axL, this.context.getResources().getString(d.l.fans_default_name));
        } else {
            b(this.axL, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = ai.getDrawable(d.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.axM.setText(al.z(i));
    }

    private void setReplyNum(int i) {
        b(this.axN, i);
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
            this.aye.setVisibility(0);
            b(this.aye, i);
            return;
        }
        this.aye.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.axC) {
            this.axO.setVisibility(0);
            ai.j(this.axO, d.g.label_onthelist);
            return;
        }
        this.axO.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.axB) {
            this.axP.setVisibility(0);
            this.axP.setText(str);
            return;
        }
        this.axP.setVisibility(8);
        this.axP.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.axS.setVisibility(8);
            return;
        }
        this.axS.setVisibility(0);
        this.axS.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.ayd.setVisibility(8);
            return;
        }
        this.ayd.setVisibility(0);
        this.ayd.setText(str);
    }

    public void setShowHead(boolean z) {
        this.axt = z;
    }

    public void setShowTitle(boolean z) {
        this.axu = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.axz = z;
    }

    public void setShowContent(boolean z) {
        this.axv = z;
    }

    public void setShowCover(boolean z) {
        this.axw = z;
    }

    public void setShowExpression(boolean z) {
        this.axx = z;
    }

    public void setShowBottom(boolean z) {
        this.axy = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.axB = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.axC = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.axD = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.axE = z;
    }

    public void setChooseStyle(int i) {
        this.ayg = i;
    }

    public int getShowStyle() {
        return this.ayg;
    }

    public void setShowLiveIcon(boolean z) {
        this.ayk = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.axr = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.axs = bVar;
    }

    public void setParentBackground(int i) {
        ai.j(this.axF, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.ayl = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.axA = z;
    }

    public void setTitlePaddingRight(int i) {
        this.ayi = i;
    }

    public void setTitleMaxLines(int i) {
        this.ayj = i;
    }

    public void setAllowGreyState(boolean z) {
        this.aym = z;
    }

    public void bp(boolean z) {
        this.ayn = z;
    }
}
