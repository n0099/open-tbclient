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
    private a gAv;
    private by gpH;
    private String gtV;
    private i gxu;
    private boolean gzS;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (g.this.gpH != null && g.this.gpH.bpj() != null && g.this.gxu != null) {
                    g.this.gxu.a(g.this.tabId, g.this.gtV, g.this.gpH);
                    return;
                }
                return;
            }
            l.showLongToast(g.this.mTbPageContext.getPageActivity(), g.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };
    View.OnClickListener gzT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.gpH != null && g.this.gpH.boP() != null && !StringUtils.isNull(g.this.gpH.boP().getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(g.this.gpH.boP().getUserId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(g.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), g.this.gpH.boP().isBigV())));
            }
        }
    };

    public g(TbPageContext<?> tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.gAv = new a(this.mRootView);
        this.gzS = z;
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(i iVar) {
        this.gxu = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.gpH == null || cVar.gpH.bpj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gpH = cVar.gpH;
        this.tabId = cVar.tabId;
        this.gtV = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gAv.gzV.setDrawerType(0);
        this.gAv.gzV.setBorderSurroundContent(true);
        this.gAv.gzV.setDrawBorder(true);
        this.gAv.gzV.startLoad(this.gpH.bpj().cover, 10, false);
        this.gAv.gzX.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gpH.bpj().audience_count)));
        this.gAv.gzZ.setData(this.gpH, false);
        this.gAv.gAa.setText(this.gpH.getTitle());
        if (this.gpH.boP() != null) {
            String name_show = this.gpH.boP().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gAv.aYw.setText(name_show);
        }
        String str = this.gpH.bpj().label_name;
        if (this.gzS && !StringUtils.isNull(str)) {
            this.gAv.gzW.setText(str);
            this.gAv.gzW.setVisibility(0);
        } else {
            this.gAv.gzW.setVisibility(8);
        }
        if (cVar.gpI) {
            this.gAv.gAb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gpH.bpj().distance / 1000.0d))));
            this.gAv.gAb.setVisibility(0);
        } else {
            this.gAv.gAb.setVisibility(8);
        }
        this.gAv.aYw.setOnClickListener(this.gzT);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gAv.gzY, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gAv.gzX, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gAv.aYw, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gAv.gAa, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gAv.gAb, (int) R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public TextView aYw;
        public TextView gAa;
        public TextView gAb;
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
            this.gAa = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.gAb = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(g.this.mOnClickListener);
            this.gzV.setDefaultErrorResource(0);
            this.gzV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gzV.setDrawerType(0);
            this.gzZ.setIsRound(true);
            this.gzZ.setDrawBorder(true);
            this.gzZ.setBorderColor(g.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gzZ.setBorderWidth(g.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gzZ.setIsGod(false);
            this.gzZ.setIsBigV(false);
            this.gzZ.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzY.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.height = layoutParams.width;
            this.gzY.setLayoutParams(layoutParams);
        }
    }
}
