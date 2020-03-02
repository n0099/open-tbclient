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
public class h implements View.OnClickListener {
    private static String eCP;
    private com.baidu.tieba.ala.d eBv;
    private String eCO;
    private a eDg;
    private bj ejJ;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener etK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.ejJ != null && h.this.ejJ.aCo() != null && !StringUtils.isNull(h.this.ejJ.aCo().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.ejJ.aCo().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bbQ().bbR();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.ejJ.aCo().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.eDg = new a(this.mRootView);
        getView().setOnClickListener(this);
        eCP = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.eBv = dVar;
    }

    public void a(bj bjVar) {
        if (bjVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejJ = bjVar;
        this.eDg.etM.setDrawerType(0);
        this.eDg.etM.setBorderSurroundContent(true);
        this.eDg.etM.setDrawBorder(true);
        this.eDg.etM.startLoad(this.ejJ.aCH().cover, 10, false);
        this.eDg.etO.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.ejJ.aCH().audience_count)));
        this.eDg.etQ.setData(this.ejJ);
        this.eDg.etQ.setIsRound(true);
        this.eDg.etQ.setBorderSurroundContent(true);
        this.eDg.etR.setText(this.ejJ.getTitle());
        if (this.ejJ.aCo() != null) {
            String name_show = this.ejJ.aCo().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eDg.ahO.setText(name_show);
        }
        this.eDg.eCU.setVisibility(0);
        this.eDg.etN.setBackgroundResource(R.drawable.transparent_bg);
        this.eDg.etN.setText(this.ejJ.aCH().label_name);
        this.eDg.etN.setVisibility(0);
        if (this.ejJ.aCo() == null || this.ejJ.aCo().getAlaUserData() == null || aq.isEmpty(this.ejJ.aCo().getAlaUserData().great_anchor_icon)) {
            this.eDg.eCR.setVisibility(8);
        } else {
            this.eDg.eCR.setVisibility(0);
            this.eDg.eCR.startLoad(this.ejJ.aCo().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.eDg.ahO.setOnClickListener(this.etK);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.ejJ != null && this.ejJ.aCH() != null) {
            if (this.eBv != null) {
                this.eBv.O(this.ejJ);
            }
            com.baidu.tieba.ala.c.bbQ().bbR();
            TiebaStatic.log(new an("c12116").s("obj_id", this.ejJ.aCH().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eDg.etP, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eDg.etN, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.eDg.etO, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eDg.ahO, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eDg.etR, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eDg.eCV, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.eCO = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView ahO;
        public TbImageView eCR;
        public RelativeLayout eCS;
        public LinearLayout eCT;
        public View eCU;
        public TextView eCV;
        private LinearLayout.LayoutParams eCW;
        private LinearLayout.LayoutParams eCX;
        public TbImageView etM;
        public TextView etN;
        public TextView etO;
        public RelativeLayout etP;
        public ClickableHeaderImageView etQ;
        public TextView etR;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.etM = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.etN = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.etO = (TextView) view.findViewById(R.id.tvLiveCount);
            this.etP = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.etQ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahO = (TextView) view.findViewById(R.id.tvUserName);
            this.eCS = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.etR = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eCT = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.eCR = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.eCU = view.findViewById(R.id.living_logo);
            this.eCV = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.eCV.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.eCW = (LinearLayout.LayoutParams) this.etR.getLayoutParams();
            this.eCX = (LinearLayout.LayoutParams) this.eCT.getLayoutParams();
            this.eCR.setDefaultErrorResource(0);
            this.eCR.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.etM.setDefaultErrorResource(0);
            this.etM.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etP.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.eCX.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.eCX.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.eCW.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eCW.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.etR.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.eCS.setVisibility(8);
            this.eCT.setLayoutParams(this.eCX);
            this.etR.setLayoutParams(this.eCW);
            this.etP.setLayoutParams(layoutParams);
        }
    }
}
