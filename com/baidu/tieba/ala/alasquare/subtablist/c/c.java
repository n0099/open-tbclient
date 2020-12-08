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
    private by gpF;
    private String gtT;
    private i gxs;
    private a gzP;
    private boolean gzQ;
    View.OnClickListener gzR;
    private View.OnClickListener mOnClickListener;
    public int mSkinType;
    private TbPageContext<?> mTbPageContext;
    private int tabId;

    public c(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.gzQ = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.isNetWorkAvailable()) {
                    if (c.this.gpF != null && c.this.gpF.bpj() != null && c.this.gxs != null) {
                        c.this.gxs.a(c.this.tabId, c.this.gtT, c.this.gpF);
                        return;
                    }
                    return;
                }
                l.showLongToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
            }
        };
        this.gzR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.subtablist.c.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gpF != null && c.this.gpF.boP() != null && !StringUtils.isNull(c.this.gpF.boP().getUserId())) {
                    long j = com.baidu.adp.lib.f.b.toLong(c.this.gpF.boP().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(c.this.mTbPageContext.getPageActivity()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), c.this.gpF.boP().isBigV())));
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gzP = new a(getView());
        this.gzQ = z;
    }

    public void c(i iVar) {
        this.gxs = iVar;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gzP.gzW, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gzP.gzV, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gzP.aYw, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gzP.gzY, (int) R.color.CAM_X0105);
            ap.setViewTextColor(this.gzP.gzZ, (int) R.color.CAM_X0109);
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
        if (cVar == null || cVar.gpF == null || cVar.gpF.bpj() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.gpF = cVar.gpF;
        this.tabId = cVar.tabId;
        this.gtT = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        this.gzP.gzT.startLoad(this.gpF.bpj().cover, 10, false);
        this.gzP.gzV.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gpF.bpj().audience_count)));
        this.gzP.gzX.setData(this.gpF, false);
        this.gzP.gzY.setText(this.gpF.getTitle());
        if (this.gpF.boP() != null) {
            String name_show = this.gpF.boP().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.gzP.aYw.setText(name_show);
        }
        String str = this.gpF.bpj().label_name;
        if (this.gzQ && !StringUtils.isNull(str)) {
            this.gzP.gzU.setText(str);
            this.gzP.gzU.setVisibility(0);
        } else {
            this.gzP.gzU.setVisibility(8);
        }
        if (cVar.gpG) {
            this.gzP.gzZ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, au.numberUniformFormatExtra((long) (this.gpF.bpj().distance / 1000.0d))));
            this.gzP.gzZ.setVisibility(0);
        } else {
            this.gzP.gzZ.setVisibility(8);
        }
        this.gzP.aYw.setOnClickListener(this.gzR);
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
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
            view.setOnClickListener(c.this.mOnClickListener);
            this.gzT.setDefaultErrorResource(0);
            this.gzT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.gzT.setDrawerType(0);
            this.gzX.setIsRound(true);
            this.gzX.setDrawBorder(true);
            this.gzX.setBorderColor(c.this.mTbPageContext.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.gzX.setBorderWidth(c.this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.gzX.setIsGod(false);
            this.gzX.setIsBigV(false);
            this.gzX.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gzW.getLayoutParams();
            layoutParams.width = (l.getEquipmentWidth(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.gzW.setLayoutParams(layoutParams);
        }
    }
}
