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
    private TextView eJN;
    private final GroupInfoActivity eKR;
    private View eKS;
    private ProgressBar eKT;
    private RelativeLayout eKU;
    private TextView eKV;
    private TextView eKW;
    private TextView eKX;
    private TextView eKY;
    private EllipsizingTextView eKZ;
    private ImageView eLA;
    private RelativeLayout eLB;
    private TextView eLC;
    private ImageView eLD;
    private RelativeLayout eLE;
    private RelativeLayout eLF;
    private ImageView eLG;
    private ImageView eLH;
    private View eLI;
    private TextView eLJ;
    private TextView eLK;
    private LinearLayout eLL;
    private View eLM;
    private TextView eLN;
    private ResponseGroupInfoLocalMessage.a eLO;
    private boolean eLP;
    private boolean eLQ;
    private TextView eLa;
    private RelativeLayout eLb;
    private PhotoWallView eLc;
    private RelativeLayout eLd;
    private RelativeLayout eLe;
    private LinearLayout eLf;
    private HeadImageView eLg;
    private TextView eLh;
    private RelativeLayout eLi;
    private com.baidu.tbadk.core.dialog.b eLj;
    private ImageView eLk;
    private final View eLl;
    private b.InterfaceC0124b eLm;
    private RelativeLayout eLn;
    private LinearLayout eLo;
    private HeadImageView[] eLp;
    private LinearLayout eLq;
    private TextView eLr;
    private RelativeLayout eLs;
    private LinearLayout eLt;
    private com.baidu.tbadk.core.dialog.b eLu;
    private LinearLayout eLv;
    private com.baidu.tbadk.core.dialog.b eLw;
    private b eLx;
    private TextView eLy;
    private String eLz;
    private View ezB;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int eLR = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eLj = null;
        this.eLm = null;
        this.eLp = new HeadImageView[5];
        this.eLz = "";
        this.eLP = true;
        this.isMemGroup = false;
        this.dsj = false;
        this.eLQ = false;
        this.eKR = groupInfoActivity;
        groupInfoActivity.setContentView(e.h.im_group_info_activity);
        this.eLl = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(e.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bDf.setVisibility(4);
        this.eLq.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eLC.setText(str);
        pG(str);
    }

    private void pG(String str) {
        if (str != null) {
            this.eLN.setText(str);
        }
    }

    public void pH(String str) {
        this.eKZ.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(e.g.view_navigation_bar);
        this.ezB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eLN = this.mNavigationBar.setTitleText("");
        this.eLM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eLy = (TextView) this.eLM.findViewById(e.g.right_textview);
        this.eLy.setText(groupInfoActivity.getPageContext().getString(e.j.setup));
        al.c(this.eLy, e.d.cp_cont_f, 1);
        this.eLy.setOnClickListener(groupInfoActivity);
        this.eLM.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eKS = groupInfoActivity.findViewById(e.g.line_activity_name_down);
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
        this.eKU = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_activity);
        this.eKU.setOnClickListener(groupInfoActivity);
        this.eKV = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_status);
        this.eKW = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_name);
        this.eLn = (RelativeLayout) groupInfoActivity.findViewById(e.g.address_layout);
        this.eLn.setOnClickListener(groupInfoActivity);
        this.eLv = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_body);
        this.eLA = (ImageView) groupInfoActivity.findViewById(e.g.img_group_type_icon);
        this.eKX = (TextView) groupInfoActivity.findViewById(e.g.txt_group_number);
        this.eKY = (TextView) groupInfoActivity.findViewById(e.g.txt_group_place);
        this.eLG = (ImageView) groupInfoActivity.findViewById(e.g.img_group_place);
        this.eKZ = (EllipsizingTextView) groupInfoActivity.findViewById(e.g.txt_group_intro);
        this.eKZ.setMaxLines(20);
        this.eKZ.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void hu(boolean z) {
                if (z) {
                    a.this.eLJ.setVisibility(0);
                } else {
                    a.this.eLJ.setVisibility(8);
                }
            }
        });
        this.eLb = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_forum);
        this.eLa = (TextView) groupInfoActivity.findViewById(e.g.txt_group_forum);
        this.eLb.setOnClickListener(groupInfoActivity);
        this.eLg = (HeadImageView) groupInfoActivity.findViewById(e.g.img_group_author);
        this.eLg.setAutoChangeStyle(true);
        this.eLg.setIsRound(false);
        this.eJN = (TextView) groupInfoActivity.findViewById(e.g.txt_group_author);
        this.eLd = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_author);
        this.eLd.setOnClickListener(groupInfoActivity);
        this.eLk = (ImageView) groupInfoActivity.findViewById(e.g.meizhi_icon);
        this.eLI = groupInfoActivity.findViewById(e.g.line_group_author_down);
        this.eLf = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_grade_star);
        this.eLb.setOnClickListener(groupInfoActivity);
        this.eLe = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_grade);
        this.eLe.setOnClickListener(groupInfoActivity);
        this.eLh = (TextView) groupInfoActivity.findViewById(e.g.txt_group_member_count);
        this.eLi = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_member);
        this.eLi.setOnClickListener(groupInfoActivity);
        this.eLo = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_member_photo);
        this.eLq = (LinearLayout) groupInfoActivity.findViewById(e.g.bottom_bar);
        this.eLL = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_bottom_button);
        this.eLr = (TextView) groupInfoActivity.findViewById(e.g.txt_join);
        this.eLL.setOnClickListener(this.eKR);
        this.eLs = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_invite);
        this.eLs.setOnClickListener(groupInfoActivity);
        this.eLt = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_notice_share);
        this.eLB = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_name);
        this.eLB.setOnClickListener(groupInfoActivity);
        this.eLC = (TextView) groupInfoActivity.findViewById(e.g.txt_group_name);
        this.eLD = (ImageView) groupInfoActivity.findViewById(e.g.img_group_intro_arrow);
        this.eLH = (ImageView) groupInfoActivity.findViewById(e.g.img_group_author_arrow);
        this.eLE = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_intro);
        this.eLE.setOnClickListener(groupInfoActivity);
        this.eLE.setLongClickable(true);
        this.eLE.setOnLongClickListener(groupInfoActivity);
        this.eLJ = (TextView) groupInfoActivity.findViewById(e.g.txt_group_intro_more);
        this.eLJ.setClickable(true);
        this.eLJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eKZ.setMaxLines(1000);
            }
        });
        this.eLF = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_number);
        this.eLF.setOnLongClickListener(groupInfoActivity);
        this.eLK = (TextView) groupInfoActivity.findViewById(e.g.can_create_mem_group);
        this.eKT = (ProgressBar) groupInfoActivity.findViewById(e.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(e.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eLc = (PhotoWallView) groupInfoActivity.findViewById(e.g.photo_wall);
        this.eLc.setPhotoClickListener(groupInfoActivity);
        this.eLc.setPhotoLongClickListener(groupInfoActivity);
        this.eLc.setVisibility(8);
    }

    public RelativeLayout aQU() {
        return this.eLF;
    }

    public RelativeLayout aQV() {
        return this.eLb;
    }

    public LinearLayout aQW() {
        return this.eLo;
    }

    public RelativeLayout aQX() {
        return this.eLs;
    }

    public RelativeLayout aQY() {
        return this.eLE;
    }

    public RelativeLayout aQZ() {
        return this.eLB;
    }

    public RelativeLayout aRa() {
        return this.eKU;
    }

    public View aRb() {
        return this.eLy;
    }

    public LinearLayout aRc() {
        return this.eLL;
    }

    public RelativeLayout aRd() {
        return this.eLd;
    }

    public RelativeLayout aRe() {
        return this.eLe;
    }

    public RelativeLayout aRf() {
        return this.eLi;
    }

    public View aPP() {
        return this.ezB;
    }

    public void aRg() {
        this.eKT.setVisibility(8);
    }

    public void aRh() {
        this.eKT.setVisibility(0);
    }

    public void i(boolean z, String str) {
        if (z) {
            this.eKY.setText(str);
            this.eLn.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eLn.setVisibility(8);
        } else {
            this.eKY.setText(str);
            this.eLn.setVisibility(0);
        }
    }

    public void iv(boolean z) {
        if (z) {
            this.eKY.setText(this.mContext.getString(e.j.live_card_hide));
        } else {
            this.eLn.setVisibility(8);
        }
    }

    public RelativeLayout aRi() {
        return this.eLn;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dsj = aVar.aRS();
            this.eLQ = aVar.aRT();
            this.eLO = aVar;
            this.eLP = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aRN() != null) {
                eLR = aVar.aRN().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eLv.setVisibility(0);
            this.eLq.setVisibility(0);
            if (aVar.getGroup() != null) {
                pG(aVar.getGroup().getName());
                this.eKX.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eLk.setVisibility(0);
                } else {
                    this.eLk.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eLA.setVisibility(0);
                    this.eLg.setVisibility(8);
                    this.eLH.setVisibility(8);
                    this.eLI.setVisibility(8);
                    this.eJN.setText(e.j.group_info_forum_author);
                    this.eLd.setEnabled(false);
                    this.eLk.setVisibility(8);
                } else {
                    this.eLA.setVisibility(8);
                    this.eLg.setVisibility(0);
                    this.eLH.setVisibility(0);
                    this.eLI.setVisibility(0);
                    this.eJN.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.eLd.setEnabled(true);
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
                this.eLz = stringBuffer.toString();
                this.eKY.setText(this.eLz);
                this.eKZ.setText(aVar.getGroup().getIntro());
                this.eLh.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eLg.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eLb.setVisibility(0);
                    this.eLa.setText(aVar.getGroup().getForumName() + this.eKR.getPageContext().getString(e.j.forum));
                } else {
                    this.eLb.setVisibility(8);
                }
                this.eLf.removeAllViews();
                boolean aRU = aVar.aRU();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.c(this.eLN, e.d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eKR.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, e.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, e.f.icon_grade_middle_star_s);
                        }
                        this.eLf.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eKR.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, e.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, e.f.icon_grade_middle_star_n);
                    }
                    this.eLf.addView(imageView2);
                }
                if (aRU) {
                    this.eLK.setVisibility(0);
                } else {
                    this.eLK.setVisibility(8);
                }
            }
            if (aVar.aRN() != null) {
                this.eKU.setVisibility(0);
                this.eKS.setVisibility(0);
                GroupActivityData aRN = aVar.aRN();
                if (!aVar.aRS()) {
                    if (aRN.getIsEnd() != 1) {
                        this.eKV.setVisibility(4);
                        this.eKW.setText(e.j.group_info_activity_not_join_tip);
                    } else {
                        this.eKU.setVisibility(8);
                        this.eKS.setVisibility(8);
                    }
                } else {
                    this.eKV.setVisibility(0);
                    this.eKW.setText(aRN.getgActivityTitle());
                    if (aRN.getIsEnd() != 1) {
                        this.eKV.setText(e.j.group_info_activity_doing);
                        al.c(this.eKV, e.d.common_color_10171, 1);
                    } else {
                        this.eKV.setText(e.j.group_activity_end);
                        al.c(this.eKV, e.d.common_color_10168, 1);
                    }
                    this.eKW.setText(aRN.getgActivityTitle());
                }
            } else if (aVar.aRT()) {
                this.eKU.setVisibility(0);
                this.eKS.setVisibility(0);
                this.eKV.setVisibility(4);
                this.eKW.setText(e.j.group_info_create_activity);
            } else {
                this.eKU.setVisibility(8);
                this.eKS.setVisibility(8);
            }
            this.eLo.removeAllViews();
            if (aVar.aRO() != null && aVar.aRO().size() > 0) {
                List<MemberData> aRO = aVar.aRO();
                int size = aRO.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aRO.get(i3);
                    HeadImageView headImageView = this.eLp[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eKR.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eLp[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds10);
                    this.eLo.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aRT()) {
                this.eLn.setEnabled(true);
                this.eLE.setEnabled(true);
                al.i(this.eLE, e.f.group_info_item);
                this.eLB.setVisibility(0);
                this.eLG.setVisibility(0);
                this.eLD.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eLC.setText(aVar.getGroup().getName());
                }
            } else {
                this.eLn.setEnabled(false);
                this.eLE.setEnabled(true);
                al.j(this.eLE, e.d.cp_bg_line_d);
                this.eLD.setVisibility(8);
                this.eLG.setVisibility(8);
                this.eKZ.setPadding(0, 0, 0, 0);
            }
            if (aVar.aRS()) {
                this.eLt.setVisibility(0);
                this.eLM.setVisibility(0);
                if (this.eLi.getParent() != this.eLt) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds18);
                    this.eLv.removeView(this.eLi);
                    this.eLt.addView(this.eLi, 1);
                }
                aRj();
            } else {
                this.eLt.setVisibility(8);
                this.eLM.setVisibility(8);
                if (this.eLi.getParent() != this.eLv) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds28);
                    this.eLt.removeView(this.eLi);
                    this.eLv.addView(this.eLi, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eLe.setVisibility(8);
            } else {
                this.eLe.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                iv(aVar.aRT());
            } else {
                i(aVar.aRT(), this.eLz);
            }
            this.bDf.setVisibility(0);
            this.eLq.setVisibility(0);
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
        this.eLr.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eLr, e.d.cp_cont_i, 1);
        this.eLr.setText(this.eKR.getPageContext().getString(e.j.i_want_talk));
        this.eLL.setEnabled(true);
    }

    private void iw(boolean z) {
        this.eLr.setText(this.eKR.getPageContext().getString(e.j.i_want_attent));
        if (z) {
            this.eLr.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eLr, e.d.cp_cont_i, 1);
        } else {
            this.eLr.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eLr, e.d.cp_cont_i, 1);
        }
        al.i(this.eLL, e.f.btn_blue_bg);
        this.eLL.setEnabled(true);
    }

    private boolean pp(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aRk() {
        this.eLr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eLr.setText(this.eKR.getPageContext().getString(e.j.group_info_refuse_join));
        this.eLr.setTextColor(this.eKR.getResources().getColorStateList(e.d.cp_cont_i));
        al.i(this.eLL, e.f.btn_app_download_d);
        this.eLL.setEnabled(false);
    }

    public void pI(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eLo.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eLo.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eLo.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eLc.setIsManager(aVar.aRT());
            if (aVar.aRT()) {
                this.eLc.setVisibility(0);
                if (aVar.aRP() != null && aVar.aRP().size() == 1 && TextUtils.isEmpty(aVar.aRP().get(0).getPicId())) {
                    this.eLc.setData(null);
                } else {
                    this.eLc.setData(aVar.aRP());
                }
            } else if (aVar.aRP() != null && aVar.aRP().size() > 0) {
                if (aVar.aRP().size() == 1 && TextUtils.isEmpty(aVar.aRP().get(0).getPicId())) {
                    this.eLc.setVisibility(8);
                    return;
                }
                this.eLc.setVisibility(0);
                this.eLc.setData(aVar.aRP());
            } else {
                this.eLc.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eLx = bVar;
    }

    public void c(Object obj, int i) {
        if (this.eLw != null) {
            this.eLw.dismiss();
            this.eLw = null;
        }
        d(obj, i);
        this.eLw.Ax();
    }

    public void aRl() {
        this.eLw.dismiss();
    }

    private void d(final Object obj, final int i) {
        if (this.eLw == null) {
            this.eLw = new com.baidu.tbadk.core.dialog.b(this.eKR.getPageContext().getPageActivity());
            this.eLw.ek(this.eKR.getResources().getString(e.j.operation));
            this.eLw.a(new String[]{this.eKR.getResources().getString(e.j.group_info_set_portrait), this.eKR.getResources().getString(e.j.delete), this.eKR.getResources().getString(e.j.cancel)}, new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eLx.a(bVar, i2, obj, i);
                }
            });
        }
        this.eLw.d(this.eKR.getPageContext());
    }

    public void onDestory() {
        if (this.eLc != null) {
            this.eLc.onDestory();
        }
        if (this.eLg != null) {
            this.eLg.stopLoad();
            this.eLg.setBackgroundDrawable(null);
            this.eLg.setImageDrawable(null);
        }
        if (this.eLo != null && this.eLp != null) {
            int length = this.eLp.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eLp[i];
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
            CharSequence[] charSequenceArr = {this.eKR.getPageContext().getString(e.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eKR.getPageContext().getPageActivity());
            bVar.ek(this.eKR.getPageContext().getString(e.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eKR.getSystemService("clipboard")).setText(str);
                        a.this.eKR.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eKR.getPageContext());
            bVar.Ax();
        }
    }

    public void pK(String str) {
        if (this.eLu == null) {
            pL(str);
        }
        this.eLu.Ax();
    }

    private void pL(final String str) {
        if (this.eLu == null) {
            this.eLu = new com.baidu.tbadk.core.dialog.b(this.eKR.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eKR.getPageContext().getString(e.j.copy_group_number)};
            this.eLu.ek(this.eKR.getPageContext().getString(e.j.operation));
            this.eLu.a(charSequenceArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eKR.getSystemService("clipboard")).setText(str);
                        a.this.eKR.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eLu.d(this.eKR.getPageContext());
        }
    }

    public void aRm() {
        ColorStateList dl = al.dl(e.d.cp_cont_i);
        if (dl != null) {
            this.eLr.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eLr.setTextColor(dl);
    }

    public void changeSkinType(int i) {
        this.eKR.getLayoutMode().setNightMode(i == 1);
        this.eKR.getLayoutMode().onModeChanged(this.bwo);
        this.eKR.getLayoutMode().onModeChanged(this.eLl);
        this.eLc.a(i, this.eKR);
        this.mNavigationBar.onChangeSkinType(this.eKR.getPageContext(), i);
        if (this.isMemGroup) {
            al.c(this.eLN, e.d.common_color_10009, 1);
        }
        if (!this.dsj) {
            b(this.eLO, this.eLP);
        }
        if (this.eLQ) {
            al.i(this.eLE, e.f.group_info_item);
        } else {
            al.j(this.eLE, e.d.cp_bg_line_d);
        }
    }

    public void ix(boolean z) {
        this.dsj = z;
    }
}
