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
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int bfz;
    private HeadImageView bnA;
    private FrameLayout bnB;
    private LinearLayout bnC;
    private TextView bnD;
    private TextView bnE;
    private TextView bnF;
    private TextView bnG;
    private TextView bnH;
    private TextView bnI;
    private LinearLayout bnJ;
    private TextView bnK;
    private TextView bnL;
    private LinearLayout bnM;
    private TextView bnN;
    private RelativeLayout bnO;
    private TbImageView bnP;
    private TextView bnQ;
    private TextView bnR;
    private TextView bnS;
    private RelativeLayout bnT;
    private TextView bnU;
    private TextView bnV;
    private TextView bnW;
    private TextView bnX;
    private int bnY;
    private ArrayList<Integer> bnZ;
    private a bnk;
    private b bnl;
    private boolean bnm;
    private boolean bnn;
    private boolean bno;
    private boolean bnp;
    private boolean bnq;
    private boolean bnr;
    private boolean bns;
    private boolean bnt;
    private boolean bnu;
    private boolean bnv;
    private boolean bnw;
    private boolean bnx;
    private LinearLayout bny;
    private View bnz;
    private int boa;
    private int bob;
    private boolean boc;
    private boolean bod;
    private boolean boe;
    private boolean bof;
    private int bog;
    private int boh;
    private int boi;
    private int boj;
    private int bok;
    private int bol;
    private int bom;
    private int bon;
    private int boo;
    private int bop;
    private int boq;
    private int bor;
    private int bos;
    private int bot;
    private int bou;
    private String bov;
    private Context context;
    private boolean isGod;
    private int padding;
    private int paddingBottom;
    private int paddingTop;
    private int size;
    private TextView title;

    /* loaded from: classes.dex */
    public interface a {
        void bf(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bg(View view);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnm = true;
        this.bnn = true;
        this.bno = true;
        this.bnp = true;
        this.bnq = true;
        this.bnr = true;
        this.bns = false;
        this.bnt = false;
        this.bnu = false;
        this.bnv = false;
        this.bnw = false;
        this.bnx = false;
        this.bnY = 0;
        this.bnZ = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.boa = 0;
        this.bob = 0;
        this.boc = false;
        this.bod = true;
        this.boe = false;
        this.bof = false;
        this.isGod = false;
        this.bfz = 3;
        this.padding = 0;
        this.bog = 0;
        this.boh = 0;
        this.boi = 0;
        this.boj = 0;
        this.bov = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.boh = (int) context.getResources().getDimension(d.e.ds100);
        this.bog = (int) context.getResources().getDimension(d.e.ds70);
        this.boi = (int) context.getResources().getDimension(d.e.ds18);
        this.boj = (int) context.getResources().getDimension(d.e.ds4);
        this.bok = (int) context.getResources().getDimension(d.e.ds80);
        this.bol = (int) context.getResources().getDimension(d.e.ds280);
        this.bom = (int) context.getResources().getDimension(d.e.ds170);
        this.bon = (int) context.getResources().getDimension(d.e.ds320);
        this.boo = (int) context.getResources().getDimension(d.e.ds200);
        this.bop = (int) context.getResources().getDimension(d.e.ds60);
        this.boq = (int) context.getResources().getDimension(d.e.ds120);
        this.bor = (int) context.getResources().getDimension(d.e.ds160);
        this.bos = (int) context.getResources().getDimension(d.e.ds220);
        this.bot = (int) context.getResources().getDimension(d.e.ds240);
        this.bou = (int) context.getResources().getDimension(d.e.ds180);
        this.size = (int) context.getResources().getDimension(d.e.ds8);
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCardView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_view, this);
        this.bny = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.bnz = inflate.findViewById(d.g.author_info);
        this.bnJ = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.bnM = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.bnO = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.bnT = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        Jm();
        Jn();
        Jo();
        Jq();
        Jp();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.bnm, photoLiveCardData);
            b(this.bnn, this.bns, photoLiveCardData);
            b(this.bno, photoLiveCardData);
            a(this.bnp, this.bnq, photoLiveCardData);
            a(this.bnr, photoLiveCardData);
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
            if (z && this.bod) {
                if (this.paddingBottom != 0) {
                    this.bnO.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.bnO.setPadding(this.padding, 0, this.padding, 0);
                }
                this.bnO.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.bnO != null) {
                this.bnO.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnT.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                l(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.bnt);
                x(photoLiveCardData.getDiscussNum(), this.bnw);
                return;
            }
            this.bnT.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnJ.setVisibility(0);
                if (this.bob != 0) {
                    this.title.setMaxLines(this.bob);
                } else {
                    this.title.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                k(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.title, photoLiveCardData.getThreadId());
                return;
            }
            this.bnJ.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.bnx) {
            this.bnL.setVisibility(0);
            this.bnL.setTag(photoLiveCardData);
            return;
        }
        this.bnL.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnM.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.bnM.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.bnM.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.bnN, photoLiveCardData.getThreadId());
                return;
            }
            this.bnM.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.boe) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sW(String.valueOf(j))) {
                aj.e(textView, d.C0141d.cp_cont_c, 1);
            } else {
                aj.e(textView, d.C0141d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnz.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.bnz.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.bnz.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.bnA.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.boh;
                        layoutParams.width = this.boh;
                    }
                    if (this.bnX == null) {
                        this.bnX = new TextView(this.context);
                        this.bnX.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.bnX.setEllipsize(TextUtils.TruncateAt.END);
                        this.bnX.setTextSize(0, this.boi);
                        aj.r(this.bnX, d.C0141d.cp_cont_h);
                        aj.s(this.bnX, d.f.icon_shen);
                        this.bnX.setSingleLine(true);
                        this.bnC.addView(this.bnX);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.bnX.setText(d.j.god_intro_default);
                    } else {
                        this.bnX.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.bnC.removeView(this.bnX);
                    this.bnX = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.bog;
                        layoutParams.width = this.bog;
                    }
                }
                this.bnA.setTag(photoLiveCardData);
                fM(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.bnC.removeView(this.bnX);
            this.bnz.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.bnA.setPadding(this.boj, this.boj, this.boj, this.boj);
            if (this.isGod) {
                this.bnB.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.bnB.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.bnB.setBackgroundDrawable(null);
        this.bnA.setPadding(0, 0, 0, 0);
    }

    private void Jm() {
        if (this.bnz != null) {
            this.bnA = (HeadImageView) this.bnz.findViewById(d.g.author_portrait);
            this.bnB = (FrameLayout) this.bnz.findViewById(d.g.author_portrait_info);
            this.bnD = (TextView) this.bnz.findViewById(d.g.author_name);
            this.bnE = (TextView) this.bnz.findViewById(d.g.nick_name);
            this.bnF = (TextView) this.bnz.findViewById(d.g.fans_num);
            this.bnG = (TextView) this.bnz.findViewById(d.g.reply_num);
            this.bnH = (TextView) this.bnz.findViewById(d.g.headlive_icon);
            this.bnI = (TextView) this.bnz.findViewById(d.g.refresh_time_in_head);
            this.bnC = (LinearLayout) this.bnz.findViewById(d.g.author_info_and_time);
            this.bnA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bnl != null) {
                        PhotoLiveCardView.this.bnl.bg(view);
                    }
                }
            });
        }
    }

    private void Jn() {
        if (this.bnJ != null) {
            this.title = (TextView) this.bnJ.findViewById(d.g.title);
            this.bnK = (TextView) findViewById(d.g.refresh_time_in_title);
            this.bnL = (TextView) this.bnJ.findViewById(d.g.card_delete_in_title);
            this.bnL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bnk != null) {
                        PhotoLiveCardView.this.bnk.bf(view);
                    }
                }
            });
        }
    }

    private void Jo() {
        if (this.bnM != null) {
            this.bnN = (TextView) this.bnM.findViewById(d.g.content);
        }
    }

    private void Jp() {
        if (this.bnT != null) {
            this.bnU = (TextView) this.bnT.findViewById(d.g.ba_name);
            this.bnV = (TextView) this.bnT.findViewById(d.g.bottom_refresh_time);
            this.bnW = (TextView) this.bnT.findViewById(d.g.bottom_reply_num);
        }
    }

    private void Jq() {
        if (this.bnO != null) {
            this.bnP = (TbImageView) this.bnO.findViewById(d.g.live_cover);
            this.bnP.setGifIconSupport(false);
            Jr();
        }
    }

    private void Jr() {
        if (this.bnO != null) {
            this.bnQ = (TextView) this.bnO.findViewById(d.g.first_style_first_expression);
            this.bnR = (TextView) this.bnO.findViewById(d.g.first_style_second_expression);
            this.bnS = (TextView) this.bnO.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.bnZ.clear();
        Jt();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Js();
        }
    }

    private void Js() {
        if (this.bnZ.size() != 0) {
            int size = this.bnZ.size();
            for (int i = 0; i < size; i++) {
                if (this.bnZ.get(i).intValue() == this.bnQ.getId()) {
                    this.bnQ.setVisibility(8);
                } else if (this.bnZ.get(i).intValue() == this.bnR.getId()) {
                    this.bnR.setVisibility(8);
                } else if (this.bnZ.get(i).intValue() == this.bnS.getId()) {
                    this.bnS.setVisibility(8);
                }
            }
        }
    }

    private void Jt() {
        this.bnQ.setText("");
        this.bnR.setText("");
        this.bnS.setText("");
        if (this.bnQ.getVisibility() == 8) {
            this.bnQ.setVisibility(0);
        }
        if (this.bnR.getVisibility() == 8) {
            this.bnR.setVisibility(0);
        }
        if (this.bnS.getVisibility() == 8) {
            this.bnS.setVisibility(0);
        }
        this.bnZ.add(Integer.valueOf(this.bnQ.getId()));
        this.bnZ.add(Integer.valueOf(this.bnR.getId()));
        this.bnZ.add(Integer.valueOf(this.bnS.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.Jj())));
            hq(textView.getId());
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
            switch (this.bnY) {
                case 0:
                    a(this.bok, this.bol, this.bnQ);
                    a(this.bom, this.bon, this.bnR);
                    a(this.boo, this.bop, this.bnS);
                    break;
                case 1:
                    a(this.bop, this.boq, this.bnQ);
                    a(this.bor, this.bop, this.bnR);
                    a(this.bos, this.bon, this.bnS);
                    break;
                case 2:
                    a(this.bop, this.bot, this.bnQ);
                    a(this.bou, this.bop, this.bnR);
                    a(this.bos, this.bon, this.bnS);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bnQ);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bnR);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bnS);
            }
        }
    }

    private void hq(int i) {
        if (this.bnZ.size() != 0) {
            int size = this.bnZ.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bnZ.get(i2).intValue() == i) {
                    this.bnZ.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.bnP.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.bnP.startLoad(str, 10, false);
        } else {
            this.bnP.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.bnU.setText("");
            return;
        }
        String trim = str.trim();
        this.bnU.setVisibility(0);
        if (w.hs(trim) > 12) {
            trim = w.j(trim, 0, 12) + "...";
        }
        this.bnU.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.bnN.setText("");
            this.bnN.setVisibility(8);
            return;
        }
        this.bnN.setVisibility(0);
        this.bnN.setText(str);
    }

    private void setTitle(String str) {
        this.bov = str;
        if (this.boa != 0) {
            this.title.setPadding(0, 0, (int) this.context.getResources().getDimension(this.boa), 0);
            this.boa = 0;
        } else {
            this.title.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.title.setText("");
            return;
        }
        this.title.setVisibility(0);
        if (this.boc) {
            if (this.bof) {
                this.title.setText(j.c(this.context, str, d.j.photo_live_tips));
                return;
            } else {
                this.title.setText(s(str));
                return;
            }
        }
        this.title.setText(str);
    }

    public static SpannableStringBuilder s(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("livespace" + ((Object) charSequence));
        Bitmap fO = aj.fO(d.f.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
        int height = fO.getHeight();
        bitmapDrawable.setBounds(0, 0, fO.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void fM(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bnA.startLoad(str, 12, false);
        } else {
            this.bnA.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.bnD.setText("");
            return;
        }
        this.bnD.setVisibility(0);
        String trim = str.trim();
        if (w.hs(trim) > 14) {
            trim = w.j(trim, 0, 14) + "...";
        }
        this.bnD.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.bnE, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.bnE, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.bnF.setText(am.H(i));
    }

    private void setReplyNum(int i) {
        b(this.bnG, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(am.H(j));
        Drawable drawable = aj.getDrawable(d.f.icon_comment_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void x(int i, boolean z) {
        if (z) {
            this.bnW.setVisibility(0);
            b(this.bnW, i);
            return;
        }
        this.bnW.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.bnv) {
            this.bnH.setVisibility(0);
            aj.s(this.bnH, d.f.label_onthelist);
            return;
        }
        this.bnH.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.bnu) {
            this.bnI.setVisibility(0);
            this.bnI.setText(str);
            return;
        }
        this.bnI.setVisibility(8);
        this.bnI.setText("");
    }

    private void k(String str, boolean z) {
        if (!z) {
            this.bnK.setVisibility(8);
            return;
        }
        this.bnK.setVisibility(0);
        this.bnK.setText(str);
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.bnV.setVisibility(8);
            return;
        }
        this.bnV.setVisibility(0);
        this.bnV.setText(str);
    }

    public void setShowHead(boolean z) {
        this.bnm = z;
    }

    public void setShowTitle(boolean z) {
        this.bnn = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.bns = z;
    }

    public void setShowContent(boolean z) {
        this.bno = z;
    }

    public void setShowCover(boolean z) {
        this.bnp = z;
    }

    public void setShowExpression(boolean z) {
        this.bnq = z;
    }

    public void setShowBottom(boolean z) {
        this.bnr = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.bnu = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.bnv = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.bnw = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.bnx = z;
    }

    public void setChooseStyle(int i) {
        this.bnY = i;
    }

    public int getShowStyle() {
        return this.bnY;
    }

    public void setShowLiveIcon(boolean z) {
        this.boc = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.bnk = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.bnl = bVar;
    }

    public void setParentBackground(int i) {
        aj.s(this.bny, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.bod = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.bnt = z;
    }

    public void setTitlePaddingRight(int i) {
        this.boa = i;
    }

    public void setTitleMaxLines(int i) {
        this.bob = i;
    }

    public void setAllowGreyState(boolean z) {
        this.boe = z;
    }
}
