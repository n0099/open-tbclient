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
    public static int iqc = 0;
    private ScrollView bHT;
    private View gNZ;
    private View idJ;
    private TextView inX;
    private LinearLayout ipA;
    private TextView ipB;
    private RelativeLayout ipC;
    private LinearLayout ipD;
    private com.baidu.tbadk.core.dialog.b ipE;
    private LinearLayout ipF;
    private i ipG;
    private b ipH;
    private TextView ipI;
    private String ipJ;
    private ImageView ipK;
    private RelativeLayout ipL;
    private TextView ipM;
    private ImageView ipN;
    private RelativeLayout ipO;
    private RelativeLayout ipP;
    private ImageView ipQ;
    private ImageView ipR;
    private View ipS;
    private TextView ipT;
    private TextView ipU;
    private LinearLayout ipV;
    private View ipW;
    private TextView ipX;
    private ResponseGroupInfoLocalMessage.a ipY;
    private boolean ipZ;
    private final GroupInfoActivity ipb;
    private View ipc;
    private ProgressBar ipd;
    private RelativeLayout ipe;
    private TextView ipf;
    private TextView ipg;
    private TextView iph;
    private TextView ipi;
    private EllipsizingTextView ipj;
    private TextView ipk;
    private RelativeLayout ipl;
    private PhotoWallView ipm;
    private RelativeLayout ipn;
    private RelativeLayout ipo;
    private LinearLayout ipp;
    private HeadImageView ipq;
    private TextView ipr;
    private RelativeLayout ips;
    private com.baidu.tbadk.core.dialog.b ipt;
    private ImageView ipu;
    private final View ipv;
    private b.a ipw;
    private RelativeLayout ipx;
    private LinearLayout ipy;
    private HeadImageView[] ipz;
    private boolean iqa;
    private boolean iqb;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.ipt = null;
        this.ipw = null;
        this.ipz = new HeadImageView[5];
        this.ipJ = "";
        this.ipZ = true;
        this.isMemGroup = false;
        this.iqa = false;
        this.iqb = false;
        this.ipb = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.ipv = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bHT.setVisibility(4);
        this.ipA.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.ipM.setText(str);
        ER(str);
    }

    private void ER(String str) {
        if (str != null) {
            this.ipX.setText(str);
        }
    }

    public void ES(String str) {
        this.ipj.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.idJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ipX = this.mNavigationBar.setTitleText("");
        this.ipW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.ipI = (TextView) this.ipW.findViewById(R.id.right_textview);
        this.ipI.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.ipI, R.color.cp_cont_f, 1);
        this.ipI.setOnClickListener(groupInfoActivity);
        this.ipW.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.ipc = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bHT = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bHT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.gNZ = groupInfoActivity.findViewById(R.id.group_top_view);
        this.gNZ.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ipe = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.ipe.setOnClickListener(groupInfoActivity);
        this.ipf = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.ipg = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.ipx = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.ipx.setOnClickListener(groupInfoActivity);
        this.ipF = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.ipK = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.iph = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.ipi = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.ipQ = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.ipj = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.ipj.setMaxLines(20);
        this.ipj.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void nF(boolean z) {
                if (z) {
                    a.this.ipT.setVisibility(0);
                } else {
                    a.this.ipT.setVisibility(8);
                }
            }
        });
        this.ipl = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.ipk = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.ipl.setOnClickListener(groupInfoActivity);
        this.ipq = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.ipq.setAutoChangeStyle(true);
        this.ipq.setIsRound(false);
        this.inX = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.ipn = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.ipn.setOnClickListener(groupInfoActivity);
        this.ipu = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.ipS = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.ipp = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.ipl.setOnClickListener(groupInfoActivity);
        this.ipo = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.ipo.setOnClickListener(groupInfoActivity);
        this.ipr = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.ips = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.ips.setOnClickListener(groupInfoActivity);
        this.ipy = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.ipA = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.ipV = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.ipB = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.ipV.setOnClickListener(this.ipb);
        this.ipC = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.ipC.setOnClickListener(groupInfoActivity);
        this.ipD = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.ipL = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.ipL.setOnClickListener(groupInfoActivity);
        this.ipM = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.ipN = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.ipR = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.ipO = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.ipO.setOnClickListener(groupInfoActivity);
        this.ipO.setLongClickable(true);
        this.ipO.setOnLongClickListener(groupInfoActivity);
        this.ipT = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.ipT.setClickable(true);
        this.ipT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ipj.setMaxLines(1000);
            }
        });
        this.ipP = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.ipP.setOnLongClickListener(groupInfoActivity);
        this.ipU = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.ipd = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.ipm = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.ipm.setPhotoClickListener(groupInfoActivity);
        this.ipm.setPhotoLongClickListener(groupInfoActivity);
        this.ipm.setVisibility(8);
    }

    public RelativeLayout cgZ() {
        return this.ipP;
    }

    public RelativeLayout cha() {
        return this.ipl;
    }

    public LinearLayout chb() {
        return this.ipy;
    }

    public RelativeLayout chc() {
        return this.ipC;
    }

    public RelativeLayout chd() {
        return this.ipO;
    }

    public RelativeLayout che() {
        return this.ipL;
    }

    public RelativeLayout chf() {
        return this.ipe;
    }

    public View chg() {
        return this.ipI;
    }

    public LinearLayout chh() {
        return this.ipV;
    }

    public RelativeLayout chi() {
        return this.ipn;
    }

    public RelativeLayout chj() {
        return this.ipo;
    }

    public RelativeLayout chk() {
        return this.ips;
    }

    public View cfT() {
        return this.idJ;
    }

    public void chl() {
        this.ipd.setVisibility(8);
    }

    public void chm() {
        this.ipd.setVisibility(0);
    }

    public void o(boolean z, String str) {
        if (z) {
            this.ipi.setText(str);
            this.ipx.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.ipx.setVisibility(8);
        } else {
            this.ipi.setText(str);
            this.ipx.setVisibility(0);
        }
    }

    public void oQ(boolean z) {
        if (z) {
            this.ipi.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.ipx.setVisibility(8);
        }
    }

    public RelativeLayout chn() {
        return this.ipx;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.iqa = aVar.chW();
            this.iqb = aVar.chX();
            this.ipY = aVar;
            this.ipZ = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.chR() != null) {
                iqc = aVar.chR().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.ipF.setVisibility(0);
            this.ipA.setVisibility(0);
            if (aVar.getGroup() != null) {
                ER(aVar.getGroup().getName());
                this.iph.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.ipu.setVisibility(0);
                } else {
                    this.ipu.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.ipK.setVisibility(0);
                    this.ipq.setVisibility(8);
                    this.ipR.setVisibility(8);
                    this.ipS.setVisibility(8);
                    this.inX.setText(R.string.group_info_forum_author);
                    this.ipn.setEnabled(false);
                    this.ipu.setVisibility(8);
                } else {
                    this.ipK.setVisibility(8);
                    this.ipq.setVisibility(0);
                    this.ipR.setVisibility(0);
                    this.ipS.setVisibility(0);
                    this.inX.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.ipn.setEnabled(true);
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
                this.ipJ = stringBuffer.toString();
                this.ipi.setText(this.ipJ);
                this.ipj.setText(aVar.getGroup().getIntro());
                this.ipr.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.ipq.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.ipl.setVisibility(0);
                    this.ipk.setText(aVar.getGroup().getForumName() + this.ipb.getPageContext().getString(R.string.forum));
                } else {
                    this.ipl.setVisibility(8);
                }
                this.ipp.removeAllViews();
                boolean chY = aVar.chY();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.ipX, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.ipb.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.ipp.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.ipb.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.ipp.addView(imageView2);
                }
                if (chY) {
                    this.ipU.setVisibility(0);
                } else {
                    this.ipU.setVisibility(8);
                }
            }
            if (aVar.chR() != null) {
                this.ipe.setVisibility(0);
                this.ipc.setVisibility(0);
                GroupActivityData chR = aVar.chR();
                if (!aVar.chW()) {
                    if (chR.getIsEnd() != 1) {
                        this.ipf.setVisibility(4);
                        this.ipg.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.ipe.setVisibility(8);
                        this.ipc.setVisibility(8);
                    }
                } else {
                    this.ipf.setVisibility(0);
                    this.ipg.setText(chR.getgActivityTitle());
                    if (chR.getIsEnd() != 1) {
                        this.ipf.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.ipf, R.color.common_color_10171, 1);
                    } else {
                        this.ipf.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.ipf, R.color.common_color_10168, 1);
                    }
                    this.ipg.setText(chR.getgActivityTitle());
                }
            } else if (aVar.chX()) {
                this.ipe.setVisibility(0);
                this.ipc.setVisibility(0);
                this.ipf.setVisibility(4);
                this.ipg.setText(R.string.group_info_create_activity);
            } else {
                this.ipe.setVisibility(8);
                this.ipc.setVisibility(8);
            }
            this.ipy.removeAllViews();
            if (aVar.chS() != null && aVar.chS().size() > 0) {
                List<MemberData> chS = aVar.chS();
                int size = chS.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = chS.get(i3);
                    HeadImageView headImageView = this.ipz[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.ipb.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.ipz[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.ipy.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.chX()) {
                this.ipx.setEnabled(true);
                this.ipO.setEnabled(true);
                am.setBackgroundResource(this.ipO, R.drawable.group_info_item);
                this.ipL.setVisibility(0);
                this.ipQ.setVisibility(0);
                this.ipN.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.ipM.setText(aVar.getGroup().getName());
                }
            } else {
                this.ipx.setEnabled(false);
                this.ipO.setEnabled(true);
                am.setBackgroundColor(this.ipO, R.color.cp_bg_line_d);
                this.ipN.setVisibility(8);
                this.ipQ.setVisibility(8);
                this.ipj.setPadding(0, 0, 0, 0);
            }
            if (aVar.chW()) {
                this.ipD.setVisibility(0);
                this.ipW.setVisibility(0);
                if (this.ips.getParent() != this.ipD) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.ipF.removeView(this.ips);
                    this.ipD.addView(this.ips, 1);
                }
                cho();
            } else {
                this.ipD.setVisibility(8);
                this.ipW.setVisibility(8);
                if (this.ips.getParent() != this.ipF) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.ipD.removeView(this.ips);
                    this.ipF.addView(this.ips, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.ipo.setVisibility(8);
            } else {
                this.ipo.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                oQ(aVar.chX());
            } else {
                o(aVar.chX(), this.ipJ);
            }
            this.bHT.setVisibility(0);
            this.ipA.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (xi(aVar.getGroup().getFlag())) {
                oR(z);
            } else {
                chp();
            }
        }
    }

    public void cho() {
        this.ipB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.ipB, R.color.cp_cont_a, 1);
        this.ipB.setText(this.ipb.getPageContext().getString(R.string.i_want_talk));
        this.ipV.setEnabled(true);
    }

    private void oR(boolean z) {
        this.ipB.setText(this.ipb.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.ipB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.ipB, R.color.cp_cont_a, 1);
        } else {
            this.ipB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.ipB, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.ipV, R.drawable.btn_blue_bg);
        this.ipV.setEnabled(true);
    }

    private boolean xi(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void chp() {
        this.ipB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ipB.setText(this.ipb.getPageContext().getString(R.string.group_info_refuse_join));
        this.ipB.setTextColor(this.ipb.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.ipV, R.drawable.btn_app_download_d);
        this.ipV.setEnabled(false);
    }

    public void ET(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.ipy.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ipy.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.ipy.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.ipm.setIsManager(aVar.chX());
            if (aVar.chX()) {
                this.ipm.setVisibility(0);
                if (aVar.chT() != null && aVar.chT().size() == 1 && TextUtils.isEmpty(aVar.chT().get(0).getPicId())) {
                    this.ipm.setData(null);
                } else {
                    this.ipm.setData(aVar.chT());
                }
            } else if (aVar.chT() != null && aVar.chT().size() > 0) {
                if (aVar.chT().size() == 1 && TextUtils.isEmpty(aVar.chT().get(0).getPicId())) {
                    this.ipm.setVisibility(8);
                    return;
                }
                this.ipm.setVisibility(0);
                this.ipm.setData(aVar.chT());
            } else {
                this.ipm.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.ipH = bVar;
    }

    public void d(Object obj, int i) {
        if (this.ipG != null) {
            this.ipG.dismiss();
            this.ipG = null;
        }
        e(obj, i);
        this.ipG.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.ipG == null) {
            this.ipG = new i(this.ipb.getPageContext());
            this.ipG.a(null, new String[]{this.ipb.getResources().getString(R.string.group_info_set_portrait), this.ipb.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.ipG != null && a.this.ipG.isShowing()) {
                        a.this.ipH.a(a.this.ipG, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.ipm != null) {
            this.ipm.onDestory();
        }
        if (this.ipq != null) {
            this.ipq.stopLoad();
            this.ipq.setBackgroundDrawable(null);
            this.ipq.setImageDrawable(null);
        }
        if (this.ipy != null && this.ipz != null) {
            int length = this.ipz.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.ipz[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void EU(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.ipb.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.ipb.getPageContext().getPageActivity());
            bVar.ug(this.ipb.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.ipb.getSystemService("clipboard")).setText(str);
                        a.this.ipb.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.ipb.getPageContext());
            bVar.aMV();
        }
    }

    public void EV(String str) {
        if (this.ipE == null) {
            EW(str);
        }
        this.ipE.aMV();
    }

    private void EW(final String str) {
        if (this.ipE == null) {
            this.ipE = new com.baidu.tbadk.core.dialog.b(this.ipb.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.ipb.getPageContext().getString(R.string.copy_group_number)};
            this.ipE.ug(this.ipb.getPageContext().getString(R.string.operation));
            this.ipE.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.ipb.getSystemService("clipboard")).setText(str);
                        a.this.ipb.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.ipE.d(this.ipb.getPageContext());
        }
    }

    public void chq() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.ipB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.ipB.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.ipb.getLayoutMode().setNightMode(i == 1);
        this.ipb.getLayoutMode().onModeChanged(this.mContainer);
        this.ipb.getLayoutMode().onModeChanged(this.ipv);
        this.ipm.a(i, this.ipb);
        this.mNavigationBar.onChangeSkinType(this.ipb.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.ipX, R.color.common_color_10009, 1);
        }
        if (!this.iqa) {
            b(this.ipY, this.ipZ);
        }
        if (this.iqb) {
            am.setBackgroundResource(this.ipO, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.ipO, R.color.cp_bg_line_d);
        }
    }

    public void oS(boolean z) {
        this.iqa = z;
    }
}
