package com.baidu.tieba.frs.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import java.util.List;
import java.util.Locale;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes22.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView eZo;
    private TextView jCA;
    private TextView jCB;
    private ItemTableView jCC;
    private TextView jCD;
    private RelativeLayout jCE;
    private HeadImageView jCF;
    private TextView jCG;
    private ImageView jCH;
    private double jCI;
    private double jCJ;
    private View.OnClickListener jCO;
    private View.OnClickListener jCP;
    private TextView jCw;
    private View jCx;
    private TextView jCy;
    private ImageView jCz;
    private ItemInfo jca;
    private ForumWriteData jfR;
    private View mBottomLine;
    private Context mContext;
    private static final String jCK = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jCL = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int jCM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int jhT = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int jCN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int ilJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i2;
                FrsTabInfoData frsTabInfoData;
                if (bh.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig((Activity) FrsTopItemInfoView.this.mContext, 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                    writeActivityConfig.getIntent().putExtra("from", "frs");
                    writeActivityConfig.getIntent().putExtra(IntentConfig.IS_EVALUATE, true);
                    writeActivityConfig.setCallFrom("2");
                    if (FrsTopItemInfoView.this.jca != null) {
                        writeActivityConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.jca));
                        writeActivityConfig.setItemIsSchool(FrsTopItemInfoView.this.jca.is_school.intValue() == 1);
                        if (FrsTopItemInfoView.this.jca.score != null) {
                            writeActivityConfig.setStarCount(FrsTopItemInfoView.this.jca.score.comment_star.intValue());
                        }
                    }
                    writeActivityConfig.setForumLevel(-1);
                    writeActivityConfig.setForumAvatar(null);
                    writeActivityConfig.setPrivateThread(0);
                    writeActivityConfig.setForumDir("", "");
                    if (FrsTopItemInfoView.this.jfR != null) {
                        i2 = FrsTopItemInfoView.this.jfR.defaultZone;
                    } else {
                        i2 = -1;
                    }
                    writeActivityConfig.setProfessionZone(i2);
                    if (FrsTopItemInfoView.this.jfR != null) {
                        frsTabInfoData = FrsTopItemInfoView.this.jfR.frsTabInfo;
                    } else {
                        frsTabInfoData = null;
                    }
                    writeActivityConfig.setFrsTabInfo(frsTabInfoData);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            }
        };
        this.jCP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.Bq(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).brv();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.jCw = (TextView) findViewById(R.id.item_title_name);
        this.jCx = findViewById(R.id.item_split);
        this.jCy = (TextView) findViewById(R.id.item_title_value);
        this.jCz = (ImageView) findViewById(R.id.icon_question);
        this.jCz.setOnClickListener(this.jCP);
        this.jCA = (TextView) findViewById(R.id.big_score);
        this.jCB = (TextView) findViewById(R.id.people_num);
        this.jCC = (ItemTableView) findViewById(R.id.item_table);
        this.jCD = (TextView) findViewById(R.id.time_score);
        this.jCE = (RelativeLayout) findViewById(R.id.evaluate_container);
        this.jCF = (HeadImageView) findViewById(R.id.user_head);
        this.jCG = (TextView) findViewById(R.id.click_tip);
        this.eZo = (RankStarView) findViewById(R.id.star_view);
        this.jCH = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.jCw.setText(R.string.frs_evaluate_item_title);
        this.jCG.setText(R.string.frs_evaluate_click_tip);
        this.jCA.setText(R.string.frs_evaluate_exception);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.jCA.setPadding(0, -jCM, 0, 0);
        }
        this.jCF.setPlaceHolder(1);
        this.eZo.setStarSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.jCE.setOnClickListener(this.jCO);
    }

    public void setData(ItemInfo itemInfo) {
        this.jca = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.jCy.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jCI = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jCJ = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jCF.startLoad(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jCA.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jCB.getLayoutParams();
            if (this.jCI <= 0.0d || this.jCI > 10.0d) {
                this.jCA.setText(R.string.frs_evaluate_exception);
                this.jCA.setTextSize(0, ilJ);
                layoutParams.topMargin = jCN;
                layoutParams.height = ilJ;
                this.jCA.setLayoutParams(layoutParams);
                layoutParams2.topMargin = jhT;
                this.jCB.setGravity(17);
                this.jCB.setLayoutParams(layoutParams2);
                this.jCB.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.eZo.setStarCount(0.0f);
                this.jCD.setVisibility(8);
                this.jCx.setVisibility(8);
                this.jCC.clear();
                return;
            }
            this.jCA.setText(String.valueOf(this.jCI));
            this.jCB.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{au.dX(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.eZo.setStarCount(itemTable.comment_star.intValue());
            }
            this.jCx.setVisibility(0);
            this.jCD.setVisibility(0);
            this.jCD.setText(D(this.jCJ), TextView.BufferType.SPANNABLE);
            this.jCC.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder D(double d) {
        return new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", jCL, Double.valueOf(d), jCK));
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.bm(this).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCw).pu(R.string.F_X02).ps(R.color.CAM_X0105);
        ap.setBackgroundColor(this.jCx, R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCy).pu(R.string.F_X02).ps(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCA).pu(R.string.F_X02).ps(R.color.CAM_X0105);
        ap.setViewTextColor(this.jCB, R.color.CAM_X0109, 1);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCD).ps(R.color.CAM_X0109).pu(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCG).pu(R.string.F_X01).ps(R.color.CAM_X0105);
        this.jCC.onChangeSkinType();
        this.eZo.bwe();
        SvgManager.btW().a(this.jCH, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0210);
        SvgManager.btW().a(this.jCz, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.jfR = forumWriteData;
    }
}
