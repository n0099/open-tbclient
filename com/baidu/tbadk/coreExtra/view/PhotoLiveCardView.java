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
    public int bfL;
    private boolean bnA;
    private boolean bnB;
    private boolean bnC;
    private boolean bnD;
    private boolean bnE;
    private boolean bnF;
    private boolean bnG;
    private boolean bnH;
    private boolean bnI;
    private boolean bnJ;
    private boolean bnK;
    private LinearLayout bnL;
    private View bnM;
    private HeadImageView bnN;
    private FrameLayout bnO;
    private LinearLayout bnP;
    private TextView bnQ;
    private TextView bnR;
    private TextView bnS;
    private TextView bnT;
    private TextView bnU;
    private TextView bnV;
    private LinearLayout bnW;
    private TextView bnX;
    private TextView bnY;
    private LinearLayout bnZ;
    private a bnx;
    private b bny;
    private boolean bnz;
    private int boA;
    private int boB;
    private int boC;
    private int boD;
    private int boE;
    private int boF;
    private int boG;
    private int boH;
    private String boI;
    private TextView boa;
    private RelativeLayout bob;
    private TbImageView boc;
    private TextView bod;
    private TextView boe;
    private TextView bof;
    private RelativeLayout bog;
    private TextView boh;
    private TextView boi;
    private TextView boj;
    private TextView bok;
    private int bol;
    private ArrayList<Integer> bom;
    private int bon;
    private int boo;
    private boolean bop;
    private boolean boq;
    private boolean bor;
    private boolean bos;
    private int bot;
    private int bou;
    private int bov;
    private int bow;
    private int box;
    private int boy;
    private int boz;
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
        this.bnz = true;
        this.bnA = true;
        this.bnB = true;
        this.bnC = true;
        this.bnD = true;
        this.bnE = true;
        this.bnF = false;
        this.bnG = false;
        this.bnH = false;
        this.bnI = false;
        this.bnJ = false;
        this.bnK = false;
        this.bol = 0;
        this.bom = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.bon = 0;
        this.boo = 0;
        this.bop = false;
        this.boq = true;
        this.bor = false;
        this.bos = false;
        this.isGod = false;
        this.bfL = 3;
        this.padding = 0;
        this.bot = 0;
        this.bou = 0;
        this.bov = 0;
        this.bow = 0;
        this.boI = "";
        this.context = context;
        this.padding = (int) context.getResources().getDimension(d.e.ds24);
        this.bou = (int) context.getResources().getDimension(d.e.ds100);
        this.bot = (int) context.getResources().getDimension(d.e.ds70);
        this.bov = (int) context.getResources().getDimension(d.e.ds18);
        this.bow = (int) context.getResources().getDimension(d.e.ds4);
        this.box = (int) context.getResources().getDimension(d.e.ds80);
        this.boy = (int) context.getResources().getDimension(d.e.ds280);
        this.boz = (int) context.getResources().getDimension(d.e.ds170);
        this.boA = (int) context.getResources().getDimension(d.e.ds320);
        this.boB = (int) context.getResources().getDimension(d.e.ds200);
        this.boC = (int) context.getResources().getDimension(d.e.ds60);
        this.boD = (int) context.getResources().getDimension(d.e.ds120);
        this.boE = (int) context.getResources().getDimension(d.e.ds160);
        this.boF = (int) context.getResources().getDimension(d.e.ds220);
        this.boG = (int) context.getResources().getDimension(d.e.ds240);
        this.boH = (int) context.getResources().getDimension(d.e.ds180);
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
        this.bnL = (LinearLayout) inflate.findViewById(d.g.pl_card_root);
        this.bnM = inflate.findViewById(d.g.author_info);
        this.bnW = (LinearLayout) inflate.findViewById(d.g.photo_live_card_title);
        this.bnZ = (LinearLayout) inflate.findViewById(d.g.photo_live_card_content);
        this.bob = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_cover_and_expression);
        this.bog = (RelativeLayout) inflate.findViewById(d.g.photo_live_card_bottom);
        Jn();
        Jo();
        Jp();
        Jr();
        Jq();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            c(this.bnz, photoLiveCardData);
            b(this.bnA, this.bnF, photoLiveCardData);
            b(this.bnB, photoLiveCardData);
            a(this.bnC, this.bnD, photoLiveCardData);
            a(this.bnE, photoLiveCardData);
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
            if (z && this.boq) {
                if (this.paddingBottom != 0) {
                    this.bob.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.bob.setPadding(this.padding, 0, this.padding, 0);
                }
                this.bob.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.bob != null) {
                this.bob.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bog.setVisibility(0);
                setBaName(photoLiveCardData.getForumName());
                m(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.bnG);
                x(photoLiveCardData.getDiscussNum(), this.bnJ);
                return;
            }
            this.bog.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnW.setVisibility(0);
                if (this.boo != 0) {
                    this.title.setMaxLines(this.boo);
                } else {
                    this.title.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                l(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.title, photoLiveCardData.getThreadId());
                return;
            }
            this.bnW.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.bnK) {
            this.bnY.setVisibility(0);
            this.bnY.setTag(photoLiveCardData);
            return;
        }
        this.bnY.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnZ.setVisibility(0);
                if (this.paddingBottom != 0) {
                    this.bnZ.setPadding(this.padding, 0, this.padding, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.bnZ.setPadding(this.padding, 0, this.padding, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.boa, photoLiveCardData.getThreadId());
                return;
            }
            this.bnZ.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.bor) {
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sW(String.valueOf(j))) {
                aj.e(textView, d.C0140d.cp_cont_c, 1);
            } else {
                aj.e(textView, d.C0140d.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.bnM.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.bnM.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.bnM.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.bnN.getLayoutParams();
                if (this.isGod) {
                    if (layoutParams != null) {
                        layoutParams.height = this.bou;
                        layoutParams.width = this.bou;
                    }
                    if (this.bok == null) {
                        this.bok = new TextView(this.context);
                        this.bok.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.bok.setEllipsize(TextUtils.TruncateAt.END);
                        this.bok.setTextSize(0, this.bov);
                        aj.r(this.bok, d.C0140d.cp_cont_h);
                        aj.s(this.bok, d.f.icon_shen);
                        this.bok.setSingleLine(true);
                        this.bnP.addView(this.bok);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.bok.setText(d.j.god_intro_default);
                    } else {
                        this.bok.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.bnP.removeView(this.bok);
                    this.bok = null;
                    if (layoutParams != null) {
                        layoutParams.height = this.bot;
                        layoutParams.width = this.bot;
                    }
                }
                this.bnN.setTag(photoLiveCardData);
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
            this.bnP.removeView(this.bok);
            this.bnM.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            this.bnN.setPadding(this.bow, this.bow, this.bow, this.bow);
            if (this.isGod) {
                this.bnO.setBackgroundDrawable(aj.getDrawable(d.f.pic_bg_jinbian));
                return;
            } else {
                this.bnO.setBackgroundDrawable(aj.getDrawable(d.f.frs_touxiang_jinkuan));
                return;
            }
        }
        this.bnO.setBackgroundDrawable(null);
        this.bnN.setPadding(0, 0, 0, 0);
    }

    private void Jn() {
        if (this.bnM != null) {
            this.bnN = (HeadImageView) this.bnM.findViewById(d.g.author_portrait);
            this.bnO = (FrameLayout) this.bnM.findViewById(d.g.author_portrait_info);
            this.bnQ = (TextView) this.bnM.findViewById(d.g.author_name);
            this.bnR = (TextView) this.bnM.findViewById(d.g.nick_name);
            this.bnS = (TextView) this.bnM.findViewById(d.g.fans_num);
            this.bnT = (TextView) this.bnM.findViewById(d.g.reply_num);
            this.bnU = (TextView) this.bnM.findViewById(d.g.headlive_icon);
            this.bnV = (TextView) this.bnM.findViewById(d.g.refresh_time_in_head);
            this.bnP = (LinearLayout) this.bnM.findViewById(d.g.author_info_and_time);
            this.bnN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bny != null) {
                        PhotoLiveCardView.this.bny.bg(view);
                    }
                }
            });
        }
    }

    private void Jo() {
        if (this.bnW != null) {
            this.title = (TextView) this.bnW.findViewById(d.g.title);
            this.bnX = (TextView) findViewById(d.g.refresh_time_in_title);
            this.bnY = (TextView) this.bnW.findViewById(d.g.card_delete_in_title);
            this.bnY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.PhotoLiveCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoLiveCardView.this.bnx != null) {
                        PhotoLiveCardView.this.bnx.bf(view);
                    }
                }
            });
        }
    }

    private void Jp() {
        if (this.bnZ != null) {
            this.boa = (TextView) this.bnZ.findViewById(d.g.content);
        }
    }

    private void Jq() {
        if (this.bog != null) {
            this.boh = (TextView) this.bog.findViewById(d.g.ba_name);
            this.boi = (TextView) this.bog.findViewById(d.g.bottom_refresh_time);
            this.boj = (TextView) this.bog.findViewById(d.g.bottom_reply_num);
        }
    }

    private void Jr() {
        if (this.bob != null) {
            this.boc = (TbImageView) this.bob.findViewById(d.g.live_cover);
            this.boc.setGifIconSupport(false);
            Js();
        }
    }

    private void Js() {
        if (this.bob != null) {
            this.bod = (TextView) this.bob.findViewById(d.g.first_style_first_expression);
            this.boe = (TextView) this.bob.findViewById(d.g.first_style_second_expression);
            this.bof = (TextView) this.bob.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.bom.clear();
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
        if (this.bom.size() != 0) {
            int size = this.bom.size();
            for (int i = 0; i < size; i++) {
                if (this.bom.get(i).intValue() == this.bod.getId()) {
                    this.bod.setVisibility(8);
                } else if (this.bom.get(i).intValue() == this.boe.getId()) {
                    this.boe.setVisibility(8);
                } else if (this.bom.get(i).intValue() == this.bof.getId()) {
                    this.bof.setVisibility(8);
                }
            }
        }
    }

    private void Ju() {
        this.bod.setText("");
        this.boe.setText("");
        this.bof.setText("");
        if (this.bod.getVisibility() == 8) {
            this.bod.setVisibility(0);
        }
        if (this.boe.getVisibility() == 8) {
            this.boe.setVisibility(0);
        }
        if (this.bof.getVisibility() == 8) {
            this.bof.setVisibility(0);
        }
        this.bom.add(Integer.valueOf(this.bod.getId()));
        this.bom.add(Integer.valueOf(this.boe.getId()));
        this.bom.add(Integer.valueOf(this.bof.getId()));
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
            switch (this.bol) {
                case 0:
                    a(this.box, this.boy, this.bod);
                    a(this.boz, this.boA, this.boe);
                    a(this.boB, this.boC, this.bof);
                    break;
                case 1:
                    a(this.boC, this.boD, this.bod);
                    a(this.boE, this.boC, this.boe);
                    a(this.boF, this.boA, this.bof);
                    break;
                case 2:
                    a(this.boC, this.boG, this.bod);
                    a(this.boH, this.boC, this.boe);
                    a(this.boF, this.boA, this.bof);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bod);
            } else if (i == 1) {
                a(arrayList.get(i2), this.boe);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bof);
            }
        }
    }

    private void hq(int i) {
        if (this.bom.size() != 0) {
            int size = this.bom.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bom.get(i2).intValue() == i) {
                    this.bom.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.boc.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.boc.startLoad(str, 10, false);
        } else {
            this.boc.startLoad(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.boh.setText("");
            return;
        }
        String trim = str.trim();
        this.boh.setVisibility(0);
        if (w.hs(trim) > 12) {
            trim = w.j(trim, 0, 12) + "...";
        }
        this.boh.setText(trim + TbadkCoreApplication.getInst().getResources().getString(d.j.forum));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.boa.setText("");
            this.boa.setVisibility(8);
            return;
        }
        this.boa.setVisibility(0);
        this.boa.setText(str);
    }

    private void setTitle(String str) {
        this.boI = str;
        if (this.bon != 0) {
            this.title.setPadding(0, 0, (int) this.context.getResources().getDimension(this.bon), 0);
            this.bon = 0;
        } else {
            this.title.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.title.setText("");
            return;
        }
        this.title.setVisibility(0);
        if (this.bop) {
            if (this.bos) {
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
            this.bnN.startLoad(str, 12, false);
        } else {
            this.bnN.startLoad(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.bnQ.setText("");
            return;
        }
        this.bnQ.setVisibility(0);
        String trim = str.trim();
        if (w.hs(trim) > 14) {
            trim = w.j(trim, 0, 14) + "...";
        }
        this.bnQ.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            a(this.bnR, this.context.getResources().getString(d.j.fans_default_name));
        } else {
            a(this.bnR, str);
        }
    }

    private void a(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = aj.getDrawable(d.f.icon_fengsi_n);
        drawable.setBounds(0, 0, this.size, this.size);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.bnS.setText(am.H(i));
    }

    private void setReplyNum(int i) {
        b(this.bnT, i);
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
            this.boj.setVisibility(0);
            b(this.boj, i);
            return;
        }
        this.boj.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.bnI) {
            this.bnU.setVisibility(0);
            aj.s(this.bnU, d.f.label_onthelist);
            return;
        }
        this.bnU.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.bnH) {
            this.bnV.setVisibility(0);
            this.bnV.setText(str);
            return;
        }
        this.bnV.setVisibility(8);
        this.bnV.setText("");
    }

    private void l(String str, boolean z) {
        if (!z) {
            this.bnX.setVisibility(8);
            return;
        }
        this.bnX.setVisibility(0);
        this.bnX.setText(str);
    }

    private void m(String str, boolean z) {
        if (!z) {
            this.boi.setVisibility(8);
            return;
        }
        this.boi.setVisibility(0);
        this.boi.setText(str);
    }

    public void setShowHead(boolean z) {
        this.bnz = z;
    }

    public void setShowTitle(boolean z) {
        this.bnA = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.bnF = z;
    }

    public void setShowContent(boolean z) {
        this.bnB = z;
    }

    public void setShowCover(boolean z) {
        this.bnC = z;
    }

    public void setShowExpression(boolean z) {
        this.bnD = z;
    }

    public void setShowBottom(boolean z) {
        this.bnE = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.bnH = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.bnI = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.bnJ = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.bnK = z;
    }

    public void setChooseStyle(int i) {
        this.bol = i;
    }

    public int getShowStyle() {
        return this.bol;
    }

    public void setShowLiveIcon(boolean z) {
        this.bop = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.bnx = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.bny = bVar;
    }

    public void setParentBackground(int i) {
        aj.s(this.bnL, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.boq = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.bnG = z;
    }

    public void setTitlePaddingRight(int i) {
        this.bon = i;
    }

    public void setTitleMaxLines(int i) {
        this.boo = i;
    }

    public void setAllowGreyState(boolean z) {
        this.bor = z;
    }
}
