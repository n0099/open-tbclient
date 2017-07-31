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
    public int aql;
    private boolean axA;
    private boolean axB;
    private boolean axC;
    private boolean axD;
    private LinearLayout axE;
    private View axF;
    private HeadImageView axG;
    private FrameLayout axH;
    private LinearLayout axI;
    private TextView axJ;
    private TextView axK;
    private TextView axL;
    private TextView axM;
    private TextView axN;
    private TextView axO;
    private LinearLayout axP;
    private TextView axQ;
    private TextView axR;
    private TextView axS;
    private LinearLayout axT;
    private TextView axU;
    private RelativeLayout axV;
    private TbImageView axW;
    private TextView axX;
    private TextView axY;
    private TextView axZ;
    private a axq;
    private b axr;
    private boolean axs;
    private boolean axt;
    private boolean axu;
    private boolean axv;
    private boolean axw;
    private boolean axx;
    private boolean axy;
    private boolean axz;
    private int ayA;
    private int ayB;
    private String ayC;
    private RelativeLayout aya;
    private TextView ayb;
    private TextView ayc;
    private TextView ayd;
    private TextView aye;
    private int ayf;
    private ArrayList<Integer> ayg;
    private int ayh;
    private int ayi;
    private boolean ayj;
    private boolean ayk;
    private boolean ayl;
    private boolean aym;
    private int ayn;
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
        this.axs = true;
        this.axt = true;
        this.axu = true;
        this.axv = true;
        this.axw = true;
        this.axx = true;
        this.axy = false;
        this.axz = false;
        this.axA = false;
        this.axB = false;
        this.axC = false;
        this.axD = false;
        this.ayf = 0;
        this.ayg = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.ayh = 0;
        this.ayi = 0;
        this.ayj = false;
        this.ayk = true;
        this.ayl = false;
        this.aym = false;
        this.isGod = false;
        this.aql = 3;
        this.padding = 0;
        this.ayn = 0;
        this.ayo = 0;
        this.ayp = 0;
        this.ayq = 0;
        this.ayC = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.f.ds24);
        this.ayo = (int) context.getResources().getDimension(d.f.ds100);
        this.ayn = (int) context.getResources().getDimension(d.f.ds70);
        this.ayp = (int) context.getResources().getDimension(d.f.ds18);
        this.ayq = (int) context.getResources().getDimension(d.f.ds4);
        this.ayr = (int) context.getResources().getDimension(d.f.ds80);
        this.ays = (int) context.getResources().getDimension(d.f.ds280);
        this.ayt = (int) context.getResources().getDimension(d.f.ds170);
        this.ayu = (int) context.getResources().getDimension(d.f.ds320);
        this.ayv = (int) context.getResources().getDimension(d.f.ds200);
        this.ayw = (int) context.getResources().getDimension(d.f.ds60);
        this.ayx = (int) context.getResources().getDimension(d.f.ds120);
        this.ayy = (int) context.getResources().getDimension(d.f.ds160);
        this.ayz = (int) context.getResources().getDimension(d.f.ds220);
        this.ayA = (int) context.getResources().getDimension(d.f.ds240);
        this.ayB = (int) context.getResources().getDimension(d.f.ds180);
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
        this.axE = (LinearLayout) inflate.findViewById(d.h.pl_card_root);
        this.axF = inflate.findViewById(d.h.author_info);
        this.axP = (LinearLayout) inflate.findViewById(d.h.photo_live_card_title);
        this.axT = (LinearLayout) inflate.findViewById(d.h.photo_live_card_content);
        this.axV = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_cover_and_expression);
        this.aya = (RelativeLayout) inflate.findViewById(d.h.photo_live_card_bottom);
        Bv();
        Bw();
        Bx();
        Bz();
        By();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.axs, photoLiveCardData);
            b(this.axt, this.axy, photoLiveCardData);
            b(this.axu, photoLiveCardData);
            a(this.axv, this.axw, photoLiveCardData);
            a(this.axx, photoLiveCardData);
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
            if (z && this.ayk) {
                if (this.paddingBottom != 0) {
                    this.axV.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axV.setPadding(this.padding, 0, this.padding, 0);
                }
                this.axV.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.axV != null) {
                this.axV.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.aya.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                n(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.axz);
                j(photoLiveCardData.getDiscussNum(), this.axC);
                return;
            }
            this.aya.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axP.setVisibility(0);
                if (this.ayi != 0) {
                    this.axQ.setMaxLines(this.ayi);
                } else {
                    this.axQ.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                m(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.axQ, photoLiveCardData.getThreadId());
                return;
            }
            this.axP.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.axD) {
            this.axS.setVisibility(0);
            this.axS.setTag(photoLiveCardData);
            return;
        }
        this.axS.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axT.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.axT.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.axT.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.axU, photoLiveCardData.getThreadId());
                return;
            }
            this.axT.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.ayl) {
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sl(String.valueOf(j))) {
                ai.c(textView, d.e.cp_cont_c, 1);
            } else {
                ai.c(textView, d.e.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.axF.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.axF.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.axF.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.axG.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.ayo;
                        layoutParams.width = this.ayo;
                    }
                    if (this.aye == null) {
                        this.aye = new TextView(this.context);
                        this.aye.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.aye.setEllipsize(TextUtils.TruncateAt.END);
                        this.aye.setTextSize(0, this.ayp);
                        ai.i(this.aye, d.e.cp_cont_h);
                        ai.j(this.aye, d.g.icon_shen);
                        this.aye.setSingleLine(true);
                        this.axI.addView(this.aye);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.aye.setText(d.l.god_intro_default);
                    } else {
                        this.aye.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.axI.removeView(this.aye);
                    this.aye = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.ayn;
                        layoutParams.width = this.ayn;
                    }
                }
                this.axG.setTag(photoLiveCardData);
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
            this.axI.removeView(this.aye);
            this.axF.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.axG.setPadding(this.ayq, this.ayq, this.ayq, this.ayq);
            if (this.isGod) {
                this.axH.setBackgroundDrawable(ai.getDrawable(d.g.pic_bg_jinbian));
                return;
            } else {
                this.axH.setBackgroundDrawable(ai.getDrawable(d.g.frs_touxiang_jinkuan));
                return;
            }
        }
        this.axH.setBackgroundDrawable(null);
        this.axG.setPadding(0, 0, 0, 0);
    }

    private void Bv() {
        if (this.axF != null) {
            this.axG = (HeadImageView) this.axF.findViewById(d.h.author_portrait);
            this.axH = (FrameLayout) this.axF.findViewById(d.h.author_portrait_info);
            this.axJ = (TextView) this.axF.findViewById(d.h.author_name);
            this.axK = (TextView) this.axF.findViewById(d.h.nick_name);
            this.axL = (TextView) this.axF.findViewById(d.h.fans_num);
            this.axM = (TextView) this.axF.findViewById(d.h.reply_num);
            this.axN = (TextView) this.axF.findViewById(d.h.headlive_icon);
            this.axO = (TextView) this.axF.findViewById(d.h.refresh_time_in_head);
            this.axI = (LinearLayout) this.axF.findViewById(d.h.author_info_and_time);
            this.axG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.axr != null) {
                        PhotoLiveCardView.this.axr.onPortraitClick(view);
                    }
                }
            });
        }
    }

    private void Bw() {
        if (this.axP != null) {
            this.axQ = (TextView) this.axP.findViewById(d.h.title);
            this.axR = (TextView) findViewById(d.h.refresh_time_in_title);
            this.axS = (TextView) this.axP.findViewById(d.h.card_delete_in_title);
            this.axS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.axq != null) {
                        PhotoLiveCardView.this.axq.onDeleteClick(view);
                    }
                }
            });
        }
    }

    private void Bx() {
        if (this.axT != null) {
            this.axU = (TextView) this.axT.findViewById(d.h.content);
        }
    }

    private void By() {
        if (this.aya != null) {
            this.ayb = (TextView) this.aya.findViewById(d.h.ba_name);
            this.ayc = (TextView) this.aya.findViewById(d.h.bottom_refresh_time);
            this.ayd = (TextView) this.aya.findViewById(d.h.bottom_reply_num);
        }
    }

    private void Bz() {
        if (this.axV != null) {
            this.axW = (TbImageView) this.axV.findViewById(d.h.live_cover);
            this.axW.setGifIconSupport(false);
            BA();
        }
    }

    private void BA() {
        if (this.axV != null) {
            this.axX = (TextView) this.axV.findViewById(d.h.first_style_first_expression);
            this.axY = (TextView) this.axV.findViewById(d.h.first_style_second_expression);
            this.axZ = (TextView) this.axV.findViewById(d.h.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.ayg.clear();
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
        if (this.ayg.size() != 0) {
            int size = this.ayg.size();
            for (int i = 0; i < size; i++) {
                if (this.ayg.get(i).intValue() == this.axX.getId()) {
                    this.axX.setVisibility(8);
                } else if (this.ayg.get(i).intValue() == this.axY.getId()) {
                    this.axY.setVisibility(8);
                } else if (this.ayg.get(i).intValue() == this.axZ.getId()) {
                    this.axZ.setVisibility(8);
                }
            }
        }
    }

    private void BC() {
        this.axX.setText("");
        this.axY.setText("");
        this.axZ.setText("");
        if (this.axX.getVisibility() == 8) {
            this.axX.setVisibility(0);
        }
        if (this.axY.getVisibility() == 8) {
            this.axY.setVisibility(0);
        }
        if (this.axZ.getVisibility() == 8) {
            this.axZ.setVisibility(0);
        }
        this.ayg.add(Integer.valueOf(this.axX.getId()));
        this.ayg.add(Integer.valueOf(this.axY.getId()));
        this.ayg.add(Integer.valueOf(this.axZ.getId()));
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
            switch (this.ayf) {
                case 0:
                    a(this.ayr, this.ays, this.axX);
                    a(this.ayt, this.ayu, this.axY);
                    a(this.ayv, this.ayw, this.axZ);
                    break;
                case 1:
                    a(this.ayw, this.ayx, this.axX);
                    a(this.ayy, this.ayw, this.axY);
                    a(this.ayz, this.ayu, this.axZ);
                    break;
                case 2:
                    a(this.ayw, this.ayA, this.axX);
                    a(this.ayB, this.ayw, this.axY);
                    a(this.ayz, this.ayu, this.axZ);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.axX);
            } else if (i == 1) {
                a(arrayList.get(i2), this.axY);
            } else if (i == 2) {
                a(arrayList.get(i2), this.axZ);
            }
        }
    }

    private void en(int i) {
        if (this.ayg.size() != 0) {
            int size = this.ayg.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.ayg.get(i2).intValue() == i) {
                    this.ayg.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.axW.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.axW.c(str, 10, false);
        } else {
            this.axW.c(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ayb.setText("");
            return;
        }
        String trim = str.trim();
        this.ayb.setVisibility(0);
        if (v.gT(trim) > 12) {
            trim = v.d(trim, 0, 12) + "...";
        }
        this.ayb.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.l.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axU.setText("");
            this.axU.setVisibility(8);
            return;
        }
        this.axU.setVisibility(0);
        this.axU.setText(str);
    }

    private void setTitle(String str) {
        this.ayC = str;
        if (this.ayh != 0) {
            this.axQ.setPadding(0, 0, (int) this.context.getResources().getDimension(this.ayh), 0);
            this.ayh = 0;
        } else {
            this.axQ.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.axQ.setText("");
            return;
        }
        this.axQ.setVisibility(0);
        if (this.ayj) {
            if (this.aym) {
                this.axQ.setText(m.c(this.context, str, d.l.photo_live_tips));
                return;
            } else {
                this.axQ.setText(e(str));
                return;
            }
        }
        this.axQ.setText(str);
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
            this.axG.c(str, 12, false);
        } else {
            this.axG.c(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.axJ.setText("");
            return;
        }
        this.axJ.setVisibility(0);
        String trim = str.trim();
        if (v.gT(trim) > 14) {
            trim = v.d(trim, 0, 14) + "...";
        }
        this.axJ.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.axK, this.context.getResources().getString(d.l.fans_default_name));
        } else {
            b(this.axK, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = ai.getDrawable(d.g.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.axL.setText(al.z(i));
    }

    private void setReplyNum(int i) {
        b(this.axM, i);
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
            this.ayd.setVisibility(0);
            b(this.ayd, i);
            return;
        }
        this.ayd.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.axB) {
            this.axN.setVisibility(0);
            ai.j(this.axN, d.g.label_onthelist);
            return;
        }
        this.axN.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.axA) {
            this.axO.setVisibility(0);
            this.axO.setText(str);
            return;
        }
        this.axO.setVisibility(8);
        this.axO.setText("");
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.axR.setVisibility(8);
            return;
        }
        this.axR.setVisibility(0);
        this.axR.setText(str);
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.ayc.setVisibility(8);
            return;
        }
        this.ayc.setVisibility(0);
        this.ayc.setText(str);
    }

    public void setShowHead(boolean z) {
        this.axs = z;
    }

    public void setShowTitle(boolean z) {
        this.axt = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.axy = z;
    }

    public void setShowContent(boolean z) {
        this.axu = z;
    }

    public void setShowCover(boolean z) {
        this.axv = z;
    }

    public void setShowExpression(boolean z) {
        this.axw = z;
    }

    public void setShowBottom(boolean z) {
        this.axx = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.axA = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.axB = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.axC = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.axD = z;
    }

    public void setChooseStyle(int i) {
        this.ayf = i;
    }

    public int getShowStyle() {
        return this.ayf;
    }

    public void setShowLiveIcon(boolean z) {
        this.ayj = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.axq = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.axr = bVar;
    }

    public void setParentBackground(int i) {
        ai.j(this.axE, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.ayk = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.axz = z;
    }

    public void setTitlePaddingRight(int i) {
        this.ayh = i;
    }

    public void setTitleMaxLines(int i) {
        this.ayi = i;
    }

    public void setAllowGreyState(boolean z) {
        this.ayl = z;
    }

    public void bp(boolean z) {
        this.aym = z;
    }
}
