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
    private ScrollView bDf;
    private RelativeLayout bwo;
    private View dmK;
    private boolean dsj;
    private TextView eJO;
    private final GroupInfoActivity eKS;
    private View eKT;
    private ProgressBar eKU;
    private RelativeLayout eKV;
    private TextView eKW;
    private TextView eKX;
    private TextView eKY;
    private TextView eKZ;
    private String eLA;
    private ImageView eLB;
    private RelativeLayout eLC;
    private TextView eLD;
    private ImageView eLE;
    private RelativeLayout eLF;
    private RelativeLayout eLG;
    private ImageView eLH;
    private ImageView eLI;
    private View eLJ;
    private TextView eLK;
    private TextView eLL;
    private LinearLayout eLM;
    private View eLN;
    private TextView eLO;
    private ResponseGroupInfoLocalMessage.a eLP;
    private boolean eLQ;
    private boolean eLR;
    private EllipsizingTextView eLa;
    private TextView eLb;
    private RelativeLayout eLc;
    private PhotoWallView eLd;
    private RelativeLayout eLe;
    private RelativeLayout eLf;
    private LinearLayout eLg;
    private HeadImageView eLh;
    private TextView eLi;
    private RelativeLayout eLj;
    private com.baidu.tbadk.core.dialog.b eLk;
    private ImageView eLl;
    private final View eLm;
    private b.InterfaceC0124b eLn;
    private RelativeLayout eLo;
    private LinearLayout eLp;
    private HeadImageView[] eLq;
    private LinearLayout eLr;
    private TextView eLs;
    private RelativeLayout eLt;
    private LinearLayout eLu;
    private com.baidu.tbadk.core.dialog.b eLv;
    private LinearLayout eLw;
    private com.baidu.tbadk.core.dialog.b eLx;
    private b eLy;
    private TextView eLz;
    private View ezC;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int eLS = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eLk = null;
        this.eLn = null;
        this.eLq = new HeadImageView[5];
        this.eLA = "";
        this.eLQ = true;
        this.isMemGroup = false;
        this.dsj = false;
        this.eLR = false;
        this.eKS = groupInfoActivity;
        groupInfoActivity.setContentView(e.h.im_group_info_activity);
        this.eLm = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(e.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bDf.setVisibility(4);
        this.eLr.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eLD.setText(str);
        pG(str);
    }

    private void pG(String str) {
        if (str != null) {
            this.eLO.setText(str);
        }
    }

    public void pH(String str) {
        this.eLa.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(e.g.view_navigation_bar);
        this.ezC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eLO = this.mNavigationBar.setTitleText("");
        this.eLN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eLz = (TextView) this.eLN.findViewById(e.g.right_textview);
        this.eLz.setText(groupInfoActivity.getPageContext().getString(e.j.setup));
        al.c(this.eLz, e.d.cp_cont_f, 1);
        this.eLz.setOnClickListener(groupInfoActivity);
        this.eLN.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eKT = groupInfoActivity.findViewById(e.g.line_activity_name_down);
        this.bwo = (RelativeLayout) groupInfoActivity.findViewById(e.g.group_info_container);
        this.bDf = (ScrollView) groupInfoActivity.findViewById(e.g.group_scrollview);
        this.bDf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.dmK = groupInfoActivity.findViewById(e.g.group_top_view);
        this.dmK.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eKV = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_activity);
        this.eKV.setOnClickListener(groupInfoActivity);
        this.eKW = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_status);
        this.eKX = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_name);
        this.eLo = (RelativeLayout) groupInfoActivity.findViewById(e.g.address_layout);
        this.eLo.setOnClickListener(groupInfoActivity);
        this.eLw = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_body);
        this.eLB = (ImageView) groupInfoActivity.findViewById(e.g.img_group_type_icon);
        this.eKY = (TextView) groupInfoActivity.findViewById(e.g.txt_group_number);
        this.eKZ = (TextView) groupInfoActivity.findViewById(e.g.txt_group_place);
        this.eLH = (ImageView) groupInfoActivity.findViewById(e.g.img_group_place);
        this.eLa = (EllipsizingTextView) groupInfoActivity.findViewById(e.g.txt_group_intro);
        this.eLa.setMaxLines(20);
        this.eLa.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void hu(boolean z) {
                if (z) {
                    a.this.eLK.setVisibility(0);
                } else {
                    a.this.eLK.setVisibility(8);
                }
            }
        });
        this.eLc = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_forum);
        this.eLb = (TextView) groupInfoActivity.findViewById(e.g.txt_group_forum);
        this.eLc.setOnClickListener(groupInfoActivity);
        this.eLh = (HeadImageView) groupInfoActivity.findViewById(e.g.img_group_author);
        this.eLh.setAutoChangeStyle(true);
        this.eLh.setIsRound(false);
        this.eJO = (TextView) groupInfoActivity.findViewById(e.g.txt_group_author);
        this.eLe = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_author);
        this.eLe.setOnClickListener(groupInfoActivity);
        this.eLl = (ImageView) groupInfoActivity.findViewById(e.g.meizhi_icon);
        this.eLJ = groupInfoActivity.findViewById(e.g.line_group_author_down);
        this.eLg = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_grade_star);
        this.eLc.setOnClickListener(groupInfoActivity);
        this.eLf = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_grade);
        this.eLf.setOnClickListener(groupInfoActivity);
        this.eLi = (TextView) groupInfoActivity.findViewById(e.g.txt_group_member_count);
        this.eLj = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_member);
        this.eLj.setOnClickListener(groupInfoActivity);
        this.eLp = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_member_photo);
        this.eLr = (LinearLayout) groupInfoActivity.findViewById(e.g.bottom_bar);
        this.eLM = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_bottom_button);
        this.eLs = (TextView) groupInfoActivity.findViewById(e.g.txt_join);
        this.eLM.setOnClickListener(this.eKS);
        this.eLt = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_invite);
        this.eLt.setOnClickListener(groupInfoActivity);
        this.eLu = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_notice_share);
        this.eLC = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_name);
        this.eLC.setOnClickListener(groupInfoActivity);
        this.eLD = (TextView) groupInfoActivity.findViewById(e.g.txt_group_name);
        this.eLE = (ImageView) groupInfoActivity.findViewById(e.g.img_group_intro_arrow);
        this.eLI = (ImageView) groupInfoActivity.findViewById(e.g.img_group_author_arrow);
        this.eLF = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_intro);
        this.eLF.setOnClickListener(groupInfoActivity);
        this.eLF.setLongClickable(true);
        this.eLF.setOnLongClickListener(groupInfoActivity);
        this.eLK = (TextView) groupInfoActivity.findViewById(e.g.txt_group_intro_more);
        this.eLK.setClickable(true);
        this.eLK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eLa.setMaxLines(1000);
            }
        });
        this.eLG = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_number);
        this.eLG.setOnLongClickListener(groupInfoActivity);
        this.eLL = (TextView) groupInfoActivity.findViewById(e.g.can_create_mem_group);
        this.eKU = (ProgressBar) groupInfoActivity.findViewById(e.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(e.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eLd = (PhotoWallView) groupInfoActivity.findViewById(e.g.photo_wall);
        this.eLd.setPhotoClickListener(groupInfoActivity);
        this.eLd.setPhotoLongClickListener(groupInfoActivity);
        this.eLd.setVisibility(8);
    }

    public RelativeLayout aQU() {
        return this.eLG;
    }

    public RelativeLayout aQV() {
        return this.eLc;
    }

    public LinearLayout aQW() {
        return this.eLp;
    }

    public RelativeLayout aQX() {
        return this.eLt;
    }

    public RelativeLayout aQY() {
        return this.eLF;
    }

    public RelativeLayout aQZ() {
        return this.eLC;
    }

    public RelativeLayout aRa() {
        return this.eKV;
    }

    public View aRb() {
        return this.eLz;
    }

    public LinearLayout aRc() {
        return this.eLM;
    }

    public RelativeLayout aRd() {
        return this.eLe;
    }

    public RelativeLayout aRe() {
        return this.eLf;
    }

    public RelativeLayout aRf() {
        return this.eLj;
    }

    public View aPP() {
        return this.ezC;
    }

    public void aRg() {
        this.eKU.setVisibility(8);
    }

    public void aRh() {
        this.eKU.setVisibility(0);
    }

    public void i(boolean z, String str) {
        if (z) {
            this.eKZ.setText(str);
            this.eLo.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eLo.setVisibility(8);
        } else {
            this.eKZ.setText(str);
            this.eLo.setVisibility(0);
        }
    }

    public void iv(boolean z) {
        if (z) {
            this.eKZ.setText(this.mContext.getString(e.j.live_card_hide));
        } else {
            this.eLo.setVisibility(8);
        }
    }

    public RelativeLayout aRi() {
        return this.eLo;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dsj = aVar.aRS();
            this.eLR = aVar.aRT();
            this.eLP = aVar;
            this.eLQ = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aRN() != null) {
                eLS = aVar.aRN().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eLw.setVisibility(0);
            this.eLr.setVisibility(0);
            if (aVar.getGroup() != null) {
                pG(aVar.getGroup().getName());
                this.eKY.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eLl.setVisibility(0);
                } else {
                    this.eLl.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eLB.setVisibility(0);
                    this.eLh.setVisibility(8);
                    this.eLI.setVisibility(8);
                    this.eLJ.setVisibility(8);
                    this.eJO.setText(e.j.group_info_forum_author);
                    this.eLe.setEnabled(false);
                    this.eLl.setVisibility(8);
                } else {
                    this.eLB.setVisibility(8);
                    this.eLh.setVisibility(0);
                    this.eLI.setVisibility(0);
                    this.eLJ.setVisibility(0);
                    this.eJO.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.eLe.setEnabled(true);
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
                this.eLA = stringBuffer.toString();
                this.eKZ.setText(this.eLA);
                this.eLa.setText(aVar.getGroup().getIntro());
                this.eLi.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eLh.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eLc.setVisibility(0);
                    this.eLb.setText(aVar.getGroup().getForumName() + this.eKS.getPageContext().getString(e.j.forum));
                } else {
                    this.eLc.setVisibility(8);
                }
                this.eLg.removeAllViews();
                boolean aRU = aVar.aRU();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.c(this.eLO, e.d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eKS.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, e.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, e.f.icon_grade_middle_star_s);
                        }
                        this.eLg.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eKS.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, e.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, e.f.icon_grade_middle_star_n);
                    }
                    this.eLg.addView(imageView2);
                }
                if (aRU) {
                    this.eLL.setVisibility(0);
                } else {
                    this.eLL.setVisibility(8);
                }
            }
            if (aVar.aRN() != null) {
                this.eKV.setVisibility(0);
                this.eKT.setVisibility(0);
                GroupActivityData aRN = aVar.aRN();
                if (!aVar.aRS()) {
                    if (aRN.getIsEnd() != 1) {
                        this.eKW.setVisibility(4);
                        this.eKX.setText(e.j.group_info_activity_not_join_tip);
                    } else {
                        this.eKV.setVisibility(8);
                        this.eKT.setVisibility(8);
                    }
                } else {
                    this.eKW.setVisibility(0);
                    this.eKX.setText(aRN.getgActivityTitle());
                    if (aRN.getIsEnd() != 1) {
                        this.eKW.setText(e.j.group_info_activity_doing);
                        al.c(this.eKW, e.d.common_color_10171, 1);
                    } else {
                        this.eKW.setText(e.j.group_activity_end);
                        al.c(this.eKW, e.d.common_color_10168, 1);
                    }
                    this.eKX.setText(aRN.getgActivityTitle());
                }
            } else if (aVar.aRT()) {
                this.eKV.setVisibility(0);
                this.eKT.setVisibility(0);
                this.eKW.setVisibility(4);
                this.eKX.setText(e.j.group_info_create_activity);
            } else {
                this.eKV.setVisibility(8);
                this.eKT.setVisibility(8);
            }
            this.eLp.removeAllViews();
            if (aVar.aRO() != null && aVar.aRO().size() > 0) {
                List<MemberData> aRO = aVar.aRO();
                int size = aRO.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aRO.get(i3);
                    HeadImageView headImageView = this.eLq[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eKS.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eLq[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds10);
                    this.eLp.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aRT()) {
                this.eLo.setEnabled(true);
                this.eLF.setEnabled(true);
                al.i(this.eLF, e.f.group_info_item);
                this.eLC.setVisibility(0);
                this.eLH.setVisibility(0);
                this.eLE.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eLD.setText(aVar.getGroup().getName());
                }
            } else {
                this.eLo.setEnabled(false);
                this.eLF.setEnabled(true);
                al.j(this.eLF, e.d.cp_bg_line_d);
                this.eLE.setVisibility(8);
                this.eLH.setVisibility(8);
                this.eLa.setPadding(0, 0, 0, 0);
            }
            if (aVar.aRS()) {
                this.eLu.setVisibility(0);
                this.eLN.setVisibility(0);
                if (this.eLj.getParent() != this.eLu) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds18);
                    this.eLw.removeView(this.eLj);
                    this.eLu.addView(this.eLj, 1);
                }
                aRj();
            } else {
                this.eLu.setVisibility(8);
                this.eLN.setVisibility(8);
                if (this.eLj.getParent() != this.eLw) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds28);
                    this.eLu.removeView(this.eLj);
                    this.eLw.addView(this.eLj, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eLf.setVisibility(8);
            } else {
                this.eLf.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                iv(aVar.aRT());
            } else {
                i(aVar.aRT(), this.eLA);
            }
            this.bDf.setVisibility(0);
            this.eLr.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (pp(aVar.getGroup().getFlag())) {
                iw(z);
            } else {
                aRk();
            }
        }
    }

    public void aRj() {
        this.eLs.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eLs, e.d.cp_cont_i, 1);
        this.eLs.setText(this.eKS.getPageContext().getString(e.j.i_want_talk));
        this.eLM.setEnabled(true);
    }

    private void iw(boolean z) {
        this.eLs.setText(this.eKS.getPageContext().getString(e.j.i_want_attent));
        if (z) {
            this.eLs.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eLs, e.d.cp_cont_i, 1);
        } else {
            this.eLs.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eLs, e.d.cp_cont_i, 1);
        }
        al.i(this.eLM, e.f.btn_blue_bg);
        this.eLM.setEnabled(true);
    }

    private boolean pp(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aRk() {
        this.eLs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eLs.setText(this.eKS.getPageContext().getString(e.j.group_info_refuse_join));
        this.eLs.setTextColor(this.eKS.getResources().getColorStateList(e.d.cp_cont_i));
        al.i(this.eLM, e.f.btn_app_download_d);
        this.eLM.setEnabled(false);
    }

    public void pI(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eLp.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eLp.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eLp.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eLd.setIsManager(aVar.aRT());
            if (aVar.aRT()) {
                this.eLd.setVisibility(0);
                if (aVar.aRP() != null && aVar.aRP().size() == 1 && TextUtils.isEmpty(aVar.aRP().get(0).getPicId())) {
                    this.eLd.setData(null);
                } else {
                    this.eLd.setData(aVar.aRP());
                }
            } else if (aVar.aRP() != null && aVar.aRP().size() > 0) {
                if (aVar.aRP().size() == 1 && TextUtils.isEmpty(aVar.aRP().get(0).getPicId())) {
                    this.eLd.setVisibility(8);
                    return;
                }
                this.eLd.setVisibility(0);
                this.eLd.setData(aVar.aRP());
            } else {
                this.eLd.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eLy = bVar;
    }

    public void c(Object obj, int i) {
        if (this.eLx != null) {
            this.eLx.dismiss();
            this.eLx = null;
        }
        d(obj, i);
        this.eLx.Ax();
    }

    public void aRl() {
        this.eLx.dismiss();
    }

    private void d(final Object obj, final int i) {
        if (this.eLx == null) {
            this.eLx = new com.baidu.tbadk.core.dialog.b(this.eKS.getPageContext().getPageActivity());
            this.eLx.ek(this.eKS.getResources().getString(e.j.operation));
            this.eLx.a(new String[]{this.eKS.getResources().getString(e.j.group_info_set_portrait), this.eKS.getResources().getString(e.j.delete), this.eKS.getResources().getString(e.j.cancel)}, new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eLy.a(bVar, i2, obj, i);
                }
            });
        }
        this.eLx.d(this.eKS.getPageContext());
    }

    public void onDestory() {
        if (this.eLd != null) {
            this.eLd.onDestory();
        }
        if (this.eLh != null) {
            this.eLh.stopLoad();
            this.eLh.setBackgroundDrawable(null);
            this.eLh.setImageDrawable(null);
        }
        if (this.eLp != null && this.eLq != null) {
            int length = this.eLq.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eLq[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void pJ(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.eKS.getPageContext().getString(e.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eKS.getPageContext().getPageActivity());
            bVar.ek(this.eKS.getPageContext().getString(e.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eKS.getSystemService("clipboard")).setText(str);
                        a.this.eKS.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eKS.getPageContext());
            bVar.Ax();
        }
    }

    public void pK(String str) {
        if (this.eLv == null) {
            pL(str);
        }
        this.eLv.Ax();
    }

    private void pL(final String str) {
        if (this.eLv == null) {
            this.eLv = new com.baidu.tbadk.core.dialog.b(this.eKS.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eKS.getPageContext().getString(e.j.copy_group_number)};
            this.eLv.ek(this.eKS.getPageContext().getString(e.j.operation));
            this.eLv.a(charSequenceArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eKS.getSystemService("clipboard")).setText(str);
                        a.this.eKS.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eLv.d(this.eKS.getPageContext());
        }
    }

    public void aRm() {
        ColorStateList dl = al.dl(e.d.cp_cont_i);
        if (dl != null) {
            this.eLs.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eLs.setTextColor(dl);
    }

    public void changeSkinType(int i) {
        this.eKS.getLayoutMode().setNightMode(i == 1);
        this.eKS.getLayoutMode().onModeChanged(this.bwo);
        this.eKS.getLayoutMode().onModeChanged(this.eLm);
        this.eLd.a(i, this.eKS);
        this.mNavigationBar.onChangeSkinType(this.eKS.getPageContext(), i);
        if (this.isMemGroup) {
            al.c(this.eLO, e.d.common_color_10009, 1);
        }
        if (!this.dsj) {
            b(this.eLP, this.eLQ);
        }
        if (this.eLR) {
            al.i(this.eLF, e.f.group_info_item);
        } else {
            al.j(this.eLF, e.d.cp_bg_line_d);
        }
    }

    public void ix(boolean z) {
        this.dsj = z;
    }
}
