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
    public int bfC;
    private boolean bnA;
    private LinearLayout bnB;
    private View bnC;
    private HeadImageView bnD;
    private FrameLayout bnE;
    private LinearLayout bnF;
    private TextView bnG;
    private TextView bnH;
    private TextView bnI;
    private TextView bnJ;
    private TextView bnK;
    private TextView bnL;
    private LinearLayout bnM;
    private TextView bnN;
    private TextView bnO;
    private LinearLayout bnP;
    private TextView bnQ;
    private RelativeLayout bnR;
    private TbImageView bnS;
    private TextView bnT;
    private TextView bnU;
    private TextView bnV;
    private RelativeLayout bnW;
    private TextView bnX;
    private TextView bnY;
    private TextView bnZ;
    private a bnn;
    private b bno;
    private boolean bnp;
    private boolean bnq;
    private boolean bnr;
    private boolean bns;
    private boolean bnt;
    private boolean bnu;
    private boolean bnv;
    private boolean bnw;
    private boolean bnx;
    private boolean bny;
    private boolean bnz;
    private TextView boa;
    private int bob;
    private ArrayList<Integer> boc;
    private int bod;
    private int boe;
    private boolean bof;
    private boolean bog;
    private boolean boh;
    private boolean boi;
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
    private int bov;
    private int bow;
    private int box;
    private String boy;
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
        this.bnp = true;
        this.bnq = true;
        this.bnr = true;
        this.bns = true;
        this.bnt = true;
        this.bnu = true;
        this.bnv = false;
        this.bnw = false;
        this.bnx = false;
        this.bny = false;
        this.bnz = false;
        this.bnA = false;
        this.bob = 0;
        this.boc = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.bod = 0;
        this.boe = 0;
        this.bof = false;
        this.bog = true;
        this.boh = false;
        this.boi = false;
        this.isGod = false;
        this.bfC = 3;
        this.padding = 0;
        this.boj = 0;
        this.bok = 0;
        this.bol = 0;
        this.bom = 0;
        this.boy = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.bok = (int) context.getResources().getDimension(d.e.ds100);
        this.boj = (int) context.getResources().getDimension(d.e.ds70);
        this.bol = (int) context.getResources().getDimension(d.e.ds18);
        this.bom = (int) context.getResources().getDimension(d.e.ds4);
        this.bon = (int) context.getResources().getDimension(d.e.ds80);
        this.boo = (int) context.getResources().getDimension(d.e.ds280);
        this.bop = (int) context.getResources().getDimension(d.e.ds170);
        this.boq = (int) context.getResources().getDimension(d.e.ds320);
        this.bor = (int) context.getResources().getDimension(d.e.ds200);
        this.bos = (int) context.getResources().getDimension(d.e.ds60);
        this.bot = (int) context.getResources().getDimension(d.e.ds120);
        this.bou = (int) context.getResources().getDimension(d.e.ds160);
        this.bov = (int) context.getResources().getDimension(d.e.ds220);
        this.bow = (int) context.getResources().getDimension(d.e.ds240);
        this.box = (int) context.getResources().getDimension(d.e.ds180);
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
        this.bnB = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.bnC = inflate.findViewById(d.g.author_info);
        this.bnM = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.bnP = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.bnR = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.bnW = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        Jn();
        Jo();
        Jp();
        Jr();
        Jq();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.bnp, photoLiveCardData);
            b(this.bnq, this.bnv, photoLiveCardData);
            b(this.bnr, photoLiveCardData);
            a(this.bns, this.bnt, photoLiveCardData);
            a(this.bnu, photoLiveCardData);
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
            if (z && this.bog) {
                if (this.paddingBottom != 0) {
                    this.bnR.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.bnR.setPadding(this.padding, 0, this.padding, 0);
                }
                this.bnR.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.bnR != null) {
                this.bnR.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnW.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                l(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.bnw);
                x(photoLiveCardData.getDiscussNum(), this.bnz);
                return;
            }
            this.bnW.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnM.setVisibility(0);
                if (this.boe != 0) {
                    this.title.setMaxLines(this.boe);
                } else {
                    this.title.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                k(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.title, photoLiveCardData.getThreadId());
                return;
            }
            this.bnM.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.bnA) {
            this.bnO.setVisibility(0);
            this.bnO.setTag(photoLiveCardData);
            return;
        }
        this.bnO.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnP.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.bnP.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.bnP.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.bnQ, photoLiveCardData.getThreadId());
                return;
            }
            this.bnP.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.boh) {
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
                this.bnC.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.bnC.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.bnC.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.bnD.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.bok;
                        layoutParams.width = this.bok;
                    }
                    if (this.boa == null) {
                        this.boa = new TextView(this.context);
                        this.boa.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.boa.setEllipsize(TextUtils.TruncateAt.END);
                        this.boa.setTextSize(0, this.bol);
                        aj.r(this.boa, d.C0141d.cp_cont_h);
                        aj.s(this.boa, d.f.icon_shen);
                        this.boa.setSingleLine(true);
                        this.bnF.addView(this.boa);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.boa.setText(d.j.god_intro_default);
                    } else {
                        this.boa.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.bnF.removeView(this.boa);
                    this.boa = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.boj;
                        layoutParams.width = this.boj;
                    }
                }
                this.bnD.setTag(photoLiveCardData);
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
            this.bnF.removeView(this.boa);
            this.bnC.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.bnD.setPadding(this.bom, this.bom, this.bom, this.bom);
            if (this.isGod) {
                this.bnE.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.bnE.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.bnE.setBackgroundDrawable(null);
        this.bnD.setPadding(0, 0, 0, 0);
    }

    private void Jn() {
        if (this.bnC != null) {
            this.bnD = (HeadImageView) this.bnC.findViewById(d.g.author_portrait);
            this.bnE = (FrameLayout) this.bnC.findViewById(d.g.author_portrait_info);
            this.bnG = (TextView) this.bnC.findViewById(d.g.author_name);
            this.bnH = (TextView) this.bnC.findViewById(d.g.nick_name);
            this.bnI = (TextView) this.bnC.findViewById(d.g.fans_num);
            this.bnJ = (TextView) this.bnC.findViewById(d.g.reply_num);
            this.bnK = (TextView) this.bnC.findViewById(d.g.headlive_icon);
            this.bnL = (TextView) this.bnC.findViewById(d.g.refresh_time_in_head);
            this.bnF = (LinearLayout) this.bnC.findViewById(d.g.author_info_and_time);
            this.bnD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bno != null) {
                        PhotoLiveCardView.this.bno.bg(view);
                    }
                }
            });
        }
    }

    private void Jo() {
        if (this.bnM != null) {
            this.title = (TextView) this.bnM.findViewById(d.g.title);
            this.bnN = (TextView) findViewById(d.g.refresh_time_in_title);
            this.bnO = (TextView) this.bnM.findViewById(d.g.card_delete_in_title);
            this.bnO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bnn != null) {
                        PhotoLiveCardView.this.bnn.bf(view);
                    }
                }
            });
        }
    }

    private void Jp() {
        if (this.bnP != null) {
            this.bnQ = (TextView) this.bnP.findViewById(d.g.content);
        }
    }

    private void Jq() {
        if (this.bnW != null) {
            this.bnX = (TextView) this.bnW.findViewById(d.g.ba_name);
            this.bnY = (TextView) this.bnW.findViewById(d.g.bottom_refresh_time);
            this.bnZ = (TextView) this.bnW.findViewById(d.g.bottom_reply_num);
        }
    }

    private void Jr() {
        if (this.bnR != null) {
            this.bnS = (TbImageView) this.bnR.findViewById(d.g.live_cover);
            this.bnS.setGifIconSupport(false);
            Js();
        }
    }

    private void Js() {
        if (this.bnR != null) {
            this.bnT = (TextView) this.bnR.findViewById(d.g.first_style_first_expression);
            this.bnU = (TextView) this.bnR.findViewById(d.g.first_style_second_expression);
            this.bnV = (TextView) this.bnR.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.boc.clear();
        Ju();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Jt();
        }
    }

    private void Jt() {
        if (this.boc.size() != 0) {
            int size = this.boc.size();
            for (int i = 0; i < size; i++) {
                if (this.boc.get(i).intValue() == this.bnT.getId()) {
                    this.bnT.setVisibility(8);
                } else if (this.boc.get(i).intValue() == this.bnU.getId()) {
                    this.bnU.setVisibility(8);
                } else if (this.boc.get(i).intValue() == this.bnV.getId()) {
                    this.bnV.setVisibility(8);
                }
            }
        }
    }

    private void Ju() {
        this.bnT.setText("");
        this.bnU.setText("");
        this.bnV.setText("");
        if (this.bnT.getVisibility() == 8) {
            this.bnT.setVisibility(0);
        }
        if (this.bnU.getVisibility() == 8) {
            this.bnU.setVisibility(0);
        }
        if (this.bnV.getVisibility() == 8) {
            this.bnV.setVisibility(0);
        }
        this.boc.add(Integer.valueOf(this.bnT.getId()));
        this.boc.add(Integer.valueOf(this.bnU.getId()));
        this.boc.add(Integer.valueOf(this.bnV.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.Jk())));
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
            switch (this.bob) {
                case 0:
                    a(this.bon, this.boo, this.bnT);
                    a(this.bop, this.boq, this.bnU);
                    a(this.bor, this.bos, this.bnV);
                    break;
                case 1:
                    a(this.bos, this.bot, this.bnT);
                    a(this.bou, this.bos, this.bnU);
                    a(this.bov, this.boq, this.bnV);
                    break;
                case 2:
                    a(this.bos, this.bow, this.bnT);
                    a(this.box, this.bos, this.bnU);
                    a(this.bov, this.boq, this.bnV);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bnT);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bnU);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bnV);
            }
        }
    }

    private void hq(int i) {
        if (this.boc.size() != 0) {
            int size = this.boc.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.boc.get(i2).intValue() == i) {
                    this.boc.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.bnS.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.bnS.startLoad(str, 10, false);
        } else {
            this.bnS.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.bnX.setText("");
            return;
        }
        String trim = str.trim();
        this.bnX.setVisibility(0);
        if (w.hs(trim) > 12) {
            trim = w.j(trim, 0, 12) + "...";
        }
        this.bnX.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.bnQ.setText("");
            this.bnQ.setVisibility(8);
            return;
        }
        this.bnQ.setVisibility(0);
        this.bnQ.setText(str);
    }

    private void setTitle(String str) {
        this.boy = str;
        if (this.bod != 0) {
            this.title.setPadding(0, 0, (int) this.context.getResources().getDimension(this.bod), 0);
            this.bod = 0;
        } else {
            this.title.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.title.setText("");
            return;
        }
        this.title.setVisibility(0);
        if (this.bof) {
            if (this.boi) {
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
            this.bnD.startLoad(str, 12, false);
        } else {
            this.bnD.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.bnG.setText("");
            return;
        }
        this.bnG.setVisibility(0);
        String trim = str.trim();
        if (w.hs(trim) > 14) {
            trim = w.j(trim, 0, 14) + "...";
        }
        this.bnG.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.bnH, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.bnH, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.bnI.setText(am.H(i));
    }

    private void setReplyNum(int i) {
        b(this.bnJ, i);
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
            this.bnZ.setVisibility(0);
            b(this.bnZ, i);
            return;
        }
        this.bnZ.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.bny) {
            this.bnK.setVisibility(0);
            aj.s(this.bnK, d.f.label_onthelist);
            return;
        }
        this.bnK.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.bnx) {
            this.bnL.setVisibility(0);
            this.bnL.setText(str);
            return;
        }
        this.bnL.setVisibility(8);
        this.bnL.setText("");
    }

    private void k(String str, boolean z) {
        if (!z) {
            this.bnN.setVisibility(8);
            return;
        }
        this.bnN.setVisibility(0);
        this.bnN.setText(str);
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.bnY.setVisibility(8);
            return;
        }
        this.bnY.setVisibility(0);
        this.bnY.setText(str);
    }

    public void setShowHead(boolean z) {
        this.bnp = z;
    }

    public void setShowTitle(boolean z) {
        this.bnq = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.bnv = z;
    }

    public void setShowContent(boolean z) {
        this.bnr = z;
    }

    public void setShowCover(boolean z) {
        this.bns = z;
    }

    public void setShowExpression(boolean z) {
        this.bnt = z;
    }

    public void setShowBottom(boolean z) {
        this.bnu = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.bnx = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.bny = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.bnz = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.bnA = z;
    }

    public void setChooseStyle(int i) {
        this.bob = i;
    }

    public int getShowStyle() {
        return this.bob;
    }

    public void setShowLiveIcon(boolean z) {
        this.bof = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.bnn = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.bno = bVar;
    }

    public void setParentBackground(int i) {
        aj.s(this.bnB, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.bog = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.bnw = z;
    }

    public void setTitlePaddingRight(int i) {
        this.bod = i;
    }

    public void setTitleMaxLines(int i) {
        this.boe = i;
    }

    public void setAllowGreyState(boolean z) {
        this.boh = z;
    }
}
