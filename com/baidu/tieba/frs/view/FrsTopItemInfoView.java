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
    private RankStarView feh;
    private ItemTableView jKA;
    private TextView jKB;
    private RelativeLayout jKC;
    private HeadImageView jKD;
    private TextView jKE;
    private ImageView jKF;
    private double jKG;
    private double jKH;
    private View.OnClickListener jKM;
    private View.OnClickListener jKN;
    private TextView jKu;
    private View jKv;
    private TextView jKw;
    private ImageView jKx;
    private TextView jKy;
    private TextView jKz;
    private ItemInfo jjM;
    private ForumWriteData jnN;
    private View mBottomLine;
    private Context mContext;
    private static final String jKI = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jKJ = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int jKK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int jpP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int jKL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int itz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jKM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(FrsTopItemInfoView.this.mContext) && !WriteActivityConfig.isAsyncWriting() && FrsTopItemInfoView.this.jjM != null) {
                    WriteActivityConfig.newInstance((Activity) FrsTopItemInfoView.this.mContext).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.jjM)).setItemIsSchool(FrsTopItemInfoView.this.jjM.is_school.intValue() == 1).setStarCount(FrsTopItemInfoView.this.jjM.score != null ? FrsTopItemInfoView.this.jjM.score.comment_star.intValue() : 0).send();
                }
            }
        };
        this.jKN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.Ad(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).bqe();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.jKu = (TextView) findViewById(R.id.item_title_name);
        this.jKv = findViewById(R.id.item_split);
        this.jKw = (TextView) findViewById(R.id.item_title_value);
        this.jKx = (ImageView) findViewById(R.id.icon_question);
        this.jKx.setOnClickListener(this.jKN);
        this.jKy = (TextView) findViewById(R.id.big_score);
        this.jKz = (TextView) findViewById(R.id.people_num);
        this.jKA = (ItemTableView) findViewById(R.id.item_table);
        this.jKB = (TextView) findViewById(R.id.time_score);
        this.jKC = (RelativeLayout) findViewById(R.id.evaluate_container);
        this.jKD = (HeadImageView) findViewById(R.id.user_head);
        this.jKE = (TextView) findViewById(R.id.click_tip);
        this.feh = (RankStarView) findViewById(R.id.star_view);
        this.jKF = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.jKu.setText(R.string.frs_evaluate_item_title);
        this.jKE.setText(R.string.frs_evaluate_click_tip);
        this.jKy.setText(R.string.frs_evaluate_exception);
        if (g.isXiaoMi()) {
            this.jKy.setPadding(0, -jKK, 0, 0);
        }
        this.jKD.setPlaceHolder(1);
        this.feh.setStarSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.jKC.setOnClickListener(this.jKM);
    }

    public void setData(ItemInfo itemInfo) {
        this.jjM = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.jKw.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jKG = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jKH = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jKD.startLoad(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jKy.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jKz.getLayoutParams();
            if (this.jKG <= 0.0d || this.jKG > 10.0d) {
                this.jKy.setText(R.string.frs_evaluate_exception);
                this.jKy.setTextSize(0, itz);
                layoutParams.topMargin = jKL;
                layoutParams.height = itz;
                this.jKy.setLayoutParams(layoutParams);
                layoutParams2.topMargin = jpP;
                this.jKz.setGravity(17);
                this.jKz.setLayoutParams(layoutParams2);
                this.jKz.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.feh.setStarCount(0.0f);
                this.jKB.setVisibility(8);
                this.jKv.setVisibility(8);
                this.jKA.clear();
                return;
            }
            this.jKy.setText(String.valueOf(this.jKG));
            this.jKz.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{at.dX(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.feh.setStarCount(itemTable.comment_star.intValue());
            }
            this.jKv.setVisibility(0);
            this.jKB.setVisibility(0);
            this.jKB.setText(w(this.jKH), TextView.BufferType.SPANNABLE);
            this.jKA.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder w(double d) {
        return new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", jKJ, Double.valueOf(d), jKI));
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.bv(this).od(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jKu).nX(R.string.F_X02).nV(R.color.CAM_X0105);
        ao.setBackgroundColor(this.jKv, R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jKw).nX(R.string.F_X02).nV(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jKy).nX(R.string.F_X02).nV(R.color.CAM_X0105);
        ao.setViewTextColor(this.jKz, R.color.CAM_X0109, 1);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jKB).nV(R.color.CAM_X0109).nX(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jKE).nX(R.string.F_X01).nV(R.color.CAM_X0105);
        this.jKA.onChangeSkinType();
        this.feh.buF();
        SvgManager.bsx().a(this.jKF, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0210);
        SvgManager.bsx().a(this.jKx, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.jnN = forumWriteData;
    }
}
