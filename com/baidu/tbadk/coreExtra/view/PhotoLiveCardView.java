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
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCardView extends FrameLayout {
    private boolean amA;
    private boolean amB;
    private boolean amC;
    private boolean amD;
    private boolean amE;
    private LinearLayout amF;
    private ViewStub amG;
    private ViewStub amH;
    private ViewStub amI;
    private ViewStub amJ;
    private ViewStub amK;
    private LinearLayout amL;
    private HeadImageView amM;
    private FrameLayout amN;
    private TextView amO;
    private TextView amP;
    private TextView amQ;
    private TextView amR;
    private TextView amS;
    private TextView amT;
    private LinearLayout amU;
    private TextView amV;
    private TextView amW;
    private TextView amX;
    private LinearLayout amY;
    private TextView amZ;
    private a amr;
    private b ams;
    private boolean amt;
    private boolean amu;
    private boolean amv;
    private boolean amw;
    private boolean amx;
    private boolean amy;
    private boolean amz;
    private FrameLayout ana;
    private TbImageView anb;
    private TextView anc;
    private TextView and;
    private TextView ane;
    private TextView anf;
    private TextView ang;
    private TextView anh;
    private TextView ani;
    private TextView anj;
    private TextView ank;
    private RelativeLayout anl;
    private TextView anm;
    private TextView ann;
    private TextView ano;
    private int anp;
    private ArrayList<Integer> anq;
    private int anr;
    private int ans;
    private boolean ant;
    private boolean anu;
    private boolean anv;
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
        this.amt = true;
        this.amu = true;
        this.amv = true;
        this.amw = true;
        this.amx = true;
        this.amy = true;
        this.amz = false;
        this.amA = false;
        this.amB = false;
        this.amC = false;
        this.amD = false;
        this.amE = false;
        this.anp = 0;
        this.anq = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.anr = 0;
        this.ans = 0;
        this.ant = false;
        this.anu = true;
        this.anv = false;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amt = true;
        this.amu = true;
        this.amv = true;
        this.amw = true;
        this.amx = true;
        this.amy = true;
        this.amz = false;
        this.amA = false;
        this.amB = false;
        this.amC = false;
        this.amD = false;
        this.amE = false;
        this.anp = 0;
        this.anq = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.anr = 0;
        this.ans = 0;
        this.ant = false;
        this.anu = true;
        this.anv = false;
        this.context = context;
        init(context);
    }

    public PhotoLiveCardView(Context context) {
        super(context);
        this.amt = true;
        this.amu = true;
        this.amv = true;
        this.amw = true;
        this.amx = true;
        this.amy = true;
        this.amz = false;
        this.amA = false;
        this.amB = false;
        this.amC = false;
        this.amD = false;
        this.amE = false;
        this.anp = 0;
        this.anq = new ArrayList<>();
        this.paddingBottom = 0;
        this.paddingTop = 0;
        this.anr = 0;
        this.ans = 0;
        this.ant = false;
        this.anu = true;
        this.anv = false;
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i.g.photo_live_card_view, this);
        this.amF = (LinearLayout) inflate.findViewById(i.f.pl_card_root);
        this.amG = (ViewStub) inflate.findViewById(i.f.card_head_view);
        this.amH = (ViewStub) findViewById(i.f.card_title);
        this.amI = (ViewStub) findViewById(i.f.card_content);
        this.amJ = (ViewStub) findViewById(i.f.card_cover_and_expression);
        this.amK = (ViewStub) findViewById(i.f.card_bottom);
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            al.h(this.amF, i.e.frs_item_control_btn_bg);
            c(this.amt, photoLiveCardData);
            b(this.amu, this.amz, photoLiveCardData);
            b(this.amv, photoLiveCardData);
            a(this.amw, this.amx, photoLiveCardData);
            a(this.amy, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.anu) {
                aW(z2);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.ana != null) {
                this.ana.setVisibility(8);
            }
        }
    }

    private void a(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                zu();
                setBaName(photoLiveCardData.getForumName());
                o(photoLiveCardData.buildRefreshTimeWithoutPostNum(), this.amA);
                f(photoLiveCardData.getDiscussNum(), this.amD);
            } else if (this.anl != null) {
                this.anl.setVisibility(8);
            }
        }
    }

    private void b(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                zs();
                setTitle(photoLiveCardData.getTitle());
                n(photoLiveCardData.buildRefreshTimeWithPostNum(), z2);
                setDeleteButtonVisibility(photoLiveCardData);
                if (this.anv) {
                    com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                    if (readThreadHistory != null && readThreadHistory.lj(String.valueOf(photoLiveCardData.getThreadId()))) {
                        al.b(this.amV, i.c.cp_cont_c, 1);
                    } else {
                        al.b(this.amV, i.c.cp_cont_b, 1);
                    }
                }
            } else if (this.amU != null) {
                this.amU.setVisibility(8);
            }
        }
    }

    private void setDeleteButtonVisibility(PhotoLiveCardData photoLiveCardData) {
        if (this.amE) {
            this.amX.setVisibility(0);
            this.amX.setTag(photoLiveCardData);
            return;
        }
        this.amX.setVisibility(8);
    }

    private void b(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z) {
                zt();
                setContent(photoLiveCardData.getContent());
                if (this.anv) {
                    com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                    if (readThreadHistory != null && readThreadHistory.lj(String.valueOf(photoLiveCardData.getThreadId()))) {
                        al.b(this.amZ, i.c.cp_cont_c, 1);
                    } else {
                        al.b(this.amZ, i.c.cp_cont_b, 1);
                    }
                }
            } else if (this.amY != null) {
                this.amY.setVisibility(8);
            }
        }
    }

    private void c(boolean z, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null && z) {
            b(photoLiveCardData);
            es(photoLiveCardData.getAuthorPortrait());
            setUserName(photoLiveCardData.getAuthorName());
            setNickName(photoLiveCardData.getNickName());
            setFansNum(photoLiveCardData.getFansNum());
            setReplyNum(photoLiveCardData.getDiscussNum());
            setHeadLiveIconInHead(photoLiveCardData.isHeadLive());
            setRefreshTimeInHead(photoLiveCardData.buildRefreshTimeWithoutPostNum());
            setPortraitBackground(photoLiveCardData.isHeadLive());
        }
    }

    public void setPortraitBackground(boolean z) {
        if (z) {
            int dimension = (int) this.context.getResources().getDimension(i.d.ds4);
            this.amM.setPadding(dimension, dimension, dimension, dimension);
            this.amN.setBackgroundDrawable(al.getDrawable(i.e.frs_touxiang_jinkuan));
            return;
        }
        this.amN.setBackgroundDrawable(null);
        this.amM.setPadding(0, 0, 0, 0);
    }

    private void b(PhotoLiveCardData photoLiveCardData) {
        if (this.amL == null) {
            this.amL = (LinearLayout) this.amG.inflate();
            if (this.paddingTop != 0) {
                this.amL.setPadding(0, (int) this.context.getResources().getDimension(this.paddingTop), 0, 0);
                this.paddingTop = 0;
            } else {
                this.amL.setPadding(0, 0, 0, 0);
            }
            this.amM = (HeadImageView) this.amL.findViewById(i.f.author_portrait);
            this.amN = (FrameLayout) this.amL.findViewById(i.f.author_portrait_info);
            this.amO = (TextView) this.amL.findViewById(i.f.author_name);
            this.amP = (TextView) findViewById(i.f.nick_name);
            this.amQ = (TextView) findViewById(i.f.fans_num);
            this.amR = (TextView) findViewById(i.f.reply_num);
            this.amS = (TextView) findViewById(i.f.headlive_icon);
            this.amT = (TextView) findViewById(i.f.refresh_time_in_head);
            this.amM.setOnClickListener(new y(this));
        }
        al.b(this.amO, i.c.cp_cont_f, 1);
        al.b(this.amP, i.c.cp_cont_d, 1);
        al.b(this.amQ, i.c.cp_cont_d, 1);
        al.b(this.amR, i.c.cp_cont_d, 1);
        al.b(this.amT, i.c.cp_cont_d, 1);
        this.amM.setTag(photoLiveCardData);
    }

    private void zs() {
        if (this.amU == null) {
            this.amU = (LinearLayout) this.amH.inflate();
            this.amV = (TextView) this.amU.findViewById(i.f.title);
            this.amW = (TextView) findViewById(i.f.refresh_time_in_title);
            this.amX = (TextView) this.amU.findViewById(i.f.card_delete_in_title);
            this.amX.setOnClickListener(new z(this));
        }
        al.b(this.amV, i.c.cp_cont_b, 1);
        al.b(this.amW, i.c.cp_cont_c, 1);
        al.b(this.amX, i.c.cp_cont_i, 1);
        al.h((View) this.amX, i.e.blacklist_remove_button_bg);
        if (this.ans != 0) {
            this.amV.setMaxLines(this.ans);
        } else {
            this.amV.setMaxLines(2);
        }
        this.amU.setVisibility(0);
    }

    private void zt() {
        if (this.amY == null) {
            this.amY = (LinearLayout) this.amI.inflate();
            this.amZ = (TextView) this.amY.findViewById(i.f.content);
            al.b(this.amZ, i.c.cp_cont_b, 1);
        }
        int dimension = (int) this.context.getResources().getDimension(i.d.ds24);
        if (this.paddingBottom != 0) {
            this.amY.setPadding(dimension, 0, dimension, (int) this.context.getResources().getDimension(this.paddingBottom));
            this.paddingBottom = 0;
        } else {
            this.amY.setPadding(dimension, 0, dimension, 0);
        }
        this.amY.setVisibility(0);
    }

    private void zu() {
        if (this.anl == null) {
            this.anl = (RelativeLayout) this.amK.inflate();
            this.anm = (TextView) this.anl.findViewById(i.f.ba_name);
            this.ann = (TextView) this.anl.findViewById(i.f.bottom_refresh_time);
            this.ano = (TextView) this.anl.findViewById(i.f.bottom_reply_num);
        }
        al.b(this.anm, i.c.cp_cont_i, 1);
        al.h((View) this.anm, i.e.label_bg_tie);
        al.b(this.ann, i.c.cp_cont_d, 1);
        al.b(this.ano, i.c.cp_cont_d, 1);
        al.b(this.anm, i.c.cp_cont_i, 1);
        this.anl.setVisibility(0);
    }

    private void aW(boolean z) {
        if (this.ana == null) {
            this.ana = (FrameLayout) this.amJ.inflate();
            this.anb = (TbImageView) this.ana.findViewById(i.f.live_cover);
            aX(z);
        }
        zv();
        if (this.paddingBottom != 0) {
            this.ana.setPadding((int) this.context.getResources().getDimension(i.d.ds24), 0, (int) this.context.getResources().getDimension(i.d.ds24), (int) this.context.getResources().getDimension(this.paddingBottom));
            this.paddingBottom = 0;
        }
        this.ana.setVisibility(0);
    }

    private void zv() {
        al.h((View) this.anc, i.e.bg_tieziyingxiang);
        al.h((View) this.and, i.e.bg_tieziyingxiang);
        al.h((View) this.ane, i.e.bg_tieziyingxiang);
        al.h((View) this.anf, i.e.bg_tieziyingxiang);
        al.h((View) this.ang, i.e.bg_tieziyingxiang);
        al.h((View) this.anh, i.e.bg_tieziyingxiang);
        al.h((View) this.ani, i.e.bg_tieziyingxiang);
        al.h((View) this.anj, i.e.bg_tieziyingxiang);
        al.h((View) this.ank, i.e.bg_tieziyingxiang);
    }

    private void aX(boolean z) {
        if (z) {
            this.anc = (TextView) this.ana.findViewById(i.f.first_style_first_expression);
            this.and = (TextView) this.ana.findViewById(i.f.first_style_second_expression);
            this.ane = (TextView) this.ana.findViewById(i.f.first_style_third_expression);
            this.anf = (TextView) this.ana.findViewById(i.f.second_style_first_expression);
            this.ang = (TextView) this.ana.findViewById(i.f.second_style_second_expression);
            this.anh = (TextView) this.ana.findViewById(i.f.second_style_third_expression);
            this.ani = (TextView) this.ana.findViewById(i.f.third_style_first_expression);
            this.anj = (TextView) this.ana.findViewById(i.f.third_style_second_expression);
            this.ank = (TextView) this.ana.findViewById(i.f.third_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.anq.clear();
        zx();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            zw();
        }
    }

    private void zw() {
        if (this.anq.size() != 0) {
            int size = this.anq.size();
            switch (this.anp) {
                case 0:
                    for (int i = 0; i < size; i++) {
                        if (this.anq.get(i).intValue() == this.anc.getId()) {
                            this.anc.setVisibility(8);
                        } else if (this.anq.get(i).intValue() == this.and.getId()) {
                            this.and.setVisibility(8);
                        } else if (this.anq.get(i).intValue() == this.ane.getId()) {
                            this.ane.setVisibility(8);
                        }
                    }
                    return;
                case 1:
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.anq.get(i2).intValue() == this.anf.getId()) {
                            this.anf.setVisibility(8);
                        } else if (this.anq.get(i2).intValue() == this.ang.getId()) {
                            this.ang.setVisibility(8);
                        } else if (this.anq.get(i2).intValue() == this.anh.getId()) {
                            this.anh.setVisibility(8);
                        }
                    }
                    return;
                case 2:
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.anq.get(i3).intValue() == this.ani.getId()) {
                            this.ani.setVisibility(8);
                        } else if (this.anq.get(i3).intValue() == this.anj.getId()) {
                            this.anj.setVisibility(8);
                        } else if (this.anq.get(i3).intValue() == this.ank.getId()) {
                            this.ank.setVisibility(8);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void zx() {
        this.anc.setText("");
        this.and.setText("");
        this.ane.setText("");
        this.anf.setText("");
        this.ang.setText("");
        this.anh.setText("");
        this.ani.setText("");
        this.anj.setText("");
        this.ank.setText("");
        switch (this.anp) {
            case 0:
                this.anc.setVisibility(0);
                this.and.setVisibility(0);
                this.ane.setVisibility(0);
                this.anf.setVisibility(8);
                this.ang.setVisibility(8);
                this.anh.setVisibility(8);
                this.ani.setVisibility(8);
                this.anj.setVisibility(8);
                this.ank.setVisibility(8);
                this.anq.add(Integer.valueOf(this.anc.getId()));
                this.anq.add(Integer.valueOf(this.and.getId()));
                this.anq.add(Integer.valueOf(this.ane.getId()));
                return;
            case 1:
                this.anc.setVisibility(8);
                this.and.setVisibility(8);
                this.ane.setVisibility(8);
                this.anf.setVisibility(0);
                this.ang.setVisibility(0);
                this.anh.setVisibility(0);
                this.ani.setVisibility(8);
                this.anj.setVisibility(8);
                this.ank.setVisibility(8);
                this.anq.add(Integer.valueOf(this.anf.getId()));
                this.anq.add(Integer.valueOf(this.ang.getId()));
                this.anq.add(Integer.valueOf(this.anh.getId()));
                return;
            case 2:
                this.anc.setVisibility(8);
                this.and.setVisibility(8);
                this.ane.setVisibility(8);
                this.anf.setVisibility(8);
                this.ang.setVisibility(8);
                this.anh.setVisibility(8);
                this.ani.setVisibility(0);
                this.anj.setVisibility(0);
                this.ank.setVisibility(0);
                this.anq.add(Integer.valueOf(this.ani.getId()));
                this.anq.add(Integer.valueOf(this.anj.getId()));
                this.anq.add(Integer.valueOf(this.ank.getId()));
                return;
            default:
                return;
        }
    }

    private void a(p pVar, TextView textView) {
        if (pVar != null && textView != null) {
            if (!a(pVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(pVar.al(pVar.getLabelName(), String.valueOf(pVar.zj())));
            dD(textView.getId());
        }
    }

    private void a(int i, ArrayList<p> arrayList, int i2) {
        if (i >= 0 && i <= 3) {
            switch (this.anp) {
                case 0:
                    if (i == 0) {
                        a(arrayList.get(i2), this.anc);
                        return;
                    } else if (i == 1) {
                        a(arrayList.get(i2), this.and);
                        return;
                    } else if (i == 2) {
                        a(arrayList.get(i2), this.ane);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    if (i == 0) {
                        a(arrayList.get(i2), this.anf);
                        return;
                    } else if (i == 1) {
                        a(arrayList.get(i2), this.ang);
                        return;
                    } else if (i == 2) {
                        a(arrayList.get(i2), this.anh);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    if (i == 0) {
                        a(arrayList.get(i2), this.ani);
                        return;
                    } else if (i == 1) {
                        a(arrayList.get(i2), this.anj);
                        return;
                    } else if (i == 2) {
                        a(arrayList.get(i2), this.ank);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void dD(int i) {
        if (this.anq.size() != 0) {
            int size = this.anq.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.anq.get(i2).intValue() == i) {
                    this.anq.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(p pVar) {
        return (pVar == null || StringUtils.isNull(pVar.getLabelName())) ? false : true;
    }

    private void setCover(String str) {
        this.anb.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.anb.d(str, 10, false);
        } else {
            this.anb.d(null, 10, false);
        }
    }

    private void setBaName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.anm.setText("");
            return;
        }
        String trim = str.trim();
        this.anm.setVisibility(0);
        if (com.baidu.tbadk.util.k.fJ(trim) > 12) {
            trim = String.valueOf(com.baidu.tbadk.util.k.f(trim, 0, 12)) + "...";
        }
        this.anm.setText(aq.dh(String.valueOf(trim) + TbadkCoreApplication.m411getInst().getResources().getString(i.h.bar)));
    }

    private void setContent(String str) {
        if (TextUtils.isEmpty(str)) {
            this.amZ.setText("");
            this.amZ.setVisibility(8);
            return;
        }
        this.amZ.setVisibility(0);
        this.amZ.setText(str);
    }

    private void setTitle(String str) {
        if (this.anr != 0) {
            this.amV.setPadding(0, 0, (int) this.context.getResources().getDimension(this.anr), 0);
            this.anr = 0;
        } else {
            this.amV.setPadding(0, 0, 0, 0);
        }
        if (TextUtils.isEmpty(str)) {
            this.amV.setText("");
            return;
        }
        this.amV.setVisibility(0);
        if (this.ant) {
            this.amV.setText(d(str));
        } else {
            this.amV.setText(str);
        }
    }

    public static SpannableStringBuilder d(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf("live") + "space" + ((Object) charSequence));
        Bitmap cu = al.cu(i.e.icon_zhibo);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cu);
        int height = cu.getHeight();
        bitmapDrawable.setBounds(0, 0, cu.getWidth(), height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), 0, "live".length(), 33);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 10, height);
        spannableStringBuilder.setSpan(new com.baidu.adp.widget.d(colorDrawable, 1), 1, "live".length() + "space".length(), 33);
        return aq.a(spannableStringBuilder);
    }

    private void es(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.amM.d(str, 12, false);
        } else {
            this.amM.d(null, 12, false);
        }
    }

    private void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.amO.setText("");
            return;
        }
        this.amO.setVisibility(0);
        String trim = str.trim();
        if (com.baidu.tbadk.util.k.fJ(trim) > 14) {
            trim = String.valueOf(com.baidu.tbadk.util.k.f(trim, 0, 14)) + "...";
        }
        this.amO.setText(trim);
    }

    private void setNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            b(this.amP, this.context.getResources().getString(i.h.fans_default_name));
        } else {
            b(this.amP, str);
        }
    }

    private void b(TextView textView, String str) {
        textView.setText(str);
        Drawable drawable = al.getDrawable(i.e.icon_fengsi_n);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setFansNum(int i) {
        this.amQ.setText(aq.o(i));
    }

    private void setReplyNum(int i) {
        a(this.amR, i);
    }

    private void a(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("");
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        textView.setText(aq.o(j));
        Drawable drawable = al.getDrawable(i.e.icon_comment_n);
        int d = com.baidu.adp.lib.util.k.d(TbadkCoreApplication.m411getInst().getContext(), i.d.ds8);
        drawable.setBounds(0, 0, d, d);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void f(int i, boolean z) {
        if (z) {
            this.ano.setVisibility(0);
            a(this.ano, i);
            return;
        }
        this.ano.setVisibility(8);
    }

    private void setHeadLiveIconInHead(boolean z) {
        if (z && this.amC) {
            this.amS.setVisibility(0);
            al.h((View) this.amS, i.e.label_onthelist);
            return;
        }
        this.amS.setVisibility(8);
    }

    private void setRefreshTimeInHead(String str) {
        if (this.amB) {
            this.amT.setVisibility(0);
            this.amT.setText(str);
            return;
        }
        this.amT.setVisibility(8);
        this.amT.setText("");
    }

    private void n(String str, boolean z) {
        if (!z) {
            this.amW.setVisibility(8);
            return;
        }
        this.amW.setVisibility(0);
        this.amW.setText(str);
    }

    private void o(String str, boolean z) {
        if (!z) {
            this.ann.setVisibility(8);
            return;
        }
        this.ann.setVisibility(0);
        this.ann.setText(str);
    }

    public void setShowHead(boolean z) {
        this.amt = z;
    }

    public void setShowTitle(boolean z) {
        this.amu = z;
    }

    public void setShowRefreshTimeInTitle(boolean z) {
        this.amz = z;
    }

    public void setShowContent(boolean z) {
        this.amv = z;
    }

    public void setShowCover(boolean z) {
        this.amw = z;
    }

    public void setShowExpression(boolean z) {
        this.amx = z;
    }

    public void setShowBottom(boolean z) {
        this.amy = z;
    }

    public void setShowRefreshTimeInHead(boolean z) {
        this.amB = z;
    }

    public void setShowHeadLiveIcon(boolean z) {
        this.amC = z;
    }

    public void setShowReplyNumInButtom(boolean z) {
        this.amD = z;
    }

    public void setShowDeleteButtonInTitle(boolean z) {
        this.amE = z;
    }

    public void setChooseStyle(int i) {
        this.anp = i;
    }

    public int getShowStyle() {
        return this.anp;
    }

    public void setShowLiveIcon(boolean z) {
        this.ant = z;
    }

    public void setDeleteButtonClickListener(a aVar) {
        this.amr = aVar;
    }

    public void setPortraitClicklistener(b bVar) {
        this.ams = bVar;
    }

    public void setParentBackground(int i) {
        al.h(this.amF, i);
    }

    public void setContentPaddingBottom(int i) {
        this.paddingBottom = i;
    }

    public void setHeadPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setShowImage(boolean z) {
        this.anu = z;
    }

    public void setShowRefreshTimeInButtom(boolean z) {
        this.amA = z;
    }

    public void setTitlePaddingRight(int i) {
        this.anr = i;
    }

    public void setTitleMaxLines(int i) {
        this.ans = i;
    }

    public void setAllowGreyState(boolean z) {
        this.anv = z;
    }
}
