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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    private static String eCO;
    private com.baidu.tieba.ala.d eBu;
    private a eCM;
    private String eCN;
    private bj ejI;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener etJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.ejI != null && d.this.ejI.aCm() != null && !StringUtils.isNull(d.this.ejI.aCm().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.ejI.aCm().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bbO().bbP();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.ejI.aCm().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.eCM = new a(this.mRootView);
        getView().setOnClickListener(this);
        eCO = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.eBu = dVar;
    }

    public void a(bj bjVar) {
        if (bjVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejI = bjVar;
        this.eCM.etL.setDrawerType(0);
        this.eCM.etL.setBorderSurroundContent(true);
        this.eCM.etL.setDrawBorder(true);
        this.eCM.etL.startLoad(this.ejI.aCF().cover, 10, false);
        this.eCM.etN.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.ejI.aCF().audience_count)));
        this.eCM.etP.setData(this.ejI);
        this.eCM.etP.setIsRound(true);
        this.eCM.etP.setBorderSurroundContent(true);
        this.eCM.etQ.setText(this.ejI.getTitle());
        if (this.ejI.aCm() != null) {
            String name_show = this.ejI.aCm().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eCM.ahO.setText(name_show);
        }
        this.eCM.eCT.setVisibility(0);
        this.eCM.etM.setBackgroundResource(R.drawable.transparent_bg);
        this.eCM.etM.setText(this.ejI.aCF().label_name);
        this.eCM.etM.setVisibility(0);
        if (this.ejI.aCm() == null || this.ejI.aCm().getAlaUserData() == null || aq.isEmpty(this.ejI.aCm().getAlaUserData().great_anchor_icon)) {
            this.eCM.eCQ.setVisibility(8);
        } else {
            this.eCM.eCQ.setVisibility(0);
            this.eCM.eCQ.startLoad(this.ejI.aCm().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.eCM.ahO.setOnClickListener(this.etJ);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.ejI != null && this.ejI.aCF() != null) {
            if (this.eBu != null) {
                this.eBu.O(this.ejI);
            }
            com.baidu.tieba.ala.c.bbO().bbP();
            TiebaStatic.log(new an("c12116").s("obj_id", this.ejI.aCF().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eCM.etO, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eCM.etM, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.eCM.etN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eCM.ahO, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eCM.etQ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eCM.eCU, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.eCN = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView ahO;
        public TbImageView eCQ;
        public RelativeLayout eCR;
        public LinearLayout eCS;
        public View eCT;
        public TextView eCU;
        private LinearLayout.LayoutParams eCV;
        private LinearLayout.LayoutParams eCW;
        public TbImageView etL;
        public TextView etM;
        public TextView etN;
        public RelativeLayout etO;
        public ClickableHeaderImageView etP;
        public TextView etQ;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.etL = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.etM = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.etN = (TextView) view.findViewById(R.id.tvLiveCount);
            this.etO = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.etP = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahO = (TextView) view.findViewById(R.id.tvUserName);
            this.eCR = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.etQ = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eCS = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.eCQ = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.eCT = view.findViewById(R.id.living_logo);
            this.eCU = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.eCU.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.eCV = (LinearLayout.LayoutParams) this.etQ.getLayoutParams();
            this.eCW = (LinearLayout.LayoutParams) this.eCS.getLayoutParams();
            this.eCQ.setDefaultErrorResource(0);
            this.eCQ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.etL.setDefaultErrorResource(0);
            this.etL.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etO.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.eCW.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eCW.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eCV.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eCV.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.etQ.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eCR.setVisibility(0);
            this.eCS.setLayoutParams(this.eCW);
            this.etQ.setLayoutParams(this.eCV);
            this.etO.setLayoutParams(layoutParams);
        }
    }
}
