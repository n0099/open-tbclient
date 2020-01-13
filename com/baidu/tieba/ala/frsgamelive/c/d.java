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
/* loaded from: classes2.dex */
public class d implements View.OnClickListener {
    private static String eyH;
    private bj efE;
    private com.baidu.tieba.ala.d exk;
    private a eyF;
    private String eyG;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener epy = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.efE != null && d.this.efE.azX() != null && !StringUtils.isNull(d.this.efE.azX().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.efE.azX().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.aZz().aZA();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.efE.azX().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.eyF = new a(this.mRootView);
        getView().setOnClickListener(this);
        eyH = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.d dVar) {
        this.exk = dVar;
    }

    public void a(bj bjVar) {
        if (bjVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.efE = bjVar;
        this.eyF.epA.setDrawerType(0);
        this.eyF.epA.setBorderSurroundContent(true);
        this.eyF.epA.setDrawBorder(true);
        this.eyF.epA.startLoad(this.efE.aAq().cover, 10, false);
        this.eyF.epC.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, aq.numberUniformFormatExtra(this.efE.aAq().audience_count)));
        this.eyF.epE.setData(this.efE);
        this.eyF.epE.setIsRound(true);
        this.eyF.epE.setBorderSurroundContent(true);
        this.eyF.epF.setText(this.efE.getTitle());
        if (this.efE.azX() != null) {
            String name_show = this.efE.azX().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eyF.afG.setText(name_show);
        }
        this.eyF.eyM.setVisibility(0);
        this.eyF.epB.setBackgroundResource(R.drawable.transparent_bg);
        this.eyF.epB.setText(this.efE.aAq().label_name);
        this.eyF.epB.setVisibility(0);
        if (this.efE.azX() == null || this.efE.azX().getAlaUserData() == null || aq.isEmpty(this.efE.azX().getAlaUserData().great_anchor_icon)) {
            this.eyF.eyJ.setVisibility(8);
        } else {
            this.eyF.eyJ.setVisibility(0);
            this.eyF.eyJ.startLoad(this.efE.azX().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.eyF.afG.setOnClickListener(this.epy);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.efE != null && this.efE.aAq() != null) {
            if (this.exk != null) {
                this.exk.N(this.efE);
            }
            com.baidu.tieba.ala.c.aZz().aZA();
            TiebaStatic.log(new an("c12116").s("obj_id", this.efE.aAq().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eyF.epD, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eyF.epB, (int) R.color.cp_cont_g);
            am.setViewTextColor(this.eyF.epC, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eyF.afG, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.eyF.epF, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.eyF.eyN, (int) R.color.cp_cont_a);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.eyG = str;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public TextView afG;
        public TbImageView epA;
        public TextView epB;
        public TextView epC;
        public RelativeLayout epD;
        public ClickableHeaderImageView epE;
        public TextView epF;
        public TbImageView eyJ;
        public RelativeLayout eyK;
        public LinearLayout eyL;
        public View eyM;
        public TextView eyN;
        private LinearLayout.LayoutParams eyO;
        private LinearLayout.LayoutParams eyP;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.epA = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.epB = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.epC = (TextView) view.findViewById(R.id.tvLiveCount);
            this.epD = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.epE = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.afG = (TextView) view.findViewById(R.id.tvUserName);
            this.eyK = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.epF = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.eyL = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.eyJ = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.eyM = view.findViewById(R.id.living_logo);
            this.eyN = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.eyN.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.eyO = (LinearLayout.LayoutParams) this.epF.getLayoutParams();
            this.eyP = (LinearLayout.LayoutParams) this.eyL.getLayoutParams();
            this.eyJ.setDefaultErrorResource(0);
            this.eyJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.epA.setDefaultErrorResource(0);
            this.epA.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epD.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.eyP.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eyP.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eyO.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.eyO.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.epF.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.eyK.setVisibility(0);
            this.eyL.setLayoutParams(this.eyP);
            this.epF.setLayoutParams(this.eyO);
            this.epD.setLayoutParams(layoutParams);
        }
    }
}
