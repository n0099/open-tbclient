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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.f;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    private RelativeLayout bmt;
    private View cYI;
    private boolean dem;
    private ScrollView dki;
    private View ekr;
    private TextView euL;
    private final GroupInfoActivity evP;
    private View evQ;
    private ProgressBar evR;
    private RelativeLayout evS;
    private TextView evT;
    private TextView evU;
    private TextView evV;
    private TextView evW;
    private EllipsizingTextView evX;
    private TextView evY;
    private RelativeLayout evZ;
    private TextView ewA;
    private ImageView ewB;
    private RelativeLayout ewC;
    private RelativeLayout ewD;
    private ImageView ewE;
    private ImageView ewF;
    private View ewG;
    private TextView ewH;
    private TextView ewI;
    private LinearLayout ewJ;
    private View ewK;
    private TextView ewL;
    private ResponseGroupInfoLocalMessage.a ewM;
    private boolean ewN;
    private boolean ewO;
    private PhotoWallView ewa;
    private RelativeLayout ewb;
    private RelativeLayout ewc;
    private LinearLayout ewd;
    private HeadImageView ewe;
    private TextView ewf;
    private RelativeLayout ewg;
    private com.baidu.tbadk.core.dialog.b ewh;
    private ImageView ewi;
    private final View ewj;
    private b.InterfaceC0101b ewk;
    private RelativeLayout ewl;
    private LinearLayout ewm;
    private HeadImageView[] ewn;
    private LinearLayout ewo;
    private TextView ewp;
    private RelativeLayout ewq;
    private LinearLayout ewr;
    private com.baidu.tbadk.core.dialog.b ews;
    private LinearLayout ewt;
    private com.baidu.tbadk.core.dialog.b ewu;
    private b ewv;
    private TextView eww;
    private String ewx;
    private ImageView ewy;
    private RelativeLayout ewz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int ewP = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.ewh = null;
        this.ewk = null;
        this.ewn = new HeadImageView[5];
        this.ewx = "";
        this.ewN = true;
        this.isMemGroup = false;
        this.dem = false;
        this.ewO = false;
        this.evP = groupInfoActivity;
        groupInfoActivity.setContentView(f.h.im_group_info_activity);
        this.ewj = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(f.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.dki.setVisibility(4);
        this.ewo.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.ewA.setText(str);
        oz(str);
    }

    private void oz(String str) {
        if (str != null) {
            this.ewL.setText(str);
        }
    }

    public void oA(String str) {
        this.evX.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(f.g.view_navigation_bar);
        this.ekr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ewL = this.mNavigationBar.setTitleText("");
        this.ewK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eww = (TextView) this.ewK.findViewById(f.g.right_textview);
        this.eww.setText(groupInfoActivity.getPageContext().getString(f.j.setup));
        am.c(this.eww, f.d.cp_cont_f, 1);
        this.eww.setOnClickListener(groupInfoActivity);
        this.ewK.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.evQ = groupInfoActivity.findViewById(f.g.line_activity_name_down);
        this.bmt = (RelativeLayout) groupInfoActivity.findViewById(f.g.group_info_container);
        this.dki = (ScrollView) groupInfoActivity.findViewById(f.g.group_scrollview);
        this.dki.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.cYI = groupInfoActivity.findViewById(f.g.group_top_view);
        this.cYI.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.evS = (RelativeLayout) groupInfoActivity.findViewById(f.g.lay_group_activity);
        this.evS.setOnClickListener(groupInfoActivity);
        this.evT = (TextView) groupInfoActivity.findViewById(f.g.txt_activity_status);
        this.evU = (TextView) groupInfoActivity.findViewById(f.g.txt_activity_name);
        this.ewl = (RelativeLayout) groupInfoActivity.findViewById(f.g.address_layout);
        this.ewl.setOnClickListener(groupInfoActivity);
        this.ewt = (LinearLayout) groupInfoActivity.findViewById(f.g.lay_group_body);
        this.ewy = (ImageView) groupInfoActivity.findViewById(f.g.img_group_type_icon);
        this.evV = (TextView) groupInfoActivity.findViewById(f.g.txt_group_number);
        this.evW = (TextView) groupInfoActivity.findViewById(f.g.txt_group_place);
        this.ewE = (ImageView) groupInfoActivity.findViewById(f.g.img_group_place);
        this.evX = (EllipsizingTextView) groupInfoActivity.findViewById(f.g.txt_group_intro);
        this.evX.setMaxLines(20);
        this.evX.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gE(boolean z) {
                if (z) {
                    a.this.ewH.setVisibility(0);
                } else {
                    a.this.ewH.setVisibility(8);
                }
            }
        });
        this.evZ = (RelativeLayout) groupInfoActivity.findViewById(f.g.lay_group_forum);
        this.evY = (TextView) groupInfoActivity.findViewById(f.g.txt_group_forum);
        this.evZ.setOnClickListener(groupInfoActivity);
        this.ewe = (HeadImageView) groupInfoActivity.findViewById(f.g.img_group_author);
        this.ewe.setAutoChangeStyle(true);
        this.ewe.setIsRound(false);
        this.euL = (TextView) groupInfoActivity.findViewById(f.g.txt_group_author);
        this.ewb = (RelativeLayout) groupInfoActivity.findViewById(f.g.lay_group_author);
        this.ewb.setOnClickListener(groupInfoActivity);
        this.ewi = (ImageView) groupInfoActivity.findViewById(f.g.meizhi_icon);
        this.ewG = groupInfoActivity.findViewById(f.g.line_group_author_down);
        this.ewd = (LinearLayout) groupInfoActivity.findViewById(f.g.lay_group_grade_star);
        this.evZ.setOnClickListener(groupInfoActivity);
        this.ewc = (RelativeLayout) groupInfoActivity.findViewById(f.g.lay_group_grade);
        this.ewc.setOnClickListener(groupInfoActivity);
        this.ewf = (TextView) groupInfoActivity.findViewById(f.g.txt_group_member_count);
        this.ewg = (RelativeLayout) groupInfoActivity.findViewById(f.g.lay_group_member);
        this.ewg.setOnClickListener(groupInfoActivity);
        this.ewm = (LinearLayout) groupInfoActivity.findViewById(f.g.lay_group_member_photo);
        this.ewo = (LinearLayout) groupInfoActivity.findViewById(f.g.bottom_bar);
        this.ewJ = (LinearLayout) groupInfoActivity.findViewById(f.g.lay_bottom_button);
        this.ewp = (TextView) groupInfoActivity.findViewById(f.g.txt_join);
        this.ewJ.setOnClickListener(this.evP);
        this.ewq = (RelativeLayout) groupInfoActivity.findViewById(f.g.lay_group_invite);
        this.ewq.setOnClickListener(groupInfoActivity);
        this.ewr = (LinearLayout) groupInfoActivity.findViewById(f.g.lay_group_notice_share);
        this.ewz = (RelativeLayout) groupInfoActivity.findViewById(f.g.lay_group_name);
        this.ewz.setOnClickListener(groupInfoActivity);
        this.ewA = (TextView) groupInfoActivity.findViewById(f.g.txt_group_name);
        this.ewB = (ImageView) groupInfoActivity.findViewById(f.g.img_group_intro_arrow);
        this.ewF = (ImageView) groupInfoActivity.findViewById(f.g.img_group_author_arrow);
        this.ewC = (RelativeLayout) groupInfoActivity.findViewById(f.g.lay_group_intro);
        this.ewC.setOnClickListener(groupInfoActivity);
        this.ewC.setLongClickable(true);
        this.ewC.setOnLongClickListener(groupInfoActivity);
        this.ewH = (TextView) groupInfoActivity.findViewById(f.g.txt_group_intro_more);
        this.ewH.setClickable(true);
        this.ewH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.evX.setMaxLines(1000);
            }
        });
        this.ewD = (RelativeLayout) groupInfoActivity.findViewById(f.g.lay_group_number);
        this.ewD.setOnLongClickListener(groupInfoActivity);
        this.ewI = (TextView) groupInfoActivity.findViewById(f.g.can_create_mem_group);
        this.evR = (ProgressBar) groupInfoActivity.findViewById(f.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(f.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.ewa = (PhotoWallView) groupInfoActivity.findViewById(f.g.photo_wall);
        this.ewa.setPhotoClickListener(groupInfoActivity);
        this.ewa.setPhotoLongClickListener(groupInfoActivity);
        this.ewa.setVisibility(8);
    }

    public RelativeLayout aLq() {
        return this.ewD;
    }

    public RelativeLayout aLr() {
        return this.evZ;
    }

    public LinearLayout aLs() {
        return this.ewm;
    }

    public RelativeLayout aLt() {
        return this.ewq;
    }

    public RelativeLayout aLu() {
        return this.ewC;
    }

    public RelativeLayout aLv() {
        return this.ewz;
    }

    public RelativeLayout aLw() {
        return this.evS;
    }

    public View aLx() {
        return this.eww;
    }

    public LinearLayout aLy() {
        return this.ewJ;
    }

    public RelativeLayout aLz() {
        return this.ewb;
    }

    public RelativeLayout aLA() {
        return this.ewc;
    }

    public RelativeLayout aLB() {
        return this.ewg;
    }

    public View aKl() {
        return this.ekr;
    }

    public void aLC() {
        this.evR.setVisibility(8);
    }

    public void aLD() {
        this.evR.setVisibility(0);
    }

    public void i(boolean z, String str) {
        if (z) {
            this.evW.setText(str);
            this.ewl.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.ewl.setVisibility(8);
        } else {
            this.evW.setText(str);
            this.ewl.setVisibility(0);
        }
    }

    public void hF(boolean z) {
        if (z) {
            this.evW.setText(this.mContext.getString(f.j.live_card_hide));
        } else {
            this.ewl.setVisibility(8);
        }
    }

    public RelativeLayout aLE() {
        return this.ewl;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dem = aVar.aMp();
            this.ewO = aVar.aMq();
            this.ewM = aVar;
            this.ewN = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aMk() != null) {
                ewP = aVar.aMk().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.ewt.setVisibility(0);
            this.ewo.setVisibility(0);
            if (aVar.getGroup() != null) {
                oz(aVar.getGroup().getName());
                this.evV.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.ewi.setVisibility(0);
                } else {
                    this.ewi.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.ewy.setVisibility(0);
                    this.ewe.setVisibility(8);
                    this.ewF.setVisibility(8);
                    this.ewG.setVisibility(8);
                    this.euL.setText(f.j.group_info_forum_author);
                    this.ewb.setEnabled(false);
                    this.ewi.setVisibility(8);
                } else {
                    this.ewy.setVisibility(8);
                    this.ewe.setVisibility(0);
                    this.ewF.setVisibility(0);
                    this.ewG.setVisibility(0);
                    this.euL.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.ewb.setEnabled(true);
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
                this.ewx = stringBuffer.toString();
                this.evW.setText(this.ewx);
                this.evX.setText(aVar.getGroup().getIntro());
                this.ewf.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.ewe.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.evZ.setVisibility(0);
                    this.evY.setText(aVar.getGroup().getForumName() + this.evP.getPageContext().getString(f.j.forum));
                } else {
                    this.evZ.setVisibility(8);
                }
                this.ewd.removeAllViews();
                boolean aMr = aVar.aMr();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.c(this.ewL, f.d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.evP.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.c(imageView, f.C0146f.icon_vip_grade_big_middle_s);
                        } else {
                            am.c(imageView, f.C0146f.icon_grade_middle_star_s);
                        }
                        this.ewd.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.evP.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.c(imageView2, f.C0146f.icon_vip_grade_big_middle_n);
                    } else {
                        am.c(imageView2, f.C0146f.icon_grade_middle_star_n);
                    }
                    this.ewd.addView(imageView2);
                }
                if (aMr) {
                    this.ewI.setVisibility(0);
                } else {
                    this.ewI.setVisibility(8);
                }
            }
            if (aVar.aMk() != null) {
                this.evS.setVisibility(0);
                this.evQ.setVisibility(0);
                GroupActivityData aMk = aVar.aMk();
                if (!aVar.aMp()) {
                    if (aMk.getIsEnd() != 1) {
                        this.evT.setVisibility(4);
                        this.evU.setText(f.j.group_info_activity_not_join_tip);
                    } else {
                        this.evS.setVisibility(8);
                        this.evQ.setVisibility(8);
                    }
                } else {
                    this.evT.setVisibility(0);
                    this.evU.setText(aMk.getgActivityTitle());
                    if (aMk.getIsEnd() != 1) {
                        this.evT.setText(f.j.group_info_activity_doing);
                        am.c(this.evT, f.d.common_color_10171, 1);
                    } else {
                        this.evT.setText(f.j.group_activity_end);
                        am.c(this.evT, f.d.common_color_10168, 1);
                    }
                    this.evU.setText(aMk.getgActivityTitle());
                }
            } else if (aVar.aMq()) {
                this.evS.setVisibility(0);
                this.evQ.setVisibility(0);
                this.evT.setVisibility(4);
                this.evU.setText(f.j.group_info_create_activity);
            } else {
                this.evS.setVisibility(8);
                this.evQ.setVisibility(8);
            }
            this.ewm.removeAllViews();
            if (aVar.aMl() != null && aVar.aMl().size() > 0) {
                List<MemberData> aMl = aVar.aMl();
                int size = aMl.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aMl.get(i3);
                    HeadImageView headImageView = this.ewn[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.evP.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.ewn[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(f.e.ds10);
                    this.ewm.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aMq()) {
                this.ewl.setEnabled(true);
                this.ewC.setEnabled(true);
                am.i(this.ewC, f.C0146f.group_info_item);
                this.ewz.setVisibility(0);
                this.ewE.setVisibility(0);
                this.ewB.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.ewA.setText(aVar.getGroup().getName());
                }
            } else {
                this.ewl.setEnabled(false);
                this.ewC.setEnabled(true);
                am.j(this.ewC, f.d.cp_bg_line_d);
                this.ewB.setVisibility(8);
                this.ewE.setVisibility(8);
                this.evX.setPadding(0, 0, 0, 0);
            }
            if (aVar.aMp()) {
                this.ewr.setVisibility(0);
                this.ewK.setVisibility(0);
                if (this.ewg.getParent() != this.ewr) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(f.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(f.e.ds18);
                    this.ewt.removeView(this.ewg);
                    this.ewr.addView(this.ewg, 1);
                }
                aLF();
            } else {
                this.ewr.setVisibility(8);
                this.ewK.setVisibility(8);
                if (this.ewg.getParent() != this.ewt) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(f.e.ds28);
                    this.ewr.removeView(this.ewg);
                    this.ewt.addView(this.ewg, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.ewc.setVisibility(8);
            } else {
                this.ewc.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hF(aVar.aMq());
            } else {
                i(aVar.aMq(), this.ewx);
            }
            this.dki.setVisibility(0);
            this.ewo.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (on(aVar.getGroup().getFlag())) {
                hG(z);
            } else {
                aLG();
            }
        }
    }

    public void aLF() {
        this.ewp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.c(this.ewp, f.d.cp_cont_i, 1);
        this.ewp.setText(this.evP.getPageContext().getString(f.j.i_want_talk));
        this.ewJ.setEnabled(true);
    }

    private void hG(boolean z) {
        this.ewp.setText(this.evP.getPageContext().getString(f.j.i_want_attent));
        if (z) {
            this.ewp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.c(this.ewp, f.d.cp_cont_i, 1);
        } else {
            this.ewp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.c(this.ewp, f.d.cp_cont_i, 1);
        }
        am.i(this.ewJ, f.C0146f.btn_blue_bg);
        this.ewJ.setEnabled(true);
    }

    private boolean on(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aLG() {
        this.ewp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ewp.setText(this.evP.getPageContext().getString(f.j.group_info_refuse_join));
        this.ewp.setTextColor(this.evP.getResources().getColorStateList(f.d.cp_cont_i));
        am.i(this.ewJ, f.C0146f.btn_app_download_d);
        this.ewJ.setEnabled(false);
    }

    public void oB(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.ewm.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ewm.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.ewm.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.ewa.setIsManager(aVar.aMq());
            if (aVar.aMq()) {
                this.ewa.setVisibility(0);
                if (aVar.aMm() != null && aVar.aMm().size() == 1 && TextUtils.isEmpty(aVar.aMm().get(0).getPicId())) {
                    this.ewa.setData(null);
                } else {
                    this.ewa.setData(aVar.aMm());
                }
            } else if (aVar.aMm() != null && aVar.aMm().size() > 0) {
                if (aVar.aMm().size() == 1 && TextUtils.isEmpty(aVar.aMm().get(0).getPicId())) {
                    this.ewa.setVisibility(8);
                    return;
                }
                this.ewa.setVisibility(0);
                this.ewa.setData(aVar.aMm());
            } else {
                this.ewa.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.ewv = bVar;
    }

    public void c(Object obj, int i) {
        if (this.ewu != null) {
            this.ewu.dismiss();
            this.ewu = null;
        }
        d(obj, i);
        this.ewu.xh();
    }

    public void aLH() {
        this.ewu.dismiss();
    }

    private void d(final Object obj, final int i) {
        if (this.ewu == null) {
            this.ewu = new com.baidu.tbadk.core.dialog.b(this.evP.getPageContext().getPageActivity());
            this.ewu.dC(this.evP.getResources().getString(f.j.operation));
            this.ewu.a(new String[]{this.evP.getResources().getString(f.j.group_info_set_portrait), this.evP.getResources().getString(f.j.delete), this.evP.getResources().getString(f.j.cancel)}, new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.ewv.a(bVar, i2, obj, i);
                }
            });
        }
        this.ewu.d(this.evP.getPageContext());
    }

    public void onDestory() {
        if (this.ewa != null) {
            this.ewa.onDestory();
        }
        if (this.ewe != null) {
            this.ewe.stopLoad();
            this.ewe.setBackgroundDrawable(null);
            this.ewe.setImageDrawable(null);
        }
        if (this.ewm != null && this.ewn != null) {
            int length = this.ewn.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.ewn[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void oC(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.evP.getPageContext().getString(f.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.evP.getPageContext().getPageActivity());
            bVar.dC(this.evP.getPageContext().getString(f.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.evP.getSystemService("clipboard")).setText(str);
                        a.this.evP.showToast(f.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.evP.getPageContext());
            bVar.xh();
        }
    }

    public void oD(String str) {
        if (this.ews == null) {
            oE(str);
        }
        this.ews.xh();
    }

    private void oE(final String str) {
        if (this.ews == null) {
            this.ews = new com.baidu.tbadk.core.dialog.b(this.evP.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.evP.getPageContext().getString(f.j.copy_group_number)};
            this.ews.dC(this.evP.getPageContext().getString(f.j.operation));
            this.ews.a(charSequenceArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.evP.getSystemService("clipboard")).setText(str);
                        a.this.evP.showToast(f.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.ews.d(this.evP.getPageContext());
        }
    }

    public void aLI() {
        ColorStateList cS = am.cS(f.d.cp_cont_i);
        if (cS != null) {
            this.ewp.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.ewp.setTextColor(cS);
    }

    public void changeSkinType(int i) {
        this.evP.getLayoutMode().setNightMode(i == 1);
        this.evP.getLayoutMode().onModeChanged(this.bmt);
        this.evP.getLayoutMode().onModeChanged(this.ewj);
        this.ewa.a(i, this.evP);
        this.mNavigationBar.onChangeSkinType(this.evP.getPageContext(), i);
        if (this.isMemGroup) {
            am.c(this.ewL, f.d.common_color_10009, 1);
        }
        if (!this.dem) {
            b(this.ewM, this.ewN);
        }
        if (this.ewO) {
            am.i(this.ewC, f.C0146f.group_info_item);
        } else {
            am.j(this.ewC, f.d.cp_bg_line_d);
        }
    }

    public void hH(boolean z) {
        this.dem = z;
    }
}
