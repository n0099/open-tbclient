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
    private RankStarView fhV;
    private double jTA;
    private double jTB;
    private View.OnClickListener jTG;
    private View.OnClickListener jTH;
    private TextView jTo;
    private View jTp;
    private TextView jTq;
    private ImageView jTr;
    private TextView jTs;
    private TextView jTt;
    private ItemTableView jTu;
    private TextView jTv;
    private RelativeLayout jTw;
    private HeadImageView jTx;
    private TextView jTy;
    private ImageView jTz;
    private ItemInfo jrq;
    private ForumWriteData jvq;
    private View mBottomLine;
    private Context mContext;
    private static final String jTC = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jTD = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int jTE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int jxs = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int jTF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int iBg = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jTG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(FrsTopItemInfoView.this.mContext) && !WriteActivityConfig.isAsyncWriting() && FrsTopItemInfoView.this.jrq != null) {
                    WriteActivityConfig.newInstance((Activity) FrsTopItemInfoView.this.mContext).setType(9).setFrom("frs").setForumId("0").setIsEvaluate(true).setCallFrom("2").setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.jrq)).setItemIsSchool(FrsTopItemInfoView.this.jrq.is_school.intValue() == 1).setStarCount(FrsTopItemInfoView.this.jrq.score != null ? FrsTopItemInfoView.this.jrq.score.comment_star.intValue() : 0).send();
                }
            }
        };
        this.jTH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.AB(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).bqz();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.jTo = (TextView) findViewById(R.id.item_title_name);
        this.jTp = findViewById(R.id.item_split);
        this.jTq = (TextView) findViewById(R.id.item_title_value);
        this.jTr = (ImageView) findViewById(R.id.icon_question);
        this.jTr.setOnClickListener(this.jTH);
        this.jTs = (TextView) findViewById(R.id.big_score);
        this.jTt = (TextView) findViewById(R.id.people_num);
        this.jTu = (ItemTableView) findViewById(R.id.item_table);
        this.jTv = (TextView) findViewById(R.id.time_score);
        this.jTw = (RelativeLayout) findViewById(R.id.evaluate_container);
        this.jTx = (HeadImageView) findViewById(R.id.user_head);
        this.jTy = (TextView) findViewById(R.id.click_tip);
        this.fhV = (RankStarView) findViewById(R.id.star_view);
        this.jTz = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.jTo.setText(R.string.frs_evaluate_item_title);
        this.jTy.setText(R.string.frs_evaluate_click_tip);
        this.jTs.setText(R.string.frs_evaluate_exception);
        if (g.isXiaoMi()) {
            this.jTs.setPadding(0, -jTE, 0, 0);
        }
        this.jTx.setPlaceHolder(1);
        this.fhV.setStarSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.jTw.setOnClickListener(this.jTG);
    }

    public void setData(ItemInfo itemInfo) {
        this.jrq = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.jTq.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jTA = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jTB = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jTx.startLoad(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jTs.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jTt.getLayoutParams();
            if (this.jTA <= 0.0d || this.jTA > 10.0d) {
                this.jTs.setText(R.string.frs_evaluate_exception);
                this.jTs.setTextSize(0, iBg);
                layoutParams.topMargin = jTF;
                layoutParams.height = iBg;
                this.jTs.setLayoutParams(layoutParams);
                layoutParams2.topMargin = jxs;
                this.jTt.setGravity(17);
                this.jTt.setLayoutParams(layoutParams2);
                this.jTt.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.fhV.setStarCount(0.0f);
                this.jTv.setVisibility(8);
                this.jTp.setVisibility(8);
                this.jTu.clear();
                return;
            }
            this.jTs.setText(String.valueOf(this.jTA));
            this.jTt.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{au.ed(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.fhV.setStarCount(itemTable.comment_star.intValue());
            }
            this.jTp.setVisibility(0);
            this.jTv.setVisibility(0);
            this.jTv.setText(w(this.jTB), TextView.BufferType.SPANNABLE);
            this.jTu.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder w(double d) {
        return new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", jTD, Double.valueOf(d), jTC));
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.br(this).oh(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jTo).ob(R.string.F_X02).nZ(R.color.CAM_X0105);
        ap.setBackgroundColor(this.jTp, R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jTq).ob(R.string.F_X02).nZ(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jTs).ob(R.string.F_X02).nZ(R.color.CAM_X0105);
        ap.setViewTextColor(this.jTt, R.color.CAM_X0109, 1);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jTv).nZ(R.color.CAM_X0109).ob(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jTy).ob(R.string.F_X01).nZ(R.color.CAM_X0105);
        this.jTu.onChangeSkinType();
        this.fhV.bvc();
        SvgManager.bsU().a(this.jTz, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0210);
        SvgManager.bsU().a(this.jTr, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.jvq = forumWriteData;
    }
}
