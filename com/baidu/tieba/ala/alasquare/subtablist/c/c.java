package com.baidu.tieba.ala.alasquare.subtablist.c;

import android.text.TextUtils;
import android.view.View;
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
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.a.c> {
    private by gpH;
    private String gtV;
    private i gxu;
    private a gzR;
    private boolean gzS;
    View.OnClickListener gzT;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gzS = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.gpH != null && c.this.gpH.bpj() != null && c.this.gxu != null) {
                        c.this.gxu.a(c.this.tabId, c.this.gtV, c.this.gpH);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.gzT = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gpH != null && c.this.gpH.boP() != null && !StringUtils.isNull(c.this.gpH.boP().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.gpH.boP().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.gpH.boP().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gzR = new a(getView());
        this.gzS = z;
    }

    public void c(i iVar) {
        this.gxu = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gzR.gzY, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gzR.gzX, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gzR.aYw, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gzR.gAa, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gzR.gAb, (int) R.color.CAM_X0109);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(com.baidu.tieba.ala.alasquare.a.c cVar) {
        if (cVar == null || cVar.gpH == null || cVar.gpH.bpj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gpH = cVar.gpH;
        this.tabId = cVar.tabId;
        this.gtV = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gzR.gzV.startLoad(this.gpH.bpj().cover, 10, false);
        this.gzR.gzX.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gpH.bpj().audience_count)));
        this.gzR.gzZ.setData(this.gpH, false);
        this.gzR.gAa.setText(this.gpH.getTitle());
        if (this.gpH.boP() != null) {
            String name_show = this.gpH.boP().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gzR.aYw.setText(name_show);
        }
        String str = this.gpH.bpj().label_name;
        if (this.gzS && !StringUtils.isNull(str)) {
            this.gzR.gzW.setText(str);
            this.gzR.gzW.setVisibility(0);
        } else {
            this.gzR.gzW.setVisibility(8);
        }
        if (cVar.gpI) {
            this.gzR.gAb.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gpH.bpj().distance / 1000.0d))));
            this.gzR.gAb.setVisibility(0);
        } else {
            this.gzR.gAb.setVisibility(8);
        }
        this.gzR.aYw.setOnClickListener(this.gzT);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
            view.setOnClickListener(c.this.mOnClickListener);
            this.gzV.setDefaultErrorResource(0);
            this.gzV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gzV.setDrawerType(0);
            this.gzZ.setIsRound(true);
            this.gzZ.setDrawBorder(true);
            this.gzZ.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gzZ.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gzZ.setIsGod(false);
            this.gzZ.setIsBigV(false);
            this.gzZ.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzY.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gzY.setLayoutParams(layoutParams);
        }
    }
}
