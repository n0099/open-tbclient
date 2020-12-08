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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class g {
    private a gAt;
    private by gpF;
    private String gtT;
    private i gxs;
    private boolean gzQ;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.gpF != null && g.this.gpF.bpj() != null && g.this.gxs != null) {
                    g.this.gxs.a(g.this.tabId, g.this.gtT, g.this.gpF);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gzR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.gpF != null && g.this.gpF.boP() != null && !StringUtils.isNull(g.this.gpF.boP().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.gpF.boP().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.gpF.boP().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gAt = new a(this.mRootView);
        this.gzQ = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.gxs = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.gpF == null || cVar.gpF.bpj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gpF = cVar.gpF;
        this.tabId = cVar.tabId;
        this.gtT = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gAt.gzT.setDrawerType(0);
        this.gAt.gzT.setBorderSurroundContent(true);
        this.gAt.gzT.setDrawBorder(true);
        this.gAt.gzT.startLoad(this.gpF.bpj().cover, 10, false);
        this.gAt.gzV.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gpF.bpj().audience_count)));
        this.gAt.gzX.setData(this.gpF, false);
        this.gAt.gzY.setText(this.gpF.getTitle());
        if (this.gpF.boP() != null) {
            String name_show = this.gpF.boP().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gAt.aYw.setText(name_show);
        }
        String str = this.gpF.bpj().label_name;
        if (this.gzQ && !StringUtils.isNull(str)) {
            this.gAt.gzU.setText(str);
            this.gAt.gzU.setVisibility(0);
        } else {
            this.gAt.gzU.setVisibility(8);
        }
        if (cVar.gpG) {
            this.gAt.gzZ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gpF.bpj().distance / 1000.0d))));
            this.gAt.gzZ.setVisibility(0);
        } else {
            this.gAt.gzZ.setVisibility(8);
        }
        this.gAt.aYw.setOnClickListener(this.gzR);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gAt.gzW, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gAt.gzV, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gAt.aYw, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gAt.gzY, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gAt.gzZ, (int) R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public TextView aYw;
        public TbImageView gzT;
        public TextView gzU;
        public TextView gzV;
        public RelativeLayout gzW;
        public ClickableHeaderImageView gzX;
        public TextView gzY;
        public TextView gzZ;
        public View rootView;

        public a(View view) {
            this.rootView = view;
            this.gzT = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.gzU = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.gzV = (TextView) view.findViewById(R.id.tvLiveCount);
            this.gzW = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.gzX = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.aYw = (TextView) view.findViewById(R.id.tvUserName);
            this.gzY = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gzZ = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.gzT.setDefaultErrorResource(0);
            this.gzT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gzT.setDrawerType(0);
            this.gzX.setIsRound(true);
            this.gzX.setDrawBorder(true);
            this.gzX.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gzX.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gzX.setIsGod(false);
            this.gzX.setIsBigV(false);
            this.gzX.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzW.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gzW.setLayoutParams(layoutParams);
        }
    }
}
