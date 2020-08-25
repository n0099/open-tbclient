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
    private RankStarView eqp;
    private ItemInfo ibV;
    private ForumWriteData ifP;
    private TextView izA;
    private TextView izB;
    private ItemTableView izC;
    private TextView izD;
    private RoundRelativeLayout izE;
    private HeadImageView izF;
    private TextView izG;
    private ImageView izH;
    private double izI;
    private double izJ;
    private View.OnClickListener izT;
    private View.OnClickListener izU;
    private TextView izw;
    private View izx;
    private TextView izy;
    private ImageView izz;
    private View mBottomLine;
    private Context mContext;
    private static final String izK = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String izL = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int izM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int feG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12);
    private static final int izN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds14);
    private static final int izO = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int izP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int izQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int izR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30);
    private static final int hlR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int izS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds124);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.izT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.ifP);
                    if (FrsTopItemInfoView.this.ibV != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.ibV));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.ibV.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        this.izU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.zz(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
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
        this.izw = (TextView) findViewById(R.id.item_title_name);
        this.izx = findViewById(R.id.item_split);
        this.izy = (TextView) findViewById(R.id.item_title_value);
        this.izz = (ImageView) findViewById(R.id.icon_question);
        this.izz.setOnClickListener(this.izU);
        this.izA = (TextView) findViewById(R.id.big_score);
        this.izB = (TextView) findViewById(R.id.people_num);
        this.izC = (ItemTableView) findViewById(R.id.item_table);
        this.izD = (TextView) findViewById(R.id.time_score);
        this.izE = (RoundRelativeLayout) findViewById(R.id.evaluate_container);
        this.izF = (HeadImageView) findViewById(R.id.user_head);
        this.izG = (TextView) findViewById(R.id.click_tip);
        this.eqp = (RankStarView) findViewById(R.id.star_view);
        this.izH = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.izw.setText(R.string.frs_evaluate_item_title);
        this.izG.setText(R.string.frs_evaluate_click_tip);
        this.izA.setTextSize(0, hlR);
        this.izA.setText(R.string.frs_evaluate_exception);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.izA.getLayoutParams();
        layoutParams.topMargin = izQ;
        layoutParams.height = hlR;
        this.izA.setLayoutParams(layoutParams);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.izA.setPadding(0, -izM, 0, 0);
        }
        this.izE.setRoundLayoutRadius(new float[]{izR, izR, izR, izR, izR, izR, izR, izR});
        this.izF.setPlaceHolder(1);
        this.eqp.setStarSpacing(izP);
        this.izE.setOnClickListener(this.izT);
    }

    public void setData(ItemInfo itemInfo) {
        this.ibV = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.izy.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.izI = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.izJ = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.izF.startLoad(currentPortrait, 12, false);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.izA.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.izB.getLayoutParams();
            if (this.izI <= 0.0d || this.izI > 10.0d) {
                this.izA.setText(R.string.frs_evaluate_exception);
                this.izA.setTextSize(0, hlR);
                layoutParams.topMargin = izQ;
                layoutParams.height = hlR;
                this.izA.setLayoutParams(layoutParams);
                layoutParams2.topMargin = izO;
                layoutParams2.addRule(5, R.id.big_score);
                this.izB.setGravity(17);
                this.izB.setLayoutParams(layoutParams2);
                this.izB.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.eqp.setStarCount(0);
                this.izD.setVisibility(8);
                this.izC.clear();
                return;
            }
            this.izA.setText(this.izI + "");
            this.izA.setTextSize(0, izS);
            layoutParams.topMargin = feG;
            layoutParams.height = izS;
            this.izA.setLayoutParams(layoutParams);
            layoutParams2.topMargin = izN;
            layoutParams2.addRule(5, R.id.big_score);
            this.izB.setGravity(17);
            this.izB.setLayoutParams(layoutParams2);
            this.izB.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{at.cR(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.eqp.setStarCount(itemTable.comment_star.intValue());
            }
            this.izD.setVisibility(0);
            this.izD.setText(y(this.izJ), TextView.BufferType.SPANNABLE);
            this.izC.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder y(double d) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(izL);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(d + izK);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.izw, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.izx, R.color.cp_cont_d);
        ap.setViewTextColor(this.izy, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.izA, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.izB, R.color.cp_cont_b, 1);
        this.izC.onChangeSkinType();
        this.izD.setText(y(this.izJ));
        ap.setBackgroundColor(this.izE, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.izG, R.color.cp_cont_j, 1);
        this.eqp.blq();
        SvgManager.bjq().a(this.izH, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_b);
        SvgManager.bjq().a(this.izz, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.ifP = forumWriteData;
    }
}
