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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.d;
import com.baidu.tieba.ala.g;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private static String gTH;
    private g gSn;
    private C0630a gTF;
    private String gTG;
    private bz gvQ;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    View.OnClickListener gGq = new View.OnClickListener() { // from class: com.baidu.tieba.ala.frsgamelive.view.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gvQ != null && a.this.gvQ.bnx() != null && !StringUtils.isNull(a.this.gvQ.bnx().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(a.this.gvQ.bnx().getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                d.bOa().bOb();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.mTbPageContext.getPageActivity()).createNormalConfig(j, z, a.this.gvQ.bnx().isBigV())));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.gTF = new C0630a(this.mRootView);
        getView().setOnClickListener(this);
        gTH = this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View getView() {
        return this.mRootView;
    }

    public void d(g gVar) {
        this.gSn = gVar;
    }

    public void a(bz bzVar) {
        if (bzVar == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gvQ = bzVar;
        this.gTF.gGs.setDrawerType(0);
        this.gTF.gGs.setBorderSurroundContent(true);
        this.gTF.gGs.setDrawBorder(true);
        this.gTF.gGs.startLoad(this.gvQ.bnQ().cover, 10, false);
        this.gTF.gGu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_list_audience_label, at.numberUniformFormatExtra(this.gvQ.bnQ().audience_count)));
        this.gTF.gGw.setData(this.gvQ);
        this.gTF.gGw.setIsRound(true);
        this.gTF.gGw.setBorderSurroundContent(true);
        this.gTF.gGx.setText(this.gvQ.getTitle());
        if (this.gvQ.bnx() != null) {
            String name_show = this.gvQ.bnx().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gTF.aVp.setText(name_show);
        }
        this.gTF.gTK.setVisibility(0);
        this.gTF.gGt.setBackgroundResource(R.drawable.transparent_bg);
        this.gTF.gGt.setText(this.gvQ.bnQ().label_name);
        this.gTF.gGt.setVisibility(0);
        if (this.gvQ.bnx() == null || this.gvQ.bnx().getAlaUserData() == null || at.isEmpty(this.gvQ.bnx().getAlaUserData().great_anchor_icon)) {
            this.gTF.gTJ.setVisibility(8);
        } else {
            this.gTF.gTJ.setVisibility(0);
            this.gTF.gTJ.startLoad(this.gvQ.bnx().getAlaUserData().great_anchor_icon, 10, false);
        }
        this.gTF.aVp.setOnClickListener(this.gGq);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        } else if (this.gvQ != null && this.gvQ.bnQ() != null) {
            if (this.gSn != null) {
                this.gSn.R(this.gvQ);
            }
            d.bOa().bOb();
            TiebaStatic.log(new aq("c12116").w("obj_id", this.gvQ.bnQ().live_id));
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gTF.gGv, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gTF.gGt, R.color.CAM_X0111);
            ao.setViewTextColor(this.gTF.gGu, R.color.CAM_X0101);
            ao.setViewTextColor(this.gTF.aVp, R.color.CAM_X0109);
            ao.setViewTextColor(this.gTF.gGx, R.color.CAM_X0105);
            ao.setViewTextColor(this.gTF.gTL, R.color.CAM_X0101);
            this.mSkinType = i;
        }
    }

    public void setLabelName(String str) {
        this.gTG = str;
    }

    /* renamed from: com.baidu.tieba.ala.frsgamelive.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0630a {
        public TextView aVp;
        public TbImageView gGs;
        public TextView gGt;
        public TextView gGu;
        public RelativeLayout gGv;
        public ClickableHeaderImageView gGw;
        public TextView gGx;
        public LinearLayout gHg;
        public RelativeLayout gHo;
        public TbImageView gTJ;
        public View gTK;
        public TextView gTL;
        private LinearLayout.LayoutParams gTM;
        private LinearLayout.LayoutParams gTN;
        public View rootView;

        public C0630a(View view) {
            this.rootView = view;
            this.gGs = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gGt = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gGu = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gGv = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gGw = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aVp = (TextView) view.findViewById(R.id.tvUserName);
            this.gHo = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.gGx = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gHg = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.gTJ = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.gTK = view.findViewById(R.id.living_logo);
            this.gTL = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.gTL.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.gTM = (LinearLayout.LayoutParams) this.gGx.getLayoutParams();
            this.gTN = (LinearLayout.LayoutParams) this.gHg.getLayoutParams();
            this.gTJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gGs.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGv.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.gTN.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gTN.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gTM.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.gTM.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.gGx.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gHo.setVisibility(0);
            this.gHg.setLayoutParams(this.gTN);
            this.gGx.setLayoutParams(this.gTM);
            this.gGv.setLayoutParams(layoutParams);
        }
    }
}
