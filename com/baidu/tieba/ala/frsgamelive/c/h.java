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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h implements View.OnClickListener {
    private static String gMB;
    private com.baidu.tieba.ala.f gLh;
    private String gMA;
    private a gMS;
    private by gpH;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gzT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.gpH != null && h.this.gpH.boP() != null && !StringUtils.isNull(h.this.gpH.boP().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(h.this.gpH.boP().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bPr().bPs();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(h.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, h.this.gpH.boP().isBigV())));
            }
        }
    };

    public h(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gMS = new a(this.mRootView);
        getView().setOnClickListener(this);
        gMB = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.f fVar) {
        this.gLh = fVar;
    }

    public void a(by byVar) {
        if (byVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gpH = byVar;
        this.gMS.gzV.setDrawerType(0);
        this.gMS.gzV.setBorderSurroundContent(true);
        this.gMS.gzV.setDrawBorder(true);
        this.gMS.gzV.startLoad(this.gpH.bpj().cover, 10, false);
        this.gMS.gzX.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.gpH.bpj().audience_count)));
        this.gMS.gzZ.setData(this.gpH);
        this.gMS.gzZ.setIsRound(true);
        this.gMS.gzZ.setBorderSurroundContent(true);
        this.gMS.gAa.setText(this.gpH.getTitle());
        if (this.gpH.boP() != null) {
            String name_show = this.gpH.boP().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gMS.aYw.setText(name_show);
        }
        this.gMS.gMG.setVisibility(0);
        this.gMS.gzW.setBackgroundResource(R.drawable.transparent_bg);
        this.gMS.gzW.setText(this.gpH.bpj().label_name);
        this.gMS.gzW.setVisibility(0);
        if (this.gpH.boP() == null || this.gpH.boP().getAlaUserData() == null || au.isEmpty(this.gpH.boP().getAlaUserData().great_anchor_icon)) {
            this.gMS.gMD.setVisibility(8);
        } else {
            this.gMS.gMD.setVisibility(0);
            this.gMS.gMD.startLoad(this.gpH.boP().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gMS.aYw.setOnClickListener(this.gzT);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gpH != null && this.gpH.bpj() != null) {
            if (this.gLh != null) {
                this.gLh.R(this.gpH);
            }
            com.baidu.tieba.ala.c.bPr().bPs();
            TiebaStatic.log(new ar("c12116").w("obj_id", this.gpH.bpj().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gMS.gzY, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gMS.gzW, (int) R.color.CAM_X0111);
            ap.setViewTextColor(this.gMS.gzX, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gMS.aYw, (int) R.color.CAM_X0109);
            ap.setViewTextColor(this.gMS.gAa, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gMS.gMH, (int) R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gMA = str;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public TextView aYw;
        public TextView gAa;
        public TbImageView gMD;
        public RelativeLayout gME;
        public LinearLayout gMF;
        public View gMG;
        public TextView gMH;
        private LinearLayout.LayoutParams gMI;
        private LinearLayout.LayoutParams gMJ;
        public TbImageView gzV;
        public TextView gzW;
        public TextView gzX;
        public RelativeLayout gzY;
        public ClickableHeaderImageView gzZ;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gzV = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gzW = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gzX = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gzY = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gzZ = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aYw = (TextView) view.findViewById(R.id.tvUserName);
            this.gME = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gAa = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gMF = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gMD = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gMG = view.findViewById(R.id.living_logo);
            this.gMH = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gMH.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gMI = (LinearLayout.LayoutParams) this.gAa.getLayoutParams();
            this.gMJ = (LinearLayout.LayoutParams) this.gMF.getLayoutParams();
            this.gMD.setDefaultErrorResource(0);
            this.gMD.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gzV.setDefaultErrorResource(0);
            this.gzV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzY.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gMJ.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gMJ.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gMI.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gMI.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gAa.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.gME.setVisibility(8);
            this.gMF.setLayoutParams(this.gMJ);
            this.gAa.setLayoutParams(this.gMI);
            this.gzY.setLayoutParams(layoutParams);
        }
    }
}
