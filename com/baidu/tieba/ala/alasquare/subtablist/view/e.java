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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class e {
    private String gDl;
    private g gGP;
    private a gJQ;
    private boolean gJn;
    private cb gyO;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (e.this.gyO != null && e.this.gyO.boj() != null && e.this.gGP != null) {
                    e.this.gGP.a(e.this.tabId, e.this.gDl, e.this.gyO);
                    return;
                }
                return;
            }
            l.showLongToast(e.this.mTbPageContext.getPageActivity(), e.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gJo = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.gyO != null && e.this.gyO.bnQ() != null && !StringUtils.isNull(e.this.gyO.bnQ().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(e.this.gyO.bnQ().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(e.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), e.this.gyO.bnQ().isBigV())));
            }
        }
    };

    public e(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gJQ = new a(this.mRootView);
        this.gJn = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(g gVar) {
        this.gGP = gVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.e eVar) {
        if (eVar == null || eVar.gyO == null || eVar.gyO.boj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gyO = eVar.gyO;
        this.tabId = eVar.tabId;
        this.gDl = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        this.gJQ.gJq.setDrawerType(0);
        this.gJQ.gJq.setBorderSurroundContent(true);
        this.gJQ.gJq.setDrawBorder(true);
        this.gJQ.gJq.startLoad(this.gyO.boj().cover, 10, false);
        this.gJQ.gJs.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gyO.boj().audience_count)));
        this.gJQ.gJu.setData(this.gyO, false);
        this.gJQ.gJv.setText(this.gyO.getTitle());
        if (this.gyO.bnQ() != null) {
            String name_show = this.gyO.bnQ().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gJQ.aYx.setText(name_show);
        }
        String str = this.gyO.boj().label_name;
        if (this.gJn && !StringUtils.isNull(str)) {
            this.gJQ.gJr.setText(str);
            this.gJQ.gJr.setVisibility(0);
        } else {
            this.gJQ.gJr.setVisibility(8);
        }
        if (eVar.gyW) {
            this.gJQ.gJw.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gyO.boj().distance / 1000.0d))));
            this.gJQ.gJw.setVisibility(0);
        } else {
            this.gJQ.gJw.setVisibility(8);
        }
        this.gJQ.aYx.setOnClickListener(this.gJo);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gJQ.gJt, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gJQ.gJs, R.color.CAM_X0101);
            ap.setViewTextColor(this.gJQ.aYx, R.color.CAM_X0101);
            ap.setViewTextColor(this.gJQ.gJv, R.color.CAM_X0105);
            ap.setViewTextColor(this.gJQ.gJw, R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public TextView aYx;
        public TbImageView gJq;
        public TextView gJr;
        public TextView gJs;
        public RelativeLayout gJt;
        public ClickableHeaderImageView gJu;
        public TextView gJv;
        public TextView gJw;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gJq = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gJr = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gJs = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gJt = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gJu = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aYx = (TextView) view.findViewById(R.id.tvUserName);
            this.gJv = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gJw = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(e.this.mOnClickListener);
            this.gJq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gJq.setDrawerType(0);
            this.gJu.setIsRound(true);
            this.gJu.setDrawBorder(true);
            this.gJu.setBorderColor(e.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gJu.setBorderWidth(e.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gJu.setIsGod(false);
            this.gJu.setIsBigV(false);
            this.gJu.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJt.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gJt.setLayoutParams(layoutParams);
        }
    }
}
