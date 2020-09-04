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
/* loaded from: classes16.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView eqt;
    private View.OnClickListener iAa;
    private ItemInfo icb;
    private ForumWriteData ifV;
    private TextView izC;
    private View izD;
    private TextView izE;
    private ImageView izF;
    private TextView izG;
    private TextView izH;
    private ItemTableView izI;
    private TextView izJ;
    private RoundRelativeLayout izK;
    private HeadImageView izL;
    private TextView izM;
    private ImageView izN;
    private double izO;
    private double izP;
    private View.OnClickListener izZ;
    private View mBottomLine;
    private Context mContext;
    private static final String izQ = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String izR = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int izS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int feK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12);
    private static final int izT = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds14);
    private static final int izU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int izV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int izW = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int izX = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30);
    private static final int hlV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int izY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds124);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.izZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.ifV);
                    if (FrsTopItemInfoView.this.icb != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.icb));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.icb.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        this.iAa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.zA(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).bhg();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.izC = (TextView) findViewById(R.id.item_title_name);
        this.izD = findViewById(R.id.item_split);
        this.izE = (TextView) findViewById(R.id.item_title_value);
        this.izF = (ImageView) findViewById(R.id.icon_question);
        this.izF.setOnClickListener(this.iAa);
        this.izG = (TextView) findViewById(R.id.big_score);
        this.izH = (TextView) findViewById(R.id.people_num);
        this.izI = (ItemTableView) findViewById(R.id.item_table);
        this.izJ = (TextView) findViewById(R.id.time_score);
        this.izK = (RoundRelativeLayout) findViewById(R.id.evaluate_container);
        this.izL = (HeadImageView) findViewById(R.id.user_head);
        this.izM = (TextView) findViewById(R.id.click_tip);
        this.eqt = (RankStarView) findViewById(R.id.star_view);
        this.izN = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.izC.setText(R.string.frs_evaluate_item_title);
        this.izM.setText(R.string.frs_evaluate_click_tip);
        this.izG.setTextSize(0, hlV);
        this.izG.setText(R.string.frs_evaluate_exception);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.izG.getLayoutParams();
        layoutParams.topMargin = izW;
        layoutParams.height = hlV;
        this.izG.setLayoutParams(layoutParams);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.izG.setPadding(0, -izS, 0, 0);
        }
        this.izK.setRoundLayoutRadius(new float[]{izX, izX, izX, izX, izX, izX, izX, izX});
        this.izL.setPlaceHolder(1);
        this.eqt.setStarSpacing(izV);
        this.izK.setOnClickListener(this.izZ);
    }

    public void setData(ItemInfo itemInfo) {
        this.icb = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.izE.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.izO = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.izP = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.izL.startLoad(currentPortrait, 12, false);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.izG.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.izH.getLayoutParams();
            if (this.izO <= 0.0d || this.izO > 10.0d) {
                this.izG.setText(R.string.frs_evaluate_exception);
                this.izG.setTextSize(0, hlV);
                layoutParams.topMargin = izW;
                layoutParams.height = hlV;
                this.izG.setLayoutParams(layoutParams);
                layoutParams2.topMargin = izU;
                layoutParams2.addRule(5, R.id.big_score);
                this.izH.setGravity(17);
                this.izH.setLayoutParams(layoutParams2);
                this.izH.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.eqt.setStarCount(0);
                this.izJ.setVisibility(8);
                this.izI.clear();
                return;
            }
            this.izG.setText(this.izO + "");
            this.izG.setTextSize(0, izY);
            layoutParams.topMargin = feK;
            layoutParams.height = izY;
            this.izG.setLayoutParams(layoutParams);
            layoutParams2.topMargin = izT;
            layoutParams2.addRule(5, R.id.big_score);
            this.izH.setGravity(17);
            this.izH.setLayoutParams(layoutParams2);
            this.izH.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{at.cR(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.eqt.setStarCount(itemTable.comment_star.intValue());
            }
            this.izJ.setVisibility(0);
            this.izJ.setText(y(this.izP), TextView.BufferType.SPANNABLE);
            this.izI.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder y(double d) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(izR);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(d + izQ);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.izC, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.izD, R.color.cp_cont_d);
        ap.setViewTextColor(this.izE, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.izG, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.izH, R.color.cp_cont_b, 1);
        this.izI.onChangeSkinType();
        this.izJ.setText(y(this.izP));
        ap.setBackgroundColor(this.izK, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.izM, R.color.cp_cont_j, 1);
        this.eqt.blq();
        SvgManager.bjq().a(this.izN, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_b);
        SvgManager.bjq().a(this.izF, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.ifV = forumWriteData;
    }
}
