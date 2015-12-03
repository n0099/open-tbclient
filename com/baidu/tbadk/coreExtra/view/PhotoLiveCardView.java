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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    public int afY;
    private TextView agd;
    private a amL;
    private b amM;
    private boolean amN;
    private boolean amO;
    private boolean amP;
    private boolean amQ;
    private boolean amR;
    private boolean amS;
    private boolean amT;
    private boolean amU;
    private boolean amV;
    private boolean amW;
    private boolean amX;
    private boolean amY;
    private LinearLayout amZ;
    private ArrayList<Integer> anA;
    private int anB;
    private int anC;
    private boolean anD;
    private boolean anE;
    private boolean anF;
    private boolean anG;
    private View ana;
    private HeadImageView anb;
    private FrameLayout anc;
    private LinearLayout and;
    private TextView ane;
    private TextView anf;
    private TextView ang;
    private TextView anh;
    private TextView ani;
    private TextView anj;
    private LinearLayout ank;
    private TextView anl;
    private TextView anm;
    private LinearLayout ann;
    private TextView ano;
    private RelativeLayout anp;
    private TbImageView anq;
    private TextView anr;
    private TextView ans;
    private TextView ant;
    private RelativeLayout anu;
    private TextView anv;
    private TextView anw;
    private TextView anx;
    private TextView any;
    private int anz;
    private Context context;
    private int paddingBottom;
    private int paddingTop;

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
        this.amN = true;
        this.amO = true;
        this.amP = true;
        this.amQ = true;
        this.amR = true;
        this.amS = true;
        this.amT = false;
        this.amU = false;
        this.amV = false;
        this.amW = false;
        this.amX = false;
        this.amY = false;
        this.anz = 0;
        this.anA = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.anB = 0;
        this.anC = 0;
        this.anD = false;
        this.anE = true;
        this.anF = false;
        this.anG = false;
        this.afY = 3;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amN = true;
        this.amO = true;
        this.amP = true;
        this.amQ = true;
        this.amR = true;
        this.amS = true;
        this.amT = false;
        this.amU = false;
        this.amV = false;
        this.amW = false;
        this.amX = false;
        this.amY = false;
        this.anz = 0;
        this.anA = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.anB = 0;
        this.anC = 0;
        this.anD = false;
        this.anE = true;
        this.anF = false;
        this.anG = false;
        this.afY = 3;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context) {
        super(context);
        this.amN = true;
        this.amO = true;
        this.amP = true;
        this.amQ = true;
        this.amR = true;
        this.amS = true;
        this.amT = false;
        this.amU = false;
        this.amV = false;
        this.amW = false;
        this.amX = false;
        this.amY = false;
        this.anz = 0;
        this.anA = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.anB = 0;
        this.anC = 0;
        this.anD = false;
        this.anE = true;
        this.anF = false;
        this.anG = false;
        this.afY = 3;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(n.g.photo_live_card_view, this);
        this.amZ = (LinearLayout) inflate.findViewById(n.f.pl_card_root);
        this.ana = inflate.findViewById(n.f.author_info);
        this.ank = (LinearLayout) inflate.findViewById(n.f.photo_live_card_title);
        this.ann = (LinearLayout) inflate.findViewById(n.f.photo_live_card_content);
        this.anp = (RelativeLayout) inflate.findViewById(n.f.photo_live_card_cover_and_expression);
        this.anu = (RelativeLayout) inflate.findViewById(n.f.photo_live_card_bottom);
        zZ();
        Aa();
        Ab();
        Ad();
        Ac();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            setIsGod(photoLiveCardData);
            wh();
            c(this.amN, photoLiveCardData);
            b(this.amO, this.amT, photoLiveCardData);
            b(this.amP, photoLiveCardData);
            a(this.amQ, this.amR, photoLiveCardData);
            a(this.amS, photoLiveCardData);
        }
    }

    private void setIsGod(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && photoLiveCardData.getGodInfo() != null) {
            this.anG = true;
        } else {
            this.anG = false;
        }
    }

    private void wh() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.afY) {
            as.i(this.amZ, n.e.frs_item_control_btn_bg);
            if (this.amN) {
                as.b(this.ane, n.c.cp_cont_f, 1);
                as.b(this.anf, n.c.cp_cont_d, 1);
                as.b(this.ang, n.c.cp_cont_d, 1);
                as.b(this.anh, n.c.cp_cont_d, 1);
                as.b(this.anj, n.c.cp_cont_d, 1);
            }
            if (this.amO) {
                as.b(this.agd, n.c.cp_cont_b, 1);
                as.b(this.anl, n.c.cp_cont_c, 1);
                as.b(this.anm, n.c.cp_cont_i, 1);
                as.i((View) this.anm, n.e.blacklist_remove_button_bg);
            }
            as.b(this.ano, n.c.cp_cont_b, 1);
            Ae();
            this.afY = skinType;
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.anE) {
                int dimension = (int) this.context.getResources().getDimension(n.d.ds24);
                if (this.paddingBottom != 0) {
                    this.anp.setPadding(dimension, 0, dimension, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.anp.setPadding(dimension, 0, dimension, 0);
                }
                this.anp.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.anp != null) {
                this.anp.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.anu.setVisibility(0);
                as.b(this.anv, n.c.cp_cont_i, 1);
                as.i((View) this.anv, n.e.label_bg_tie);
                as.b(this.anw, n.c.cp_cont_d, 1);
                as.b(this.anx, n.c.cp_cont_d, 1);
                as.b(this.anv, n.c.cp_cont_i, 1);
                setBaName(photoLiveCardData.getForumName());
                o(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.amU);
                f(photoLiveCardData.getDiscussNum(), this.amX);
                return;
            }
            this.anu.setVisibility(8);
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.ank.setVisibility(0);
                if (this.anC != 0) {
                    this.agd.setMaxLines(this.anC);
                } else {
                    this.agd.setMaxLines(2);
                }
                setTitle(photoLiveCardData.getTitle());
                n(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                a(this.agd, photoLiveCardData.getThreadId());
                return;
            }
            this.ank.setVisibility(8);
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.amY) {
            this.anm.setVisibility(0);
            this.anm.setTag(photoLiveCardData);
            return;
        }
        this.anm.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.ann.setVisibility(0);
                int dimension = (int) this.context.getResources().getDimension(n.d.ds24);
                if (this.paddingBottom != 0) {
                    this.ann.setPadding(dimension, 0, dimension, (int) this.context.getResources().getDimension(this.paddingBottom));
                    this.paddingBottom = 0;
                } else {
                    this.ann.setPadding(dimension, 0, dimension, 0);
                }
                setContent(photoLiveCardData.getContent());
                a(this.ano, photoLiveCardData.getThreadId());
                return;
            }
            this.ann.setVisibility(8);
        }
    }

    private void a(TextView textView, long j) {
        if (textView != null && this.anF) {
            com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.mF(String.valueOf(j))) {
                as.b(textView, n.c.cp_cont_c, 1);
            } else {
                as.b(textView, n.c.cp_cont_b, 1);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                this.ana.setVisibility(0);
                if (this.paddingTop != 0) {
                    this.ana.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                } else {
                    this.ana.setPadding(0, 0, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams = this.anb.getLayoutParams();
                if (this.anG) {
                    if (layoutParams != null) {
                        layoutParams.height = (int) this.context.getResources().getDimension(n.d.ds100);
                        layoutParams.width = (int) this.context.getResources().getDimension(n.d.ds100);
                    }
                    if (this.any == null) {
                        this.any = new TextView(this.context);
                        this.any.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        this.any.setEllipsize(TextUtils.TruncateAt.END);
                        this.any.setTextSize(0, this.context.getResources().getDimension(n.d.ds18));
                        as.h((View) this.any, n.c.cp_cont_h);
                        as.i((View) this.any, n.e.icon_shen);
                        this.any.setSingleLine(true);
                        this.and.addView(this.any);
                    }
                    if (photoLiveCardData.getGodInfo() == null || StringUtils.isNull(photoLiveCardData.getGodInfo().intro)) {
                        this.any.setText(n.i.god_intro_default);
                    } else {
                        this.any.setText(photoLiveCardData.getGodInfo().intro);
                    }
                } else {
                    this.and.removeView(this.any);
                    this.any = null;
                    if (layoutParams != null) {
                        layoutParams.height = (int) this.context.getResources().getDimension(n.d.ds70);
                        layoutParams.width = (int) this.context.getResources().getDimension(n.d.ds70);
                    }
                }
                this.anb.setTag(photoLiveCardData);
                eE(photoLiveCardData.getAuthorPortrait());
                setUserName(photoLiveCardData.getAuthorName());
                setNickName(photoLiveCardData.getNickName());
                setFansNum(photoLiveCardData.getFansNum());
                setReplyNum(photoLiveCardData.getDiscussNum());
                setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
                setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
                setPortraitBackground(photoLiveCardData.isHeadLive());
                return;
            }
            this.and.removeView(this.any);
            this.ana.setVisibility(8);
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            int dimension = (int) this.context.getResources().getDimension(n.d.ds4);
            this.anb.setPadding(dimension, dimension, dimension, dimension);
            if (this.anG) {
                this.anc.setBackgroundDrawable(as.getDrawable(n.e.pic_bg_jinbian));
                return;
            } else {
                this.anc.setBackgroundDrawable(as.getDrawable(n.e.frs_touxiang_jinkuan));
                return;
            }
        }
        this.anc.setBackgroundDrawable(null);
        this.anb.setPadding(0, 0, 0, 0);
    }

    private void zZ() {
        if (this.ana != null) {
            this.anb = (HeadImageView) this.ana.findViewById(n.f.author_portrait);
            this.anc = (FrameLayout) this.ana.findViewById(n.f.author_portrait_info);
            this.ane = (TextView) this.ana.findViewById(n.f.author_name);
            this.anf = (TextView) this.ana.findViewById(n.f.nick_name);
            this.ang = (TextView) this.ana.findViewById(n.f.fans_num);
            this.anh = (TextView) this.ana.findViewById(n.f.reply_num);
            this.ani = (TextView) this.ana.findViewById(n.f.headlive_icon);
            this.anj = (TextView) this.ana.findViewById(n.f.refresh_time_in_head);
            this.and = (LinearLayout) this.ana.findViewById(n.f.author_info_and_time);
            this.anb.setOnClickListener(new x(this));
        }
    }

    private void Aa() {
        if (this.ank != null) {
            this.agd = (TextView) this.ank.findViewById(n.f.title);
            this.anl = (TextView) findViewById(n.f.refresh_time_in_title);
            this.anm = (TextView) this.ank.findViewById(n.f.card_delete_in_title);
            this.anm.setOnClickListener(new y(this));
        }
    }

    private void Ab() {
        if (this.ann != null) {
            this.ano = (TextView) this.ann.findViewById(n.f.content);
        }
    }

    private void Ac() {
        if (this.anu != null) {
            this.anv = (TextView) this.anu.findViewById(n.f.ba_name);
            this.anw = (TextView) this.anu.findViewById(n.f.bottom_refresh_time);
            this.anx = (TextView) this.anu.findViewById(n.f.bottom_reply_num);
        }
    }

    private void Ad() {
        if (this.anp != null) {
            this.anq = (TbImageView) this.anp.findViewById(n.f.live_cover);
            Af();
        }
    }

    private void Ae() {
        as.i((View) this.anr, n.e.bg_tieziyingxiang);
        as.i((View) this.ans, n.e.bg_tieziyingxiang);
        as.i((View) this.ant, n.e.bg_tieziyingxiang);
    }

    private void Af() {
        if (this.anp != null) {
            this.anr = (TextView) this.anp.findViewById(n.f.first_style_first_expression);
            this.ans = (TextView) this.anp.findViewById(n.f.first_style_second_expression);
            this.ant = (TextView) this.anp.findViewById(n.f.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.anA.clear();
        Ah();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Ag();
        }
    }

    private void Ag() {
        if (this.anA.size() != 0) {
            int size = this.anA.size();
            for (int i = 0; i < size; i++) {
                if (this.anA.get(i).intValue() == this.anr.getId()) {
                    this.anr.setVisibility(8);
                } else if (this.anA.get(i).intValue() == this.ans.getId()) {
                    this.ans.setVisibility(8);
                } else if (this.anA.get(i).intValue() == this.ant.getId()) {
                    this.ant.setVisibility(8);
                }
            }
        }
    }

    private void Ah() {
        this.anr.setText("");
        this.ans.setText("");
        this.ant.setText("");
        this.anr.setVisibility(0);
        this.ans.setVisibility(0);
        this.ant.setVisibility(0);
        this.anA.add(Integer.valueOf(this.anr.getId()));
        this.anA.add(Integer.valueOf(this.ans.getId()));
        this.anA.add(Integer.valueOf(this.ant.getId()));
    }

    private void a(o oVar, TextView textView) {
        if (oVar != null && textView != null) {
            if (!a(oVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(oVar.ah(oVar.getLabelName(), String.valueOf(oVar.zQ())));
            dT(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void a(int i, ArrayList<o> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.anz) {
                case 0:
                    a((int) this.context.getResources().getDimension(n.d.ds80), (int) this.context.getResources().getDimension(n.d.ds280), this.anr);
                    a((int) this.context.getResources().getDimension(n.d.ds170), (int) this.context.getResources().getDimension(n.d.ds320), this.ans);
                    a((int) this.context.getResources().getDimension(n.d.ds200), (int) this.context.getResources().getDimension(n.d.ds60), this.ant);
                    break;
                case 1:
                    a((int) this.context.getResources().getDimension(n.d.ds60), (int) this.context.getResources().getDimension(n.d.ds120), this.anr);
                    a((int) this.context.getResources().getDimension(n.d.ds160), (int) this.context.getResources().getDimension(n.d.ds60), this.ans);
                    a((int) this.context.getResources().getDimension(n.d.ds220), (int) this.context.getResources().getDimension(n.d.ds320), this.ant);
                    break;
                case 2:
                    a((int) this.context.getResources().getDimension(n.d.ds60), (int) this.context.getResources().getDimension(n.d.ds240), this.anr);
                    a((int) this.context.getResources().getDimension(n.d.ds180), (int) this.context.getResources().getDimension(n.d.ds60), this.ans);
                    a((int) this.context.getResources().getDimension(n.d.ds220), (int) this.context.getResources().getDimension(n.d.ds320), this.ant);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.anr);
            } else if (i == 1) {
                a(arrayList.get(i2), this.ans);
            } else if (i == 2) {
                a(arrayList.get(i2), this.ant);
            }
        }
    }

    private void dT(int i) {
        if (this.anA.size() != 0) {
            int size = this.anA.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.anA.get(i2).intValue() == i) {
                    this.anA.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(o oVar) {
        return (oVar == null || StringUtils.isNull(oVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.anq.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.anq.d(str, 10, false);
        } else {
            this.anq.d(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.anv.setText("");
            return;
        }
        String trim = str.trim();
        this.anv.setVisibility(0);
        if (com.baidu.tbadk.util.o.ge(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.o.e(trim, 0, 12)) + "...";
        }
        this.anv.setText(String.valueOf(trim) + TbadkCoreApplication.m411getInst().getResources().getString(n.i.bar));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ano.setText("");
            this.ano.setVisibility(8);
            return;
        }
        this.ano.setVisibility(0);
        this.ano.setText(str);
    }

    private void setTitle(String str) {
        if (this.anB != 0) {
            this.agd.setPadding(0, 0, (int) this.context.getResources().getDimension(this.anB), 0);
            this.anB = 0;
        } else {
            this.agd.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.agd.setText("");
            return;
        }
        this.agd.setVisibility(0);
        if (this.anD) {
            this.agd.setText(f(str));
        } else {
            this.agd.setText(str);
        }
    }

    public static SpannableStringBuilder f(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cE = as.cE(n.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cE);
        int height = cE.getHeight();
        bitmapDrawable.setBounds(0, 0, cE.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return spannableStringBuilder;
    }

    private void eE(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.anb.d(str, 12, false);
        } else {
            this.anb.d(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ane.setText("");
            return;
        }
        this.ane.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.o.ge(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.o.e(trim, 0, 14)) + "...";
        }
        this.ane.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.anf, this.context.getResources().getString(n.i.fans_default_name));
        } else {
            b(this.anf, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = as.getDrawable(n.e.icon_fengsi_n);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), n.d.ds8);
        drawable.setBounds(0, 0, d, d);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.ang.setText(ax.w(i));
    }

    private void setReplyNum(int i) {
        b(this.anh, i);
    }

    private void b(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(ax.w(j));
        Drawable drawable = as.getDrawable(n.e.icon_comment_n);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), n.d.ds8);
        drawable.setBounds(0, 0, d, d);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void f(int i, boolean z) {
        if (z) {
            this.anx.setVisibility(0);
            b(this.anx, i);
            return;
        }
        this.anx.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.amW) {
            this.ani.setVisibility(0);
            as.i((View) this.ani, n.e.label_onthelist);
            return;
        }
        this.ani.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.amV) {
            this.anj.setVisibility(0);
            this.anj.setText(str);
            return;
        }
        this.anj.setVisibility(8);
        this.anj.setText("");
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.anl.setVisibility(8);
            return;
        }
        this.anl.setVisibility(0);
        this.anl.setText(str);
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.anw.setVisibility(8);
            return;
        }
        this.anw.setVisibility(0);
        this.anw.setText(str);
    }

    public void setShowHead(boolean z) {
        this.amN = z;
    }

    public void setShowTitle(boolean z) {
        this.amO = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.amT = z;
    }

    public void setShowContent(boolean z) {
        this.amP = z;
    }

    public void setShowCover(boolean z) {
        this.amQ = z;
    }

    public void setShowExpression(boolean z) {
        this.amR = z;
    }

    public void setShowBottom(boolean z) {
        this.amS = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.amV = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.amW = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.amX = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.amY = z;
    }

    public void setChooseStyle(int i) {
        this.anz = i;
    }

    public int getShowStyle() {
        return this.anz;
    }

    public void setShowLiveIcon(boolean z) {
        this.anD = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.amL = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.amM = bVar;
    }

    public void setParentBackground(int i) {
        as.i(this.amZ, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.anE = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.amU = z;
    }

    public void setTitlePaddingRight(int i) {
        this.anB = i;
    }

    public void setTitleMaxLines(int i) {
        this.anC = i;
    }

    public void setAllowGreyState(boolean z) {
        this.anF = z;
    }
}
