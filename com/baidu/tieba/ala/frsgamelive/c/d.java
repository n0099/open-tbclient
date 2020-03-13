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
    private static String eDc;
    private com.baidu.tieba.ala.d eBI;
    private a eDa;
    private String eDb;
    private bj ejW;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener etX = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.ejW != null && d.this.ejW.aCo() != null && !StringUtils.isNull(d.this.ejW.aCo().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.ejW.aCo().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bbR().bbS();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.ejW.aCo().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.eDa = new a(this.mRootView);
        getView().setOnClickListener(this);
        eDc = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.eBI = dVar;
    }

    public void a(bj bjVar) {
        if (bjVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ejW = bjVar;
        this.eDa.etZ.setDrawerType(0);
        this.eDa.etZ.setBorderSurroundContent(true);
        this.eDa.etZ.setDrawBorder(true);
        this.eDa.etZ.startLoad(this.ejW.aCH().cover, 10, false);
        this.eDa.eub.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.ejW.aCH().audience_count)));
        this.eDa.eud.setData(this.ejW);
        this.eDa.eud.setIsRound(true);
        this.eDa.eud.setBorderSurroundContent(true);
        this.eDa.eue.setText(this.ejW.getTitle());
        if (this.ejW.aCo() != null) {
            String name_show = this.ejW.aCo().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eDa.ahO.setText(name_show);
        }
        this.eDa.eDh.setVisibility(0);
        this.eDa.eua.setBackgroundResource(R.drawable.transparent_bg);
        this.eDa.eua.setText(this.ejW.aCH().label_name);
        this.eDa.eua.setVisibility(0);
        if (this.ejW.aCo() == null || this.ejW.aCo().getAlaUserData() == null || aq.isEmpty(this.ejW.aCo().getAlaUserData().great_anchor_icon)) {
            this.eDa.eDe.setVisibility(8);
        } else {
            this.eDa.eDe.setVisibility(0);
            this.eDa.eDe.startLoad(this.ejW.aCo().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.eDa.ahO.setOnClickListener(this.etX);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.ejW != null && this.ejW.aCH() != null) {
            if (this.eBI != null) {
                this.eBI.O(this.ejW);
            }
            com.baidu.tieba.ala.c.bbR().bbS();
            TiebaStatic.log(new an("c12116").s("obj_id", this.ejW.aCH().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eDa.euc, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eDa.eua, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.eDa.eub, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eDa.ahO, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eDa.eue, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eDa.eDi, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.eDb = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView ahO;
        public TbImageView eDe;
        public RelativeLayout eDf;
        public LinearLayout eDg;
        public View eDh;
        public TextView eDi;
        private LinearLayout.LayoutParams eDj;
        private LinearLayout.LayoutParams eDk;
        public TbImageView etZ;
        public TextView eua;
        public TextView eub;
        public RelativeLayout euc;
        public ClickableHeaderImageView eud;
        public TextView eue;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.etZ = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.eua = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.eub = (TextView) view.findViewById(R.id.tvLiveCount);
            this.euc = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.eud = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.ahO = (TextView) view.findViewById(R.id.tvUserName);
            this.eDf = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.eue = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eDg = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.eDe = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.eDh = view.findViewById(R.id.living_logo);
            this.eDi = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.eDi.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.eDj = (LinearLayout.LayoutParams) this.eue.getLayoutParams();
            this.eDk = (LinearLayout.LayoutParams) this.eDg.getLayoutParams();
            this.eDe.setDefaultErrorResource(0);
            this.eDe.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.etZ.setDefaultErrorResource(0);
            this.etZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.euc.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.eDk.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eDk.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eDj.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eDj.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.eue.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eDf.setVisibility(0);
            this.eDg.setLayoutParams(this.eDk);
            this.eue.setLayoutParams(this.eDj);
            this.euc.setLayoutParams(layoutParams);
        }
    }
}
