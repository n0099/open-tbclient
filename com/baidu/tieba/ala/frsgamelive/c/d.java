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
public class d implements View.OnClickListener {
    private static String gMz;
    private com.baidu.tieba.ala.f gLf;
    private a gMx;
    private String gMy;
    private by gpF;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gzR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.c.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.gpF != null && d.this.gpF.boP() != null && !StringUtils.isNull(d.this.gpF.boP().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(d.this.gpF.boP().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                com.baidu.tieba.ala.c.bPq().bPr();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, d.this.gpF.boP().isBigV())));
            }
        }
    };

    public d(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gMx = new a(this.mRootView);
        getView().setOnClickListener(this);
        gMz = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(com.baidu.tieba.ala.f fVar) {
        this.gLf = fVar;
    }

    public void a(by byVar) {
        if (byVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gpF = byVar;
        this.gMx.gzT.setDrawerType(0);
        this.gMx.gzT.setBorderSurroundContent(true);
        this.gMx.gzT.setDrawBorder(true);
        this.gMx.gzT.startLoad(this.gpF.bpj().cover, 10, false);
        this.gMx.gzV.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.gpF.bpj().audience_count)));
        this.gMx.gzX.setData(this.gpF);
        this.gMx.gzX.setIsRound(true);
        this.gMx.gzX.setBorderSurroundContent(true);
        this.gMx.gzY.setText(this.gpF.getTitle());
        if (this.gpF.boP() != null) {
            String name_show = this.gpF.boP().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gMx.aYw.setText(name_show);
        }
        this.gMx.gME.setVisibility(0);
        this.gMx.gzU.setBackgroundResource(R.drawable.transparent_bg);
        this.gMx.gzU.setText(this.gpF.bpj().label_name);
        this.gMx.gzU.setVisibility(0);
        if (this.gpF.boP() == null || this.gpF.boP().getAlaUserData() == null || au.isEmpty(this.gpF.boP().getAlaUserData().great_anchor_icon)) {
            this.gMx.gMB.setVisibility(8);
        } else {
            this.gMx.gMB.setVisibility(0);
            this.gMx.gMB.startLoad(this.gpF.boP().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gMx.aYw.setOnClickListener(this.gzR);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gpF != null && this.gpF.bpj() != null) {
            if (this.gLf != null) {
                this.gLf.R(this.gpF);
            }
            com.baidu.tieba.ala.c.bPq().bPr();
            TiebaStatic.log(new ar("c12116").w("obj_id", this.gpF.bpj().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gMx.gzW, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gMx.gzU, R.color.CAM_X0111);
            ap.setViewTextColor(this.gMx.gzV, R.color.CAM_X0101);
            ap.setViewTextColor(this.gMx.aYw, R.color.CAM_X0109);
            ap.setViewTextColor(this.gMx.gzY, R.color.CAM_X0105);
            ap.setViewTextColor(this.gMx.gMF, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gMy = str;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public TextView aYw;
        public TbImageView gMB;
        public RelativeLayout gMC;
        public LinearLayout gMD;
        public View gME;
        public TextView gMF;
        private LinearLayout.LayoutParams gMG;
        private LinearLayout.LayoutParams gMH;
        public TbImageView gzT;
        public TextView gzU;
        public TextView gzV;
        public RelativeLayout gzW;
        public ClickableHeaderImageView gzX;
        public TextView gzY;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gzT = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gzU = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gzV = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gzW = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gzX = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aYw = (TextView) view.findViewById(R.id.tvUserName);
            this.gMC = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gzY = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gMD = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gMB = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gME = view.findViewById(R.id.living_logo);
            this.gMF = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gMF.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gMG = (LinearLayout.LayoutParams) this.gzY.getLayoutParams();
            this.gMH = (LinearLayout.LayoutParams) this.gMD.getLayoutParams();
            this.gMB.setDefaultErrorResource(0);
            this.gMB.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gzT.setDefaultErrorResource(0);
            this.gzT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzW.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gMH.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gMH.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gMG.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gMG.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gzY.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gMC.setVisibility(0);
            this.gMD.setLayoutParams(this.gMH);
            this.gzY.setLayoutParams(this.gMG);
            this.gzW.setLayoutParams(layoutParams);
        }
    }
}
