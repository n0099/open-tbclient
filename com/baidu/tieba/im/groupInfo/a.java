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
import com.baidu.tieba.d;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    private RelativeLayout bmp;
    private View cYM;
    private boolean deo;
    private ScrollView dkk;
    private View ekv;
    private TextView euP;
    private final GroupInfoActivity evT;
    private View evU;
    private ProgressBar evV;
    private RelativeLayout evW;
    private TextView evX;
    private TextView evY;
    private TextView evZ;
    private TextView ewA;
    private String ewB;
    private ImageView ewC;
    private RelativeLayout ewD;
    private TextView ewE;
    private ImageView ewF;
    private RelativeLayout ewG;
    private RelativeLayout ewH;
    private ImageView ewI;
    private ImageView ewJ;
    private View ewK;
    private TextView ewL;
    private TextView ewM;
    private LinearLayout ewN;
    private View ewO;
    private TextView ewP;
    private ResponseGroupInfoLocalMessage.a ewQ;
    private boolean ewR;
    private boolean ewS;
    private TextView ewa;
    private EllipsizingTextView ewb;
    private TextView ewc;
    private RelativeLayout ewd;
    private PhotoWallView ewe;
    private RelativeLayout ewf;
    private RelativeLayout ewg;
    private LinearLayout ewh;
    private HeadImageView ewi;
    private TextView ewj;
    private RelativeLayout ewk;
    private com.baidu.tbadk.core.dialog.b ewl;
    private ImageView ewm;
    private final View ewn;
    private b.InterfaceC0101b ewo;
    private RelativeLayout ewp;
    private LinearLayout ewq;
    private HeadImageView[] ewr;
    private LinearLayout ews;
    private TextView ewt;
    private RelativeLayout ewu;
    private LinearLayout ewv;
    private com.baidu.tbadk.core.dialog.b eww;
    private LinearLayout ewx;
    private com.baidu.tbadk.core.dialog.b ewy;
    private b ewz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int ewT = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.ewl = null;
        this.ewo = null;
        this.ewr = new HeadImageView[5];
        this.ewB = "";
        this.ewR = true;
        this.isMemGroup = false;
        this.deo = false;
        this.ewS = false;
        this.evT = groupInfoActivity;
        groupInfoActivity.setContentView(d.h.im_group_info_activity);
        this.ewn = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.dkk.setVisibility(4);
        this.ews.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.ewE.setText(str);
        ox(str);
    }

    private void ox(String str) {
        if (str != null) {
            this.ewP.setText(str);
        }
    }

    public void oy(String str) {
        this.ewb.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.ekv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ewP = this.mNavigationBar.setTitleText("");
        this.ewO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.ewA = (TextView) this.ewO.findViewById(d.g.right_textview);
        this.ewA.setText(groupInfoActivity.getPageContext().getString(d.j.setup));
        am.c(this.ewA, d.C0140d.cp_cont_f, 1);
        this.ewA.setOnClickListener(groupInfoActivity);
        this.ewO.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.evU = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.bmp = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.dkk = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.dkk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.cYM = groupInfoActivity.findViewById(d.g.group_top_view);
        this.cYM.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.evW = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.evW.setOnClickListener(groupInfoActivity);
        this.evX = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.evY = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.ewp = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.ewp.setOnClickListener(groupInfoActivity);
        this.ewx = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.ewC = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.evZ = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.ewa = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.ewI = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.ewb = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.ewb.setMaxLines(20);
        this.ewb.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gE(boolean z) {
                if (z) {
                    a.this.ewL.setVisibility(0);
                } else {
                    a.this.ewL.setVisibility(8);
                }
            }
        });
        this.ewd = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.ewc = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.ewd.setOnClickListener(groupInfoActivity);
        this.ewi = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.ewi.setAutoChangeStyle(true);
        this.ewi.setIsRound(false);
        this.euP = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.ewf = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.ewf.setOnClickListener(groupInfoActivity);
        this.ewm = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.ewK = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.ewh = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.ewd.setOnClickListener(groupInfoActivity);
        this.ewg = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.ewg.setOnClickListener(groupInfoActivity);
        this.ewj = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.ewk = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.ewk.setOnClickListener(groupInfoActivity);
        this.ewq = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.ews = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.ewN = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.ewt = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.ewN.setOnClickListener(this.evT);
        this.ewu = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.ewu.setOnClickListener(groupInfoActivity);
        this.ewv = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.ewD = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.ewD.setOnClickListener(groupInfoActivity);
        this.ewE = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.ewF = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.ewJ = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.ewG = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.ewG.setOnClickListener(groupInfoActivity);
        this.ewG.setLongClickable(true);
        this.ewG.setOnLongClickListener(groupInfoActivity);
        this.ewL = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.ewL.setClickable(true);
        this.ewL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ewb.setMaxLines(1000);
            }
        });
        this.ewH = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.ewH.setOnLongClickListener(groupInfoActivity);
        this.ewM = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.evV = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.ewe = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.ewe.setPhotoClickListener(groupInfoActivity);
        this.ewe.setPhotoLongClickListener(groupInfoActivity);
        this.ewe.setVisibility(8);
    }

    public RelativeLayout aLt() {
        return this.ewH;
    }

    public RelativeLayout aLu() {
        return this.ewd;
    }

    public LinearLayout aLv() {
        return this.ewq;
    }

    public RelativeLayout aLw() {
        return this.ewu;
    }

    public RelativeLayout aLx() {
        return this.ewG;
    }

    public RelativeLayout aLy() {
        return this.ewD;
    }

    public RelativeLayout aLz() {
        return this.evW;
    }

    public View aLA() {
        return this.ewA;
    }

    public LinearLayout aLB() {
        return this.ewN;
    }

    public RelativeLayout aLC() {
        return this.ewf;
    }

    public RelativeLayout aLD() {
        return this.ewg;
    }

    public RelativeLayout aLE() {
        return this.ewk;
    }

    public View aKo() {
        return this.ekv;
    }

    public void aLF() {
        this.evV.setVisibility(8);
    }

    public void aLG() {
        this.evV.setVisibility(0);
    }

    public void j(boolean z, String str) {
        if (z) {
            this.ewa.setText(str);
            this.ewp.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.ewp.setVisibility(8);
        } else {
            this.ewa.setText(str);
            this.ewp.setVisibility(0);
        }
    }

    public void hF(boolean z) {
        if (z) {
            this.ewa.setText(this.mContext.getString(d.j.live_card_hide));
        } else {
            this.ewp.setVisibility(8);
        }
    }

    public RelativeLayout aLH() {
        return this.ewp;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.deo = aVar.aMs();
            this.ewS = aVar.aMt();
            this.ewQ = aVar;
            this.ewR = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aMn() != null) {
                ewT = aVar.aMn().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.ewx.setVisibility(0);
            this.ews.setVisibility(0);
            if (aVar.getGroup() != null) {
                ox(aVar.getGroup().getName());
                this.evZ.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.ewm.setVisibility(0);
                } else {
                    this.ewm.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.ewC.setVisibility(0);
                    this.ewi.setVisibility(8);
                    this.ewJ.setVisibility(8);
                    this.ewK.setVisibility(8);
                    this.euP.setText(d.j.group_info_forum_author);
                    this.ewf.setEnabled(false);
                    this.ewm.setVisibility(8);
                } else {
                    this.ewC.setVisibility(8);
                    this.ewi.setVisibility(0);
                    this.ewJ.setVisibility(0);
                    this.ewK.setVisibility(0);
                    this.euP.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.ewf.setEnabled(true);
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
                this.ewB = stringBuffer.toString();
                this.ewa.setText(this.ewB);
                this.ewb.setText(aVar.getGroup().getIntro());
                this.ewj.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.ewi.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.ewd.setVisibility(0);
                    this.ewc.setText(aVar.getGroup().getForumName() + this.evT.getPageContext().getString(d.j.forum));
                } else {
                    this.ewd.setVisibility(8);
                }
                this.ewh.removeAllViews();
                boolean aMu = aVar.aMu();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.c(this.ewP, d.C0140d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.evT.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            am.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.ewh.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.evT.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        am.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.ewh.addView(imageView2);
                }
                if (aMu) {
                    this.ewM.setVisibility(0);
                } else {
                    this.ewM.setVisibility(8);
                }
            }
            if (aVar.aMn() != null) {
                this.evW.setVisibility(0);
                this.evU.setVisibility(0);
                GroupActivityData aMn = aVar.aMn();
                if (!aVar.aMs()) {
                    if (aMn.getIsEnd() != 1) {
                        this.evX.setVisibility(4);
                        this.evY.setText(d.j.group_info_activity_not_join_tip);
                    } else {
                        this.evW.setVisibility(8);
                        this.evU.setVisibility(8);
                    }
                } else {
                    this.evX.setVisibility(0);
                    this.evY.setText(aMn.getgActivityTitle());
                    if (aMn.getIsEnd() != 1) {
                        this.evX.setText(d.j.group_info_activity_doing);
                        am.c(this.evX, d.C0140d.common_color_10171, 1);
                    } else {
                        this.evX.setText(d.j.group_activity_end);
                        am.c(this.evX, d.C0140d.common_color_10168, 1);
                    }
                    this.evY.setText(aMn.getgActivityTitle());
                }
            } else if (aVar.aMt()) {
                this.evW.setVisibility(0);
                this.evU.setVisibility(0);
                this.evX.setVisibility(4);
                this.evY.setText(d.j.group_info_create_activity);
            } else {
                this.evW.setVisibility(8);
                this.evU.setVisibility(8);
            }
            this.ewq.removeAllViews();
            if (aVar.aMo() != null && aVar.aMo().size() > 0) {
                List<MemberData> aMo = aVar.aMo();
                int size = aMo.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aMo.get(i3);
                    HeadImageView headImageView = this.ewr[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.evT.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.ewr[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.ewq.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aMt()) {
                this.ewp.setEnabled(true);
                this.ewG.setEnabled(true);
                am.i(this.ewG, d.f.group_info_item);
                this.ewD.setVisibility(0);
                this.ewI.setVisibility(0);
                this.ewF.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.ewE.setText(aVar.getGroup().getName());
                }
            } else {
                this.ewp.setEnabled(false);
                this.ewG.setEnabled(true);
                am.j(this.ewG, d.C0140d.cp_bg_line_d);
                this.ewF.setVisibility(8);
                this.ewI.setVisibility(8);
                this.ewb.setPadding(0, 0, 0, 0);
            }
            if (aVar.aMs()) {
                this.ewv.setVisibility(0);
                this.ewO.setVisibility(0);
                if (this.ewk.getParent() != this.ewv) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.ewx.removeView(this.ewk);
                    this.ewv.addView(this.ewk, 1);
                }
                aLI();
            } else {
                this.ewv.setVisibility(8);
                this.ewO.setVisibility(8);
                if (this.ewk.getParent() != this.ewx) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.ewv.removeView(this.ewk);
                    this.ewx.addView(this.ewk, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.ewg.setVisibility(8);
            } else {
                this.ewg.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hF(aVar.aMt());
            } else {
                j(aVar.aMt(), this.ewB);
            }
            this.dkk.setVisibility(0);
            this.ews.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (on(aVar.getGroup().getFlag())) {
                hG(z);
            } else {
                aLJ();
            }
        }
    }

    public void aLI() {
        this.ewt.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.c(this.ewt, d.C0140d.cp_cont_i, 1);
        this.ewt.setText(this.evT.getPageContext().getString(d.j.i_want_talk));
        this.ewN.setEnabled(true);
    }

    private void hG(boolean z) {
        this.ewt.setText(this.evT.getPageContext().getString(d.j.i_want_attent));
        if (z) {
            this.ewt.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.c(this.ewt, d.C0140d.cp_cont_i, 1);
        } else {
            this.ewt.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.c(this.ewt, d.C0140d.cp_cont_i, 1);
        }
        am.i(this.ewN, d.f.btn_blue_bg);
        this.ewN.setEnabled(true);
    }

    private boolean on(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aLJ() {
        this.ewt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ewt.setText(this.evT.getPageContext().getString(d.j.group_info_refuse_join));
        this.ewt.setTextColor(this.evT.getResources().getColorStateList(d.C0140d.cp_cont_i));
        am.i(this.ewN, d.f.btn_app_download_d);
        this.ewN.setEnabled(false);
    }

    public void oz(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.ewq.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ewq.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.ewq.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.ewe.setIsManager(aVar.aMt());
            if (aVar.aMt()) {
                this.ewe.setVisibility(0);
                if (aVar.aMp() != null && aVar.aMp().size() == 1 && TextUtils.isEmpty(aVar.aMp().get(0).getPicId())) {
                    this.ewe.setData(null);
                } else {
                    this.ewe.setData(aVar.aMp());
                }
            } else if (aVar.aMp() != null && aVar.aMp().size() > 0) {
                if (aVar.aMp().size() == 1 && TextUtils.isEmpty(aVar.aMp().get(0).getPicId())) {
                    this.ewe.setVisibility(8);
                    return;
                }
                this.ewe.setVisibility(0);
                this.ewe.setData(aVar.aMp());
            } else {
                this.ewe.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.ewz = bVar;
    }

    public void c(Object obj, int i) {
        if (this.ewy != null) {
            this.ewy.dismiss();
            this.ewy = null;
        }
        d(obj, i);
        this.ewy.xi();
    }

    public void aLK() {
        this.ewy.dismiss();
    }

    private void d(final Object obj, final int i) {
        if (this.ewy == null) {
            this.ewy = new com.baidu.tbadk.core.dialog.b(this.evT.getPageContext().getPageActivity());
            this.ewy.dC(this.evT.getResources().getString(d.j.operation));
            this.ewy.a(new String[]{this.evT.getResources().getString(d.j.group_info_set_portrait), this.evT.getResources().getString(d.j.delete), this.evT.getResources().getString(d.j.cancel)}, new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.ewz.a(bVar, i2, obj, i);
                }
            });
        }
        this.ewy.d(this.evT.getPageContext());
    }

    public void onDestory() {
        if (this.ewe != null) {
            this.ewe.onDestory();
        }
        if (this.ewi != null) {
            this.ewi.stopLoad();
            this.ewi.setBackgroundDrawable(null);
            this.ewi.setImageDrawable(null);
        }
        if (this.ewq != null && this.ewr != null) {
            int length = this.ewr.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.ewr[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void oA(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.evT.getPageContext().getString(d.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.evT.getPageContext().getPageActivity());
            bVar.dC(this.evT.getPageContext().getString(d.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.evT.getSystemService("clipboard")).setText(str);
                        a.this.evT.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.evT.getPageContext());
            bVar.xi();
        }
    }

    public void oB(String str) {
        if (this.eww == null) {
            oC(str);
        }
        this.eww.xi();
    }

    private void oC(final String str) {
        if (this.eww == null) {
            this.eww = new com.baidu.tbadk.core.dialog.b(this.evT.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.evT.getPageContext().getString(d.j.copy_group_number)};
            this.eww.dC(this.evT.getPageContext().getString(d.j.operation));
            this.eww.a(charSequenceArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.evT.getSystemService("clipboard")).setText(str);
                        a.this.evT.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eww.d(this.evT.getPageContext());
        }
    }

    public void aLL() {
        ColorStateList cS = am.cS(d.C0140d.cp_cont_i);
        if (cS != null) {
            this.ewt.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.ewt.setTextColor(cS);
    }

    public void changeSkinType(int i) {
        this.evT.getLayoutMode().setNightMode(i == 1);
        this.evT.getLayoutMode().onModeChanged(this.bmp);
        this.evT.getLayoutMode().onModeChanged(this.ewn);
        this.ewe.a(i, this.evT);
        this.mNavigationBar.onChangeSkinType(this.evT.getPageContext(), i);
        if (this.isMemGroup) {
            am.c(this.ewP, d.C0140d.common_color_10009, 1);
        }
        if (!this.deo) {
            b(this.ewQ, this.ewR);
        }
        if (this.ewS) {
            am.i(this.ewG, d.f.group_info_item);
        } else {
            am.j(this.ewG, d.C0140d.cp_bg_line_d);
        }
    }

    public void hH(boolean z) {
        this.deo = z;
    }
}
