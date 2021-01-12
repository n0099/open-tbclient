package com.baidu.tieba.ala.alasquare.subtablist.view;

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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e {
    private String gAn;
    private g gDR;
    private a gGS;
    private boolean gGp;
    private bz gvQ;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (e.this.gvQ != null && e.this.gvQ.bnQ() != null && e.this.gDR != null) {
                    e.this.gDR.a(e.this.tabId, e.this.gAn, e.this.gvQ);
                    return;
                }
                return;
            }
            l.showLongToast(e.this.mTbPageContext.getPageActivity(), e.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gGq = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gvQ != null && e.this.gvQ.bnx() != null && !StringUtils.isNull(e.this.gvQ.bnx().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(e.this.gvQ.bnx().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(e.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.gvQ.bnx().isBigV())));
            }
        }
    };

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gGS = new a(this.mRootView);
        this.gGp = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(g gVar) {
        this.gDR = gVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gvQ == null || eVar.gvQ.bnQ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gvQ = eVar.gvQ;
        this.tabId = eVar.tabId;
        this.gAn = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gGS.gGs.setDrawerType(0);
        this.gGS.gGs.setBorderSurroundContent(true);
        this.gGS.gGs.setDrawBorder(true);
        this.gGS.gGs.startLoad(this.gvQ.bnQ().cover, 10, false);
        this.gGS.gGu.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.gvQ.bnQ().audience_count)));
        this.gGS.gGw.setData(this.gvQ, false);
        this.gGS.gGx.setText(this.gvQ.getTitle());
        if (this.gvQ.bnx() != null) {
            String name_show = this.gvQ.bnx().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gGS.aVp.setText(name_show);
        }
        String str = this.gvQ.bnQ().label_name;
        if (this.gGp && !StringUtils.isNull(str)) {
            this.gGS.gGt.setText(str);
            this.gGS.gGt.setVisibility(0);
        } else {
            this.gGS.gGt.setVisibility(8);
        }
        if (eVar.gvY) {
            this.gGS.gGy.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, at.numberUniformFormatExtra((long) (this.gvQ.bnQ().distance / 1000.0d))));
            this.gGS.gGy.setVisibility(0);
        } else {
            this.gGS.gGy.setVisibility(8);
        }
        this.gGS.aVp.setOnClickListener(this.gGq);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.gGS.gGv, R.drawable.addresslist_item_bg);
            ao.setViewTextColor(this.gGS.gGu, R.color.CAM_X0101);
            ao.setViewTextColor(this.gGS.aVp, R.color.CAM_X0101);
            ao.setViewTextColor(this.gGS.gGx, R.color.CAM_X0105);
            ao.setViewTextColor(this.gGS.gGy, R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public TextView aVp;
        public TbImageView gGs;
        public TextView gGt;
        public TextView gGu;
        public RelativeLayout gGv;
        public ClickableHeaderImageView gGw;
        public TextView gGx;
        public TextView gGy;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gGs = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gGt = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gGu = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gGv = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gGw = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aVp = (TextView) view.findViewById(R.id.tvUserName);
            this.gGx = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gGy = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(e.this.mOnClickListener);
            this.gGs.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gGs.setDrawerType(0);
            this.gGw.setIsRound(true);
            this.gGw.setDrawBorder(true);
            this.gGw.setBorderColor(e.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gGw.setBorderWidth(e.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gGw.setIsGod(false);
            this.gGw.setIsBigV(false);
            this.gGw.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGv.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gGv.setLayoutParams(layoutParams);
        }
    }
}
