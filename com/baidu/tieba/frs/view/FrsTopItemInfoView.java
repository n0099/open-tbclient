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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UniversityEvaluationConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
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
    private RankStarView egI;
    private ItemInfo hNQ;
    private ForumWriteData hRH;
    private TextView ilA;
    private RoundRelativeLayout ilB;
    private HeadImageView ilC;
    private TextView ilD;
    private ImageView ilE;
    private double ilF;
    private double ilG;
    private View.OnClickListener ilQ;
    private View.OnClickListener ilR;
    private TextView ilt;
    private View ilu;
    private TextView ilv;
    private ImageView ilw;
    private TextView ilx;
    private TextView ily;
    private ItemTableView ilz;
    private View mBottomLine;
    private Context mContext;
    private static final String ilH = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String ilI = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int ilJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int eTZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12);
    private static final int ilK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds14);
    private static final int ilL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int ilM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int ilN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int ilO = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30);
    private static final int gYY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int ilP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds124);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bf.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.hRH);
                    if (FrsTopItemInfoView.this.hNQ != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.hNQ));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.hNQ.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        this.ilR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.xl(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).aYL();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.ilt = (TextView) findViewById(R.id.item_title_name);
        this.ilu = findViewById(R.id.item_split);
        this.ilv = (TextView) findViewById(R.id.item_title_value);
        this.ilw = (ImageView) findViewById(R.id.icon_question);
        this.ilw.setOnClickListener(this.ilR);
        this.ilx = (TextView) findViewById(R.id.big_score);
        this.ily = (TextView) findViewById(R.id.people_num);
        this.ilz = (ItemTableView) findViewById(R.id.item_table);
        this.ilA = (TextView) findViewById(R.id.time_score);
        this.ilB = (RoundRelativeLayout) findViewById(R.id.evaluate_container);
        this.ilC = (HeadImageView) findViewById(R.id.user_head);
        this.ilD = (TextView) findViewById(R.id.click_tip);
        this.egI = (RankStarView) findViewById(R.id.star_view);
        this.ilE = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.ilt.setText(R.string.frs_evaluate_item_title);
        this.ilD.setText(R.string.frs_evaluate_click_tip);
        this.ilx.setTextSize(0, gYY);
        this.ilx.setText(R.string.frs_evaluate_exception);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilx.getLayoutParams();
        layoutParams.topMargin = ilN;
        layoutParams.height = gYY;
        this.ilx.setLayoutParams(layoutParams);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.ilx.setPadding(0, -ilJ, 0, 0);
        }
        this.ilB.setRoundLayoutRadius(new float[]{ilO, ilO, ilO, ilO, ilO, ilO, ilO, ilO});
        this.ilC.setPlaceHolder(1);
        this.egI.setStarSpacing(ilM);
        this.ilB.setOnClickListener(this.ilQ);
    }

    public void setData(ItemInfo itemInfo) {
        this.hNQ = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.ilv.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if (SchemeCollecter.CLASSIFY_ALL.equals(itemPoint.time_intval)) {
                            this.ilF = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.ilG = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.ilC.startLoad(currentPortrait, 12, false);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilx.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ily.getLayoutParams();
            if (this.ilF <= 0.0d || this.ilF > 10.0d) {
                this.ilx.setText(R.string.frs_evaluate_exception);
                this.ilx.setTextSize(0, gYY);
                layoutParams.topMargin = ilN;
                layoutParams.height = gYY;
                this.ilx.setLayoutParams(layoutParams);
                layoutParams2.topMargin = ilL;
                layoutParams2.addRule(5, R.id.big_score);
                this.ily.setGravity(17);
                this.ily.setLayoutParams(layoutParams2);
                this.ily.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.egI.setStarCount(0);
                this.ilA.setVisibility(8);
                this.ilz.clear();
                return;
            }
            this.ilx.setText(this.ilF + "");
            this.ilx.setTextSize(0, ilP);
            layoutParams.topMargin = eTZ;
            layoutParams.height = ilP;
            this.ilx.setLayoutParams(layoutParams);
            layoutParams2.topMargin = ilK;
            layoutParams2.addRule(5, R.id.big_score);
            this.ily.setGravity(17);
            this.ily.setLayoutParams(layoutParams2);
            this.ily.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{as.cG(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.egI.setStarCount(itemTable.comment_star.intValue());
            }
            this.ilA.setVisibility(0);
            this.ilA.setText(s(this.ilG), TextView.BufferType.SPANNABLE);
            this.ilz.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder s(double d) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ilI);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(d + ilH);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.ilt, R.color.cp_cont_b, 1);
        ao.setBackgroundColor(this.ilu, R.color.cp_cont_d);
        ao.setViewTextColor(this.ilv, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.ilx, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.ily, R.color.cp_cont_b, 1);
        this.ilz.onChangeSkinType();
        this.ilA.setText(s(this.ilG));
        ao.setBackgroundColor(this.ilB, R.color.cp_bg_line_g);
        ao.setViewTextColor(this.ilD, R.color.cp_cont_j, 1);
        this.egI.bcT();
        SvgManager.baR().a(this.ilE, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_b);
        SvgManager.baR().a(this.ilw, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.hRH = forumWriteData;
    }
}
