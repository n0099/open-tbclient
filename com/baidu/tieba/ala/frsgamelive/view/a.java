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
public class a implements View.OnClickListener {
    private static String gWF;
    private h gVl;
    private C0630a gWD;
    private String gWE;
    private cb gyO;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gJo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gyO != null && a.this.gyO.bnQ() != null && !StringUtils.isNull(a.this.gyO.bnQ().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(a.this.gyO.bnQ().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                d.bOL().bOM();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, a.this.gyO.bnQ().isBigV())));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gWD = new C0630a(this.mRootView);
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
        this.gWD.gJq.setDrawerType(0);
        this.gWD.gJq.setBorderSurroundContent(true);
        this.gWD.gJq.setDrawBorder(true);
        this.gWD.gJq.startLoad(this.gyO.boj().cover, 10, false);
        this.gWD.gJs.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, au.numberUniformFormatExtra(this.gyO.boj().audience_count)));
        this.gWD.gJu.setData(this.gyO);
        this.gWD.gJu.setIsRound(true);
        this.gWD.gJu.setBorderSurroundContent(true);
        this.gWD.gJv.setText(this.gyO.getTitle());
        if (this.gyO.bnQ() != null) {
            String name_show = this.gyO.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gWD.aYx.setText(name_show);
        }
        this.gWD.gWI.setVisibility(0);
        this.gWD.gJr.setBackgroundResource(R.drawable.transparent_bg);
        this.gWD.gJr.setText(this.gyO.boj().label_name);
        this.gWD.gJr.setVisibility(0);
        if (this.gyO.bnQ() == null || this.gyO.bnQ().getAlaUserData() == null || au.isEmpty(this.gyO.bnQ().getAlaUserData().great_anchor_icon)) {
            this.gWD.gWH.setVisibility(8);
        } else {
            this.gWD.gWH.setVisibility(0);
            this.gWD.gWH.startLoad(this.gyO.bnQ().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gWD.aYx.setOnClickListener(this.gJo);
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
            ap.setBackgroundResource(this.gWD.gJt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gWD.gJr, R.color.CAM_X0111);
            ap.setViewTextColor(this.gWD.gJs, R.color.CAM_X0101);
            ap.setViewTextColor(this.gWD.aYx, R.color.CAM_X0109);
            ap.setViewTextColor(this.gWD.gJv, R.color.CAM_X0105);
            ap.setViewTextColor(this.gWD.gWJ, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gWE = str;
    }

    /* renamed from: com.baidu.tieba.ala.frsgamelive.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0630a {
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

        public C0630a(View view) {
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
            this.gWL.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gWL.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gWK.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gWK.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gJv.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gKm.setVisibility(0);
            this.gKe.setLayoutParams(this.gWL);
            this.gJv.setLayoutParams(this.gWK);
            this.gJt.setLayoutParams(layoutParams);
        }
    }
}
