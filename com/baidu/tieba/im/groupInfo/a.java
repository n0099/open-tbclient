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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.ak;
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
    private RelativeLayout bbZ;
    private View cOP;
    private ScrollView cWr;
    private View dRy;
    private TextView ebO;
    private final GroupInfoActivity ecS;
    private View ecT;
    private ProgressBar ecU;
    private RelativeLayout ecV;
    private TextView ecW;
    private TextView ecX;
    private TextView ecY;
    private TextView ecZ;
    private String edA;
    private ImageView edB;
    private RelativeLayout edC;
    private TextView edD;
    private ImageView edE;
    private RelativeLayout edF;
    private RelativeLayout edG;
    private ImageView edH;
    private ImageView edI;
    private View edJ;
    private TextView edK;
    private TextView edL;
    private LinearLayout edM;
    private View edN;
    private TextView edO;
    private ResponseGroupInfoLocalMessage.a edP;
    private boolean edQ;
    private boolean edR;
    private boolean edS;
    private EllipsizingTextView eda;
    private TextView edb;
    private RelativeLayout edc;
    private PhotoWallView edd;
    private RelativeLayout ede;
    private RelativeLayout edf;
    private LinearLayout edg;
    private HeadImageView edh;
    private TextView edi;
    private RelativeLayout edj;
    private com.baidu.tbadk.core.dialog.b edk;
    private ImageView edl;
    private final View edm;
    private b.InterfaceC0086b edn;
    private RelativeLayout edo;
    private LinearLayout edp;
    private HeadImageView[] edq;
    private LinearLayout edr;
    private TextView eds;
    private RelativeLayout edt;
    private LinearLayout edu;
    private com.baidu.tbadk.core.dialog.b edv;
    private LinearLayout edw;
    private com.baidu.tbadk.core.dialog.b edx;
    private b edy;
    private TextView edz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int edT = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.edk = null;
        this.edn = null;
        this.edq = new HeadImageView[5];
        this.edA = "";
        this.edQ = true;
        this.isMemGroup = false;
        this.edR = false;
        this.edS = false;
        this.ecS = groupInfoActivity;
        groupInfoActivity.setContentView(d.i.im_group_info_activity);
        this.edm = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.i.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cWr.setVisibility(4);
        this.edr.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.edD.setText(str);
        nG(str);
    }

    private void nG(String str) {
        if (str != null) {
            this.edO.setText(str);
        }
    }

    public void nH(String str) {
        this.eda.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.dRy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.edO = this.mNavigationBar.setTitleText("");
        this.edN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.edz = (TextView) this.edN.findViewById(d.g.right_textview);
        this.edz.setText(groupInfoActivity.getPageContext().getString(d.k.setup));
        ak.c(this.edz, d.C0126d.cp_cont_f, 1);
        this.edz.setOnClickListener(groupInfoActivity);
        this.edN.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.ecT = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.bbZ = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.cWr = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.cWr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
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
        this.cOP = groupInfoActivity.findViewById(d.g.group_top_view);
        this.cOP.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ecV = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.ecV.setOnClickListener(groupInfoActivity);
        this.ecW = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.ecX = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.edo = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.edo.setOnClickListener(groupInfoActivity);
        this.edw = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.edB = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.ecY = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.ecZ = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.edH = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.eda = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.eda.setMaxLines(20);
        this.eda.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gm(boolean z) {
                if (z) {
                    a.this.edK.setVisibility(0);
                } else {
                    a.this.edK.setVisibility(8);
                }
            }
        });
        this.edc = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.edb = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.edc.setOnClickListener(groupInfoActivity);
        this.edh = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.edh.setAutoChangeStyle(true);
        this.edh.setIsRound(false);
        this.ebO = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.ede = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.ede.setOnClickListener(groupInfoActivity);
        this.edl = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.edJ = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.edg = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.edc.setOnClickListener(groupInfoActivity);
        this.edf = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.edf.setOnClickListener(groupInfoActivity);
        this.edi = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.edj = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.edj.setOnClickListener(groupInfoActivity);
        this.edp = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.edr = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.edM = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.eds = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.edM.setOnClickListener(this.ecS);
        this.edt = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.edt.setOnClickListener(groupInfoActivity);
        this.edu = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.edC = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.edC.setOnClickListener(groupInfoActivity);
        this.edD = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.edE = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.edI = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.edF = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.edF.setOnClickListener(groupInfoActivity);
        this.edF.setLongClickable(true);
        this.edF.setOnLongClickListener(groupInfoActivity);
        this.edK = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.edK.setClickable(true);
        this.edK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.eda.setMaxLines(1000);
            }
        });
        this.edG = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.edG.setOnLongClickListener(groupInfoActivity);
        this.edL = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.ecU = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.edd = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.edd.setPhotoClickListener(groupInfoActivity);
        this.edd.setPhotoLongClickListener(groupInfoActivity);
        this.edd.setVisibility(8);
    }

    public RelativeLayout aEQ() {
        return this.edG;
    }

    public RelativeLayout aER() {
        return this.edc;
    }

    public LinearLayout aES() {
        return this.edp;
    }

    public RelativeLayout aET() {
        return this.edt;
    }

    public RelativeLayout aEU() {
        return this.edF;
    }

    public RelativeLayout aEV() {
        return this.edC;
    }

    public RelativeLayout aEW() {
        return this.ecV;
    }

    public View aEX() {
        return this.edz;
    }

    public LinearLayout aEY() {
        return this.edM;
    }

    public RelativeLayout aEZ() {
        return this.ede;
    }

    public RelativeLayout aFa() {
        return this.edf;
    }

    public RelativeLayout aFb() {
        return this.edj;
    }

    public View aDL() {
        return this.dRy;
    }

    public void aFc() {
        this.ecU.setVisibility(8);
    }

    public void aFd() {
        this.ecU.setVisibility(0);
    }

    public void i(boolean z, String str) {
        if (z) {
            this.ecZ.setText(str);
            this.edo.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.edo.setVisibility(8);
        } else {
            this.ecZ.setText(str);
            this.edo.setVisibility(0);
        }
    }

    public void hm(boolean z) {
        if (z) {
            this.ecZ.setText(this.mContext.getString(d.k.live_card_hide));
        } else {
            this.edo.setVisibility(8);
        }
    }

    public RelativeLayout aFe() {
        return this.edo;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.edR = aVar.aFQ();
            this.edS = aVar.aFR();
            this.edP = aVar;
            this.edQ = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aFL() != null) {
                edT = aVar.aFL().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.edw.setVisibility(0);
            this.edr.setVisibility(0);
            if (aVar.getGroup() != null) {
                nG(aVar.getGroup().getName());
                this.ecY.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.edl.setVisibility(0);
                } else {
                    this.edl.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.edB.setVisibility(0);
                    this.edh.setVisibility(8);
                    this.edI.setVisibility(8);
                    this.edJ.setVisibility(8);
                    this.ebO.setText(d.k.group_info_forum_author);
                    this.ede.setEnabled(false);
                    this.edl.setVisibility(8);
                } else {
                    this.edB.setVisibility(8);
                    this.edh.setVisibility(0);
                    this.edI.setVisibility(0);
                    this.edJ.setVisibility(0);
                    this.ebO.setText(aVar.getGroup().getAuthorName());
                    this.ede.setEnabled(true);
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
                this.edA = stringBuffer.toString();
                this.ecZ.setText(this.edA);
                this.eda.setText(aVar.getGroup().getIntro());
                this.edi.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.edh.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.edc.setVisibility(0);
                    this.edb.setText(aVar.getGroup().getForumName() + this.ecS.getPageContext().getString(d.k.forum));
                } else {
                    this.edc.setVisibility(8);
                }
                this.edg.removeAllViews();
                boolean aFS = aVar.aFS();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ak.c(this.edO, d.C0126d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.ecS.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ak.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            ak.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.edg.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.ecS.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ak.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        ak.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.edg.addView(imageView2);
                }
                if (aFS) {
                    this.edL.setVisibility(0);
                } else {
                    this.edL.setVisibility(8);
                }
            }
            if (aVar.aFL() != null) {
                this.ecV.setVisibility(0);
                this.ecT.setVisibility(0);
                GroupActivityData aFL = aVar.aFL();
                if (!aVar.aFQ()) {
                    if (aFL.getIsEnd() != 1) {
                        this.ecW.setVisibility(4);
                        this.ecX.setText(d.k.group_info_activity_not_join_tip);
                    } else {
                        this.ecV.setVisibility(8);
                        this.ecT.setVisibility(8);
                    }
                } else {
                    this.ecW.setVisibility(0);
                    this.ecX.setText(aFL.getgActivityTitle());
                    if (aFL.getIsEnd() != 1) {
                        this.ecW.setText(d.k.group_info_activity_doing);
                        ak.c(this.ecW, d.C0126d.common_color_10171, 1);
                    } else {
                        this.ecW.setText(d.k.group_activity_end);
                        ak.c(this.ecW, d.C0126d.common_color_10168, 1);
                    }
                    this.ecX.setText(aFL.getgActivityTitle());
                }
            } else if (aVar.aFR()) {
                this.ecV.setVisibility(0);
                this.ecT.setVisibility(0);
                this.ecW.setVisibility(4);
                this.ecX.setText(d.k.group_info_create_activity);
            } else {
                this.ecV.setVisibility(8);
                this.ecT.setVisibility(8);
            }
            this.edp.removeAllViews();
            if (aVar.aFM() != null && aVar.aFM().size() > 0) {
                List<MemberData> aFM = aVar.aFM();
                int size = aFM.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aFM.get(i3);
                    HeadImageView headImageView = this.edq[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.ecS.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.edq[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.edp.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aFR()) {
                this.edo.setEnabled(true);
                this.edF.setEnabled(true);
                ak.i(this.edF, d.f.group_info_item);
                this.edC.setVisibility(0);
                this.edH.setVisibility(0);
                this.edE.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.edD.setText(aVar.getGroup().getName());
                }
            } else {
                this.edo.setEnabled(false);
                this.edF.setEnabled(true);
                ak.j(this.edF, d.C0126d.cp_bg_line_d);
                this.edE.setVisibility(8);
                this.edH.setVisibility(8);
                this.eda.setPadding(0, 0, 0, 0);
            }
            if (aVar.aFQ()) {
                this.edu.setVisibility(0);
                this.edN.setVisibility(0);
                if (this.edj.getParent() != this.edu) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.edw.removeView(this.edj);
                    this.edu.addView(this.edj, 1);
                }
                aFf();
            } else {
                this.edu.setVisibility(8);
                this.edN.setVisibility(8);
                if (this.edj.getParent() != this.edw) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.edu.removeView(this.edj);
                    this.edw.addView(this.edj, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.edf.setVisibility(8);
            } else {
                this.edf.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hm(aVar.aFR());
            } else {
                i(aVar.aFR(), this.edA);
            }
            this.cWr.setVisibility(0);
            this.edr.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (nG(aVar.getGroup().getFlag())) {
                hn(z);
            } else {
                aFg();
            }
        }
    }

    public void aFf() {
        this.eds.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.c(this.eds, d.C0126d.cp_cont_i, 1);
        this.eds.setText(this.ecS.getPageContext().getString(d.k.i_want_talk));
        this.edM.setEnabled(true);
    }

    private void hn(boolean z) {
        this.eds.setText(this.ecS.getPageContext().getString(d.k.i_want_attent));
        if (z) {
            this.eds.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.c(this.eds, d.C0126d.cp_cont_i, 1);
        } else {
            this.eds.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.c(this.eds, d.C0126d.cp_cont_i, 1);
        }
        ak.i(this.edM, d.f.btn_blue_bg);
        this.edM.setEnabled(true);
    }

    private boolean nG(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aFg() {
        this.eds.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eds.setText(this.ecS.getPageContext().getString(d.k.group_info_refuse_join));
        this.eds.setTextColor(this.ecS.getResources().getColorStateList(d.C0126d.cp_cont_i));
        ak.i(this.edM, d.f.btn_app_download_d);
        this.edM.setEnabled(false);
    }

    public void nI(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.edp.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.edp.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.edp.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.edd.setIsManager(aVar.aFR());
            if (aVar.aFR()) {
                this.edd.setVisibility(0);
                if (aVar.aFN() != null && aVar.aFN().size() == 1 && TextUtils.isEmpty(aVar.aFN().get(0).getPicId())) {
                    this.edd.setData(null);
                } else {
                    this.edd.setData(aVar.aFN());
                }
            } else if (aVar.aFN() != null && aVar.aFN().size() > 0) {
                if (aVar.aFN().size() == 1 && TextUtils.isEmpty(aVar.aFN().get(0).getPicId())) {
                    this.edd.setVisibility(8);
                    return;
                }
                this.edd.setVisibility(0);
                this.edd.setData(aVar.aFN());
            } else {
                this.edd.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.edy = bVar;
    }

    public void d(Object obj, int i) {
        if (this.edx != null) {
            this.edx.dismiss();
            this.edx = null;
        }
        e(obj, i);
        this.edx.tF();
    }

    public void aFh() {
        this.edx.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.edx == null) {
            this.edx = new com.baidu.tbadk.core.dialog.b(this.ecS.getPageContext().getPageActivity());
            this.edx.dd(this.ecS.getResources().getString(d.k.operation));
            this.edx.a(new String[]{this.ecS.getResources().getString(d.k.group_info_set_portrait), this.ecS.getResources().getString(d.k.delete), this.ecS.getResources().getString(d.k.cancel)}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                    a.this.edy.a(bVar, i2, obj, i);
                }
            });
        }
        this.edx.d(this.ecS.getPageContext());
    }

    public void onDestory() {
        if (this.edd != null) {
            this.edd.onDestory();
        }
        if (this.edh != null) {
            this.edh.stopLoad();
            this.edh.setBackgroundDrawable(null);
            this.edh.setImageDrawable(null);
        }
        if (this.edp != null && this.edq != null) {
            int length = this.edq.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.edq[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void nJ(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.ecS.getPageContext().getString(d.k.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.ecS.getPageContext().getPageActivity());
            bVar.dd(this.ecS.getPageContext().getString(d.k.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.ecS.getSystemService("clipboard")).setText(str);
                        a.this.ecS.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.ecS.getPageContext());
            bVar.tF();
        }
    }

    public void nK(String str) {
        if (this.edv == null) {
            nL(str);
        }
        this.edv.tF();
    }

    private void nL(final String str) {
        if (this.edv == null) {
            this.edv = new com.baidu.tbadk.core.dialog.b(this.ecS.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.ecS.getPageContext().getString(d.k.copy_group_number)};
            this.edv.dd(this.ecS.getPageContext().getString(d.k.operation));
            this.edv.a(charSequenceArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.ecS.getSystemService("clipboard")).setText(str);
                        a.this.ecS.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.edv.d(this.ecS.getPageContext());
        }
    }

    public void aFi() {
        ColorStateList cN = ak.cN(d.C0126d.cp_cont_i);
        if (cN != null) {
            this.eds.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eds.setTextColor(cN);
    }

    public void changeSkinType(int i) {
        this.ecS.getLayoutMode().setNightMode(i == 1);
        this.ecS.getLayoutMode().u(this.bbZ);
        this.ecS.getLayoutMode().u(this.edm);
        this.edd.a(i, this.ecS);
        this.mNavigationBar.onChangeSkinType(this.ecS.getPageContext(), i);
        if (this.isMemGroup) {
            ak.c(this.edO, d.C0126d.common_color_10009, 1);
        }
        if (!this.edR) {
            b(this.edP, this.edQ);
        }
        if (this.edS) {
            ak.i(this.edF, d.f.group_info_item);
        } else {
            ak.j(this.edF, d.C0126d.cp_bg_line_d);
        }
    }

    public void ho(boolean z) {
        this.edR = z;
    }
}
