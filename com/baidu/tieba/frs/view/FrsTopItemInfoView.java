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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
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
    private RankStarView fgw;
    private HeadImageView jRA;
    private TextView jRB;
    private ImageView jRC;
    private double jRD;
    private double jRE;
    private View.OnClickListener jRJ;
    private View.OnClickListener jRK;
    private TextView jRr;
    private View jRs;
    private TextView jRt;
    private ImageView jRu;
    private TextView jRv;
    private TextView jRw;
    private ItemTableView jRx;
    private TextView jRy;
    private RelativeLayout jRz;
    private ItemInfo jpt;
    private ForumWriteData jtt;
    private View mBottomLine;
    private Context mContext;
    private static final String jRF = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jRG = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int jRH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int jvv = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int jRI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int izj = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jRJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(FrsTopItemInfoView.this.mContext) && !WriteActivityConfig.isAsyncWriting() && FrsTopItemInfoView.this.jpt != null) {
                    WriteActivityConfig.newInstance((Activity) FrsTopItemInfoView.this.mContext).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.jpt)).setItemIsSchool(FrsTopItemInfoView.this.jpt.is_school.intValue() == 1).setStarCount(FrsTopItemInfoView.this.jpt.score != null ? FrsTopItemInfoView.this.jpt.score.comment_star.intValue() : 0).send();
                }
            }
        };
        this.jRK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.Au(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).bqx();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.jRr = (TextView) findViewById(R.id.item_title_name);
        this.jRs = findViewById(R.id.item_split);
        this.jRt = (TextView) findViewById(R.id.item_title_value);
        this.jRu = (ImageView) findViewById(R.id.icon_question);
        this.jRu.setOnClickListener(this.jRK);
        this.jRv = (TextView) findViewById(R.id.big_score);
        this.jRw = (TextView) findViewById(R.id.people_num);
        this.jRx = (ItemTableView) findViewById(R.id.item_table);
        this.jRy = (TextView) findViewById(R.id.time_score);
        this.jRz = (RelativeLayout) findViewById(R.id.evaluate_container);
        this.jRA = (HeadImageView) findViewById(R.id.user_head);
        this.jRB = (TextView) findViewById(R.id.click_tip);
        this.fgw = (RankStarView) findViewById(R.id.star_view);
        this.jRC = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.jRr.setText(R.string.frs_evaluate_item_title);
        this.jRB.setText(R.string.frs_evaluate_click_tip);
        this.jRv.setText(R.string.frs_evaluate_exception);
        if (g.isXiaoMi()) {
            this.jRv.setPadding(0, -jRH, 0, 0);
        }
        this.jRA.setPlaceHolder(1);
        this.fgw.setStarSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.jRz.setOnClickListener(this.jRJ);
    }

    public void setData(ItemInfo itemInfo) {
        this.jpt = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.jRt.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jRD = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jRE = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jRA.startLoad(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jRv.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jRw.getLayoutParams();
            if (this.jRD <= 0.0d || this.jRD > 10.0d) {
                this.jRv.setText(R.string.frs_evaluate_exception);
                this.jRv.setTextSize(0, izj);
                layoutParams.topMargin = jRI;
                layoutParams.height = izj;
                this.jRv.setLayoutParams(layoutParams);
                layoutParams2.topMargin = jvv;
                this.jRw.setGravity(17);
                this.jRw.setLayoutParams(layoutParams2);
                this.jRw.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.fgw.setStarCount(0.0f);
                this.jRy.setVisibility(8);
                this.jRs.setVisibility(8);
                this.jRx.clear();
                return;
            }
            this.jRv.setText(String.valueOf(this.jRD));
            this.jRw.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{au.ed(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.fgw.setStarCount(itemTable.comment_star.intValue());
            }
            this.jRs.setVisibility(0);
            this.jRy.setVisibility(0);
            this.jRy.setText(w(this.jRE), TextView.BufferType.SPANNABLE);
            this.jRx.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder w(double d) {
        return new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", jRG, Double.valueOf(d), jRF));
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.br(this).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRr).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        ap.setBackgroundColor(this.jRs, R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRt).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRv).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        ap.setViewTextColor(this.jRw, R.color.CAM_X0109, 1);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRy).nY(R.color.CAM_X0109).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRB).oa(R.string.F_X01).nY(R.color.CAM_X0105);
        this.jRx.onChangeSkinType();
        this.fgw.buZ();
        SvgManager.bsR().a(this.jRC, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0210);
        SvgManager.bsR().a(this.jRu, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.jtt = forumWriteData;
    }
}
