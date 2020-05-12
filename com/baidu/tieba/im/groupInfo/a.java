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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int iqi = 0;
    private ScrollView bHY;
    private View gOf;
    private View idP;
    private TextView iod;
    private ImageView ipA;
    private final View ipB;
    private b.a ipC;
    private RelativeLayout ipD;
    private LinearLayout ipE;
    private HeadImageView[] ipF;
    private LinearLayout ipG;
    private TextView ipH;
    private RelativeLayout ipI;
    private LinearLayout ipJ;
    private com.baidu.tbadk.core.dialog.b ipK;
    private LinearLayout ipL;
    private i ipM;
    private b ipN;
    private TextView ipO;
    private String ipP;
    private ImageView ipQ;
    private RelativeLayout ipR;
    private TextView ipS;
    private ImageView ipT;
    private RelativeLayout ipU;
    private RelativeLayout ipV;
    private ImageView ipW;
    private ImageView ipX;
    private View ipY;
    private TextView ipZ;
    private final GroupInfoActivity iph;
    private View ipi;
    private ProgressBar ipj;
    private RelativeLayout ipk;
    private TextView ipl;
    private TextView ipm;
    private TextView ipn;
    private TextView ipo;
    private EllipsizingTextView ipp;
    private TextView ipq;
    private RelativeLayout ipr;
    private PhotoWallView ips;
    private RelativeLayout ipt;
    private RelativeLayout ipu;
    private LinearLayout ipv;
    private HeadImageView ipw;
    private TextView ipx;
    private RelativeLayout ipy;
    private com.baidu.tbadk.core.dialog.b ipz;
    private TextView iqa;
    private LinearLayout iqb;
    private View iqc;
    private TextView iqd;
    private ResponseGroupInfoLocalMessage.a iqe;
    private boolean iqf;
    private boolean iqg;
    private boolean iqh;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.ipz = null;
        this.ipC = null;
        this.ipF = new HeadImageView[5];
        this.ipP = "";
        this.iqf = true;
        this.isMemGroup = false;
        this.iqg = false;
        this.iqh = false;
        this.iph = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.ipB = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bHY.setVisibility(4);
        this.ipG.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.ipS.setText(str);
        EU(str);
    }

    private void EU(String str) {
        if (str != null) {
            this.iqd.setText(str);
        }
    }

    public void EV(String str) {
        this.ipp.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.idP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iqd = this.mNavigationBar.setTitleText("");
        this.iqc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.ipO = (TextView) this.iqc.findViewById(R.id.right_textview);
        this.ipO.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.ipO, R.color.cp_cont_f, 1);
        this.ipO.setOnClickListener(groupInfoActivity);
        this.iqc.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.ipi = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bHY = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bHY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.gOf = groupInfoActivity.findViewById(R.id.group_top_view);
        this.gOf.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ipk = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.ipk.setOnClickListener(groupInfoActivity);
        this.ipl = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.ipm = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.ipD = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.ipD.setOnClickListener(groupInfoActivity);
        this.ipL = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.ipQ = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.ipn = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.ipo = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.ipW = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.ipp = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.ipp.setMaxLines(20);
        this.ipp.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void nF(boolean z) {
                if (z) {
                    a.this.ipZ.setVisibility(0);
                } else {
                    a.this.ipZ.setVisibility(8);
                }
            }
        });
        this.ipr = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.ipq = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.ipr.setOnClickListener(groupInfoActivity);
        this.ipw = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.ipw.setAutoChangeStyle(true);
        this.ipw.setIsRound(false);
        this.iod = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.ipt = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.ipt.setOnClickListener(groupInfoActivity);
        this.ipA = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.ipY = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.ipv = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.ipr.setOnClickListener(groupInfoActivity);
        this.ipu = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.ipu.setOnClickListener(groupInfoActivity);
        this.ipx = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.ipy = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.ipy.setOnClickListener(groupInfoActivity);
        this.ipE = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.ipG = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.iqb = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.ipH = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.iqb.setOnClickListener(this.iph);
        this.ipI = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.ipI.setOnClickListener(groupInfoActivity);
        this.ipJ = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.ipR = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.ipR.setOnClickListener(groupInfoActivity);
        this.ipS = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.ipT = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.ipX = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.ipU = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.ipU.setOnClickListener(groupInfoActivity);
        this.ipU.setLongClickable(true);
        this.ipU.setOnLongClickListener(groupInfoActivity);
        this.ipZ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.ipZ.setClickable(true);
        this.ipZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ipp.setMaxLines(1000);
            }
        });
        this.ipV = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.ipV.setOnLongClickListener(groupInfoActivity);
        this.iqa = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.ipj = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.ips = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.ips.setPhotoClickListener(groupInfoActivity);
        this.ips.setPhotoLongClickListener(groupInfoActivity);
        this.ips.setVisibility(8);
    }

    public RelativeLayout cgY() {
        return this.ipV;
    }

    public RelativeLayout cgZ() {
        return this.ipr;
    }

    public LinearLayout cha() {
        return this.ipE;
    }

    public RelativeLayout chb() {
        return this.ipI;
    }

    public RelativeLayout chc() {
        return this.ipU;
    }

    public RelativeLayout chd() {
        return this.ipR;
    }

    public RelativeLayout che() {
        return this.ipk;
    }

    public View chf() {
        return this.ipO;
    }

    public LinearLayout chg() {
        return this.iqb;
    }

    public RelativeLayout chh() {
        return this.ipt;
    }

    public RelativeLayout chi() {
        return this.ipu;
    }

    public RelativeLayout chj() {
        return this.ipy;
    }

    public View cfS() {
        return this.idP;
    }

    public void chk() {
        this.ipj.setVisibility(8);
    }

    public void chl() {
        this.ipj.setVisibility(0);
    }

    public void o(boolean z, String str) {
        if (z) {
            this.ipo.setText(str);
            this.ipD.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.ipD.setVisibility(8);
        } else {
            this.ipo.setText(str);
            this.ipD.setVisibility(0);
        }
    }

    public void oQ(boolean z) {
        if (z) {
            this.ipo.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.ipD.setVisibility(8);
        }
    }

    public RelativeLayout chm() {
        return this.ipD;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.iqg = aVar.chV();
            this.iqh = aVar.chW();
            this.iqe = aVar;
            this.iqf = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.chQ() != null) {
                iqi = aVar.chQ().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.ipL.setVisibility(0);
            this.ipG.setVisibility(0);
            if (aVar.getGroup() != null) {
                EU(aVar.getGroup().getName());
                this.ipn.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.ipA.setVisibility(0);
                } else {
                    this.ipA.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.ipQ.setVisibility(0);
                    this.ipw.setVisibility(8);
                    this.ipX.setVisibility(8);
                    this.ipY.setVisibility(8);
                    this.iod.setText(R.string.group_info_forum_author);
                    this.ipt.setEnabled(false);
                    this.ipA.setVisibility(8);
                } else {
                    this.ipQ.setVisibility(8);
                    this.ipw.setVisibility(0);
                    this.ipX.setVisibility(0);
                    this.ipY.setVisibility(0);
                    this.iod.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.ipt.setEnabled(true);
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
                this.ipP = stringBuffer.toString();
                this.ipo.setText(this.ipP);
                this.ipp.setText(aVar.getGroup().getIntro());
                this.ipx.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.ipw.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.ipr.setVisibility(0);
                    this.ipq.setText(aVar.getGroup().getForumName() + this.iph.getPageContext().getString(R.string.forum));
                } else {
                    this.ipr.setVisibility(8);
                }
                this.ipv.removeAllViews();
                boolean chX = aVar.chX();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.iqd, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.iph.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.ipv.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.iph.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.ipv.addView(imageView2);
                }
                if (chX) {
                    this.iqa.setVisibility(0);
                } else {
                    this.iqa.setVisibility(8);
                }
            }
            if (aVar.chQ() != null) {
                this.ipk.setVisibility(0);
                this.ipi.setVisibility(0);
                GroupActivityData chQ = aVar.chQ();
                if (!aVar.chV()) {
                    if (chQ.getIsEnd() != 1) {
                        this.ipl.setVisibility(4);
                        this.ipm.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.ipk.setVisibility(8);
                        this.ipi.setVisibility(8);
                    }
                } else {
                    this.ipl.setVisibility(0);
                    this.ipm.setText(chQ.getgActivityTitle());
                    if (chQ.getIsEnd() != 1) {
                        this.ipl.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.ipl, R.color.common_color_10171, 1);
                    } else {
                        this.ipl.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.ipl, R.color.common_color_10168, 1);
                    }
                    this.ipm.setText(chQ.getgActivityTitle());
                }
            } else if (aVar.chW()) {
                this.ipk.setVisibility(0);
                this.ipi.setVisibility(0);
                this.ipl.setVisibility(4);
                this.ipm.setText(R.string.group_info_create_activity);
            } else {
                this.ipk.setVisibility(8);
                this.ipi.setVisibility(8);
            }
            this.ipE.removeAllViews();
            if (aVar.chR() != null && aVar.chR().size() > 0) {
                List<MemberData> chR = aVar.chR();
                int size = chR.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = chR.get(i3);
                    HeadImageView headImageView = this.ipF[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.iph.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.ipF[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.ipE.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.chW()) {
                this.ipD.setEnabled(true);
                this.ipU.setEnabled(true);
                am.setBackgroundResource(this.ipU, R.drawable.group_info_item);
                this.ipR.setVisibility(0);
                this.ipW.setVisibility(0);
                this.ipT.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.ipS.setText(aVar.getGroup().getName());
                }
            } else {
                this.ipD.setEnabled(false);
                this.ipU.setEnabled(true);
                am.setBackgroundColor(this.ipU, R.color.cp_bg_line_d);
                this.ipT.setVisibility(8);
                this.ipW.setVisibility(8);
                this.ipp.setPadding(0, 0, 0, 0);
            }
            if (aVar.chV()) {
                this.ipJ.setVisibility(0);
                this.iqc.setVisibility(0);
                if (this.ipy.getParent() != this.ipJ) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.ipL.removeView(this.ipy);
                    this.ipJ.addView(this.ipy, 1);
                }
                chn();
            } else {
                this.ipJ.setVisibility(8);
                this.iqc.setVisibility(8);
                if (this.ipy.getParent() != this.ipL) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.ipJ.removeView(this.ipy);
                    this.ipL.addView(this.ipy, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.ipu.setVisibility(8);
            } else {
                this.ipu.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                oQ(aVar.chW());
            } else {
                o(aVar.chW(), this.ipP);
            }
            this.bHY.setVisibility(0);
            this.ipG.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (xi(aVar.getGroup().getFlag())) {
                oR(z);
            } else {
                cho();
            }
        }
    }

    public void chn() {
        this.ipH.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.ipH, R.color.cp_cont_a, 1);
        this.ipH.setText(this.iph.getPageContext().getString(R.string.i_want_talk));
        this.iqb.setEnabled(true);
    }

    private void oR(boolean z) {
        this.ipH.setText(this.iph.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.ipH.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.ipH, R.color.cp_cont_a, 1);
        } else {
            this.ipH.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.ipH, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.iqb, R.drawable.btn_blue_bg);
        this.iqb.setEnabled(true);
    }

    private boolean xi(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cho() {
        this.ipH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ipH.setText(this.iph.getPageContext().getString(R.string.group_info_refuse_join));
        this.ipH.setTextColor(this.iph.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.iqb, R.drawable.btn_app_download_d);
        this.iqb.setEnabled(false);
    }

    public void EW(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.ipE.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ipE.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.ipE.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.ips.setIsManager(aVar.chW());
            if (aVar.chW()) {
                this.ips.setVisibility(0);
                if (aVar.chS() != null && aVar.chS().size() == 1 && TextUtils.isEmpty(aVar.chS().get(0).getPicId())) {
                    this.ips.setData(null);
                } else {
                    this.ips.setData(aVar.chS());
                }
            } else if (aVar.chS() != null && aVar.chS().size() > 0) {
                if (aVar.chS().size() == 1 && TextUtils.isEmpty(aVar.chS().get(0).getPicId())) {
                    this.ips.setVisibility(8);
                    return;
                }
                this.ips.setVisibility(0);
                this.ips.setData(aVar.chS());
            } else {
                this.ips.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.ipN = bVar;
    }

    public void d(Object obj, int i) {
        if (this.ipM != null) {
            this.ipM.dismiss();
            this.ipM = null;
        }
        e(obj, i);
        this.ipM.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.ipM == null) {
            this.ipM = new i(this.iph.getPageContext());
            this.ipM.a(null, new String[]{this.iph.getResources().getString(R.string.group_info_set_portrait), this.iph.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.ipM != null && a.this.ipM.isShowing()) {
                        a.this.ipN.a(a.this.ipM, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.ips != null) {
            this.ips.onDestory();
        }
        if (this.ipw != null) {
            this.ipw.stopLoad();
            this.ipw.setBackgroundDrawable(null);
            this.ipw.setImageDrawable(null);
        }
        if (this.ipE != null && this.ipF != null) {
            int length = this.ipF.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.ipF[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void EX(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.iph.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iph.getPageContext().getPageActivity());
            bVar.uj(this.iph.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.iph.getSystemService("clipboard")).setText(str);
                        a.this.iph.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.iph.getPageContext());
            bVar.aMT();
        }
    }

    public void EY(String str) {
        if (this.ipK == null) {
            EZ(str);
        }
        this.ipK.aMT();
    }

    private void EZ(final String str) {
        if (this.ipK == null) {
            this.ipK = new com.baidu.tbadk.core.dialog.b(this.iph.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.iph.getPageContext().getString(R.string.copy_group_number)};
            this.ipK.uj(this.iph.getPageContext().getString(R.string.operation));
            this.ipK.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.iph.getSystemService("clipboard")).setText(str);
                        a.this.iph.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.ipK.d(this.iph.getPageContext());
        }
    }

    public void chp() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.ipH.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.ipH.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.iph.getLayoutMode().setNightMode(i == 1);
        this.iph.getLayoutMode().onModeChanged(this.mContainer);
        this.iph.getLayoutMode().onModeChanged(this.ipB);
        this.ips.a(i, this.iph);
        this.mNavigationBar.onChangeSkinType(this.iph.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.iqd, R.color.common_color_10009, 1);
        }
        if (!this.iqg) {
            b(this.iqe, this.iqf);
        }
        if (this.iqh) {
            am.setBackgroundResource(this.ipU, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.ipU, R.color.cp_bg_line_d);
        }
    }

    public void oS(boolean z) {
        this.iqg = z;
    }
}
