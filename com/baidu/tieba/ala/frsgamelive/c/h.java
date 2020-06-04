package com.baidu.tieba.ala.frsgamelive.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class h implements View.OnClickListener {
    private static String fvQ;
    private bk faJ;
    private com.baidu.tieba.ala.d fuw;
    private String fvP;
    private a fwh;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener fkO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.faJ != null && h.this.faJ.aQx() != null && !StringUtils.isNull(h.this.faJ.aQx().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.faJ.aQx().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bps().bpt();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.faJ.aQx().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.fwh = new a(this.mRootView);
        getView().setOnClickListener(this);
        fvQ = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.fuw = dVar;
    }

    public void a(bk bkVar) {
        if (bkVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.faJ = bkVar;
        this.fwh.fkQ.setDrawerType(0);
        this.fwh.fkQ.setBorderSurroundContent(true);
        this.fwh.fkQ.setDrawBorder(true);
        this.fwh.fkQ.startLoad(this.faJ.aQS().cover, 10, false);
        this.fwh.fkS.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.faJ.aQS().audience_count)));
        this.fwh.fkU.setData(this.faJ);
        this.fwh.fkU.setIsRound(true);
        this.fwh.fkU.setBorderSurroundContent(true);
        this.fwh.fkV.setText(this.faJ.getTitle());
        if (this.faJ.aQx() != null) {
            String name_show = this.faJ.aQx().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fwh.aFR.setText(name_show);
        }
        this.fwh.fvV.setVisibility(0);
        this.fwh.fkR.setBackgroundResource(R.drawable.transparent_bg);
        this.fwh.fkR.setText(this.faJ.aQS().label_name);
        this.fwh.fkR.setVisibility(0);
        if (this.faJ.aQx() == null || this.faJ.aQx().getAlaUserData() == null || aq.isEmpty(this.faJ.aQx().getAlaUserData().great_anchor_icon)) {
            this.fwh.fvS.setVisibility(8);
        } else {
            this.fwh.fvS.setVisibility(0);
            this.fwh.fvS.startLoad(this.faJ.aQx().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.fwh.aFR.setOnClickListener(this.fkO);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.faJ != null && this.faJ.aQS() != null) {
            if (this.fuw != null) {
                this.fuw.Q(this.faJ);
            }
            com.baidu.tieba.ala.c.bps().bpt();
            TiebaStatic.log(new an("c12116").s("obj_id", this.faJ.aQS().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fwh.fkT, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.fwh.fkR, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.fwh.fkS, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fwh.aFR, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fwh.fkV, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.fwh.fvW, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.fvP = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView aFR;
        public TbImageView fkQ;
        public TextView fkR;
        public TextView fkS;
        public RelativeLayout fkT;
        public ClickableHeaderImageView fkU;
        public TextView fkV;
        public TbImageView fvS;
        public RelativeLayout fvT;
        public LinearLayout fvU;
        public View fvV;
        public TextView fvW;
        private LinearLayout.LayoutParams fvX;
        private LinearLayout.LayoutParams fvY;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.fkQ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.fkR = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.fkS = (TextView) view.findViewById(R.id.tvLiveCount);
            this.fkT = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.fkU = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aFR = (TextView) view.findViewById(R.id.tvUserName);
            this.fvT = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.fkV = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.fvU = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.fvS = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.fvV = view.findViewById(R.id.living_logo);
            this.fvW = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.fvW.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.fvX = (LinearLayout.LayoutParams) this.fkV.getLayoutParams();
            this.fvY = (LinearLayout.LayoutParams) this.fvU.getLayoutParams();
            this.fvS.setDefaultErrorResource(0);
            this.fvS.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.fkQ.setDefaultErrorResource(0);
            this.fkQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkT.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.fvY.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.fvY.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.fvX.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.fvX.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.fkV.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.fvT.setVisibility(8);
            this.fvU.setLayoutParams(this.fvY);
            this.fkV.setLayoutParams(this.fvX);
            this.fkT.setLayoutParams(layoutParams);
        }
    }
}
