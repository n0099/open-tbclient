package com.baidu.tieba.ala.frsgamelive.view;

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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.d;
import com.baidu.tieba.ala.h;
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private static String gWF;
    private h gVl;
    private String gWE;
    private a gWU;
    private cb gyO;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gJo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gyO != null && b.this.gyO.bnQ() != null && !StringUtils.isNull(b.this.gyO.bnQ().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(b.this.gyO.bnQ().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                d.bOL().bOM();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(b.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, b.this.gyO.bnQ().isBigV())));
            }
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gWU = new a(this.mRootView);
        getView().setOnClickListener(this);
        gWF = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(h hVar) {
        this.gVl = hVar;
    }

    public void a(cb cbVar) {
        if (cbVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gyO = cbVar;
        this.gWU.gJq.setDrawerType(0);
        this.gWU.gJq.setBorderSurroundContent(true);
        this.gWU.gJq.setDrawBorder(true);
        this.gWU.gJq.startLoad(this.gyO.boj().cover, 10, false);
        this.gWU.gJs.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.gyO.boj().audience_count)));
        this.gWU.gJu.setData(this.gyO);
        this.gWU.gJu.setIsRound(true);
        this.gWU.gJu.setBorderSurroundContent(true);
        this.gWU.gJv.setText(this.gyO.getTitle());
        if (this.gyO.bnQ() != null) {
            String name_show = this.gyO.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gWU.aYx.setText(name_show);
        }
        this.gWU.gWI.setVisibility(0);
        this.gWU.gJr.setBackgroundResource(R.drawable.transparent_bg);
        this.gWU.gJr.setText(this.gyO.boj().label_name);
        this.gWU.gJr.setVisibility(0);
        if (this.gyO.bnQ() == null || this.gyO.bnQ().getAlaUserData() == null || au.isEmpty(this.gyO.bnQ().getAlaUserData().great_anchor_icon)) {
            this.gWU.gWH.setVisibility(8);
        } else {
            this.gWU.gWH.setVisibility(0);
            this.gWU.gWH.startLoad(this.gyO.bnQ().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gWU.aYx.setOnClickListener(this.gJo);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gyO != null && this.gyO.boj() != null) {
            if (this.gVl != null) {
                this.gVl.S(this.gyO);
            }
            d.bOL().bOM();
            TiebaStatic.log(new ar("c12116").v("obj_id", this.gyO.boj().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gWU.gJt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gWU.gJr, R.color.CAM_X0111);
            ap.setViewTextColor(this.gWU.gJs, R.color.CAM_X0101);
            ap.setViewTextColor(this.gWU.aYx, R.color.CAM_X0109);
            ap.setViewTextColor(this.gWU.gJv, R.color.CAM_X0105);
            ap.setViewTextColor(this.gWU.gWJ, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gWE = str;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public TextView aYx;
        public TbImageView gJq;
        public TextView gJr;
        public TextView gJs;
        public RelativeLayout gJt;
        public ClickableHeaderImageView gJu;
        public TextView gJv;
        public LinearLayout gKe;
        public RelativeLayout gKm;
        public TbImageView gWH;
        public View gWI;
        public TextView gWJ;
        private LinearLayout.LayoutParams gWK;
        private LinearLayout.LayoutParams gWL;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gJq = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJr = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gJs = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gJt = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJu = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aYx = (TextView) view.findViewById(R.id.tvUserName);
            this.gKm = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gJv = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gKe = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gWH = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gWI = view.findViewById(R.id.living_logo);
            this.gWJ = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gWJ.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gWK = (LinearLayout.LayoutParams) this.gJv.getLayoutParams();
            this.gWL = (LinearLayout.LayoutParams) this.gKe.getLayoutParams();
            this.gWH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gJq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJt.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gWL.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gWL.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.gWK.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gWK.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gJv.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.gKm.setVisibility(8);
            this.gKe.setLayoutParams(this.gWL);
            this.gJv.setLayoutParams(this.gWK);
            this.gJt.setLayoutParams(layoutParams);
        }
    }
}
