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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int jCz = 0;
    private ScrollView cek;
    private View hPv;
    private boolean isMemGroup;
    private TextView jAu;
    private ProgressBar jBA;
    private RelativeLayout jBB;
    private TextView jBC;
    private TextView jBD;
    private TextView jBE;
    private TextView jBF;
    private EllipsizingTextView jBG;
    private TextView jBH;
    private RelativeLayout jBI;
    private PhotoWallView jBJ;
    private RelativeLayout jBK;
    private RelativeLayout jBL;
    private LinearLayout jBM;
    private HeadImageView jBN;
    private TextView jBO;
    private RelativeLayout jBP;
    private com.baidu.tbadk.core.dialog.b jBQ;
    private ImageView jBR;
    private final View jBS;
    private b.InterfaceC0533b jBT;
    private RelativeLayout jBU;
    private LinearLayout jBV;
    private HeadImageView[] jBW;
    private LinearLayout jBX;
    private TextView jBY;
    private RelativeLayout jBZ;
    private final GroupInfoActivity jBy;
    private View jBz;
    private LinearLayout jCa;
    private com.baidu.tbadk.core.dialog.b jCb;
    private LinearLayout jCc;
    private i jCd;
    private b jCe;
    private TextView jCf;
    private String jCg;
    private ImageView jCh;
    private RelativeLayout jCi;
    private TextView jCj;
    private ImageView jCk;
    private RelativeLayout jCl;
    private RelativeLayout jCm;
    private ImageView jCn;
    private ImageView jCo;
    private View jCp;
    private TextView jCq;
    private TextView jCr;
    private LinearLayout jCs;
    private View jCt;
    private TextView jCu;
    private ResponseGroupInfoLocalMessage.a jCv;
    private boolean jCw;
    private boolean jCx;
    private boolean jCy;
    private View joh;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.jBQ = null;
        this.jBT = null;
        this.jBW = new HeadImageView[5];
        this.jCg = "";
        this.jCw = true;
        this.isMemGroup = false;
        this.jCx = false;
        this.jCy = false;
        this.jBy = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.jBS = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cek.setVisibility(4);
        this.jBX.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.jCj.setText(str);
        Lp(str);
    }

    private void Lp(String str) {
        if (str != null) {
            this.jCu.setText(str);
        }
    }

    public void Lq(String str) {
        this.jBG.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.joh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jCu = this.mNavigationBar.setTitleText("");
        this.jCt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jCf = (TextView) this.jCt.findViewById(R.id.right_textview);
        this.jCf.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ap.setViewTextColor(this.jCf, R.color.cp_cont_f, 1);
        this.jCf.setOnClickListener(groupInfoActivity);
        this.jCt.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.jBz = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.cek = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.cek.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.hPv = groupInfoActivity.findViewById(R.id.group_top_view);
        this.hPv.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.jBB = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.jBB.setOnClickListener(groupInfoActivity);
        this.jBC = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.jBD = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.jBU = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.jBU.setOnClickListener(groupInfoActivity);
        this.jCc = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.jCh = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.jBE = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.jBF = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.jCn = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.jBG = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.jBG.setMaxLines(20);
        this.jBG.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void pE(boolean z) {
                if (z) {
                    a.this.jCq.setVisibility(0);
                } else {
                    a.this.jCq.setVisibility(8);
                }
            }
        });
        this.jBI = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.jBH = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.jBI.setOnClickListener(groupInfoActivity);
        this.jBN = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.jBN.setAutoChangeStyle(true);
        this.jBN.setIsRound(false);
        this.jAu = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.jBK = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.jBK.setOnClickListener(groupInfoActivity);
        this.jBR = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.jCp = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.jBM = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.jBI.setOnClickListener(groupInfoActivity);
        this.jBL = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.jBL.setOnClickListener(groupInfoActivity);
        this.jBO = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.jBP = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.jBP.setOnClickListener(groupInfoActivity);
        this.jBV = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.jBX = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.jCs = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.jBY = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.jCs.setOnClickListener(this.jBy);
        this.jBZ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.jBZ.setOnClickListener(groupInfoActivity);
        this.jCa = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.jCi = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.jCi.setOnClickListener(groupInfoActivity);
        this.jCj = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.jCk = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.jCo = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.jCl = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.jCl.setOnClickListener(groupInfoActivity);
        this.jCl.setLongClickable(true);
        this.jCl.setOnLongClickListener(groupInfoActivity);
        this.jCq = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.jCq.setClickable(true);
        this.jCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jBG.setMaxLines(1000);
            }
        });
        this.jCm = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.jCm.setOnLongClickListener(groupInfoActivity);
        this.jCr = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.jBA = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.jBJ = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.jBJ.setPhotoClickListener(groupInfoActivity);
        this.jBJ.setPhotoLongClickListener(groupInfoActivity);
        this.jBJ.setVisibility(8);
    }

    public RelativeLayout cJQ() {
        return this.jCm;
    }

    public RelativeLayout cJR() {
        return this.jBI;
    }

    public LinearLayout cJS() {
        return this.jBV;
    }

    public RelativeLayout cJT() {
        return this.jBZ;
    }

    public RelativeLayout cJU() {
        return this.jCl;
    }

    public RelativeLayout cJV() {
        return this.jCi;
    }

    public RelativeLayout cJW() {
        return this.jBB;
    }

    public View cJX() {
        return this.jCf;
    }

    public LinearLayout cJY() {
        return this.jCs;
    }

    public RelativeLayout cJZ() {
        return this.jBK;
    }

    public RelativeLayout cKa() {
        return this.jBL;
    }

    public RelativeLayout cKb() {
        return this.jBP;
    }

    public View cIK() {
        return this.joh;
    }

    public void cKc() {
        this.jBA.setVisibility(8);
    }

    public void cKd() {
        this.jBA.setVisibility(0);
    }

    public void r(boolean z, String str) {
        if (z) {
            this.jBF.setText(str);
            this.jBU.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.jBU.setVisibility(8);
        } else {
            this.jBF.setText(str);
            this.jBU.setVisibility(0);
        }
    }

    public void qT(boolean z) {
        if (z) {
            this.jBF.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.jBU.setVisibility(8);
        }
    }

    public RelativeLayout cKe() {
        return this.jBU;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.jCx = aVar.cKN();
            this.jCy = aVar.cKO();
            this.jCv = aVar;
            this.jCw = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cKI() != null) {
                jCz = aVar.cKI().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.jCc.setVisibility(0);
            this.jBX.setVisibility(0);
            if (aVar.getGroup() != null) {
                Lp(aVar.getGroup().getName());
                this.jBE.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.jBR.setVisibility(0);
                } else {
                    this.jBR.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.jCh.setVisibility(0);
                    this.jBN.setVisibility(8);
                    this.jCo.setVisibility(8);
                    this.jCp.setVisibility(8);
                    this.jAu.setText(R.string.group_info_forum_author);
                    this.jBK.setEnabled(false);
                    this.jBR.setVisibility(8);
                } else {
                    this.jCh.setVisibility(8);
                    this.jBN.setVisibility(0);
                    this.jCo.setVisibility(0);
                    this.jCp.setVisibility(0);
                    this.jAu.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.jBK.setEnabled(true);
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
                this.jCg = stringBuffer.toString();
                this.jBF.setText(this.jCg);
                this.jBG.setText(aVar.getGroup().getIntro());
                this.jBO.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.jBN.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.jBI.setVisibility(0);
                    this.jBH.setText(aVar.getGroup().getForumName() + this.jBy.getPageContext().getString(R.string.forum));
                } else {
                    this.jBI.setVisibility(8);
                }
                this.jBM.removeAllViews();
                boolean cKP = aVar.cKP();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ap.setViewTextColor(this.jCu, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.jBy.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ap.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ap.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.jBM.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.jBy.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ap.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ap.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.jBM.addView(imageView2);
                }
                if (cKP) {
                    this.jCr.setVisibility(0);
                } else {
                    this.jCr.setVisibility(8);
                }
            }
            if (aVar.cKI() != null) {
                this.jBB.setVisibility(0);
                this.jBz.setVisibility(0);
                GroupActivityData cKI = aVar.cKI();
                if (!aVar.cKN()) {
                    if (cKI.getIsEnd() != 1) {
                        this.jBC.setVisibility(4);
                        this.jBD.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.jBB.setVisibility(8);
                        this.jBz.setVisibility(8);
                    }
                } else {
                    this.jBC.setVisibility(0);
                    this.jBD.setText(cKI.getgActivityTitle());
                    if (cKI.getIsEnd() != 1) {
                        this.jBC.setText(R.string.group_info_activity_doing);
                        ap.setViewTextColor(this.jBC, R.color.common_color_10171, 1);
                    } else {
                        this.jBC.setText(R.string.group_activity_end);
                        ap.setViewTextColor(this.jBC, R.color.common_color_10168, 1);
                    }
                    this.jBD.setText(cKI.getgActivityTitle());
                }
            } else if (aVar.cKO()) {
                this.jBB.setVisibility(0);
                this.jBz.setVisibility(0);
                this.jBC.setVisibility(4);
                this.jBD.setText(R.string.group_info_create_activity);
            } else {
                this.jBB.setVisibility(8);
                this.jBz.setVisibility(8);
            }
            this.jBV.removeAllViews();
            if (aVar.cKJ() != null && aVar.cKJ().size() > 0) {
                List<MemberData> cKJ = aVar.cKJ();
                int size = cKJ.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cKJ.get(i3);
                    HeadImageView headImageView = this.jBW[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.jBy.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.jBW[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.jBV.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cKO()) {
                this.jBU.setEnabled(true);
                this.jCl.setEnabled(true);
                ap.setBackgroundResource(this.jCl, R.drawable.group_info_item);
                this.jCi.setVisibility(0);
                this.jCn.setVisibility(0);
                this.jCk.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.jCj.setText(aVar.getGroup().getName());
                }
            } else {
                this.jBU.setEnabled(false);
                this.jCl.setEnabled(true);
                ap.setBackgroundColor(this.jCl, R.color.cp_bg_line_d);
                this.jCk.setVisibility(8);
                this.jCn.setVisibility(8);
                this.jBG.setPadding(0, 0, 0, 0);
            }
            if (aVar.cKN()) {
                this.jCa.setVisibility(0);
                this.jCt.setVisibility(0);
                if (this.jBP.getParent() != this.jCa) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.jCc.removeView(this.jBP);
                    this.jCa.addView(this.jBP, 1);
                }
                cKf();
            } else {
                this.jCa.setVisibility(8);
                this.jCt.setVisibility(8);
                if (this.jBP.getParent() != this.jCc) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.jCa.removeView(this.jBP);
                    this.jCc.addView(this.jBP, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.jBL.setVisibility(8);
            } else {
                this.jBL.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                qT(aVar.cKO());
            } else {
                r(aVar.cKO(), this.jCg);
            }
            this.cek.setVisibility(0);
            this.jBX.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (BS(aVar.getGroup().getFlag())) {
                qU(z);
            } else {
                cKg();
            }
        }
    }

    public void cKf() {
        this.jBY.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.jBY, R.color.cp_cont_a, 1);
        this.jBY.setText(this.jBy.getPageContext().getString(R.string.i_want_talk));
        this.jCs.setEnabled(true);
    }

    private void qU(boolean z) {
        this.jBY.setText(this.jBy.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.jBY.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.jBY, R.color.cp_cont_a, 1);
        } else {
            this.jBY.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.jBY, R.color.cp_cont_a, 1);
        }
        ap.setBackgroundResource(this.jCs, R.drawable.btn_blue_bg);
        this.jCs.setEnabled(true);
    }

    private boolean BS(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cKg() {
        this.jBY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.jBY.setText(this.jBy.getPageContext().getString(R.string.group_info_refuse_join));
        this.jBY.setTextColor(this.jBy.getResources().getColorStateList(R.color.cp_cont_a));
        ap.setBackgroundResource(this.jCs, R.drawable.btn_app_download_d);
        this.jCs.setEnabled(false);
    }

    public void Lr(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.jBV.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.jBV.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.jBV.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.jBJ.setIsManager(aVar.cKO());
            if (aVar.cKO()) {
                this.jBJ.setVisibility(0);
                if (aVar.cKK() != null && aVar.cKK().size() == 1 && TextUtils.isEmpty(aVar.cKK().get(0).getPicId())) {
                    this.jBJ.setData(null);
                } else {
                    this.jBJ.setData(aVar.cKK());
                }
            } else if (aVar.cKK() != null && aVar.cKK().size() > 0) {
                if (aVar.cKK().size() == 1 && TextUtils.isEmpty(aVar.cKK().get(0).getPicId())) {
                    this.jBJ.setVisibility(8);
                    return;
                }
                this.jBJ.setVisibility(0);
                this.jBJ.setData(aVar.cKK());
            } else {
                this.jBJ.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.jCe = bVar;
    }

    public void d(Object obj, int i) {
        if (this.jCd != null) {
            this.jCd.dismiss();
            this.jCd = null;
        }
        e(obj, i);
        this.jCd.NY();
    }

    private void e(final Object obj, final int i) {
        if (this.jCd == null) {
            this.jCd = new i(this.jBy.getPageContext());
            this.jCd.a(null, new String[]{this.jBy.getResources().getString(R.string.group_info_set_portrait), this.jBy.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.jCd != null && a.this.jCd.isShowing()) {
                        a.this.jCe.a(a.this.jCd, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.jBJ != null) {
            this.jBJ.onDestory();
        }
        if (this.jBN != null) {
            this.jBN.stopLoad();
            this.jBN.setBackgroundDrawable(null);
            this.jBN.setImageDrawable(null);
        }
        if (this.jBV != null && this.jBW != null) {
            int length = this.jBW.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.jBW[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void Ls(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.jBy.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.jBy.getPageContext().getPageActivity());
            bVar.zW(this.jBy.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0533b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.jBy.getSystemService("clipboard")).setText(str);
                        a.this.jBy.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.jBy.getPageContext());
            bVar.bic();
        }
    }

    public void Lt(String str) {
        if (this.jCb == null) {
            Lu(str);
        }
        this.jCb.bic();
    }

    private void Lu(final String str) {
        if (this.jCb == null) {
            this.jCb = new com.baidu.tbadk.core.dialog.b(this.jBy.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.jBy.getPageContext().getString(R.string.copy_group_number)};
            this.jCb.zW(this.jBy.getPageContext().getString(R.string.operation));
            this.jCb.a(charSequenceArr, new b.InterfaceC0533b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.jBy.getSystemService("clipboard")).setText(str);
                        a.this.jBy.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.jCb.d(this.jBy.getPageContext());
        }
    }

    public void cKh() {
        ColorStateList colorList = ap.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.jBY.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.jBY.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.jBy.getLayoutMode().setNightMode(i == 1);
        this.jBy.getLayoutMode().onModeChanged(this.mContainer);
        this.jBy.getLayoutMode().onModeChanged(this.jBS);
        this.jBJ.a(i, this.jBy);
        this.mNavigationBar.onChangeSkinType(this.jBy.getPageContext(), i);
        if (this.isMemGroup) {
            ap.setViewTextColor(this.jCu, R.color.common_color_10009, 1);
        }
        if (!this.jCx) {
            b(this.jCv, this.jCw);
        }
        if (this.jCy) {
            ap.setBackgroundResource(this.jCl, R.drawable.group_info_item);
        } else {
            ap.setBackgroundColor(this.jCl, R.color.cp_bg_line_d);
        }
    }

    public void qV(boolean z) {
        this.jCx = z;
    }
}
