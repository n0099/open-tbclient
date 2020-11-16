package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {
    private bx ghv;
    private String glK;
    private i gpj;
    private boolean grH;
    private a gsk;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.ghv != null && g.this.ghv.blW() != null && g.this.gpj != null) {
                    g.this.gpj.a(g.this.tabId, g.this.glK, g.this.ghv);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener grI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.ghv != null && g.this.ghv.blC() != null && !StringUtils.isNull(g.this.ghv.blC().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.ghv.blC().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.ghv.blC().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gsk = new a(this.mRootView);
        this.grH = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.gpj = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.ghv == null || cVar.ghv.blW() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.ghv = cVar.ghv;
        this.tabId = cVar.tabId;
        this.glK = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gsk.grK.setDrawerType(0);
        this.gsk.grK.setBorderSurroundContent(true);
        this.gsk.grK.setDrawBorder(true);
        this.gsk.grK.startLoad(this.ghv.blW().cover, 10, false);
        this.gsk.grM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.ghv.blW().audience_count)));
        this.gsk.grO.setData(this.ghv, false);
        this.gsk.grP.setText(this.ghv.getTitle());
        if (this.ghv.blC() != null) {
            String name_show = this.ghv.blC().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gsk.aVl.setText(name_show);
        }
        String str = this.ghv.blW().label_name;
        if (this.grH && !StringUtils.isNull(str)) {
            this.gsk.grL.setText(str);
            this.gsk.grL.setVisibility(0);
        } else {
            this.gsk.grL.setVisibility(8);
        }
        if (cVar.ghw) {
            this.gsk.grQ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.ghv.blW().distance / 1000.0d))));
            this.gsk.grQ.setVisibility(0);
        } else {
            this.gsk.grQ.setVisibility(8);
        }
        this.gsk.aVl.setOnClickListener(this.grI);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gsk.grN, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gsk.grM, R.color.CAM_X0101);
            ap.setViewTextColor(this.gsk.aVl, R.color.CAM_X0101);
            ap.setViewTextColor(this.gsk.grP, R.color.CAM_X0105);
            ap.setViewTextColor(this.gsk.grQ, R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView aVl;
        public TbImageView grK;
        public TextView grL;
        public TextView grM;
        public RelativeLayout grN;
        public ClickableHeaderImageView grO;
        public TextView grP;
        public TextView grQ;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.grK = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.grL = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.grM = (TextView) view.findViewById(R.id.tvLiveCount);
            this.grN = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.grO = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aVl = (TextView) view.findViewById(R.id.tvUserName);
            this.grP = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.grQ = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.grK.setDefaultErrorResource(0);
            this.grK.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.grK.setDrawerType(0);
            this.grO.setIsRound(true);
            this.grO.setDrawBorder(true);
            this.grO.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.grO.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.grO.setIsGod(false);
            this.grO.setIsBigV(false);
            this.grO.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grN.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.grN.setLayoutParams(layoutParams);
        }
    }
}
