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
/* loaded from: classes21.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView esy;
    private TextView iGX;
    private View iGY;
    private TextView iGZ;
    private ImageView iHa;
    private TextView iHb;
    private TextView iHc;
    private ItemTableView iHd;
    private TextView iHe;
    private RoundRelativeLayout iHf;
    private HeadImageView iHg;
    private TextView iHh;
    private ImageView iHi;
    private double iHj;
    private double iHk;
    private View.OnClickListener iHu;
    private View.OnClickListener iHv;
    private ItemInfo ijf;
    private ForumWriteData imW;
    private View mBottomLine;
    private Context mContext;
    private static final String iHl = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String iHm = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int iHn = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int afZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12);
    private static final int iHo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds14);
    private static final int iHp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int iHq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int iHr = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int iHs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30);
    private static final int hsY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int iHt = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds124);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iHu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.imW);
                    if (FrsTopItemInfoView.this.ijf != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.ijf));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.ijf.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        this.iHv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.zV(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).bia();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.iGX = (TextView) findViewById(R.id.item_title_name);
        this.iGY = findViewById(R.id.item_split);
        this.iGZ = (TextView) findViewById(R.id.item_title_value);
        this.iHa = (ImageView) findViewById(R.id.icon_question);
        this.iHa.setOnClickListener(this.iHv);
        this.iHb = (TextView) findViewById(R.id.big_score);
        this.iHc = (TextView) findViewById(R.id.people_num);
        this.iHd = (ItemTableView) findViewById(R.id.item_table);
        this.iHe = (TextView) findViewById(R.id.time_score);
        this.iHf = (RoundRelativeLayout) findViewById(R.id.evaluate_container);
        this.iHg = (HeadImageView) findViewById(R.id.user_head);
        this.iHh = (TextView) findViewById(R.id.click_tip);
        this.esy = (RankStarView) findViewById(R.id.star_view);
        this.iHi = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.iGX.setText(R.string.frs_evaluate_item_title);
        this.iHh.setText(R.string.frs_evaluate_click_tip);
        this.iHb.setTextSize(0, hsY);
        this.iHb.setText(R.string.frs_evaluate_exception);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iHb.getLayoutParams();
        layoutParams.topMargin = iHr;
        layoutParams.height = hsY;
        this.iHb.setLayoutParams(layoutParams);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.iHb.setPadding(0, -iHn, 0, 0);
        }
        this.iHf.setRoundLayoutRadius(new float[]{iHs, iHs, iHs, iHs, iHs, iHs, iHs, iHs});
        this.iHg.setPlaceHolder(1);
        this.esy.setStarSpacing(iHq);
        this.iHf.setOnClickListener(this.iHu);
    }

    public void setData(ItemInfo itemInfo) {
        this.ijf = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.iGZ.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.iHj = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.iHk = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.iHg.startLoad(currentPortrait, 12, false);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iHb.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iHc.getLayoutParams();
            if (this.iHj <= 0.0d || this.iHj > 10.0d) {
                this.iHb.setText(R.string.frs_evaluate_exception);
                this.iHb.setTextSize(0, hsY);
                layoutParams.topMargin = iHr;
                layoutParams.height = hsY;
                this.iHb.setLayoutParams(layoutParams);
                layoutParams2.topMargin = iHp;
                layoutParams2.addRule(5, R.id.big_score);
                this.iHc.setGravity(17);
                this.iHc.setLayoutParams(layoutParams2);
                this.iHc.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.esy.setStarCount(0);
                this.iHe.setVisibility(8);
                this.iHd.clear();
                return;
            }
            this.iHb.setText(this.iHj + "");
            this.iHb.setTextSize(0, iHt);
            layoutParams.topMargin = afZ;
            layoutParams.height = iHt;
            this.iHb.setLayoutParams(layoutParams);
            layoutParams2.topMargin = iHo;
            layoutParams2.addRule(5, R.id.big_score);
            this.iHc.setGravity(17);
            this.iHc.setLayoutParams(layoutParams2);
            this.iHc.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{at.cS(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.esy.setStarCount(itemTable.comment_star.intValue());
            }
            this.iHe.setVisibility(0);
            this.iHe.setText(y(this.iHk), TextView.BufferType.SPANNABLE);
            this.iHd.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder y(double d) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(iHm);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(d + iHl);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.iGX, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.iGY, R.color.cp_cont_d);
        ap.setViewTextColor(this.iGZ, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iHb, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iHc, R.color.cp_cont_b, 1);
        this.iHd.onChangeSkinType();
        this.iHe.setText(y(this.iHk));
        ap.setBackgroundColor(this.iHf, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.iHh, R.color.cp_cont_j, 1);
        this.esy.bml();
        SvgManager.bkl().a(this.iHi, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_b);
        SvgManager.bkl().a(this.iHa, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.imW = forumWriteData;
    }
}
