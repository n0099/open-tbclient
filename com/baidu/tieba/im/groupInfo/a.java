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
import com.baidu.tieba.d;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    private RelativeLayout bkk;
    private View cXU;
    private ScrollView dfE;
    private View ecL;
    private TextView enb;
    private ImageView eoA;
    private final View eoB;
    private b.InterfaceC0103b eoC;
    private RelativeLayout eoD;
    private LinearLayout eoE;
    private HeadImageView[] eoF;
    private LinearLayout eoG;
    private TextView eoH;
    private RelativeLayout eoI;
    private LinearLayout eoJ;
    private com.baidu.tbadk.core.dialog.b eoK;
    private LinearLayout eoL;
    private com.baidu.tbadk.core.dialog.b eoM;
    private b eoN;
    private TextView eoO;
    private String eoP;
    private ImageView eoQ;
    private RelativeLayout eoR;
    private TextView eoS;
    private ImageView eoT;
    private RelativeLayout eoU;
    private RelativeLayout eoV;
    private ImageView eoW;
    private ImageView eoX;
    private View eoY;
    private TextView eoZ;
    private final GroupInfoActivity eoh;
    private View eoi;
    private ProgressBar eoj;
    private RelativeLayout eok;
    private TextView eol;
    private TextView eom;
    private TextView eon;
    private TextView eoo;
    private EllipsizingTextView eop;
    private TextView eoq;
    private RelativeLayout eor;
    private PhotoWallView eos;
    private RelativeLayout eot;
    private RelativeLayout eou;
    private LinearLayout eov;
    private HeadImageView eow;
    private TextView eox;
    private RelativeLayout eoy;
    private com.baidu.tbadk.core.dialog.b eoz;
    private TextView epa;
    private LinearLayout epb;
    private View epc;
    private TextView epd;
    private ResponseGroupInfoLocalMessage.a epe;
    private boolean epf;
    private boolean epg;
    private boolean eph;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int epi = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eoz = null;
        this.eoC = null;
        this.eoF = new HeadImageView[5];
        this.eoP = "";
        this.epf = true;
        this.isMemGroup = false;
        this.epg = false;
        this.eph = false;
        this.eoh = groupInfoActivity;
        groupInfoActivity.setContentView(d.i.im_group_info_activity);
        this.eoB = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.i.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.dfE.setVisibility(4);
        this.eoG.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eoS.setText(str);
        ou(str);
    }

    private void ou(String str) {
        if (str != null) {
            this.epd.setText(str);
        }
    }

    public void ov(String str) {
        this.eop.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.ecL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.epd = this.mNavigationBar.setTitleText("");
        this.epc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.eoO = (TextView) this.epc.findViewById(d.g.right_textview);
        this.eoO.setText(groupInfoActivity.getPageContext().getString(d.k.setup));
        al.c(this.eoO, d.C0141d.cp_cont_f, 1);
        this.eoO.setOnClickListener(groupInfoActivity);
        this.epc.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eoi = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.bkk = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.dfE = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.dfE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.cXU = groupInfoActivity.findViewById(d.g.group_top_view);
        this.cXU.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eok = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.eok.setOnClickListener(groupInfoActivity);
        this.eol = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.eom = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.eoD = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.eoD.setOnClickListener(groupInfoActivity);
        this.eoL = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.eoQ = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.eon = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.eoo = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.eoW = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.eop = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.eop.setMaxLines(20);
        this.eop.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gs(boolean z) {
                if (z) {
                    a.this.eoZ.setVisibility(0);
                } else {
                    a.this.eoZ.setVisibility(8);
                }
            }
        });
        this.eor = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.eoq = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.eor.setOnClickListener(groupInfoActivity);
        this.eow = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.eow.setAutoChangeStyle(true);
        this.eow.setIsRound(false);
        this.enb = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.eot = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.eot.setOnClickListener(groupInfoActivity);
        this.eoA = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.eoY = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.eov = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.eor.setOnClickListener(groupInfoActivity);
        this.eou = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.eou.setOnClickListener(groupInfoActivity);
        this.eox = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.eoy = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.eoy.setOnClickListener(groupInfoActivity);
        this.eoE = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.eoG = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.epb = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.eoH = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.epb.setOnClickListener(this.eoh);
        this.eoI = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.eoI.setOnClickListener(groupInfoActivity);
        this.eoJ = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.eoR = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.eoR.setOnClickListener(groupInfoActivity);
        this.eoS = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.eoT = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.eoX = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.eoU = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.eoU.setOnClickListener(groupInfoActivity);
        this.eoU.setLongClickable(true);
        this.eoU.setOnLongClickListener(groupInfoActivity);
        this.eoZ = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.eoZ.setClickable(true);
        this.eoZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eop.setMaxLines(1000);
            }
        });
        this.eoV = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.eoV.setOnLongClickListener(groupInfoActivity);
        this.epa = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.eoj = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eos = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.eos.setPhotoClickListener(groupInfoActivity);
        this.eos.setPhotoLongClickListener(groupInfoActivity);
        this.eos.setVisibility(8);
    }

    public RelativeLayout aJL() {
        return this.eoV;
    }

    public RelativeLayout aJM() {
        return this.eor;
    }

    public LinearLayout aJN() {
        return this.eoE;
    }

    public RelativeLayout aJO() {
        return this.eoI;
    }

    public RelativeLayout aJP() {
        return this.eoU;
    }

    public RelativeLayout aJQ() {
        return this.eoR;
    }

    public RelativeLayout aJR() {
        return this.eok;
    }

    public View aJS() {
        return this.eoO;
    }

    public LinearLayout aJT() {
        return this.epb;
    }

    public RelativeLayout aJU() {
        return this.eot;
    }

    public RelativeLayout aJV() {
        return this.eou;
    }

    public RelativeLayout aJW() {
        return this.eoy;
    }

    public View aIG() {
        return this.ecL;
    }

    public void aJX() {
        this.eoj.setVisibility(8);
    }

    public void aJY() {
        this.eoj.setVisibility(0);
    }

    public void j(boolean z, String str) {
        if (z) {
            this.eoo.setText(str);
            this.eoD.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eoD.setVisibility(8);
        } else {
            this.eoo.setText(str);
            this.eoD.setVisibility(0);
        }
    }

    public void hs(boolean z) {
        if (z) {
            this.eoo.setText(this.mContext.getString(d.k.live_card_hide));
        } else {
            this.eoD.setVisibility(8);
        }
    }

    public RelativeLayout aJZ() {
        return this.eoD;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.epg = aVar.aKL();
            this.eph = aVar.aKM();
            this.epe = aVar;
            this.epf = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aKG() != null) {
                epi = aVar.aKG().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eoL.setVisibility(0);
            this.eoG.setVisibility(0);
            if (aVar.getGroup() != null) {
                ou(aVar.getGroup().getName());
                this.eon.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eoA.setVisibility(0);
                } else {
                    this.eoA.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eoQ.setVisibility(0);
                    this.eow.setVisibility(8);
                    this.eoX.setVisibility(8);
                    this.eoY.setVisibility(8);
                    this.enb.setText(d.k.group_info_forum_author);
                    this.eot.setEnabled(false);
                    this.eoA.setVisibility(8);
                } else {
                    this.eoQ.setVisibility(8);
                    this.eow.setVisibility(0);
                    this.eoX.setVisibility(0);
                    this.eoY.setVisibility(0);
                    this.enb.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.eot.setEnabled(true);
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
                this.eoP = stringBuffer.toString();
                this.eoo.setText(this.eoP);
                this.eop.setText(aVar.getGroup().getIntro());
                this.eox.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eow.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eor.setVisibility(0);
                    this.eoq.setText(aVar.getGroup().getForumName() + this.eoh.getPageContext().getString(d.k.forum));
                } else {
                    this.eor.setVisibility(8);
                }
                this.eov.removeAllViews();
                boolean aKN = aVar.aKN();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.c(this.epd, d.C0141d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eoh.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.eov.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eoh.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.eov.addView(imageView2);
                }
                if (aKN) {
                    this.epa.setVisibility(0);
                } else {
                    this.epa.setVisibility(8);
                }
            }
            if (aVar.aKG() != null) {
                this.eok.setVisibility(0);
                this.eoi.setVisibility(0);
                GroupActivityData aKG = aVar.aKG();
                if (!aVar.aKL()) {
                    if (aKG.getIsEnd() != 1) {
                        this.eol.setVisibility(4);
                        this.eom.setText(d.k.group_info_activity_not_join_tip);
                    } else {
                        this.eok.setVisibility(8);
                        this.eoi.setVisibility(8);
                    }
                } else {
                    this.eol.setVisibility(0);
                    this.eom.setText(aKG.getgActivityTitle());
                    if (aKG.getIsEnd() != 1) {
                        this.eol.setText(d.k.group_info_activity_doing);
                        al.c(this.eol, d.C0141d.common_color_10171, 1);
                    } else {
                        this.eol.setText(d.k.group_activity_end);
                        al.c(this.eol, d.C0141d.common_color_10168, 1);
                    }
                    this.eom.setText(aKG.getgActivityTitle());
                }
            } else if (aVar.aKM()) {
                this.eok.setVisibility(0);
                this.eoi.setVisibility(0);
                this.eol.setVisibility(4);
                this.eom.setText(d.k.group_info_create_activity);
            } else {
                this.eok.setVisibility(8);
                this.eoi.setVisibility(8);
            }
            this.eoE.removeAllViews();
            if (aVar.aKH() != null && aVar.aKH().size() > 0) {
                List<MemberData> aKH = aVar.aKH();
                int size = aKH.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aKH.get(i3);
                    HeadImageView headImageView = this.eoF[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eoh.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eoF[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.eoE.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aKM()) {
                this.eoD.setEnabled(true);
                this.eoU.setEnabled(true);
                al.i(this.eoU, d.f.group_info_item);
                this.eoR.setVisibility(0);
                this.eoW.setVisibility(0);
                this.eoT.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eoS.setText(aVar.getGroup().getName());
                }
            } else {
                this.eoD.setEnabled(false);
                this.eoU.setEnabled(true);
                al.j(this.eoU, d.C0141d.cp_bg_line_d);
                this.eoT.setVisibility(8);
                this.eoW.setVisibility(8);
                this.eop.setPadding(0, 0, 0, 0);
            }
            if (aVar.aKL()) {
                this.eoJ.setVisibility(0);
                this.epc.setVisibility(0);
                if (this.eoy.getParent() != this.eoJ) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.eoL.removeView(this.eoy);
                    this.eoJ.addView(this.eoy, 1);
                }
                aKa();
            } else {
                this.eoJ.setVisibility(8);
                this.epc.setVisibility(8);
                if (this.eoy.getParent() != this.eoL) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.eoJ.removeView(this.eoy);
                    this.eoL.addView(this.eoy, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eou.setVisibility(8);
            } else {
                this.eou.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hs(aVar.aKM());
            } else {
                j(aVar.aKM(), this.eoP);
            }
            this.dfE.setVisibility(0);
            this.eoG.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (nS(aVar.getGroup().getFlag())) {
                ht(z);
            } else {
                aKb();
            }
        }
    }

    public void aKa() {
        this.eoH.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eoH, d.C0141d.cp_cont_i, 1);
        this.eoH.setText(this.eoh.getPageContext().getString(d.k.i_want_talk));
        this.epb.setEnabled(true);
    }

    private void ht(boolean z) {
        this.eoH.setText(this.eoh.getPageContext().getString(d.k.i_want_attent));
        if (z) {
            this.eoH.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eoH, d.C0141d.cp_cont_i, 1);
        } else {
            this.eoH.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eoH, d.C0141d.cp_cont_i, 1);
        }
        al.i(this.epb, d.f.btn_blue_bg);
        this.epb.setEnabled(true);
    }

    private boolean nS(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aKb() {
        this.eoH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eoH.setText(this.eoh.getPageContext().getString(d.k.group_info_refuse_join));
        this.eoH.setTextColor(this.eoh.getResources().getColorStateList(d.C0141d.cp_cont_i));
        al.i(this.epb, d.f.btn_app_download_d);
        this.epb.setEnabled(false);
    }

    public void ow(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eoE.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eoE.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eoE.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eos.setIsManager(aVar.aKM());
            if (aVar.aKM()) {
                this.eos.setVisibility(0);
                if (aVar.aKI() != null && aVar.aKI().size() == 1 && TextUtils.isEmpty(aVar.aKI().get(0).getPicId())) {
                    this.eos.setData(null);
                } else {
                    this.eos.setData(aVar.aKI());
                }
            } else if (aVar.aKI() != null && aVar.aKI().size() > 0) {
                if (aVar.aKI().size() == 1 && TextUtils.isEmpty(aVar.aKI().get(0).getPicId())) {
                    this.eos.setVisibility(8);
                    return;
                }
                this.eos.setVisibility(0);
                this.eos.setData(aVar.aKI());
            } else {
                this.eos.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eoN = bVar;
    }

    public void d(Object obj, int i) {
        if (this.eoM != null) {
            this.eoM.dismiss();
            this.eoM = null;
        }
        e(obj, i);
        this.eoM.xd();
    }

    public void aKc() {
        this.eoM.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.eoM == null) {
            this.eoM = new com.baidu.tbadk.core.dialog.b(this.eoh.getPageContext().getPageActivity());
            this.eoM.dC(this.eoh.getResources().getString(d.k.operation));
            this.eoM.a(new String[]{this.eoh.getResources().getString(d.k.group_info_set_portrait), this.eoh.getResources().getString(d.k.delete), this.eoh.getResources().getString(d.k.cancel)}, new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eoN.a(bVar, i2, obj, i);
                }
            });
        }
        this.eoM.d(this.eoh.getPageContext());
    }

    public void onDestory() {
        if (this.eos != null) {
            this.eos.onDestory();
        }
        if (this.eow != null) {
            this.eow.stopLoad();
            this.eow.setBackgroundDrawable(null);
            this.eow.setImageDrawable(null);
        }
        if (this.eoE != null && this.eoF != null) {
            int length = this.eoF.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eoF[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void ox(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.eoh.getPageContext().getString(d.k.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eoh.getPageContext().getPageActivity());
            bVar.dC(this.eoh.getPageContext().getString(d.k.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eoh.getSystemService("clipboard")).setText(str);
                        a.this.eoh.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eoh.getPageContext());
            bVar.xd();
        }
    }

    public void oy(String str) {
        if (this.eoK == null) {
            oz(str);
        }
        this.eoK.xd();
    }

    private void oz(final String str) {
        if (this.eoK == null) {
            this.eoK = new com.baidu.tbadk.core.dialog.b(this.eoh.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eoh.getPageContext().getString(d.k.copy_group_number)};
            this.eoK.dC(this.eoh.getPageContext().getString(d.k.operation));
            this.eoK.a(charSequenceArr, new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eoh.getSystemService("clipboard")).setText(str);
                        a.this.eoh.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eoK.d(this.eoh.getPageContext());
        }
    }

    public void aKd() {
        ColorStateList cP = al.cP(d.C0141d.cp_cont_i);
        if (cP != null) {
            this.eoH.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eoH.setTextColor(cP);
    }

    public void changeSkinType(int i) {
        this.eoh.getLayoutMode().setNightMode(i == 1);
        this.eoh.getLayoutMode().onModeChanged(this.bkk);
        this.eoh.getLayoutMode().onModeChanged(this.eoB);
        this.eos.a(i, this.eoh);
        this.mNavigationBar.onChangeSkinType(this.eoh.getPageContext(), i);
        if (this.isMemGroup) {
            al.c(this.epd, d.C0141d.common_color_10009, 1);
        }
        if (!this.epg) {
            b(this.epe, this.epf);
        }
        if (this.eph) {
            al.i(this.eoU, d.f.group_info_item);
        } else {
            al.j(this.eoU, d.C0141d.cp_bg_line_d);
        }
    }

    public void hu(boolean z) {
        this.epg = z;
    }
}
