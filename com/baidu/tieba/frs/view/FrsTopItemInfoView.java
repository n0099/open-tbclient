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
    private TextView jRF;
    private View jRG;
    private TextView jRH;
    private ImageView jRI;
    private TextView jRJ;
    private TextView jRK;
    private ItemTableView jRL;
    private TextView jRM;
    private RelativeLayout jRN;
    private HeadImageView jRO;
    private TextView jRP;
    private ImageView jRQ;
    private double jRR;
    private double jRS;
    private View.OnClickListener jRX;
    private View.OnClickListener jRY;
    private ItemInfo jpH;
    private ForumWriteData jtH;
    private View mBottomLine;
    private Context mContext;
    private static final String jRT = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jRU = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int jRV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int jvJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int jRW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int izx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jRX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(FrsTopItemInfoView.this.mContext) && !WriteActivityConfig.isAsyncWriting() && FrsTopItemInfoView.this.jpH != null) {
                    WriteActivityConfig.newInstance((Activity) FrsTopItemInfoView.this.mContext).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.jpH)).setItemIsSchool(FrsTopItemInfoView.this.jpH.is_school.intValue() == 1).setStarCount(FrsTopItemInfoView.this.jpH.score != null ? FrsTopItemInfoView.this.jpH.score.comment_star.intValue() : 0).send();
                }
            }
        };
        this.jRY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
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
        this.jRF = (TextView) findViewById(R.id.item_title_name);
        this.jRG = findViewById(R.id.item_split);
        this.jRH = (TextView) findViewById(R.id.item_title_value);
        this.jRI = (ImageView) findViewById(R.id.icon_question);
        this.jRI.setOnClickListener(this.jRY);
        this.jRJ = (TextView) findViewById(R.id.big_score);
        this.jRK = (TextView) findViewById(R.id.people_num);
        this.jRL = (ItemTableView) findViewById(R.id.item_table);
        this.jRM = (TextView) findViewById(R.id.time_score);
        this.jRN = (RelativeLayout) findViewById(R.id.evaluate_container);
        this.jRO = (HeadImageView) findViewById(R.id.user_head);
        this.jRP = (TextView) findViewById(R.id.click_tip);
        this.fgw = (RankStarView) findViewById(R.id.star_view);
        this.jRQ = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.jRF.setText(R.string.frs_evaluate_item_title);
        this.jRP.setText(R.string.frs_evaluate_click_tip);
        this.jRJ.setText(R.string.frs_evaluate_exception);
        if (g.isXiaoMi()) {
            this.jRJ.setPadding(0, -jRV, 0, 0);
        }
        this.jRO.setPlaceHolder(1);
        this.fgw.setStarSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.jRN.setOnClickListener(this.jRX);
    }

    public void setData(ItemInfo itemInfo) {
        this.jpH = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.jRH.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jRR = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jRS = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jRO.startLoad(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jRJ.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jRK.getLayoutParams();
            if (this.jRR <= 0.0d || this.jRR > 10.0d) {
                this.jRJ.setText(R.string.frs_evaluate_exception);
                this.jRJ.setTextSize(0, izx);
                layoutParams.topMargin = jRW;
                layoutParams.height = izx;
                this.jRJ.setLayoutParams(layoutParams);
                layoutParams2.topMargin = jvJ;
                this.jRK.setGravity(17);
                this.jRK.setLayoutParams(layoutParams2);
                this.jRK.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.fgw.setStarCount(0.0f);
                this.jRM.setVisibility(8);
                this.jRG.setVisibility(8);
                this.jRL.clear();
                return;
            }
            this.jRJ.setText(String.valueOf(this.jRR));
            this.jRK.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{au.ed(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.fgw.setStarCount(itemTable.comment_star.intValue());
            }
            this.jRG.setVisibility(0);
            this.jRM.setVisibility(0);
            this.jRM.setText(w(this.jRS), TextView.BufferType.SPANNABLE);
            this.jRL.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder w(double d) {
        return new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", jRU, Double.valueOf(d), jRT));
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.br(this).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRF).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        ap.setBackgroundColor(this.jRG, R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRH).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRJ).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        ap.setViewTextColor(this.jRK, R.color.CAM_X0109, 1);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRM).nY(R.color.CAM_X0109).oa(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jRP).oa(R.string.F_X01).nY(R.color.CAM_X0105);
        this.jRL.onChangeSkinType();
        this.fgw.buZ();
        SvgManager.bsR().a(this.jRQ, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0210);
        SvgManager.bsR().a(this.jRI, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.jtH = forumWriteData;
    }
}
