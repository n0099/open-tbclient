package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.SerializableItemInfo;
import java.util.List;
import java.util.Locale;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes2.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView fiS;
    private TextView jPa;
    private View jPb;
    private TextView jPc;
    private ImageView jPd;
    private TextView jPe;
    private TextView jPf;
    private ItemTableView jPg;
    private TextView jPh;
    private RelativeLayout jPi;
    private HeadImageView jPj;
    private TextView jPk;
    private ImageView jPl;
    private double jPm;
    private double jPn;
    private View.OnClickListener jPs;
    private View.OnClickListener jPt;
    private ItemInfo jot;
    private ForumWriteData jst;
    private View mBottomLine;
    private Context mContext;
    private static final String jPo = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jPp = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int jPq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int juv = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int jPr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int iyg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jPs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(FrsTopItemInfoView.this.mContext) && !WriteActivityConfig.isAsyncWriting() && FrsTopItemInfoView.this.jot != null) {
                    WriteActivityConfig.newInstance((Activity) FrsTopItemInfoView.this.mContext).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.jot)).setItemIsSchool(FrsTopItemInfoView.this.jot.is_school.intValue() == 1).setStarCount(FrsTopItemInfoView.this.jot.score != null ? FrsTopItemInfoView.this.jot.score.comment_star.intValue() : 0).send();
                }
            }
        };
        this.jPt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.Bo(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).btY();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.jPa = (TextView) findViewById(R.id.item_title_name);
        this.jPb = findViewById(R.id.item_split);
        this.jPc = (TextView) findViewById(R.id.item_title_value);
        this.jPd = (ImageView) findViewById(R.id.icon_question);
        this.jPd.setOnClickListener(this.jPt);
        this.jPe = (TextView) findViewById(R.id.big_score);
        this.jPf = (TextView) findViewById(R.id.people_num);
        this.jPg = (ItemTableView) findViewById(R.id.item_table);
        this.jPh = (TextView) findViewById(R.id.time_score);
        this.jPi = (RelativeLayout) findViewById(R.id.evaluate_container);
        this.jPj = (HeadImageView) findViewById(R.id.user_head);
        this.jPk = (TextView) findViewById(R.id.click_tip);
        this.fiS = (RankStarView) findViewById(R.id.star_view);
        this.jPl = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.jPa.setText(R.string.frs_evaluate_item_title);
        this.jPk.setText(R.string.frs_evaluate_click_tip);
        this.jPe.setText(R.string.frs_evaluate_exception);
        if (g.isXiaoMi()) {
            this.jPe.setPadding(0, -jPq, 0, 0);
        }
        this.jPj.setPlaceHolder(1);
        this.fiS.setStarSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.jPi.setOnClickListener(this.jPs);
    }

    public void setData(ItemInfo itemInfo) {
        this.jot = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.jPc.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jPm = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jPn = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jPj.startLoad(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jPe.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jPf.getLayoutParams();
            if (this.jPm <= 0.0d || this.jPm > 10.0d) {
                this.jPe.setText(R.string.frs_evaluate_exception);
                this.jPe.setTextSize(0, iyg);
                layoutParams.topMargin = jPr;
                layoutParams.height = iyg;
                this.jPe.setLayoutParams(layoutParams);
                layoutParams2.topMargin = juv;
                this.jPf.setGravity(17);
                this.jPf.setLayoutParams(layoutParams2);
                this.jPf.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.fiS.setStarCount(0.0f);
                this.jPh.setVisibility(8);
                this.jPb.setVisibility(8);
                this.jPg.clear();
                return;
            }
            this.jPe.setText(String.valueOf(this.jPm));
            this.jPf.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{at.dX(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.fiS.setStarCount(itemTable.comment_star.intValue());
            }
            this.jPb.setVisibility(0);
            this.jPh.setVisibility(0);
            this.jPh.setText(C(this.jPn), TextView.BufferType.SPANNABLE);
            this.jPg.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder C(double d) {
        return new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", jPp, Double.valueOf(d), jPo));
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.bv(this).pK(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jPa).pE(R.string.F_X02).pC(R.color.CAM_X0105);
        ao.setBackgroundColor(this.jPb, R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jPc).pE(R.string.F_X02).pC(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jPe).pE(R.string.F_X02).pC(R.color.CAM_X0105);
        ao.setViewTextColor(this.jPf, R.color.CAM_X0109, 1);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jPh).pC(R.color.CAM_X0109).pE(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jPk).pE(R.string.F_X01).pC(R.color.CAM_X0105);
        this.jPg.onChangeSkinType();
        this.fiS.byz();
        SvgManager.bwr().a(this.jPl, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0210);
        SvgManager.bwr().a(this.jPd, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.jst = forumWriteData;
    }
}
