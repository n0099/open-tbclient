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
    public static int hGm = 0;
    private ScrollView bjL;
    private View geR;
    private TextView hEh;
    private HeadImageView hFA;
    private TextView hFB;
    private RelativeLayout hFC;
    private com.baidu.tbadk.core.dialog.b hFD;
    private ImageView hFE;
    private final View hFF;
    private b.a hFG;
    private RelativeLayout hFH;
    private LinearLayout hFI;
    private HeadImageView[] hFJ;
    private LinearLayout hFK;
    private TextView hFL;
    private RelativeLayout hFM;
    private LinearLayout hFN;
    private com.baidu.tbadk.core.dialog.b hFO;
    private LinearLayout hFP;
    private i hFQ;
    private b hFR;
    private TextView hFS;
    private String hFT;
    private ImageView hFU;
    private RelativeLayout hFV;
    private TextView hFW;
    private ImageView hFX;
    private RelativeLayout hFY;
    private RelativeLayout hFZ;
    private final GroupInfoActivity hFl;
    private View hFm;
    private ProgressBar hFn;
    private RelativeLayout hFo;
    private TextView hFp;
    private TextView hFq;
    private TextView hFr;
    private TextView hFs;
    private EllipsizingTextView hFt;
    private TextView hFu;
    private RelativeLayout hFv;
    private PhotoWallView hFw;
    private RelativeLayout hFx;
    private RelativeLayout hFy;
    private LinearLayout hFz;
    private ImageView hGa;
    private ImageView hGb;
    private View hGc;
    private TextView hGd;
    private TextView hGe;
    private LinearLayout hGf;
    private View hGg;
    private TextView hGh;
    private ResponseGroupInfoLocalMessage.a hGi;
    private boolean hGj;
    private boolean hGk;
    private boolean hGl;
    private View htW;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.hFD = null;
        this.hFG = null;
        this.hFJ = new HeadImageView[5];
        this.hFT = "";
        this.hGj = true;
        this.isMemGroup = false;
        this.hGk = false;
        this.hGl = false;
        this.hFl = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.hFF = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bjL.setVisibility(4);
        this.hFK.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.hFW.setText(str);
        Dj(str);
    }

    private void Dj(String str) {
        if (str != null) {
            this.hGh.setText(str);
        }
    }

    public void Dk(String str) {
        this.hFt.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.htW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hGh = this.mNavigationBar.setTitleText("");
        this.hGg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hFS = (TextView) this.hGg.findViewById(R.id.right_textview);
        this.hFS.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.hFS, R.color.cp_cont_f, 1);
        this.hFS.setOnClickListener(groupInfoActivity);
        this.hGg.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.hFm = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bjL = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bjL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.geR = groupInfoActivity.findViewById(R.id.group_top_view);
        this.geR.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.hFo = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.hFo.setOnClickListener(groupInfoActivity);
        this.hFp = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.hFq = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.hFH = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.hFH.setOnClickListener(groupInfoActivity);
        this.hFP = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.hFU = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.hFr = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.hFs = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.hGa = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.hFt = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.hFt.setMaxLines(20);
        this.hFt.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void mB(boolean z) {
                if (z) {
                    a.this.hGd.setVisibility(0);
                } else {
                    a.this.hGd.setVisibility(8);
                }
            }
        });
        this.hFv = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.hFu = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.hFv.setOnClickListener(groupInfoActivity);
        this.hFA = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.hFA.setAutoChangeStyle(true);
        this.hFA.setIsRound(false);
        this.hEh = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.hFx = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.hFx.setOnClickListener(groupInfoActivity);
        this.hFE = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.hGc = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.hFz = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.hFv.setOnClickListener(groupInfoActivity);
        this.hFy = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.hFy.setOnClickListener(groupInfoActivity);
        this.hFB = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.hFC = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.hFC.setOnClickListener(groupInfoActivity);
        this.hFI = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.hFK = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.hGf = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.hFL = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.hGf.setOnClickListener(this.hFl);
        this.hFM = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.hFM.setOnClickListener(groupInfoActivity);
        this.hFN = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.hFV = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.hFV.setOnClickListener(groupInfoActivity);
        this.hFW = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.hFX = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.hGb = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.hFY = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.hFY.setOnClickListener(groupInfoActivity);
        this.hFY.setLongClickable(true);
        this.hFY.setOnLongClickListener(groupInfoActivity);
        this.hGd = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.hGd.setClickable(true);
        this.hGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hFt.setMaxLines(1000);
            }
        });
        this.hFZ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.hFZ.setOnLongClickListener(groupInfoActivity);
        this.hGe = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.hFn = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.hFw = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.hFw.setPhotoClickListener(groupInfoActivity);
        this.hFw.setPhotoLongClickListener(groupInfoActivity);
        this.hFw.setVisibility(8);
    }

    public RelativeLayout bWy() {
        return this.hFZ;
    }

    public RelativeLayout bWz() {
        return this.hFv;
    }

    public LinearLayout bWA() {
        return this.hFI;
    }

    public RelativeLayout bWB() {
        return this.hFM;
    }

    public RelativeLayout bWC() {
        return this.hFY;
    }

    public RelativeLayout bWD() {
        return this.hFV;
    }

    public RelativeLayout bWE() {
        return this.hFo;
    }

    public View bWF() {
        return this.hFS;
    }

    public LinearLayout bWG() {
        return this.hGf;
    }

    public RelativeLayout bWH() {
        return this.hFx;
    }

    public RelativeLayout bWI() {
        return this.hFy;
    }

    public RelativeLayout bWJ() {
        return this.hFC;
    }

    public View bVs() {
        return this.htW;
    }

    public void bWK() {
        this.hFn.setVisibility(8);
    }

    public void bWL() {
        this.hFn.setVisibility(0);
    }

    public void n(boolean z, String str) {
        if (z) {
            this.hFs.setText(str);
            this.hFH.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.hFH.setVisibility(8);
        } else {
            this.hFs.setText(str);
            this.hFH.setVisibility(0);
        }
    }

    public void nM(boolean z) {
        if (z) {
            this.hFs.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.hFH.setVisibility(8);
        }
    }

    public RelativeLayout bWM() {
        return this.hFH;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.hGk = aVar.bXv();
            this.hGl = aVar.bXw();
            this.hGi = aVar;
            this.hGj = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bXq() != null) {
                hGm = aVar.bXq().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.hFP.setVisibility(0);
            this.hFK.setVisibility(0);
            if (aVar.getGroup() != null) {
                Dj(aVar.getGroup().getName());
                this.hFr.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.hFE.setVisibility(0);
                } else {
                    this.hFE.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.hFU.setVisibility(0);
                    this.hFA.setVisibility(8);
                    this.hGb.setVisibility(8);
                    this.hGc.setVisibility(8);
                    this.hEh.setText(R.string.group_info_forum_author);
                    this.hFx.setEnabled(false);
                    this.hFE.setVisibility(8);
                } else {
                    this.hFU.setVisibility(8);
                    this.hFA.setVisibility(0);
                    this.hGb.setVisibility(0);
                    this.hGc.setVisibility(0);
                    this.hEh.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.hFx.setEnabled(true);
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
                this.hFT = stringBuffer.toString();
                this.hFs.setText(this.hFT);
                this.hFt.setText(aVar.getGroup().getIntro());
                this.hFB.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.hFA.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.hFv.setVisibility(0);
                    this.hFu.setText(aVar.getGroup().getForumName() + this.hFl.getPageContext().getString(R.string.forum));
                } else {
                    this.hFv.setVisibility(8);
                }
                this.hFz.removeAllViews();
                boolean bXx = aVar.bXx();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.hGh, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.hFl.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.hFz.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.hFl.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.hFz.addView(imageView2);
                }
                if (bXx) {
                    this.hGe.setVisibility(0);
                } else {
                    this.hGe.setVisibility(8);
                }
            }
            if (aVar.bXq() != null) {
                this.hFo.setVisibility(0);
                this.hFm.setVisibility(0);
                GroupActivityData bXq = aVar.bXq();
                if (!aVar.bXv()) {
                    if (bXq.getIsEnd() != 1) {
                        this.hFp.setVisibility(4);
                        this.hFq.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.hFo.setVisibility(8);
                        this.hFm.setVisibility(8);
                    }
                } else {
                    this.hFp.setVisibility(0);
                    this.hFq.setText(bXq.getgActivityTitle());
                    if (bXq.getIsEnd() != 1) {
                        this.hFp.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.hFp, R.color.common_color_10171, 1);
                    } else {
                        this.hFp.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.hFp, R.color.common_color_10168, 1);
                    }
                    this.hFq.setText(bXq.getgActivityTitle());
                }
            } else if (aVar.bXw()) {
                this.hFo.setVisibility(0);
                this.hFm.setVisibility(0);
                this.hFp.setVisibility(4);
                this.hFq.setText(R.string.group_info_create_activity);
            } else {
                this.hFo.setVisibility(8);
                this.hFm.setVisibility(8);
            }
            this.hFI.removeAllViews();
            if (aVar.bXr() != null && aVar.bXr().size() > 0) {
                List<MemberData> bXr = aVar.bXr();
                int size = bXr.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bXr.get(i3);
                    HeadImageView headImageView = this.hFJ[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.hFl.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.hFJ[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.hFI.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bXw()) {
                this.hFH.setEnabled(true);
                this.hFY.setEnabled(true);
                am.setBackgroundResource(this.hFY, R.drawable.group_info_item);
                this.hFV.setVisibility(0);
                this.hGa.setVisibility(0);
                this.hFX.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.hFW.setText(aVar.getGroup().getName());
                }
            } else {
                this.hFH.setEnabled(false);
                this.hFY.setEnabled(true);
                am.setBackgroundColor(this.hFY, R.color.cp_bg_line_d);
                this.hFX.setVisibility(8);
                this.hGa.setVisibility(8);
                this.hFt.setPadding(0, 0, 0, 0);
            }
            if (aVar.bXv()) {
                this.hFN.setVisibility(0);
                this.hGg.setVisibility(0);
                if (this.hFC.getParent() != this.hFN) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.hFP.removeView(this.hFC);
                    this.hFN.addView(this.hFC, 1);
                }
                bWN();
            } else {
                this.hFN.setVisibility(8);
                this.hGg.setVisibility(8);
                if (this.hFC.getParent() != this.hFP) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.hFN.removeView(this.hFC);
                    this.hFP.addView(this.hFC, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.hFy.setVisibility(8);
            } else {
                this.hFy.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                nM(aVar.bXw());
            } else {
                n(aVar.bXw(), this.hFT);
            }
            this.bjL.setVisibility(0);
            this.hFK.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (wK(aVar.getGroup().getFlag())) {
                nN(z);
            } else {
                bWO();
            }
        }
    }

    public void bWN() {
        this.hFL.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.hFL, R.color.cp_cont_a, 1);
        this.hFL.setText(this.hFl.getPageContext().getString(R.string.i_want_talk));
        this.hGf.setEnabled(true);
    }

    private void nN(boolean z) {
        this.hFL.setText(this.hFl.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.hFL.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hFL, R.color.cp_cont_a, 1);
        } else {
            this.hFL.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hFL, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.hGf, R.drawable.btn_blue_bg);
        this.hGf.setEnabled(true);
    }

    private boolean wK(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bWO() {
        this.hFL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.hFL.setText(this.hFl.getPageContext().getString(R.string.group_info_refuse_join));
        this.hFL.setTextColor(this.hFl.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.hGf, R.drawable.btn_app_download_d);
        this.hGf.setEnabled(false);
    }

    public void Dl(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.hFI.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.hFI.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.hFI.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.hFw.setIsManager(aVar.bXw());
            if (aVar.bXw()) {
                this.hFw.setVisibility(0);
                if (aVar.bXs() != null && aVar.bXs().size() == 1 && TextUtils.isEmpty(aVar.bXs().get(0).getPicId())) {
                    this.hFw.setData(null);
                } else {
                    this.hFw.setData(aVar.bXs());
                }
            } else if (aVar.bXs() != null && aVar.bXs().size() > 0) {
                if (aVar.bXs().size() == 1 && TextUtils.isEmpty(aVar.bXs().get(0).getPicId())) {
                    this.hFw.setVisibility(8);
                    return;
                }
                this.hFw.setVisibility(0);
                this.hFw.setData(aVar.bXs());
            } else {
                this.hFw.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.hFR = bVar;
    }

    public void c(Object obj, int i) {
        if (this.hFQ != null) {
            this.hFQ.dismiss();
            this.hFQ = null;
        }
        d(obj, i);
        this.hFQ.showDialog();
    }

    private void d(final Object obj, final int i) {
        if (this.hFQ == null) {
            this.hFQ = new i(this.hFl.getPageContext());
            this.hFQ.a(null, new String[]{this.hFl.getResources().getString(R.string.group_info_set_portrait), this.hFl.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.hFQ != null && a.this.hFQ.isShowing()) {
                        a.this.hFR.a(a.this.hFQ, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.hFw != null) {
            this.hFw.onDestory();
        }
        if (this.hFA != null) {
            this.hFA.stopLoad();
            this.hFA.setBackgroundDrawable(null);
            this.hFA.setImageDrawable(null);
        }
        if (this.hFI != null && this.hFJ != null) {
            int length = this.hFJ.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.hFJ[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void Dm(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.hFl.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hFl.getPageContext().getPageActivity());
            bVar.sT(this.hFl.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.hFl.getSystemService("clipboard")).setText(str);
                        a.this.hFl.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.hFl.getPageContext());
            bVar.aEH();
        }
    }

    public void Dn(String str) {
        if (this.hFO == null) {
            Do(str);
        }
        this.hFO.aEH();
    }

    private void Do(final String str) {
        if (this.hFO == null) {
            this.hFO = new com.baidu.tbadk.core.dialog.b(this.hFl.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.hFl.getPageContext().getString(R.string.copy_group_number)};
            this.hFO.sT(this.hFl.getPageContext().getString(R.string.operation));
            this.hFO.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.hFl.getSystemService("clipboard")).setText(str);
                        a.this.hFl.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.hFO.d(this.hFl.getPageContext());
        }
    }

    public void bWP() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.hFL.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.hFL.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.hFl.getLayoutMode().setNightMode(i == 1);
        this.hFl.getLayoutMode().onModeChanged(this.mContainer);
        this.hFl.getLayoutMode().onModeChanged(this.hFF);
        this.hFw.a(i, this.hFl);
        this.mNavigationBar.onChangeSkinType(this.hFl.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.hGh, R.color.common_color_10009, 1);
        }
        if (!this.hGk) {
            b(this.hGi, this.hGj);
        }
        if (this.hGl) {
            am.setBackgroundResource(this.hFY, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.hFY, R.color.cp_bg_line_d);
        }
    }

    public void nO(boolean z) {
        this.hGk = z;
    }
}
