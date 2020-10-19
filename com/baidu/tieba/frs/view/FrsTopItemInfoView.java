package com.baidu.tieba.frs.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UniversityEvaluationConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.view.RoundRelativeLayout;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes22.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView eEJ;
    private ForumWriteData iBQ;
    private TextView iVN;
    private View iVO;
    private TextView iVP;
    private ImageView iVQ;
    private TextView iVR;
    private TextView iVS;
    private ItemTableView iVT;
    private TextView iVU;
    private RoundRelativeLayout iVV;
    private HeadImageView iVW;
    private TextView iVX;
    private ImageView iVY;
    private double iVZ;
    private double iWa;
    private View.OnClickListener iWk;
    private View.OnClickListener iWl;
    private ItemInfo iyc;
    private View mBottomLine;
    private Context mContext;
    private static final String iWb = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String iWc = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int iWd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int agr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12);
    private static final int iWe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds14);
    private static final int iWf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int iWg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int iWh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int iWi = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30);
    private static final int hHS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int iWj = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds124);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iWk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.iBQ);
                    if (FrsTopItemInfoView.this.iyc != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.iyc));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.iyc.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        this.iWl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.AH(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).bkJ();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.iVN = (TextView) findViewById(R.id.item_title_name);
        this.iVO = findViewById(R.id.item_split);
        this.iVP = (TextView) findViewById(R.id.item_title_value);
        this.iVQ = (ImageView) findViewById(R.id.icon_question);
        this.iVQ.setOnClickListener(this.iWl);
        this.iVR = (TextView) findViewById(R.id.big_score);
        this.iVS = (TextView) findViewById(R.id.people_num);
        this.iVT = (ItemTableView) findViewById(R.id.item_table);
        this.iVU = (TextView) findViewById(R.id.time_score);
        this.iVV = (RoundRelativeLayout) findViewById(R.id.evaluate_container);
        this.iVW = (HeadImageView) findViewById(R.id.user_head);
        this.iVX = (TextView) findViewById(R.id.click_tip);
        this.eEJ = (RankStarView) findViewById(R.id.star_view);
        this.iVY = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.iVN.setText(R.string.frs_evaluate_item_title);
        this.iVX.setText(R.string.frs_evaluate_click_tip);
        this.iVR.setTextSize(0, hHS);
        this.iVR.setText(R.string.frs_evaluate_exception);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iVR.getLayoutParams();
        layoutParams.topMargin = iWh;
        layoutParams.height = hHS;
        this.iVR.setLayoutParams(layoutParams);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.iVR.setPadding(0, -iWd, 0, 0);
        }
        this.iVV.setRoundLayoutRadius(new float[]{iWi, iWi, iWi, iWi, iWi, iWi, iWi, iWi});
        this.iVW.setPlaceHolder(1);
        this.eEJ.setStarSpacing(iWg);
        this.iVV.setOnClickListener(this.iWk);
    }

    public void setData(ItemInfo itemInfo) {
        this.iyc = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.iVP.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.iVZ = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.iWa = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.iVW.startLoad(currentPortrait, 12, false);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iVR.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iVS.getLayoutParams();
            if (this.iVZ <= 0.0d || this.iVZ > 10.0d) {
                this.iVR.setText(R.string.frs_evaluate_exception);
                this.iVR.setTextSize(0, hHS);
                layoutParams.topMargin = iWh;
                layoutParams.height = hHS;
                this.iVR.setLayoutParams(layoutParams);
                layoutParams2.topMargin = iWf;
                layoutParams2.addRule(5, R.id.big_score);
                this.iVS.setGravity(17);
                this.iVS.setLayoutParams(layoutParams2);
                this.iVS.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.eEJ.setStarCount(0);
                this.iVU.setVisibility(8);
                this.iVT.clear();
                return;
            }
            this.iVR.setText(this.iVZ + "");
            this.iVR.setTextSize(0, iWj);
            layoutParams.topMargin = agr;
            layoutParams.height = iWj;
            this.iVR.setLayoutParams(layoutParams);
            layoutParams2.topMargin = iWe;
            layoutParams2.addRule(5, R.id.big_score);
            this.iVS.setGravity(17);
            this.iVS.setLayoutParams(layoutParams2);
            this.iVS.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{at.da(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.eEJ.setStarCount(itemTable.comment_star.intValue());
            }
            this.iVU.setVisibility(0);
            this.iVU.setText(B(this.iWa), TextView.BufferType.SPANNABLE);
            this.iVT.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder B(double d) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(iWc);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(d + iWb);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.iVN, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.iVO, R.color.cp_cont_d);
        ap.setViewTextColor(this.iVP, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iVR, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iVS, R.color.cp_cont_b, 1);
        this.iVT.onChangeSkinType();
        this.iVU.setText(B(this.iWa));
        ap.setBackgroundColor(this.iVV, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.iVX, R.color.cp_cont_j, 1);
        this.eEJ.boV();
        SvgManager.bmU().a(this.iVY, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_b);
        SvgManager.bmU().a(this.iVQ, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.iBQ = forumWriteData;
    }
}
