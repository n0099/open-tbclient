package com.baidu.tieba.im.groupInfo;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    private ScrollView bDR;
    private RelativeLayout bwZ;
    private View dnP;
    private boolean dtn;
    private View eAV;
    private TextView eLg;
    private TextView eMA;
    private RelativeLayout eMB;
    private com.baidu.tbadk.core.dialog.b eMC;
    private ImageView eMD;
    private final View eME;
    private b.InterfaceC0148b eMF;
    private RelativeLayout eMG;
    private LinearLayout eMH;
    private HeadImageView[] eMI;
    private LinearLayout eMJ;
    private TextView eMK;
    private RelativeLayout eML;
    private LinearLayout eMM;
    private com.baidu.tbadk.core.dialog.b eMN;
    private LinearLayout eMO;
    private com.baidu.tbadk.core.dialog.b eMP;
    private b eMQ;
    private TextView eMR;
    private String eMS;
    private ImageView eMT;
    private RelativeLayout eMU;
    private TextView eMV;
    private ImageView eMW;
    private RelativeLayout eMX;
    private RelativeLayout eMY;
    private ImageView eMZ;
    private final GroupInfoActivity eMk;
    private View eMl;
    private ProgressBar eMm;
    private RelativeLayout eMn;
    private TextView eMo;
    private TextView eMp;
    private TextView eMq;
    private TextView eMr;
    private EllipsizingTextView eMs;
    private TextView eMt;
    private RelativeLayout eMu;
    private PhotoWallView eMv;
    private RelativeLayout eMw;
    private RelativeLayout eMx;
    private LinearLayout eMy;
    private HeadImageView eMz;
    private ImageView eNa;
    private View eNb;
    private TextView eNc;
    private TextView eNd;
    private LinearLayout eNe;
    private View eNf;
    private TextView eNg;
    private ResponseGroupInfoLocalMessage.a eNh;
    private boolean eNi;
    private boolean eNj;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int eNk = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eMC = null;
        this.eMF = null;
        this.eMI = new HeadImageView[5];
        this.eMS = "";
        this.eNi = true;
        this.isMemGroup = false;
        this.dtn = false;
        this.eNj = false;
        this.eMk = groupInfoActivity;
        groupInfoActivity.setContentView(e.h.im_group_info_activity);
        this.eME = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(e.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bDR.setVisibility(4);
        this.eMJ.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eMV.setText(str);
        pH(str);
    }

    private void pH(String str) {
        if (str != null) {
            this.eNg.setText(str);
        }
    }

    public void pI(String str) {
        this.eMs.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(e.g.view_navigation_bar);
        this.eAV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eNg = this.mNavigationBar.setTitleText("");
        this.eNf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eMR = (TextView) this.eNf.findViewById(e.g.right_textview);
        this.eMR.setText(groupInfoActivity.getPageContext().getString(e.j.setup));
        al.c(this.eMR, e.d.cp_cont_f, 1);
        this.eMR.setOnClickListener(groupInfoActivity);
        this.eNf.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eMl = groupInfoActivity.findViewById(e.g.line_activity_name_down);
        this.bwZ = (RelativeLayout) groupInfoActivity.findViewById(e.g.group_info_container);
        this.bDR = (ScrollView) groupInfoActivity.findViewById(e.g.group_scrollview);
        this.bDR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        a.this.mBottomLine.setVisibility(0);
                        break;
                    case 1:
                        a.this.mBottomLine.setVisibility(0);
                        break;
                    case 2:
                        a.this.mBottomLine.setVisibility(8);
                        break;
                }
                return false;
            }
        });
        this.dnP = groupInfoActivity.findViewById(e.g.group_top_view);
        this.dnP.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eMn = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_activity);
        this.eMn.setOnClickListener(groupInfoActivity);
        this.eMo = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_status);
        this.eMp = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_name);
        this.eMG = (RelativeLayout) groupInfoActivity.findViewById(e.g.address_layout);
        this.eMG.setOnClickListener(groupInfoActivity);
        this.eMO = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_body);
        this.eMT = (ImageView) groupInfoActivity.findViewById(e.g.img_group_type_icon);
        this.eMq = (TextView) groupInfoActivity.findViewById(e.g.txt_group_number);
        this.eMr = (TextView) groupInfoActivity.findViewById(e.g.txt_group_place);
        this.eMZ = (ImageView) groupInfoActivity.findViewById(e.g.img_group_place);
        this.eMs = (EllipsizingTextView) groupInfoActivity.findViewById(e.g.txt_group_intro);
        this.eMs.setMaxLines(20);
        this.eMs.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void hE(boolean z) {
                if (z) {
                    a.this.eNc.setVisibility(0);
                } else {
                    a.this.eNc.setVisibility(8);
                }
            }
        });
        this.eMu = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_forum);
        this.eMt = (TextView) groupInfoActivity.findViewById(e.g.txt_group_forum);
        this.eMu.setOnClickListener(groupInfoActivity);
        this.eMz = (HeadImageView) groupInfoActivity.findViewById(e.g.img_group_author);
        this.eMz.setAutoChangeStyle(true);
        this.eMz.setIsRound(false);
        this.eLg = (TextView) groupInfoActivity.findViewById(e.g.txt_group_author);
        this.eMw = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_author);
        this.eMw.setOnClickListener(groupInfoActivity);
        this.eMD = (ImageView) groupInfoActivity.findViewById(e.g.meizhi_icon);
        this.eNb = groupInfoActivity.findViewById(e.g.line_group_author_down);
        this.eMy = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_grade_star);
        this.eMu.setOnClickListener(groupInfoActivity);
        this.eMx = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_grade);
        this.eMx.setOnClickListener(groupInfoActivity);
        this.eMA = (TextView) groupInfoActivity.findViewById(e.g.txt_group_member_count);
        this.eMB = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_member);
        this.eMB.setOnClickListener(groupInfoActivity);
        this.eMH = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_member_photo);
        this.eMJ = (LinearLayout) groupInfoActivity.findViewById(e.g.bottom_bar);
        this.eNe = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_bottom_button);
        this.eMK = (TextView) groupInfoActivity.findViewById(e.g.txt_join);
        this.eNe.setOnClickListener(this.eMk);
        this.eML = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_invite);
        this.eML.setOnClickListener(groupInfoActivity);
        this.eMM = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_notice_share);
        this.eMU = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_name);
        this.eMU.setOnClickListener(groupInfoActivity);
        this.eMV = (TextView) groupInfoActivity.findViewById(e.g.txt_group_name);
        this.eMW = (ImageView) groupInfoActivity.findViewById(e.g.img_group_intro_arrow);
        this.eNa = (ImageView) groupInfoActivity.findViewById(e.g.img_group_author_arrow);
        this.eMX = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_intro);
        this.eMX.setOnClickListener(groupInfoActivity);
        this.eMX.setLongClickable(true);
        this.eMX.setOnLongClickListener(groupInfoActivity);
        this.eNc = (TextView) groupInfoActivity.findViewById(e.g.txt_group_intro_more);
        this.eNc.setClickable(true);
        this.eNc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eMs.setMaxLines(1000);
            }
        });
        this.eMY = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_number);
        this.eMY.setOnLongClickListener(groupInfoActivity);
        this.eNd = (TextView) groupInfoActivity.findViewById(e.g.can_create_mem_group);
        this.eMm = (ProgressBar) groupInfoActivity.findViewById(e.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(e.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eMv = (PhotoWallView) groupInfoActivity.findViewById(e.g.photo_wall);
        this.eMv.setPhotoClickListener(groupInfoActivity);
        this.eMv.setPhotoLongClickListener(groupInfoActivity);
        this.eMv.setVisibility(8);
    }

    public RelativeLayout aQr() {
        return this.eMY;
    }

    public RelativeLayout aQs() {
        return this.eMu;
    }

    public LinearLayout aQt() {
        return this.eMH;
    }

    public RelativeLayout aQu() {
        return this.eML;
    }

    public RelativeLayout aQv() {
        return this.eMX;
    }

    public RelativeLayout aQw() {
        return this.eMU;
    }

    public RelativeLayout aQx() {
        return this.eMn;
    }

    public View aQy() {
        return this.eMR;
    }

    public LinearLayout aQz() {
        return this.eNe;
    }

    public RelativeLayout aQA() {
        return this.eMw;
    }

    public RelativeLayout aQB() {
        return this.eMx;
    }

    public RelativeLayout aQC() {
        return this.eMB;
    }

    public View aPm() {
        return this.eAV;
    }

    public void aQD() {
        this.eMm.setVisibility(8);
    }

    public void aQE() {
        this.eMm.setVisibility(0);
    }

    public void h(boolean z, String str) {
        if (z) {
            this.eMr.setText(str);
            this.eMG.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eMG.setVisibility(8);
        } else {
            this.eMr.setText(str);
            this.eMG.setVisibility(0);
        }
    }

    public void iE(boolean z) {
        if (z) {
            this.eMr.setText(this.mContext.getString(e.j.live_card_hide));
        } else {
            this.eMG.setVisibility(8);
        }
    }

    public RelativeLayout aQF() {
        return this.eMG;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dtn = aVar.aRp();
            this.eNj = aVar.aRq();
            this.eNh = aVar;
            this.eNi = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aRk() != null) {
                eNk = aVar.aRk().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eMO.setVisibility(0);
            this.eMJ.setVisibility(0);
            if (aVar.getGroup() != null) {
                pH(aVar.getGroup().getName());
                this.eMq.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eMD.setVisibility(0);
                } else {
                    this.eMD.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eMT.setVisibility(0);
                    this.eMz.setVisibility(8);
                    this.eNa.setVisibility(8);
                    this.eNb.setVisibility(8);
                    this.eLg.setText(e.j.group_info_forum_author);
                    this.eMw.setEnabled(false);
                    this.eMD.setVisibility(8);
                } else {
                    this.eMT.setVisibility(8);
                    this.eMz.setVisibility(0);
                    this.eNa.setVisibility(0);
                    this.eNb.setVisibility(0);
                    this.eLg.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.eMw.setEnabled(true);
                }
                String position = aVar.getGroup().getPosition();
                String business = aVar.getGroup().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.eMS = stringBuffer.toString();
                this.eMr.setText(this.eMS);
                this.eMs.setText(aVar.getGroup().getIntro());
                this.eMA.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eMz.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eMu.setVisibility(0);
                    this.eMt.setText(aVar.getGroup().getForumName() + this.eMk.getPageContext().getString(e.j.forum));
                } else {
                    this.eMu.setVisibility(8);
                }
                this.eMy.removeAllViews();
                boolean aRr = aVar.aRr();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.c(this.eNg, e.d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eMk.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, e.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, e.f.icon_grade_middle_star_s);
                        }
                        this.eMy.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eMk.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, e.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, e.f.icon_grade_middle_star_n);
                    }
                    this.eMy.addView(imageView2);
                }
                if (aRr) {
                    this.eNd.setVisibility(0);
                } else {
                    this.eNd.setVisibility(8);
                }
            }
            if (aVar.aRk() != null) {
                this.eMn.setVisibility(0);
                this.eMl.setVisibility(0);
                GroupActivityData aRk = aVar.aRk();
                if (!aVar.aRp()) {
                    if (aRk.getIsEnd() != 1) {
                        this.eMo.setVisibility(4);
                        this.eMp.setText(e.j.group_info_activity_not_join_tip);
                    } else {
                        this.eMn.setVisibility(8);
                        this.eMl.setVisibility(8);
                    }
                } else {
                    this.eMo.setVisibility(0);
                    this.eMp.setText(aRk.getgActivityTitle());
                    if (aRk.getIsEnd() != 1) {
                        this.eMo.setText(e.j.group_info_activity_doing);
                        al.c(this.eMo, e.d.common_color_10171, 1);
                    } else {
                        this.eMo.setText(e.j.group_activity_end);
                        al.c(this.eMo, e.d.common_color_10168, 1);
                    }
                    this.eMp.setText(aRk.getgActivityTitle());
                }
            } else if (aVar.aRq()) {
                this.eMn.setVisibility(0);
                this.eMl.setVisibility(0);
                this.eMo.setVisibility(4);
                this.eMp.setText(e.j.group_info_create_activity);
            } else {
                this.eMn.setVisibility(8);
                this.eMl.setVisibility(8);
            }
            this.eMH.removeAllViews();
            if (aVar.aRl() != null && aVar.aRl().size() > 0) {
                List<MemberData> aRl = aVar.aRl();
                int size = aRl.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aRl.get(i3);
                    HeadImageView headImageView = this.eMI[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eMk.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eMI[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds10);
                    this.eMH.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aRq()) {
                this.eMG.setEnabled(true);
                this.eMX.setEnabled(true);
                al.i(this.eMX, e.f.group_info_item);
                this.eMU.setVisibility(0);
                this.eMZ.setVisibility(0);
                this.eMW.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eMV.setText(aVar.getGroup().getName());
                }
            } else {
                this.eMG.setEnabled(false);
                this.eMX.setEnabled(true);
                al.j(this.eMX, e.d.cp_bg_line_d);
                this.eMW.setVisibility(8);
                this.eMZ.setVisibility(8);
                this.eMs.setPadding(0, 0, 0, 0);
            }
            if (aVar.aRp()) {
                this.eMM.setVisibility(0);
                this.eNf.setVisibility(0);
                if (this.eMB.getParent() != this.eMM) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds18);
                    this.eMO.removeView(this.eMB);
                    this.eMM.addView(this.eMB, 1);
                }
                aQG();
            } else {
                this.eMM.setVisibility(8);
                this.eNf.setVisibility(8);
                if (this.eMB.getParent() != this.eMO) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds28);
                    this.eMM.removeView(this.eMB);
                    this.eMO.addView(this.eMB, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eMx.setVisibility(8);
            } else {
                this.eMx.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                iE(aVar.aRq());
            } else {
                h(aVar.aRq(), this.eMS);
            }
            this.bDR.setVisibility(0);
            this.eMJ.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (pI(aVar.getGroup().getFlag())) {
                iF(z);
            } else {
                aQH();
            }
        }
    }

    public void aQG() {
        this.eMK.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eMK, e.d.cp_cont_i, 1);
        this.eMK.setText(this.eMk.getPageContext().getString(e.j.i_want_talk));
        this.eNe.setEnabled(true);
    }

    private void iF(boolean z) {
        this.eMK.setText(this.eMk.getPageContext().getString(e.j.i_want_attent));
        if (z) {
            this.eMK.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eMK, e.d.cp_cont_i, 1);
        } else {
            this.eMK.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eMK, e.d.cp_cont_i, 1);
        }
        al.i(this.eNe, e.f.btn_blue_bg);
        this.eNe.setEnabled(true);
    }

    private boolean pI(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aQH() {
        this.eMK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eMK.setText(this.eMk.getPageContext().getString(e.j.group_info_refuse_join));
        this.eMK.setTextColor(this.eMk.getResources().getColorStateList(e.d.cp_cont_i));
        al.i(this.eNe, e.f.btn_app_download_d);
        this.eNe.setEnabled(false);
    }

    public void pJ(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eMH.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eMH.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eMH.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eMv.setIsManager(aVar.aRq());
            if (aVar.aRq()) {
                this.eMv.setVisibility(0);
                if (aVar.aRm() != null && aVar.aRm().size() == 1 && TextUtils.isEmpty(aVar.aRm().get(0).getPicId())) {
                    this.eMv.setData(null);
                } else {
                    this.eMv.setData(aVar.aRm());
                }
            } else if (aVar.aRm() != null && aVar.aRm().size() > 0) {
                if (aVar.aRm().size() == 1 && TextUtils.isEmpty(aVar.aRm().get(0).getPicId())) {
                    this.eMv.setVisibility(8);
                    return;
                }
                this.eMv.setVisibility(0);
                this.eMv.setData(aVar.aRm());
            } else {
                this.eMv.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eMQ = bVar;
    }

    public void d(Object obj, int i) {
        if (this.eMP != null) {
            this.eMP.dismiss();
            this.eMP = null;
        }
        e(obj, i);
        this.eMP.AE();
    }

    public void aQI() {
        this.eMP.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.eMP == null) {
            this.eMP = new com.baidu.tbadk.core.dialog.b(this.eMk.getPageContext().getPageActivity());
            this.eMP.ek(this.eMk.getResources().getString(e.j.operation));
            this.eMP.a(new String[]{this.eMk.getResources().getString(e.j.group_info_set_portrait), this.eMk.getResources().getString(e.j.delete), this.eMk.getResources().getString(e.j.cancel)}, new b.InterfaceC0148b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eMQ.a(bVar, i2, obj, i);
                }
            });
        }
        this.eMP.d(this.eMk.getPageContext());
    }

    public void onDestory() {
        if (this.eMv != null) {
            this.eMv.onDestory();
        }
        if (this.eMz != null) {
            this.eMz.stopLoad();
            this.eMz.setBackgroundDrawable(null);
            this.eMz.setImageDrawable(null);
        }
        if (this.eMH != null && this.eMI != null) {
            int length = this.eMI.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eMI[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void pK(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.eMk.getPageContext().getString(e.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eMk.getPageContext().getPageActivity());
            bVar.ek(this.eMk.getPageContext().getString(e.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eMk.getSystemService("clipboard")).setText(str);
                        a.this.eMk.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eMk.getPageContext());
            bVar.AE();
        }
    }

    public void pL(String str) {
        if (this.eMN == null) {
            pM(str);
        }
        this.eMN.AE();
    }

    private void pM(final String str) {
        if (this.eMN == null) {
            this.eMN = new com.baidu.tbadk.core.dialog.b(this.eMk.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eMk.getPageContext().getString(e.j.copy_group_number)};
            this.eMN.ek(this.eMk.getPageContext().getString(e.j.operation));
            this.eMN.a(charSequenceArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eMk.getSystemService("clipboard")).setText(str);
                        a.this.eMk.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eMN.d(this.eMk.getPageContext());
        }
    }

    public void aQJ() {
        ColorStateList dz = al.dz(e.d.cp_cont_i);
        if (dz != null) {
            this.eMK.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eMK.setTextColor(dz);
    }

    public void changeSkinType(int i) {
        this.eMk.getLayoutMode().setNightMode(i == 1);
        this.eMk.getLayoutMode().onModeChanged(this.bwZ);
        this.eMk.getLayoutMode().onModeChanged(this.eME);
        this.eMv.a(i, this.eMk);
        this.mNavigationBar.onChangeSkinType(this.eMk.getPageContext(), i);
        if (this.isMemGroup) {
            al.c(this.eNg, e.d.common_color_10009, 1);
        }
        if (!this.dtn) {
            b(this.eNh, this.eNi);
        }
        if (this.eNj) {
            al.i(this.eMX, e.f.group_info_item);
        } else {
            al.j(this.eMX, e.d.cp_bg_line_d);
        }
    }

    public void iG(boolean z) {
        this.dtn = z;
    }
}
